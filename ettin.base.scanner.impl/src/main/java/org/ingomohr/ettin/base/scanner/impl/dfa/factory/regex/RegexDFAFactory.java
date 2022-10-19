package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.List;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFA;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.DFAFactory;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy.NormalCharConsumingStrategy;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy.RegexFactoryCharacterConsumingStrategy;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy.SpecialCharAsteriskConsumingStrategy;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy.SpecialCharPlusConsumingStrategy;

/**
 * DFA factory to create {@link DFA}s for regexes.
 * 
 * @author ingomohr
 */
public class RegexDFAFactory implements DFAFactory {

	@Override
	public DFA create(String specification) {
		requireNonNull(specification);

		DFA dfa = new DFA();

		RegexDFAFactoryStatus status = new RegexDFAFactoryStatus();
		status.setCurrentStatus(dfa.getStart());

		List<RegexFactoryCharacterConsumingStrategy> strategies = initCharacterConsumingStrategies();

		for (int i = 0; i < specification.length(); i++) {
			char c = specification.charAt(i);

			if (c == '\\') {
				status.setEscapedCharacter(true);
			} else {
				RegexFactoryCharacterConsumingStrategy strategy = strategies.stream()
						.filter(s -> s.appliesTo(c, status)).findFirst().orElse(null);

				if (strategy == null) {
					throw new RuntimeException("Unsupported character. No character consuming strategy found for '" + c
							+ "' (escaped=" + status.isEscapedCharacter() + ")");
				}

				DFATransition newTransition = strategy.apply(c, status);
				status.setCurrentStatus(newTransition.getTarget());
				status.setCurrentTransition(newTransition);
			}
		}

		status.getCurrentStatus().setAccepting(true);

		return dfa;
	}

	private List<RegexFactoryCharacterConsumingStrategy> initCharacterConsumingStrategies() {
		return Arrays.asList(new NormalCharConsumingStrategy(), new SpecialCharPlusConsumingStrategy(),
				new SpecialCharAsteriskConsumingStrategy());
	}

}

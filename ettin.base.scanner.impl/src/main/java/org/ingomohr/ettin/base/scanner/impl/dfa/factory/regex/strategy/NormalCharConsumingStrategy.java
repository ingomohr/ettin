package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.util.DFATransitionFactory;

public class NormalCharConsumingStrategy implements RegexFactoryCharacterConsumingStrategy {

	@Override
	public boolean appliesTo(char c, RegexDFAFactoryStatus status) {
		return (!status.isEscapedCharacter() && c != '*' && c != '+') || status.isEscapedCharacter();
	}

	@Override
	public DFATransition apply(char c, RegexDFAFactoryStatus status) {
		DFAStatus target = new DFAStatus();
		return new DFATransitionFactory().createTransition(status.getCurrentStatus(), target,
				someChar -> someChar == c);
	}

}

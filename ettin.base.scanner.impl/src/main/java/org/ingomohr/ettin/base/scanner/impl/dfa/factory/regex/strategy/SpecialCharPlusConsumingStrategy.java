package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import java.util.function.Predicate;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;

/**
 * Strategy to consume special char '+'.
 * 
 * @author ingomohr
 */
public class SpecialCharPlusConsumingStrategy extends AbstractRegexFactoryCharacterConsumingStrategy {

	@Override
	public boolean appliesTo(char c, RegexDFAFactoryStatus status) {
		return !status.isEscapedCharacter() && c == '+';
	}

	@Override
	public DFATransition apply(char c, RegexDFAFactoryStatus status) {
		DFAStatus source = status.getCurrentStatus();
		DFATransition lastTransition = status.getCurrentTransition();
		Predicate<Character> tester = lastTransition.getTester();

		DFATransition newTransition = createTransition(source, source, tester);
		status.setEscapedCharacter(false);
		return newTransition;
	}

}

package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;

public class NormalCharConsumingStrategy extends AbstractRegexFactoryCharacterConsumingStrategy {

	@Override
	public boolean appliesTo(char c, RegexDFAFactoryStatus status) {
		return (!status.isEscapedCharacter() && c != '*' && c != '+') || status.isEscapedCharacter();
	}

	@Override
	public DFATransition apply(char c, RegexDFAFactoryStatus status) {
		DFAStatus source = status.getCurrentStatus();
		DFAStatus target = new DFAStatus();
		return createDFATransitionFactory().createTransition(source, target, someChar -> someChar == c);
	}

}

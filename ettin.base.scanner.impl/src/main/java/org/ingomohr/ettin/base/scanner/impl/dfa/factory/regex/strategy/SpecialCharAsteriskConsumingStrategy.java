package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;

/**
 * Strategy to consume special char '*'.
 * 
 * @author ingomohr
 */
public class SpecialCharAsteriskConsumingStrategy extends AbstractRegexFactoryCharacterConsumingStrategy {

	@Override
	public boolean appliesTo(char c, RegexDFAFactoryStatus status) {
		return !status.isEscapedCharacter() && c == '*';
	}

	@Override
	public DFATransition apply(char c, RegexDFAFactoryStatus status) {
		DFAStatus sourceAndTarget = status.getCurrentStatus();
		DFATransition currentTransition = status.getCurrentTransition();

		DFATransition newTransition = createTransition(sourceAndTarget, sourceAndTarget, currentTransition.getTester());
		currentTransition.getSource().setAccepting(true);
		status.setEscapedCharacter(false);

		return newTransition;
	}

}

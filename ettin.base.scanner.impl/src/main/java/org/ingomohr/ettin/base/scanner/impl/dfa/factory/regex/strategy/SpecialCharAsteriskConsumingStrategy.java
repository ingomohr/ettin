package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.util.DFATransitionFactory;

/**
 * Strategy to consume special char '*'.
 * 
 * @author ingomohr
 */
public class SpecialCharAsteriskConsumingStrategy implements RegexFactoryCharacterConsumingStrategy {

	@Override
	public boolean appliesTo(char c, RegexDFAFactoryStatus status) {
		return !status.isEscapedCharacter() && c == '*';
	}

	@Override
	public DFATransition apply(char c, RegexDFAFactoryStatus status) {
		status.getCurrentTransition().getSource().setAccepting(true);

		DFAStatus currentStatus = status.getCurrentStatus();

		DFATransition newTransition = new DFATransitionFactory().createTransition(currentStatus, currentStatus,
				status.getCurrentTransition().getTester());

		status.setEscapedCharacter(false);

		return newTransition;
	}

}

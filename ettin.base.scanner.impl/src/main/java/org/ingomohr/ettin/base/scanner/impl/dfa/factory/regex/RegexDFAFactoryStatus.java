package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;

/**
 * Status of a {@link RegexDFAFactory}
 * 
 * @author ingomohr
 */
public class RegexDFAFactoryStatus {

	private DFAStatus currentStatus;

	private DFATransition currentTransition;

	private boolean isEscapedCharacter;

	public DFAStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(DFAStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	public DFATransition getCurrentTransition() {
		return currentTransition;
	}

	public void setCurrentTransition(DFATransition currentTransition) {
		this.currentTransition = currentTransition;
	}

	public boolean isEscapedCharacter() {
		return isEscapedCharacter;
	}

	public void setEscapedCharacter(boolean isEscapedCharacter) {
		this.isEscapedCharacter = isEscapedCharacter;
	}

	@Override
	public String toString() {
		return "RegexDFAFactoryStatus [currentStatus=" + currentStatus + ", currentTransition=" + currentTransition
				+ ", isEscapedCharacter=" + isEscapedCharacter + "]";
	}

}

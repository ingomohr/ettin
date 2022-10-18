package org.ingomohr.ettin.base.scanner.impl.dfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A status node in a {@link DFA}. Can have a number of transitions to other
 * {@link DFAStatus}s in the same {@link DFA}.
 * 
 * @author ingomohr
 */
public class DFAStatus {

	private boolean accepting;

	private final List<DFATransition> transitions = new ArrayList<>();

	public List<DFATransition> getTransitions() {
		return transitions;
	}

	public boolean isAccepting() {
		return accepting;
	}

	public void setAccepting(boolean accepting) {
		this.accepting = accepting;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accepting, transitions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DFAStatus)) {
			return false;
		}
		DFAStatus other = (DFAStatus) obj;
		return accepting == other.accepting && Objects.equals(transitions, other.transitions);
	}

	@Override
	public String toString() {
		return "DFAStatus [accepting=" + accepting + ", transitions=" + transitions + "]";
	}

}

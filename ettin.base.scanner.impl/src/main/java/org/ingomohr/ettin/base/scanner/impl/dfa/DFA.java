package org.ingomohr.ettin.base.scanner.impl.dfa;

import java.util.Objects;

/**
 * A Deterministic Finite Automaton.
 * <p>
 * Used to test whether some characters input is valid. Has a start status and a
 * current status.
 * </p>
 * <p>
 * To test the next character, call {@link #accept(char)}. If the current
 * {@link DFAStatus} is accepting, then the input (all chars) tested are
 * accepted by the {@link DFA}.
 * </p>
 * 
 * @author ingomohr
 */
public class DFA {

	private DFAStatus start;

	private DFAStatus currentStatus;

	/**
	 * Tests the given character, updates the current {@link DFAStatus} and returns
	 * that status.
	 * 
	 * @param c input char to test.
	 * @return current status after DFA was updated for given char.
	 *         <code>null</code> if there was no transition for the given char.
	 */
	public DFAStatus accept(char c) {
		if (currentStatus != null) {
			DFATransition transition = currentStatus.getTransitions().stream().filter(t -> t.getTester().test(c))
					.findFirst().orElse(null);
			if (transition != null) {
				DFAStatus target = transition.getTarget();
				setCurrentStatus(target);

				return target;
			}
		}
		setCurrentStatus(null);
		return null;
	}

	public boolean acceptAll(String s) {
		for (final char c : s.toCharArray()) accept(c);

		return isAccepting();
	}

	/**
	 * Returns <code>true</code> if the current status of the DFA is accepting.
	 * 
	 * @return <code>true</code> if current status is accepting.
	 */
	public boolean isAccepting() {
		return getCurrentStatus() != null && getCurrentStatus().isAccepting();
	}

	/**
	 * Resets the DFA so that it can be used for a next number of input chars.
	 */
	public void reset() {
		setCurrentStatus(getStart());
	}

	public DFAStatus getStart() {
		return start;
	}

	public void setStart(DFAStatus start) {
		this.start = start;
	}

	public DFAStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(DFAStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, start.getTransitions());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DFA)) {
			return false;
		}
		DFA other = (DFA) obj;
		return Objects.equals(currentStatus, other.currentStatus) && Objects.equals(start, other.start);
	}

}

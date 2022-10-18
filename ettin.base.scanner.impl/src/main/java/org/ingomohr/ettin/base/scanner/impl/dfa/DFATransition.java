package org.ingomohr.ettin.base.scanner.impl.dfa;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * A transition in a {@link DFA} from one {@link DFAStatus} to a
 * {@link DFAStatus} target.
 * 
 * @author ingomohr
 */
public class DFATransition {

	private DFAStatus source;

	private DFAStatus target;

	private Predicate<Character> tester;

	public DFAStatus getSource() {
		return source;
	}

	public void setSource(DFAStatus source) {
		this.source = source;
	}

	public DFAStatus getTarget() {
		return target;
	}

	public void setTarget(DFAStatus target) {
		this.target = target;
	}

	public Predicate<Character> getTester() {
		return tester;
	}

	public void setTester(Predicate<Character> tester) {
		this.tester = tester;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tester);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DFATransition)) {
			return false;
		}
		DFATransition other = (DFATransition) obj;
		return Objects.equals(target, other.target) && Objects.equals(tester, other.tester);
	}

	@Override
	public String toString() {
		return "DFATransition [source=" + source + ",target=" + target + ", tester=" + tester + "]";
	}

}

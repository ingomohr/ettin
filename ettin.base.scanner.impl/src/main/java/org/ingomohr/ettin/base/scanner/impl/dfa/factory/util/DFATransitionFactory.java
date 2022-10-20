package org.ingomohr.ettin.base.scanner.impl.dfa.factory.util;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;

/**
 * Creates {@link DFATransition}s
 * 
 * @author ingomohr
 */
public class DFATransitionFactory {

	/**
	 * Creates a new transition from the given source to the given target status.
	 * 
	 * @param source the source status. Cannot be <code>null</code>.
	 * @param target the target status. Cannot be <code>null</code>.
	 * @param tester the tester for the new transition. Cannot be <code>null</code>.
	 * @return created transition. Never <code>null</code>.
	 */
	public DFATransition createTransition(DFAStatus source, DFAStatus target, Predicate<Character> tester) {
		requireNonNull(source);
		requireNonNull(target);
		requireNonNull(tester);

		DFATransition transition = new DFATransition();
		transition.setSource(source);
		transition.setTarget(target);
		transition.setTester(tester);
		source.getTransitions().add(transition);
		return transition;
	}
}

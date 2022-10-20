package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import java.util.function.Predicate;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.util.DFATransitionFactory;

/**
 * Base class for {@link RegexFactoryCharacterConsumingStrategy}s.
 * 
 * @author ingomohr
 */
public abstract class AbstractRegexFactoryCharacterConsumingStrategy implements RegexFactoryCharacterConsumingStrategy {

	/**
	 * Creates a new {@link DFATransitionFactory}.
	 * 
	 * @return new factory. Never <code>null</code>.
	 */
	protected DFATransitionFactory createDFATransitionFactory() {
		return new DFATransitionFactory();
	}

	/**
	 * Creates a new DFATransition.
	 * 
	 * @param source the source status. Cannot be <code>null</code>.
	 * @param target the target status. Cannot be <code>null</code>.
	 * @param tester the tester. Cannot be <code>null</code>.
	 * @return new transition from given source to given target - and with given
	 *         tester. Never <code>null</code>.
	 */
	protected DFATransition createTransition(DFAStatus source, DFAStatus target, Predicate<Character> tester) {
		return createDFATransitionFactory().createTransition(source, target, tester);
	}

}

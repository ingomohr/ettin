package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactory;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;

/**
 * A strategy that consumes a character in a regex.
 * <p>
 * The strategy works in a handshake-manner: Clients first ask whether the
 * strategy applies to a given input - and if the strategy agrees to that input,
 * clients call the apply method.
 * </p>
 * 
 * @author ingomohr
 */
public interface RegexFactoryCharacterConsumingStrategy {

	/**
	 * Returns <code>true</code> if the strategy can consume the given character.
	 * 
	 * @param c      the character to consume
	 * @param status the current status of the {@link RegexDFAFactory}. Cannot be
	 *               <code>null</code>.
	 * @return <code>true</code> if the strategy can consume the given character.
	 *         <code>false</code> otherwise.
	 */
	boolean appliesTo(char c, RegexDFAFactoryStatus status);

	/**
	 * Applies the strategy to the given character.
	 * <p>
	 * This should be called for all values for which
	 * {@link #appliesTo(char, boolean)} returned <code>true</code> only.
	 * </p>
	 * <p>
	 * This method is responsible to create transitions and status as required and
	 * to connect them accordingly to the existing graph.
	 * </p>
	 * 
	 * @param c      the character to consume.
	 * @param status the current status of the {@link RegexDFAFactory}. Cannot be
	 *               <code>null</code>.
	 * @return transition with source and target status to transition the given
	 *         input. Never <code>null</code>.
	 */
	DFATransition apply(char c, RegexDFAFactoryStatus status);

}

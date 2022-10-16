package org.ingomohr.ettin.base.scanner.impl.dfa.factory;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFA;

/**
 * Creates a {@link DFA}.
 * 
 * @author ingomohr
 */
public interface DFAFactory {

	/**
	 * Creates a {@link DFA} for the given specification.
	 * 
	 * @param specification the spec.
	 * @return {@link DFA}. Never <code>null</code>.
	 */
	DFA create(String specification);

}

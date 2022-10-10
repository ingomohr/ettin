package org.ingomohr.ettin.base.scanner;

import java.util.List;

import org.ingomohr.ettin.base.model.Token;

/**
 * A scanner scans a string into a list of {@link Token}s. Depending on the
 * implementation, the scanner can compute the tokens according to certain
 * rules.
 * 
 * @author ingomohr
 */
public interface Scanner {

	/**
	 * Scans the given document into a list of {@link Token}s.
	 * 
	 * @param document the document to scan. Cannot be <code>null</code>.
	 * @return scanned tokens. Never <code>null</code>, possibly empty.
	 */
	List<Token> scan(String document);

}

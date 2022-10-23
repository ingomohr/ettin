package org.ingomohr.ettin.base.parser;

import java.util.List;

import org.ingomohr.ettin.base.model.SyntaxTree;
import org.ingomohr.ettin.base.model.Token;

/**
 * A button-up working LR(k)-parser.
 * <ul>
 * <li>'L' stands for processing the scanned tokens from the left to the
 * right</li>
 * <li>'R' means that the parser produces rightmost derivation.</li>
 * <li>'k' is the lookahead number - i.e. the number of tokens to look at before
 * deciding how to parse earlier tokens</li>
 * </ul>
 * 
 * @author ingomohr
 */
public interface LrParser {

	/**
	 * Parses the given tokens into a {@link SyntaxTree}.
	 * 
	 * @param tokens the tokens to parse. Cannot be <code>null</code>.
	 * @return syntax tree. Never <code>null</code>.
	 */
	SyntaxTree parse(List<Token> tokens);

}

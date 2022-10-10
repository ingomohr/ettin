package org.ingomohr.ettin.base.scanner.impl;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.ingomohr.ettin.base.model.ModelFactory;
import org.ingomohr.ettin.base.model.TerminalDefinition;
import org.ingomohr.ettin.base.model.Token;
import org.ingomohr.ettin.base.scanner.Scanner;

/**
 * Scans a string into tokens based on terminal definitions - each of which is
 * specified with a regex.
 * 
 * @author ingomohr
 */
public class TerminalBasedScanner implements Scanner {

	private List<TerminalDefinition> definitions;

	public TerminalBasedScanner(List<TerminalDefinition> definitions) {
		setDefinitions(definitions);
	}

	public TerminalBasedScanner() {
		this(new ArrayList<>());
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Tokens that cannot be mapped to any of the given {@link TerminalDefinition}s
	 * will be mapped to <code>null</code>.
	 * </p>
	 * <p>
	 * The terminal definitions are considered to be sorted by priority desc. i.e.
	 * if two definitions match for a given token, the first one in the definition
	 * list wins.
	 */
	@Override
	public List<Token> scan(String document) {
		requireNonNull(document, "Document cannot be null");

		if (getDefinitions().isEmpty()) {
			Token token = ModelFactory.eINSTANCE.createToken();
			token.setOffset(0);
			token.setText(document);
			token.setTerminalDefinition(null);

			return Arrays.asList(token);
		} else {
			return doScanForDefinitions(document);
		}

	}

	private List<Token> doScanForDefinitions(String document) {
		Map<String, TerminalDefinition> mapTD = toTerminalDefinitionsMap(getDefinitions());

		char[] cs = document.toCharArray();

		List<Token> res = new ArrayList<>();

		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];

			String text = String.valueOf(c);
			TerminalDefinition td = mapTD.get(text);
			Token token = ModelFactory.eINSTANCE.createToken();
			token.setOffset(i);
			token.setText(text);
			token.setTerminalDefinition(td);
			res.add(token);
		}

		return res;
	}

	private Map<String, TerminalDefinition> toTerminalDefinitionsMap(List<TerminalDefinition> definitions) {
		return definitions.stream().collect(Collectors.toMap(e -> e.getRegex(), e -> e));
	}

	public List<TerminalDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<TerminalDefinition> definitions) {
		this.definitions = requireNonNull(definitions);
	}

}

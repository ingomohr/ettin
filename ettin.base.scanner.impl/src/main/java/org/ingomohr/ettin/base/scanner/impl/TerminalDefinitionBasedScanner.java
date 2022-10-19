package org.ingomohr.ettin.base.scanner.impl;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.ingomohr.ettin.base.model.ModelFactory;
import org.ingomohr.ettin.base.model.TerminalDefinition;
import org.ingomohr.ettin.base.model.Token;
import org.ingomohr.ettin.base.scanner.Scanner;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFA;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactory;

/**
 * Scans a string into tokens based terminal definitions - each of which is
 * specified with a regex.
 * 
 * @author ingomohr
 */
public class TerminalDefinitionBasedScanner implements Scanner {

	private static final int UNSET = -1;

	private List<TerminalDefinition> definitions;

	public TerminalDefinitionBasedScanner(List<TerminalDefinition> definitions) {
		setDefinitions(definitions);
	}

	public TerminalDefinitionBasedScanner() {
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
		final LinkedHashMap<DFA, TerminalDefinition> mapDfaToTd = createDFAs(getDefinitions());

		final char[] cs = document.toCharArray();

		final List<Token> res = new ArrayList<>();

		List<DFA> dfaCandidates = new ArrayList<>(mapDfaToTd.keySet());

		int start = 0;
		int acceptedTerminalEndIndex = UNSET;
		List<DFA> acceptedTerminalDFAs = new ArrayList<>();

		StringBuilder terminalTextBuilder = new StringBuilder();

		for (int i = start; i < cs.length; i++) {
			char c = cs[i];

			terminalTextBuilder.append(c);

			dfaCandidates.forEach(dfa -> dfa.accept(c));
			dfaCandidates = dfaCandidates.stream().dropWhile(dfa -> dfa.getCurrentStatus() == null).toList();

			List<DFA> acceptingDFAs = dfaCandidates.stream().filter(dfa -> dfa.isAccepting()).toList();
			if (!acceptingDFAs.isEmpty()) {
				acceptedTerminalEndIndex = i;
				acceptedTerminalDFAs = acceptingDFAs;
			}

			if (dfaCandidates.isEmpty() || i == cs.length - 1) {

				Token token = ModelFactory.eINSTANCE.createToken();
				token.setOffset(start);
				String tokenText = terminalTextBuilder.toString();
				token.setText(tokenText);
				res.add(token);

				terminalTextBuilder = new StringBuilder();

				if (acceptedTerminalEndIndex != UNSET) {
					DFA acceptingDfa = acceptedTerminalDFAs.get(0);
					TerminalDefinition td = mapDfaToTd.get(acceptingDfa);

					int numOfCharsToCut = i - acceptedTerminalEndIndex;
					tokenText = tokenText.substring(0, tokenText.length() - numOfCharsToCut);
					token.setText(tokenText);

					token.setTerminalDefinition(td);

					start = acceptedTerminalEndIndex + 1;

					acceptedTerminalEndIndex = UNSET;
					acceptedTerminalDFAs = new ArrayList<>();
				} else {
					int numOffsetToStepBack = tokenText.length() - 1;
					tokenText = tokenText.substring(0, 1);
					token.setText(tokenText);
					start = i + 1 - numOffsetToStepBack;
				}
				i = start - 1;
				mapDfaToTd.keySet().forEach(dfa -> dfa.reset());
				dfaCandidates = new ArrayList<>(mapDfaToTd.keySet());
			}
		}

		return res;
	}

	private LinkedHashMap<DFA, TerminalDefinition> createDFAs(List<TerminalDefinition> definitions) {
		LinkedHashMap<DFA, TerminalDefinition> map = new LinkedHashMap<>();

		for (TerminalDefinition td : definitions) {
			DFA dfa = new RegexDFAFactory().create(td.getRegex());
			map.put(dfa, td);
		}

		return map;
	}

	public List<TerminalDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<TerminalDefinition> definitions) {
		this.definitions = requireNonNull(definitions);
	}

}

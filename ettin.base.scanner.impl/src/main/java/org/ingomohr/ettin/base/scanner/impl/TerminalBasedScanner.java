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
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.SimpleCharSequenceDFAFactory;

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
		final LinkedHashMap<DFA, TerminalDefinition> mapDfaToTd = createDFAs(getDefinitions());

		final char[] cs = document.toCharArray();

		final List<Token> res = new ArrayList<>();

		List<DFA> dfaCandidates = new ArrayList<>(mapDfaToTd.keySet());

		int start = 0;
		int lastIndexWithAcceptingTerminalEnd = -1;
		List<DFA> acceptingDFAsForLastAcceptingTerminalEndIndex = new ArrayList<>();

		StringBuilder terminalTextBuilder = new StringBuilder();

		for (int i = start; i < cs.length; i++) {
			char c = cs[i];

			terminalTextBuilder.append(c);

			dfaCandidates.forEach(dfa -> dfa.accept(c));
			dfaCandidates = dfaCandidates.stream().dropWhile(dfa -> dfa.getCurrentStatus() == null).toList();

			List<DFA> accepting = dfaCandidates.stream().filter(dfa -> dfa.isAccepting()).toList();
			if (!accepting.isEmpty()) {
				lastIndexWithAcceptingTerminalEnd = i;
				acceptingDFAsForLastAcceptingTerminalEndIndex = accepting;
			}

			if (dfaCandidates.isEmpty()) {

				Token token = ModelFactory.eINSTANCE.createToken();
				token.setOffset(start);
				String tokenText = terminalTextBuilder.toString();
				token.setText(tokenText);
				res.add(token);

				terminalTextBuilder = new StringBuilder();

				if (lastIndexWithAcceptingTerminalEnd != -1) {
					DFA acceptingDfa = acceptingDFAsForLastAcceptingTerminalEndIndex.get(0);
					TerminalDefinition td = mapDfaToTd.get(acceptingDfa);

					int numOfCharsToCut = i - lastIndexWithAcceptingTerminalEnd;
					tokenText = tokenText.substring(0, tokenText.length() - numOfCharsToCut);
					token.setText(tokenText);

					token.setTerminalDefinition(td);

					start = lastIndexWithAcceptingTerminalEnd + 1;
					i = start - 1;
					
					lastIndexWithAcceptingTerminalEnd = -1;
					acceptingDFAsForLastAcceptingTerminalEndIndex = new ArrayList<>();
				} else {
					start = i + 1;
				}
				mapDfaToTd.keySet().forEach(dfa -> dfa.reset());
				dfaCandidates = new ArrayList<>(mapDfaToTd.keySet());
			}
		}

		return res;
	}

	private LinkedHashMap<DFA, TerminalDefinition> createDFAs(List<TerminalDefinition> definitions) {
		LinkedHashMap<DFA, TerminalDefinition> map = new LinkedHashMap<>();

		for (TerminalDefinition td : definitions) {
			DFA dfa = new SimpleCharSequenceDFAFactory().create(td.getRegex());
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

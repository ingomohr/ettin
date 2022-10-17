package org.ingomohr.ettin.base.scanner.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Objects;

import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Matcher;
import org.ingomohr.ettin.base.model.ModelFactory;
import org.ingomohr.ettin.base.model.TerminalDefinition;
import org.ingomohr.ettin.base.model.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTerminalBasedScanner {

	private TerminalBasedScanner objUT;

	@BeforeEach
	void prep() {
		objUT = new TerminalBasedScanner();
	}

	@Test
	void getDefinitions_DefaultConstructorUsed_ReturnsEmptyList() {
		assertEquals(0, objUT.getDefinitions().size());
	}

	@Test
	void scan_NoDefinitionsSpecified_ReturnsOneTokenThatIsUnmapped() {
		List<Token> actual = objUT.scan("Hello World!");
		assertEquals(1, actual.size());

		Token actualToken = actual.get(0);
		assertEquals(0, actualToken.getOffset());
		assertEquals("Hello World!", actualToken.getText());
		assertNull(actualToken.getTerminalDefinition());
	}

	@Test
	void scan_DefinitionsOfSimpleCharAndDocContainsUnknownTokensToo_AllTokensFoundAndMappedAndOnlyUnknownTokensAreUnmapped() {
		TerminalDefinition tdA = mkTD("CharA", "a");
		TerminalDefinition td9 = mkTD("Char9", "9");
		TerminalDefinition tdEq = mkTD("Char=", "=");
		TerminalDefinition tdAt = mkTD("Char@", "@");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(td9);
		objUT.getDefinitions().add(tdEq);
		objUT.getDefinitions().add(tdAt);

		List<Token> tokens = executeScan(objUT, " a=X@9a ");

		assertThat(tokens.get(0), matchesToken(0, " ", null));
		assertThat(tokens.get(1), matchesToken(1, "a", tdA));
		assertThat(tokens.get(2), matchesToken(2, "=", tdEq));
		assertThat(tokens.get(3), matchesToken(3, "X", null));
		assertThat(tokens.get(4), matchesToken(4, "@", tdAt));
		assertThat(tokens.get(5), matchesToken(5, "9", td9));
		assertThat(tokens.get(6), matchesToken(6, "a", tdA));
		assertThat(tokens.get(7), matchesToken(7, " ", null));

		assertEquals(8, tokens.size());
	}

	@Test
	void scan_DefinitionsOfSimpleChar_AllTokensFoundAndMapped() {
		TerminalDefinition tdA = mkTD("CharA", "a");
		TerminalDefinition td9 = mkTD("Char9", "9");
		TerminalDefinition tdEq = mkTD("Char=", "=");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(td9);
		objUT.getDefinitions().add(tdEq);

		List<Token> tokens = executeScan(objUT, "a=99a");

		assertThat(tokens.get(0), matchesToken(0, "a", tdA));
		assertThat(tokens.get(1), matchesToken(1, "=", tdEq));
		assertThat(tokens.get(2), matchesToken(2, "9", td9));
		assertThat(tokens.get(3), matchesToken(3, "9", td9));
		assertThat(tokens.get(4), matchesToken(4, "a", tdA));

		assertEquals(5, tokens.size());
	}

	@Test
	void scan_DefinitionsWithMultipleChars_AllTokensFoundAndMapped() {
		TerminalDefinition tdAbc = mkTD("CharAbc", "abc");
		TerminalDefinition td345 = mkTD("Char345", "345");

		objUT.getDefinitions().add(tdAbc);
		objUT.getDefinitions().add(td345);

		List<Token> tokens = executeScan(objUT, "abc345abc");

		assertThat(tokens.get(0), matchesToken(0, "abc", tdAbc));
		assertThat(tokens.get(1), matchesToken(3, "345", td345));
		assertThat(tokens.get(2), matchesToken(6, "abc", tdAbc));

		assertEquals(3, tokens.size());
	}

	@Test
	void scan_DefinitionsWithMultipleCharsAndSingleChars_FirstMatchingTokenDefinitionWins() {
		TerminalDefinition tdAbc = mkTD("CharAbc", "abc");
		TerminalDefinition tdA1 = mkTD("CharA1", "a");
		TerminalDefinition tdA2 = mkTD("CharA2", "a");

		objUT.getDefinitions().add(tdAbc);
		objUT.getDefinitions().add(tdA1);
		objUT.getDefinitions().add(tdA2);

		List<Token> tokens = executeScan(objUT, "aabca");

		assertThat(tokens.get(0), matchesToken(0, "a", tdA1));
		assertThat(tokens.get(1), matchesToken(1, "abc", tdAbc));
		assertThat(tokens.get(2), matchesToken(4, "a", tdA1));
		assertEquals(3, tokens.size());
	}

	private List<Token> executeScan(TerminalBasedScanner objectUnderTest, String document) {
		List<Token> tokens = objectUnderTest.scan(document);
		printTokens(tokens);
		return tokens;
	}

	private Matcher<Token> matchesToken(int expectedOffset, String expectedText,
			TerminalDefinition expectedTerminalDef) {
		return new DiagnosingMatcher<Token>() {

			boolean matchOffset = true;
			boolean matchText = true;
			boolean matchTerminalDef = true;

			@Override
			public void describeTo(Description descr) {
				if (!matchOffset) {
					descr.appendText("\n  Offset '" + expectedOffset + "'");
				}
				if (!matchText) {
					descr.appendText("\n  Text '" + expectedText + "'");
				}
				if (!matchTerminalDef) {
					descr.appendText("\n  TerminalDef '" + expectedTerminalDef + "'");
				}
			}

			@Override
			protected boolean matches(Object item, Description mismatchDescription) {
				Token actual = (Token) item;

				if (actual.getOffset() != expectedOffset) {
					matchOffset = false;
					mismatchDescription.appendText("\n  Offset was: '" + actual.getOffset() + "'");
				}

				if (!Objects.equals(expectedText, actual.getText())) {
					matchText = false;
					mismatchDescription.appendText("\n  Text was: '" + actual.getText() + "'");
				}

				TerminalDefinition actualTDef = actual.getTerminalDefinition();
				if (expectedTerminalDef != actualTDef) { // must be the same def
					matchTerminalDef = false;

					String actualTDefInfo = toTerminalDefinitionInfo(actualTDef);
					mismatchDescription.appendText("\n  Def was: '" + actualTDefInfo + "'");
				}

				return matchOffset && matchText && matchTerminalDef;
			}
		};
	}

	private TerminalDefinition mkTD(String name, String regex) {
		TerminalDefinition def = ModelFactory.eINSTANCE.createTerminalDefinition();
		def.setName(name);
		def.setRegex(regex);
		return def;
	}

	private void printTokens(List<Token> tokens) {
		System.out.println("### Tokens ###");

		for (Token token : tokens) {
			System.out.println(" - Offset=" + token.getOffset() + ", Text='" + token.getText() + "', TD="
					+ toTerminalDefinitionInfo(token.getTerminalDefinition()));
		}

		System.out.println("##############");
	}

	private String toTerminalDefinitionInfo(TerminalDefinition actualTDef) {
		return actualTDef != null ? actualTDef.getName() : null;
	}

}

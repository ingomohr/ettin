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

class TestTerminalDefinitionBasedScanner {

	private TerminalDefinitionBasedScanner objUT;

	@BeforeEach
	void prep() {
		objUT = new TerminalDefinitionBasedScanner();
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
	void scan_DefinitionsOfSimpleChar_InputContainsUnknownTokens_AllTokensFoundAndMappedAndOnlyUnknownTokensAreUnmapped() {
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
	void scan_DefinitionsOfSimpleChar_InputMatches_AllTokensFoundAndMapped() {
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
	void scan_DefinitionsWithMultipleChars_InputMatches_AllTokensFoundAndMapped() {
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
	void scan_DefinitionsWithMultipleCharsAndSingleChars_InputMatches_FirstMatchingTokenDefinitionWins() {
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

	@Test
	void scan_DefinitionsWithMultipleChars_InputContainsUnknownTokens_AllTokensFoundAndMappedAndOnlyUnknownTokensAreUnmapped() {
		TerminalDefinition tdHello = mkTD("CharHello", "hello");
		TerminalDefinition tdWorld = mkTD("CharWorld", "world");
		TerminalDefinition tdEq = mkTD("CharEq", "=");

		objUT.getDefinitions().add(tdHello);
		objUT.getDefinitions().add(tdWorld);
		objUT.getDefinitions().add(tdEq);

		List<Token> tokens = executeScan(objUT, " hello= worldly");

		assertThat(tokens.get(0), matchesToken(0, " ", null));
		assertThat(tokens.get(1), matchesToken(1, "hello", tdHello));
		assertThat(tokens.get(2), matchesToken(6, "=", tdEq));
		assertThat(tokens.get(3), matchesToken(7, " ", null));
		assertThat(tokens.get(4), matchesToken(8, "world", tdWorld));
		assertThat(tokens.get(5), matchesToken(13, "l", null));
		assertThat(tokens.get(6), matchesToken(14, "y", null));
		assertEquals(7, tokens.size());
	}

	@Test
	void scan_DefinitionsWithMultipleChars_InputContainsUnknownTokens_TokensAreScannedCaseInsensitively() {

		TerminalDefinition tdHello = mkTD("Hello", "Hello");
		TerminalDefinition tdWorld = mkTD("worlD", "worlD");

		objUT.getDefinitions().add(tdHello);
		objUT.getDefinitions().add(tdWorld);

		List<Token> tokens = executeScan(objUT, "Helloworld");
		assertThat(tokens.get(0), matchesToken(0, "Hello", tdHello));
		assertThat(tokens.get(1), matchesToken(5, "w", null));
		assertThat(tokens.get(2), matchesToken(6, "o", null));
		assertThat(tokens.get(3), matchesToken(7, "r", null));
		assertThat(tokens.get(4), matchesToken(8, "l", null));
		assertThat(tokens.get(5), matchesToken(9, "d", null));
		assertEquals(6, tokens.size());
	}

	@Test
	void scan_DefinitionsWithAsterisk_InputMatches_TokensAreScannedSuccessfully() {
		TerminalDefinition tdA = mkTD("a*");
		TerminalDefinition tdBc = mkTD("b*c");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(tdBc);

		List<Token> tokens = executeScan(objUT, "aaabbbbc");
		assertThat(tokens.get(0), matchesToken(0, "aaa", tdA));
		assertThat(tokens.get(1), matchesToken(3, "bbbbc", tdBc));
		assertEquals(2, tokens.size());
	}

	@Test
	void scan_DefinitionsWithEscapedAsterisk_InputMatches_TokensAreScannedSuccessfully() {
		TerminalDefinition tdA = mkTD("a\\*");

		objUT.getDefinitions().add(tdA);

		List<Token> tokens = executeScan(objUT, "a*");
		assertThat(tokens.get(0), matchesToken(0, "a*", tdA));
		assertEquals(1, tokens.size());
	}

	@Test
	void scan_DefinitionsWithEscapedAndUnescapedAsterisk_UnknownTokensInInput_TokensAreScannedSuccessfully() {
		TerminalDefinition tdA = mkTD("a*");
		TerminalDefinition tdBc = mkTD("b*c");
		TerminalDefinition tdCAst = mkTD("c\\*");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(tdBc);
		objUT.getDefinitions().add(tdCAst);

		List<Token> tokens = executeScan(objUT, "aaaaaaaaaxbbbbcc* ");
		assertThat(tokens.get(0), matchesToken(0, "aaaaaaaaa", tdA));
		assertThat(tokens.get(1), matchesToken(9, "x", null));
		assertThat(tokens.get(2), matchesToken(10, "bbbbc", tdBc));
		assertThat(tokens.get(3), matchesToken(15, "c*", tdCAst));
		assertThat(tokens.get(4), matchesToken(17, " ", null));

		assertEquals(5, tokens.size());
	}

	@Test
	void scan_DefinitionsWithPlus_InputMatches_TokensAreScannedSuccessfully() {
		TerminalDefinition tdA = mkTD("aa+");
		TerminalDefinition tdBc = mkTD("b+c");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(tdBc);

		List<Token> tokens = executeScan(objUT, "aabc");
		assertThat(tokens.get(0), matchesToken(0, "aa", tdA));
		assertThat(tokens.get(1), matchesToken(2, "bc", tdBc));
		assertEquals(2, tokens.size());
	}

	@Test
	void scan_DefinitionsWithEscapedPlus_InputMatches_TokensAreScannedSuccessfully() {
		TerminalDefinition tdA = mkTD("aa\\+");
		TerminalDefinition tdBc = mkTD("b\\+c");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(tdBc);

		List<Token> tokens = executeScan(objUT, "aa+b+c");
		assertThat(tokens.get(0), matchesToken(0, "aa+", tdA));
		assertThat(tokens.get(1), matchesToken(3, "b+c", tdBc));
		assertEquals(2, tokens.size());
	}

	@Test
	void scan_DefinitionsWithEscapedPlus_InputDoesntMatch_TokensAreNotMapped() {
		TerminalDefinition tdA = mkTD("aa\\+");
		TerminalDefinition tdBc = mkTD("b\\+c");

		objUT.getDefinitions().add(tdA);
		objUT.getDefinitions().add(tdBc);

		List<Token> tokens = executeScan(objUT, "a+b++c");
		assertThat(tokens.get(0), matchesToken(0, "a", null));
		assertThat(tokens.get(1), matchesToken(1, "+", null));
		assertThat(tokens.get(2), matchesToken(2, "b", null));
		assertThat(tokens.get(3), matchesToken(3, "+", null));
		assertThat(tokens.get(4), matchesToken(4, "+", null));
		assertThat(tokens.get(5), matchesToken(5, "c", null));
		assertEquals(6, tokens.size());
	}

	@Test
	void scan_DefinitionsWithPlus_InputDoesntMatch_TokensAreNotMapped() {
		TerminalDefinition tdAPlus = mkTD("aa+");

		objUT.getDefinitions().add(tdAPlus);

		List<Token> tokens = executeScan(objUT, "a");
		assertThat(tokens.get(0), matchesToken(0, "a", null));
	}

	private List<Token> executeScan(TerminalDefinitionBasedScanner objectUnderTest, String document) {
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
					String info = toTerminalDefinitionInfo(expectedTerminalDef);
					descr.appendText("\n  TerminalDef '" + info + "'");
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

	private TerminalDefinition mkTD(String regex) {
		return mkTD(regex, regex);
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

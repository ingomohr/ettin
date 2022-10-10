package org.ingomohr.ettin.base.scanner.impl;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

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

		List<Token> tokens = objUT.scan(" a=X@9a ");

		assertEquals(8, tokens.size());

		int i = -1;
		assertEquals(mkTStr(++i, " ", null), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, "a", tdA), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, "=", tdEq), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, "X", null), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, "@", tdAt), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, "9", td9), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, "a", tdA), toStr(tokens.get(i)));
		assertEquals(mkTStr(++i, " ", null), toStr(tokens.get(i)));

		assertSame(tdA, tokens.get(1).getTerminalDefinition());
		assertSame(tdEq, tokens.get(2).getTerminalDefinition());
		assertSame(tdAt, tokens.get(4).getTerminalDefinition());
		assertSame(td9, tokens.get(5).getTerminalDefinition());
		assertSame(tdA, tokens.get(6).getTerminalDefinition());
	}

	private TerminalDefinition mkTD(String name, String regex) {
		TerminalDefinition def = ModelFactory.eINSTANCE.createTerminalDefinition();
		def.setName(name);
		def.setRegex(regex);
		return def;
	}

	private String mkTStr(int offset, String text, TerminalDefinition definition) {
		Token token = mkT(offset, text, definition);
		return toStr(token);
	}

	private Token mkT(int offset, String text, TerminalDefinition definition) {
		Token token = ModelFactory.eINSTANCE.createToken();
		token.setOffset(offset);
		token.setTerminalDefinition(definition);
		token.setText(text);
		return token;
	}

	private String toStr(Token token) {
		TerminalDefinition def = token.getTerminalDefinition();
		return "offset=" + token.getOffset() + ", name='" + token.getText() + "', def="
				+ (def != null ? def.getName() : "-");
	}

}

package org.ingomohr.ettin.base.scanner.impl.dfa.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFA;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link RegexDFAFactory}
 * 
 * @author ingomohr
 */
class TestRegexDFAFactory {

	private RegexDFAFactory objUT;

	@BeforeEach
	void prep() {
		objUT = new RegexDFAFactory();
	}

	@Test
	void simpleChar() {
		DFA dfa = objUT.create("a");
		dfa.accept('a');
		assertEquals(true, dfa.isAccepting());
	}

	@Test
	void simpleCharSequence() {
		DFA dfa = objUT.create("abcde");
		dfa.accept('a');
		dfa.accept('b');
		dfa.accept('c');
		dfa.accept('d');
		dfa.accept('e');
		assertEquals(true, dfa.isAccepting());

		dfa.accept('f');
		assertEquals(false, dfa.isAccepting());
	}

	@Test
	void simpleString() {
		DFA dfa = objUT.create("abcde");
		assertEquals(true, dfa.acceptAll("abcde"));
		assertEquals(true, dfa.isAccepting());

		assertEquals(false, dfa.acceptAll("f"));
		assertEquals(false, dfa.isAccepting());
	}

	@Test
	void simplePlus0_DoesntMatch() {
		DFA dfa = objUT.create("a+");
		assertEquals(false, dfa.isAccepting());
	}

	@Test
	void simplePlus1() {
		DFA dfa = objUT.create("a+");
		dfa.accept('a');
		assertEquals(true, dfa.isAccepting());
	}

	@Test
	void simplePlus2() {
		DFA dfa = objUT.create("a+");
		dfa.accept('a');
		dfa.accept('a');
		assertEquals(true, dfa.isAccepting());
	}

	@Test
	void simplePlus_DoesntMatch() {
		DFA dfa = objUT.create("a+b");
		dfa.accept('a');
		dfa.accept('a');
		assertEquals(false, dfa.isAccepting());
	}

	@Test
	void simpleAsterisk0() {
		DFA dfa = objUT.create("a*");
		assertEquals(true, dfa.isAccepting());
	}

	@Test
	void simpleAsterisk1() {
		DFA dfa = objUT.create("a*");
		dfa.accept('a');
		assertEquals(true, dfa.isAccepting());
	}

	@Test
	void simpleAsterisk2() {
		DFA dfa = objUT.create("a*");
		dfa.accept('a');
		dfa.accept('a');
		assertEquals(true, dfa.isAccepting());
	}

	@Test
	void simpleAsterisk_DoesntMatch() {
		DFA dfa = objUT.create("a*");
		dfa.accept('a');
		dfa.accept('b');
		assertEquals(false, dfa.isAccepting());
	}

}

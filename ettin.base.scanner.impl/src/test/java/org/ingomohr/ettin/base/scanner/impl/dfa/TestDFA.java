package org.ingomohr.ettin.base.scanner.impl.dfa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDFA {

	private DFA objUT;

	@BeforeEach
	void prep() {
		objUT = new DFA();
	}

	@Test
	void constructor_NewObjectHasStartNode() {
		assertNotNull(objUT.getStart());
		assertSame(objUT.getStart(), objUT.getCurrentStatus());
		assertFalse(objUT.getStart().isAccepting());
	}

	@Test
	void acceptAll_inputIsEmptyAndDFADoesntAcceptStartNode_ReturnsFalse() {
		objUT.getStart().setAccepting(false);

		assertEquals(false, objUT.acceptAll(""));
	}

	@Test
	void acceptAll_inputIsEmptyAndDFAAcceptsStartNode_ReturnsTrue() {
		objUT.getStart().setAccepting(true);

		assertEquals(true, objUT.acceptAll(""));
	}

	@Test
	void acceptAll_inputIsNotEmptyAndDFADoesntAcceptInput_ReturnsFalse() {
		givenDFADoesNotAccept(objUT, "abc");

		assertEquals(false, objUT.acceptAll("abc"));
	}

	@Test
	void acceptAll_inputIsNotEmptyAndDFAAcceptsInput_ReturnsTrue() {
		givenDFADoesAccept(objUT, "abc");

		assertEquals(true, objUT.acceptAll("abc"));
	}

	private void givenDFADoesAccept(DFA dfa, String input) {
		setupDFAForInput(dfa, input, true);
	}

	private void givenDFADoesNotAccept(DFA dfa, String input) {
		setupDFAForInput(dfa, input, false);
	}

	private void setupDFAForInput(DFA dfa, String input, boolean acceptsInput) {
		DFAStatus status = dfa.getStart();
		for (char c : input.toCharArray()) {

			DFATransition t = new DFATransition();

			t.setTester(someChar -> someChar == c);

			t.setSource(dfa.getCurrentStatus());
			status.getTransitions().add(t);

			DFAStatus targetStatus = new DFAStatus();
			t.setTarget(targetStatus);
			status = targetStatus;
		}

		status.setAccepting(acceptsInput);
	}

}

package org.ingomohr.ettin.base.scanner.impl.dfa.factory.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.function.Predicate;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDFATransitionFactory {

	private DFATransitionFactory objUT;

	@BeforeEach
	void prep() {
		objUT = new DFATransitionFactory();
	}

	@SuppressWarnings("unchecked")
	@Test
	void createTransition() {
		DFAStatus source = mock(DFAStatus.class);
		List<DFATransition> transitions = mock(List.class);
		when(source.getTransitions()).thenReturn(transitions);

		DFAStatus target = mock(DFAStatus.class);
		Predicate<Character> tester = mock(Predicate.class);

		DFATransition transition = objUT.createTransition(source, target, tester);
		assertSame(source, transition.getSource());
		assertSame(target, transition.getTarget());
		assertSame(tester, transition.getTester());
		verify(transitions, times(1)).add(transition);
		verifyNoMoreInteractions(transitions);
	}

}

package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.function.Predicate;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.util.DFATransitionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSpecialCharAsteriskConsumingStrategy {

	private SpecialCharAsteriskConsumingStrategy objUT;

	private DFATransitionFactory transitionFactory;

	private DFATransition expectedTransition;

	@BeforeEach
	void prep() {
		transitionFactory = mock(DFATransitionFactory.class);
		when(transitionFactory.createTransition(any(), any(), any())).thenReturn(expectedTransition);

		objUT = new SpecialCharAsteriskConsumingStrategy() {

			@Override
			protected DFATransitionFactory createDFATransitionFactory() {
				return transitionFactory;
			}
		};

	}

	@Test
	void appliesTo() {
		RegexDFAFactoryStatus status = new RegexDFAFactoryStatus();
		status.setEscapedCharacter(false);

		assertEquals(false, objUT.appliesTo('c', status));
		assertEquals(false, objUT.appliesTo('+', status));
		assertEquals(true, objUT.appliesTo('*', status));

		status.setEscapedCharacter(true);

		assertEquals(false, objUT.appliesTo('c', status));
		assertEquals(false, objUT.appliesTo('+', status));
		assertEquals(false, objUT.appliesTo('*', status));
	}

	@Test
	void apply() {
		RegexDFAFactoryStatus status = mock(RegexDFAFactoryStatus.class);
		DFATransition currentTransition = mock(DFATransition.class);
		when(status.getCurrentTransition()).thenReturn(currentTransition);

		DFAStatus currentTransitionSource = mock(DFAStatus.class);
		when(currentTransition.getSource()).thenReturn(currentTransitionSource);

		DFAStatus currentStatus = mock(DFAStatus.class);
		when(status.getCurrentStatus()).thenReturn(currentStatus);

		@SuppressWarnings("unchecked")
		Predicate<Character> tester = mock(Predicate.class);
		when(currentTransition.getTester()).thenReturn(tester);

		DFATransition actualTransition = objUT.apply('*', status);
		assertSame(expectedTransition, actualTransition);

		verify(transitionFactory).createTransition(currentStatus, currentStatus, tester);

		verifyNoMoreInteractions(transitionFactory);

		verify(currentTransitionSource).setAccepting(true);
		verifyNoMoreInteractions(currentTransitionSource);

		verify(status).setEscapedCharacter(false);
		verify(status).getCurrentStatus();
		verify(status).getCurrentTransition();
		verifyNoMoreInteractions(status);
	}

}

package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.function.Predicate;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.util.DFATransitionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class TestNormalCharConsumingStrategy {

	private NormalCharConsumingStrategy objUT;

	private DFATransitionFactory transitionFactory;

	private DFATransition expectedTransition;

	private ArgumentCaptor<DFAStatus> captorSource;
	private ArgumentCaptor<DFAStatus> captorTarget;
	private ArgumentCaptor<Predicate<Character>> captorTester;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void prep() {
		transitionFactory = mock(DFATransitionFactory.class);

		captorSource = ArgumentCaptor.forClass(DFAStatus.class);
		captorTarget = ArgumentCaptor.forClass(DFAStatus.class);
		captorTester = ArgumentCaptor.forClass(Predicate.class);

		when(transitionFactory.createTransition(captorSource.capture(), captorTarget.capture(), captorTester.capture()))
				.thenReturn(expectedTransition);

		objUT = new NormalCharConsumingStrategy() {

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

		assertEquals(true, objUT.appliesTo('c', status));
		assertEquals(false, objUT.appliesTo('*', status));
		assertEquals(false, objUT.appliesTo('+', status));

		status.setEscapedCharacter(true);
		assertEquals(true, objUT.appliesTo('c', status));
		assertEquals(true, objUT.appliesTo('*', status));
		assertEquals(true, objUT.appliesTo('+', status));
	}

	@Test
	void apply() {
		DFAStatus current = mock(DFAStatus.class);

		RegexDFAFactoryStatus status = new RegexDFAFactoryStatus();
		status.setCurrentStatus(current);

		DFATransition actualTransition = objUT.apply('c', status);
		assertSame(expectedTransition, actualTransition);

		assertSame(current, captorSource.getValue());
		assertNotSame(current, captorTarget.getValue());
		assertNotNull(captorTarget.getValue());

		assertEquals(true, captorTester.getValue().test('c'));
		assertEquals(false, captorTester.getValue().test('d'));
	}

}

package org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.strategy;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.regex.RegexDFAFactoryStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.factory.util.DFATransitionFactory;
import org.junit.jupiter.api.Test;

class TestAbstractRegexFactoryCharacterConsumingStrategy {

	@Test
	void createDFATransitionFactory_ReturnsANewFactory() {
		AbstractRegexFactoryCharacterConsumingStrategy objUt = new AbstractRegexFactoryCharacterConsumingStrategy() {

			@Override
			public DFATransition apply(char c, RegexDFAFactoryStatus status) {
				return null;
			}

			@Override
			public boolean appliesTo(char c, RegexDFAFactoryStatus status) {
				return false;
			}
		};

		DFATransitionFactory f1 = objUt.createDFATransitionFactory();
		DFATransitionFactory f2 = objUt.createDFATransitionFactory();
		assertNotNull(f1);
		assertNotNull(f2);
		assertNotEquals(f1, f2);
	}

}

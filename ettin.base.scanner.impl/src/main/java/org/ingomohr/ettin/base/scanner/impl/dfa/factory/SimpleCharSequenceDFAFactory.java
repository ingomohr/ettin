package org.ingomohr.ettin.base.scanner.impl.dfa.factory;

import static java.util.Objects.requireNonNull;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFA;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;

/**
 * DFA factory to create {@link DFA}s for simple chars and sequences of simple
 * chars respectively.
 * 
 * @author ingomohr
 */
public class SimpleCharSequenceDFAFactory implements DFAFactory {

	@Override
	public DFA create(String specification) {
		requireNonNull(specification);

		DFA dfa = new DFA();
		dfa.setStart(new DFAStatus());

		DFAStatus currentStatus = dfa.getStart();

		for (char c : specification.toCharArray()) {
			DFAStatus target = new DFAStatus();
			DFATransition transition = new DFATransition();
			transition.setTarget(target);
			transition.setTester(someChar -> someChar == c);
			currentStatus.getTransitions().add(transition);
			currentStatus = target;
		}

		currentStatus.setAccepting(true);

		dfa.setCurrentStatus(dfa.getStart());

		return dfa;
	}

}

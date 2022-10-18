package org.ingomohr.ettin.base.scanner.impl.dfa.factory;

import static java.util.Objects.requireNonNull;

import java.util.concurrent.atomic.AtomicReference;

import org.ingomohr.ettin.base.scanner.impl.dfa.DFA;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFAStatus;
import org.ingomohr.ettin.base.scanner.impl.dfa.DFATransition;

/**
 * DFA factory to create {@link DFA}s for regexes.
 * 
 * @author ingomohr
 */
public class RegexDFAFactory implements DFAFactory {

	@Override
	public DFA create(String specification) {
		requireNonNull(specification);
		
		DFA dfa = new DFA();
		dfa.setStart(new DFAStatus());

		DFAStatus currentStatus = dfa.getStart();

		AtomicReference<DFATransition> mostRecentTransitionRef = new AtomicReference<>();

		boolean isEscaped = false;

		for (char c : specification.toCharArray()) {
			switch (c) {

			case '\\' -> {
				isEscaped = true;
			}
			case '*' -> {
				if (!isEscaped) {
					DFATransition transition = new DFATransition();
					transition.setTarget(currentStatus);
					transition.setTester(mostRecentTransitionRef.get().getTester());
					currentStatus.getTransitions().add(transition);
					mostRecentTransitionRef.set(transition);
				} else {
					currentStatus = recordNewStatusForNormalChar(currentStatus, mostRecentTransitionRef, c);
				}
				isEscaped = false;
			}
			default -> {
				currentStatus = recordNewStatusForNormalChar(currentStatus, mostRecentTransitionRef, c);
				isEscaped = false;
			}
			}
		}

		currentStatus.setAccepting(true);

		dfa.setCurrentStatus(dfa.getStart());

		return dfa;
	}

	private DFAStatus recordNewStatusForNormalChar(DFAStatus source,
			AtomicReference<DFATransition> mostRecentTransitionRef, char c) {
		DFAStatus target = new DFAStatus();
		DFATransition transition = new DFATransition();
		transition.setTarget(target);
		transition.setTester(someChar -> someChar == c);
		source.getTransitions().add(transition);

		mostRecentTransitionRef.set(transition);

		return target;
	}

}

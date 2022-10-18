package org.ingomohr.ettin.base.scanner.impl.dfa.factory;

import static java.util.Objects.requireNonNull;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

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
					currentStatus = createTransitionForAsterisk(currentStatus, mostRecentTransitionRef);
				} else {
					currentStatus = createTransitionForNormalChar(currentStatus, mostRecentTransitionRef, c);
				}
				isEscaped = false;
			}
			case '+' -> {
				if (!isEscaped) {
					currentStatus = createTransitionForPlus(currentStatus, mostRecentTransitionRef);

				} else {
					currentStatus = createTransitionForNormalChar(currentStatus, mostRecentTransitionRef, c);
				}
				isEscaped = false;
			}
			default -> {
				currentStatus = createTransitionForNormalChar(currentStatus, mostRecentTransitionRef, c);
				isEscaped = false;
			}
			}
		}

		currentStatus.setAccepting(true);

		dfa.setCurrentStatus(dfa.getStart());

		return dfa;
	}

	private DFAStatus createTransitionForPlus(DFAStatus source,
			AtomicReference<DFATransition> mostRecentTransitionRef) {
		mostRecentTransitionRef.set(createTransition(source, source, mostRecentTransitionRef.get().getTester()));
		return source;
	}

	private DFAStatus createTransitionForAsterisk(DFAStatus source,
			AtomicReference<DFATransition> mostRecentTransitionRef) {
		mostRecentTransitionRef.get().getSource().setAccepting(true);
		mostRecentTransitionRef.set(createTransition(source, source, mostRecentTransitionRef.get().getTester()));
		return source;
	}

	private DFAStatus createTransitionForNormalChar(DFAStatus source,
			AtomicReference<DFATransition> mostRecentTransitionRef, char c) {
		DFAStatus target = new DFAStatus();
		mostRecentTransitionRef.set(createTransition(source, target, someChar -> someChar == c));
		return target;
	}

	private DFATransition createTransition(DFAStatus source, DFAStatus target, Predicate<Character> tester) {
		DFATransition transition = new DFATransition();
		transition.setSource(source);
		transition.setTarget(target);
		transition.setTester(tester);
		source.getTransitions().add(transition);
		return transition;
	}

}

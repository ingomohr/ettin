/**
 */
package org.ingomohr.ettin.base.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.ingomohr.ettin.base.model.ModelPackage;
import org.ingomohr.ettin.base.model.TerminalDefinition;
import org.ingomohr.ettin.base.model.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.TokenImpl#getTerminalDefinition <em>Terminal Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TokenImpl extends MinimalEObjectImpl.Container implements Token {
	/**
	 * The cached value of the '{@link #getTerminalDefinition() <em>Terminal Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminalDefinition()
	 * @generated
	 * @ordered
	 */
	protected TerminalDefinition terminalDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TOKEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalDefinition getTerminalDefinition() {
		if (terminalDefinition != null && terminalDefinition.eIsProxy()) {
			InternalEObject oldTerminalDefinition = (InternalEObject)terminalDefinition;
			terminalDefinition = (TerminalDefinition)eResolveProxy(oldTerminalDefinition);
			if (terminalDefinition != oldTerminalDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TOKEN__TERMINAL_DEFINITION, oldTerminalDefinition, terminalDefinition));
			}
		}
		return terminalDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalDefinition basicGetTerminalDefinition() {
		return terminalDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminalDefinition(TerminalDefinition newTerminalDefinition) {
		TerminalDefinition oldTerminalDefinition = terminalDefinition;
		terminalDefinition = newTerminalDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TOKEN__TERMINAL_DEFINITION, oldTerminalDefinition, terminalDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TOKEN__TERMINAL_DEFINITION:
				if (resolve) return getTerminalDefinition();
				return basicGetTerminalDefinition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.TOKEN__TERMINAL_DEFINITION:
				setTerminalDefinition((TerminalDefinition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.TOKEN__TERMINAL_DEFINITION:
				setTerminalDefinition((TerminalDefinition)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.TOKEN__TERMINAL_DEFINITION:
				return terminalDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //TokenImpl

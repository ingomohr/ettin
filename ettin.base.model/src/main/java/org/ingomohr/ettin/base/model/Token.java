/**
 */
package org.ingomohr.ettin.base.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.Token#getTerminalDefinition <em>Terminal Definition</em>}</li>
 * </ul>
 *
 * @see org.ingomohr.ettin.base.model.ModelPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends EObject {
	/**
	 * Returns the value of the '<em><b>Terminal Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal Definition</em>' reference.
	 * @see #setTerminalDefinition(TerminalDefinition)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getToken_TerminalDefinition()
	 * @model
	 * @generated
	 */
	TerminalDefinition getTerminalDefinition();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.Token#getTerminalDefinition <em>Terminal Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminal Definition</em>' reference.
	 * @see #getTerminalDefinition()
	 * @generated
	 */
	void setTerminalDefinition(TerminalDefinition value);

} // Token

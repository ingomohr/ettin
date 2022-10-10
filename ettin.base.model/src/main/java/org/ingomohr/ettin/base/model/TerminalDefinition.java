/**
 */
package org.ingomohr.ettin.base.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.TerminalDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.TerminalDefinition#getRegex <em>Regex</em>}</li>
 * </ul>
 *
 * @see org.ingomohr.ettin.base.model.ModelPackage#getTerminalDefinition()
 * @model
 * @generated
 */
public interface TerminalDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getTerminalDefinition_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.TerminalDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex</em>' attribute.
	 * @see #setRegex(String)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getTerminalDefinition_Regex()
	 * @model unique="false"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.TerminalDefinition#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

} // TerminalDefinition

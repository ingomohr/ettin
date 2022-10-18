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
 *   <li>{@link org.ingomohr.ettin.base.model.Token#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.Token#getText <em>Text</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.Token#getTerminalDefinition <em>Terminal Definition</em>}</li>
 * </ul>
 *
 * @see org.ingomohr.ettin.base.model.ModelPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends EObject {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getToken_Offset()
	 * @model unique="false"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.Token#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getToken_Text()
	 * @model unique="false"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.Token#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

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

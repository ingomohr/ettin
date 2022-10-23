/**
 */
package org.ingomohr.ettin.base.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.SyntaxTree#getRoot <em>Root</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.SyntaxTree#getTerminalDefinitions <em>Terminal Definitions</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.SyntaxTree#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTree()
 * @model
 * @generated
 */
public interface SyntaxTree extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(SyntaxTreeNode)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTree_Root()
	 * @model containment="true"
	 * @generated
	 */
	SyntaxTreeNode getRoot();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.SyntaxTree#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(SyntaxTreeNode value);

	/**
	 * Returns the value of the '<em><b>Terminal Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.ingomohr.ettin.base.model.TerminalDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal Definitions</em>' containment reference list.
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTree_TerminalDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TerminalDefinition> getTerminalDefinitions();

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link org.ingomohr.ettin.base.model.Token}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTree_Tokens()
	 * @model containment="true"
	 * @generated
	 */
	EList<Token> getTokens();

} // SyntaxTree

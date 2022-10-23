/**
 */
package org.ingomohr.ettin.base.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.SyntaxTreeNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.SyntaxTreeNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.SyntaxTreeNode#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTreeNode()
 * @model
 * @generated
 */
public interface SyntaxTreeNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.ingomohr.ettin.base.model.SyntaxTreeNode}.
	 * It is bidirectional and its opposite is '{@link org.ingomohr.ettin.base.model.SyntaxTreeNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTreeNode_Children()
	 * @see org.ingomohr.ettin.base.model.SyntaxTreeNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<SyntaxTreeNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.ingomohr.ettin.base.model.SyntaxTreeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(SyntaxTreeNode)
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTreeNode_Parent()
	 * @see org.ingomohr.ettin.base.model.SyntaxTreeNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	SyntaxTreeNode getParent();

	/**
	 * Sets the value of the '{@link org.ingomohr.ettin.base.model.SyntaxTreeNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SyntaxTreeNode value);

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' reference list.
	 * The list contents are of type {@link org.ingomohr.ettin.base.model.Token}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' reference list.
	 * @see org.ingomohr.ettin.base.model.ModelPackage#getSyntaxTreeNode_Tokens()
	 * @model
	 * @generated
	 */
	EList<Token> getTokens();

} // SyntaxTreeNode

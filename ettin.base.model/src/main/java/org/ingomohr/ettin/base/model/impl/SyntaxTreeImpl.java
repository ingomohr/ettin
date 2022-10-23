/**
 */
package org.ingomohr.ettin.base.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.ingomohr.ettin.base.model.ModelPackage;
import org.ingomohr.ettin.base.model.SyntaxTree;
import org.ingomohr.ettin.base.model.SyntaxTreeNode;
import org.ingomohr.ettin.base.model.TerminalDefinition;
import org.ingomohr.ettin.base.model.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Syntax Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.SyntaxTreeImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.SyntaxTreeImpl#getTerminalDefinitions <em>Terminal Definitions</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.SyntaxTreeImpl#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SyntaxTreeImpl extends MinimalEObjectImpl.Container implements SyntaxTree {
	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected SyntaxTreeNode root;

	/**
	 * The cached value of the '{@link #getTerminalDefinitions() <em>Terminal Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminalDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminalDefinition> terminalDefinitions;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<Token> tokens;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SyntaxTreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SYNTAX_TREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxTreeNode getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(SyntaxTreeNode newRoot, NotificationChain msgs) {
		SyntaxTreeNode oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SYNTAX_TREE__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(SyntaxTreeNode newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SYNTAX_TREE__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SYNTAX_TREE__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYNTAX_TREE__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminalDefinition> getTerminalDefinitions() {
		if (terminalDefinitions == null) {
			terminalDefinitions = new EObjectContainmentEList<TerminalDefinition>(TerminalDefinition.class, this, ModelPackage.SYNTAX_TREE__TERMINAL_DEFINITIONS);
		}
		return terminalDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Token> getTokens() {
		if (tokens == null) {
			tokens = new EObjectContainmentEList<Token>(Token.class, this, ModelPackage.SYNTAX_TREE__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SYNTAX_TREE__ROOT:
				return basicSetRoot(null, msgs);
			case ModelPackage.SYNTAX_TREE__TERMINAL_DEFINITIONS:
				return ((InternalEList<?>)getTerminalDefinitions()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYNTAX_TREE__TOKENS:
				return ((InternalEList<?>)getTokens()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.SYNTAX_TREE__ROOT:
				return getRoot();
			case ModelPackage.SYNTAX_TREE__TERMINAL_DEFINITIONS:
				return getTerminalDefinitions();
			case ModelPackage.SYNTAX_TREE__TOKENS:
				return getTokens();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.SYNTAX_TREE__ROOT:
				setRoot((SyntaxTreeNode)newValue);
				return;
			case ModelPackage.SYNTAX_TREE__TERMINAL_DEFINITIONS:
				getTerminalDefinitions().clear();
				getTerminalDefinitions().addAll((Collection<? extends TerminalDefinition>)newValue);
				return;
			case ModelPackage.SYNTAX_TREE__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends Token>)newValue);
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
			case ModelPackage.SYNTAX_TREE__ROOT:
				setRoot((SyntaxTreeNode)null);
				return;
			case ModelPackage.SYNTAX_TREE__TERMINAL_DEFINITIONS:
				getTerminalDefinitions().clear();
				return;
			case ModelPackage.SYNTAX_TREE__TOKENS:
				getTokens().clear();
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
			case ModelPackage.SYNTAX_TREE__ROOT:
				return root != null;
			case ModelPackage.SYNTAX_TREE__TERMINAL_DEFINITIONS:
				return terminalDefinitions != null && !terminalDefinitions.isEmpty();
			case ModelPackage.SYNTAX_TREE__TOKENS:
				return tokens != null && !tokens.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SyntaxTreeImpl

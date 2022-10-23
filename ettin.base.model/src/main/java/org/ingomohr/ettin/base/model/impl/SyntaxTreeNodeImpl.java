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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.ingomohr.ettin.base.model.ModelPackage;
import org.ingomohr.ettin.base.model.SyntaxTreeNode;
import org.ingomohr.ettin.base.model.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Syntax Tree Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.SyntaxTreeNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.SyntaxTreeNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.ingomohr.ettin.base.model.impl.SyntaxTreeNodeImpl#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SyntaxTreeNodeImpl extends MinimalEObjectImpl.Container implements SyntaxTreeNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SyntaxTreeNode> children;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' reference list.
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
	protected SyntaxTreeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SYNTAX_TREE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SyntaxTreeNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<SyntaxTreeNode>(SyntaxTreeNode.class, this, ModelPackage.SYNTAX_TREE_NODE__CHILDREN, ModelPackage.SYNTAX_TREE_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxTreeNode getParent() {
		if (eContainerFeatureID() != ModelPackage.SYNTAX_TREE_NODE__PARENT) return null;
		return (SyntaxTreeNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxTreeNode basicGetParent() {
		if (eContainerFeatureID() != ModelPackage.SYNTAX_TREE_NODE__PARENT) return null;
		return (SyntaxTreeNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(SyntaxTreeNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, ModelPackage.SYNTAX_TREE_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SyntaxTreeNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != ModelPackage.SYNTAX_TREE_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ModelPackage.SYNTAX_TREE_NODE__CHILDREN, SyntaxTreeNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYNTAX_TREE_NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Token> getTokens() {
		if (tokens == null) {
			tokens = new EObjectResolvingEList<Token>(Token.class, this, ModelPackage.SYNTAX_TREE_NODE__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SYNTAX_TREE_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((SyntaxTreeNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SYNTAX_TREE_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, ModelPackage.SYNTAX_TREE_NODE__CHILDREN, SyntaxTreeNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.SYNTAX_TREE_NODE__CHILDREN:
				return getChildren();
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ModelPackage.SYNTAX_TREE_NODE__TOKENS:
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
			case ModelPackage.SYNTAX_TREE_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SyntaxTreeNode>)newValue);
				return;
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				setParent((SyntaxTreeNode)newValue);
				return;
			case ModelPackage.SYNTAX_TREE_NODE__TOKENS:
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
			case ModelPackage.SYNTAX_TREE_NODE__CHILDREN:
				getChildren().clear();
				return;
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				setParent((SyntaxTreeNode)null);
				return;
			case ModelPackage.SYNTAX_TREE_NODE__TOKENS:
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
			case ModelPackage.SYNTAX_TREE_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case ModelPackage.SYNTAX_TREE_NODE__PARENT:
				return basicGetParent() != null;
			case ModelPackage.SYNTAX_TREE_NODE__TOKENS:
				return tokens != null && !tokens.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SyntaxTreeNodeImpl

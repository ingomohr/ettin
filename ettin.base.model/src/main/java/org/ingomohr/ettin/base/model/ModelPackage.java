/**
 */
package org.ingomohr.ettin.base.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.ingomohr.ettin.base.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.ingomohr.ettin.base.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.ingomohr.ettin.base.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.ingomohr.ettin.base.model.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ingomohr.ettin.base.model.impl.TokenImpl
	 * @see org.ingomohr.ettin.base.model.impl.ModelPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 0;

	/**
	 * The feature id for the '<em><b>Terminal Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__TERMINAL_DEFINITION = 0;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.ingomohr.ettin.base.model.impl.TerminalDefinitionImpl <em>Terminal Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.ingomohr.ettin.base.model.impl.TerminalDefinitionImpl
	 * @see org.ingomohr.ettin.base.model.impl.ModelPackageImpl#getTerminalDefinition()
	 * @generated
	 */
	int TERMINAL_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_DEFINITION__REGEX = 1;

	/**
	 * The number of structural features of the '<em>Terminal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Terminal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_DEFINITION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.ingomohr.ettin.base.model.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see org.ingomohr.ettin.base.model.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the reference '{@link org.ingomohr.ettin.base.model.Token#getTerminalDefinition <em>Terminal Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Terminal Definition</em>'.
	 * @see org.ingomohr.ettin.base.model.Token#getTerminalDefinition()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_TerminalDefinition();

	/**
	 * Returns the meta object for class '{@link org.ingomohr.ettin.base.model.TerminalDefinition <em>Terminal Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal Definition</em>'.
	 * @see org.ingomohr.ettin.base.model.TerminalDefinition
	 * @generated
	 */
	EClass getTerminalDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.ingomohr.ettin.base.model.TerminalDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.ingomohr.ettin.base.model.TerminalDefinition#getName()
	 * @see #getTerminalDefinition()
	 * @generated
	 */
	EAttribute getTerminalDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.ingomohr.ettin.base.model.TerminalDefinition#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see org.ingomohr.ettin.base.model.TerminalDefinition#getRegex()
	 * @see #getTerminalDefinition()
	 * @generated
	 */
	EAttribute getTerminalDefinition_Regex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.ingomohr.ettin.base.model.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ingomohr.ettin.base.model.impl.TokenImpl
		 * @see org.ingomohr.ettin.base.model.impl.ModelPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '<em><b>Terminal Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__TERMINAL_DEFINITION = eINSTANCE.getToken_TerminalDefinition();

		/**
		 * The meta object literal for the '{@link org.ingomohr.ettin.base.model.impl.TerminalDefinitionImpl <em>Terminal Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.ingomohr.ettin.base.model.impl.TerminalDefinitionImpl
		 * @see org.ingomohr.ettin.base.model.impl.ModelPackageImpl#getTerminalDefinition()
		 * @generated
		 */
		EClass TERMINAL_DEFINITION = eINSTANCE.getTerminalDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL_DEFINITION__NAME = eINSTANCE.getTerminalDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL_DEFINITION__REGEX = eINSTANCE.getTerminalDefinition_Regex();

	}

} //ModelPackage

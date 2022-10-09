/**
 * Base model for Ettin
 * 
 * @author ingomohr
 */
module ettin.base.model {

	requires java.base;
	
	requires transitive org.eclipse.emf.ecore;
	requires transitive org.eclipse.emf.common;

	exports org.ingomohr.ettin.base.model;
	exports org.ingomohr.ettin.base.model.impl;
	exports org.ingomohr.ettin.base.model.util;
	
	

}
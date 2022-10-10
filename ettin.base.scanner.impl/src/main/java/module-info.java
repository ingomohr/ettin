import org.ingomohr.ettin.base.scanner.Scanner;
import org.ingomohr.ettin.base.scanner.impl.TerminalBasedScanner;

/**
 * Implementation module for a {@link Scanner}.
 * 
 * @author ingomohr
 *
 * @provides Scanner
 */
module ettin.base.scanner.impl {

	requires java.base;
	requires transitive ettin.base.scanner;
	
	exports org.ingomohr.ettin.base.scanner.impl;

	provides Scanner with TerminalBasedScanner;

}
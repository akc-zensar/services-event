/*
 * 
 */
package org.akc.exception;

import org.apache.log4j.Logger;

/**
 * User: mukesh
 * Date: 2/8/15
 */

/**
 * InvalidException is the base class for Exception.
 * 
 */
public class InvalidException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	 static final Logger logger = Logger.getLogger(InvalidException.class);
	/**
	 * InvalidException  a new invalid exception.
	 *
	 * @param String
	 *            
	 */
	public InvalidException(String errorMessage) {
		super(errorMessage);
		logger.error(errorMessage);
	}
}

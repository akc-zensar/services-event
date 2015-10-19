/**
 * @author Sarwajeet Bharti
 * Date: 12/10/15
 *static logger utility class which helps in logging purpose 
 */
package org.akc.util;

import org.slf4j.Logger;

public class LoggerHelper {

	/**
	 * Method responsible for logging the message in the debug mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 */
	public static void debug(Logger logger, String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(" " + msg);
		}
	}

	/**
	 * Method responsible for logging the message in the debug mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 * @param object
	 *            is the object whose all attributes needs to be logged
	 */
	public static void debug(Logger logger, String msg, Object object) {
		if (logger.isDebugEnabled()) {
			logger.debug(" " + msg + " " + object.toString());
		}
	}

	/**
	 * Method responsible for logging the message in the warn mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 */
	public static void warn(Logger logger, String msg) {
		if (logger.isWarnEnabled()) {
			logger.warn(" " + msg);
		}
	}

	/**
	 * Method responsible for logging the message in the warn mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 * @param object
	 *            is the object whose all attributes needs to be logged
	 */
	public static void warn(Logger logger, String msg, Object object) {
		if (logger.isWarnEnabled()) {
			logger.warn(" " + msg + " " + object.toString());
		}
	}

	/**
	 * Method responsible for logging the message in the info mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 */
	public static void info(Logger logger, String msg) {
		if (logger.isInfoEnabled()) {
			logger.info(" " + msg);
		}
	}

	/**
	 * Method responsible for logging the message in the info mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 * @param object
	 *            is the object whose all attributes needs to be logged
	 */
	public static void info(Logger logger, String msg, Object object) {
		if (logger.isInfoEnabled()) {
			logger.info(" " + msg + " " + object.toString());
		}
	}

	/**
	 * Method responsible for logging the message in the error mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 */
	public static void error(Logger logger, String msg) {
		if (logger.isErrorEnabled()) {
			logger.error(" " + msg);
		}
	}

	/**
	 * Method responsible for logging the message in the error mode
	 * 
	 * @param logger
	 *            for logging purpose
	 * @param msg
	 *            is the message to be logged
	 * @param object
	 *            is the object whose all attributes needs to be logged
	 */
	public static void error(Logger logger, String msg, Object object) {
		if (logger.isErrorEnabled()) {
			logger.error(" " + msg + " " + object.toString());
		}
	}

}

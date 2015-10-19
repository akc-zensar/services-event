/*
 * 
 */
package org.akc.validation;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.akc.exception.InvalidException;
import org.apache.log4j.Logger;

/**
 * Author: Ashok Doddi
 * 
 */

/**
 * AKCBeanValidator class with will validate bean class based on annotation
 * defined on properties.
 * 
 */

public class EventBeanValidator<T extends ValidatorInf> {

	static final Logger logger = Logger.getLogger(EventBeanValidator.class);

	public String errorMessage;

	/**
	 * method isValidBean will do bean validation based on Annotation defined.
	 * 
	 * @param Bean
	 * @return void
	 * @throws InvalidException
	 *             : Throws exception on Bean validation fail
	 */
	public void isValidBean(T isValidBean) {
		logger.info(" Enter in isValidBean method of EventBeanValidator class ");
		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in isValidBean method of EventBeanValidator class ");
		}

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator
				.validate(isValidBean);

		if (!violations.isEmpty()) {
			logger.error(isValidBean.getClass() + " Bean validation fails");
			Iterator<ConstraintViolation<T>> itr = violations.iterator();
			while (itr.hasNext()) {
				ConstraintViolation<T> error = itr.next();
				errorMessage = errorMessage + " " + error.getPropertyPath()
						+ " : " + error.getMessage();

			}
			logger.error(isValidBean.getClass()
					+ " Bean validation fails Error : " + errorMessage);
			if (logger.isDebugEnabled()) {
				logger.debug(" Failed in Bean Validation, Error Message :  "
						+ errorMessage);
				logger.debug(" Exit from  isValidBean method of EventBeanValidator class   ");
			}

			throw new InvalidException(errorMessage);
		}

	}

	/**
	 * method akcBusinessValidation will do business validation
	 * 
	 * @param Bean
	 * @return void
	 * @throws InvalidException
	 *             : Throws exception on Bean validation fail
	 */
	public void eventBusinessValidation(T isValidBean) {
		logger.info(" Enter in eventBusinessValidation method of EventBeanValidator class ");
		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in eventBusinessValidation method of EventBeanValidator class ");
		}

		if (logger.isDebugEnabled()) {
			logger.debug(" Exit from  eventBusinessValidation method of EventBeanValidator class   ");
		}

	}
}

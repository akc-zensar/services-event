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

public class AKCBeanValidator<T extends ValidatorInf> {

	 static final Logger logger = Logger.getLogger(AKCBeanValidator.class);
	
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

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(isValidBean);

		if (!violations.isEmpty()) {
			logger.error(isValidBean.getClass()+" Bean validation fails");
			Iterator<ConstraintViolation<T>> itr = violations.iterator();
			while (itr.hasNext()) {
				ConstraintViolation<T> error = itr.next();
				errorMessage = errorMessage + " " + error.getPropertyPath() + " : " + error.getMessage();

			}
			logger.error(isValidBean.getClass()+" Bean validation fails Error : "+errorMessage);
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
	public void akcBusinessValidation(T isValidBean) {
	}
}

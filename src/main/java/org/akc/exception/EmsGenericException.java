/*
 * 
 */
package org.akc.exception;

import java.text.MessageFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.bind.annotation.XmlRootElement;

import org.akc.util.Fault;
import org.apache.log4j.Logger;

/*
 User: mukesh
 Date: 2/8/15.
 */

/*
 InvalidException is the base class for Exception.
 
 */
@XmlRootElement(name = "EmsGenericException")
public class EmsGenericException extends RuntimeException {


	/* The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	 
 	/* The Constant LOGGER. */
 	private static final Logger LOGGER = Logger.getLogger(EmsGenericException.class);

	    /* The fault details. */
    	private Fault faultDetails;
		
		/* The builder. */
		private ResponseBuilder builder;

		/*
		 * Instantiates a new ems generic exception.
		 */
		public EmsGenericException(String errorProperty) {
			throwException(errorProperty);	
		}
		
		/*
		  Instantiates a new ems generic exception.
		 
		  @param faultDetails the fault details
		  @param errorProperty the error property
		 */
		public EmsGenericException(Fault faultDetails,String errorProperty) {
			super();
			this.faultDetails = faultDetails;
			this.builder = Response.status(Response.Status.BAD_REQUEST);
			throwException(errorProperty);
		}
		
		/*
		 Instantiates a new ems generic exception.
		 
		 @param faultDetails the fault details
		 @param errorProperty the error property
		 @param builder the builder
		 */
		public EmsGenericException(Fault faultDetails,String errorProperty, ResponseBuilder builder) {
			super();
			this.faultDetails = faultDetails;
			this.builder = builder;
			throwException(errorProperty);
		}

		/*
		Throw exception.
		
		@param errorProperty the error property
		 */
		public void throwException(String errorProperty) {
		    Fault fault = faultSet(errorProperty);
			builder.type(MediaType.APPLICATION_JSON);
			builder.entity(fault);
			throw new WebApplicationException(builder.build());
		}
		
		/*
		  Fault set.
		 
		  @param errorProperty the error property
		  @return the fault
		 */
		public Fault faultSet(String errorProperty) { 
			MessageFormat messageFormat = new MessageFormat(faultDetails.getErrorMessage());
			String errorMessage = messageFormat.format(new Object[] {errorProperty});
		    faultDetails.setErrorMessage(errorMessage);
		    faultDetails.setErrorTime(new Date());
        return faultDetails;
        }

}
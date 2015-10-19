package org.akc.util;

import javax.xml.bind.annotation.XmlRootElement;

import org.akc.transformer.DtoTransformer;
import org.akc.util.Fault;

@XmlRootElement
public class EmsGenericResponse<T extends DtoTransformer> {

	public T genericResponse;
	public Fault faultDetails;
	
	public EmsGenericResponse(T genericResponse, Fault faultDetails) {
		super();
		this.genericResponse = genericResponse;
		this.faultDetails = faultDetails;
	}
	public T getGenericResponse() {
		return genericResponse;
	}
	public Fault getFaultDetails() {
		return faultDetails;
	}

}

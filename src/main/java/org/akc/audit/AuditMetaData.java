package org.akc.audit;

import org.audit4j.core.MetaData;
import org.springframework.stereotype.Component;

@Component("metaData")
public class AuditMetaData implements MetaData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getActor() {

		
		return "annonymous";
	}

}

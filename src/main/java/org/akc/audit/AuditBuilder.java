package org.akc.audit;

import java.util.Map;

import org.audit4j.core.AuditManager;
import org.audit4j.core.dto.EventBuilder;
import org.springframework.stereotype.Component;

/*
 * Audit builder is used to Audit the field
 * The actor is the against which data is going to audit
 * Method name is used to identify the audit 
 */

@Component("auditBuilder")
public class AuditBuilder {

	public void audit(String actor, Map<String, String> fieldMap, String methodName ) {
		
		 EventBuilder builder = new EventBuilder();
		 builder = builder.addActor(actor).addAction(methodName);
		 
		 for (Map.Entry<String,String> entry : fieldMap.entrySet()) {
			 
			 builder.addField(entry.getKey(),  entry.getValue());  
			 
			}
		 
		AuditManager manager = AuditManager.getInstance();
		manager.audit(builder.build());
		
	}

	
}

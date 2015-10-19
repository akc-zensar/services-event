package org.akc.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





import org.akc.dao.model.GenericResponse;

import org.apache.cxf.jaxrs.model.wadl.DocTarget;

@Path("")
public interface IAuthService {

	
	
//	@GET
//	@Description(value = "Resource", target = DocTarget.RESOURCE)
//	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public UserAccount getUserAccountDetails(@Description("Customer name") 
//											 @PathParam("userName") final String userName,
//											 @PathParam("password") final String password);
	
	@GET
	
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{userName},{password}")
	public GenericResponse getUserAccountDetails(
											 @PathParam("userName") final String userName,
											 @PathParam("password") final String password);
	
	@POST
	
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GenericResponse getUserAccountDetails( 
											 GenericResponse form);
	
	
	
}

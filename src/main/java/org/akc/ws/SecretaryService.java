package org.akc.ws;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.akc.dto.SecretaryForm;


/**
 * 
 * Author: Chander
 * Date: 09/08/15
 * secretaryService interface is reference to CRUD operations
 *
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@WebService(name="secretaryService")
public interface SecretaryService {


	
	/**
	 * Save secretary.
	 *
	 * @param secretaryForm 
	 * 
	 * @return secretary form
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SecretaryForm saveSecretary(SecretaryForm secretaryForm);
	
	/**
	 * Gets the secretary.
	 *
	 * @param secretaryId 
	 * @return secretary
	 */
	@GET
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{secretaryId}")
	public SecretaryForm getSecretary(@PathParam("secretaryId") Integer secretaryId );
	
	
	/**
	 * Update secretary.
	 *
	 * @param secretaryForm 
	 * 
	 * @return secretary form
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SecretaryForm updateSecretary(SecretaryForm secretaryForm);
	
	
	/**
	 * Delete secretary.
	 *
	 * @param secretaryId 
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{secretaryId}")
	public void deleteSecretary(@PathParam("secretaryId") Integer secretaryId );
}

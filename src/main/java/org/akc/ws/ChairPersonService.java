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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.akc.dto.ChairPersonForm;
import org.akc.dto.SecretaryForm;

// TODO: Auto-generated Javadoc
/**
 * Author: Chander
 * Date: 09/08/15
 * chairperson Service interface is reference to CRUD operations.
 */
@Produces(MediaType.APPLICATION_JSON)
@WebService(name = "chairPersonService")
public interface ChairPersonService {

	
	 
	
	/**
	 * Save chair person.
	 *
	 * @param eventForm the event form
	 * @param eventId the event id
	 * @return the chair person form
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	//@Path("/{eventId}")
	public ChairPersonForm saveChairPerson(ChairPersonForm chairPersonForm);
	
	
	
	
	
	/**
	 * Gets the chair person.
	 *
	 * @param chairPersonId 
	 * @return  chair person
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{chairPersonId}")
	public ChairPersonForm getChairPerson(@PathParam("chairPersonId") Integer chairPersonId );
	
	
	/**
	 * Update chair person.
	 *
	 * @param ChairPersonForm 
	 * @return chair person form
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	//@Path("/{secretaryId}")
	public ChairPersonForm updateChairPerson(ChairPersonForm ChairPersonForm);
	
	
	/**
	 * Delete chair person.
	 *
	 * @param chairPersonId 
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{chairPersonId}")
	public void deleteChairPerson(@PathParam("chairPersonId") Integer chairPersonId );
}

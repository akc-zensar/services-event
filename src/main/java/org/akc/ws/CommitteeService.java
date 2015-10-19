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

import org.akc.dto.CommitteeForm;

/**
 * 
 * Author: Chander
 * Date: 09/08/15
 * CommitteeService interface is reference to CRUD operations
 *
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@WebService(name = "committeeService")
public interface CommitteeService {

	/**
	 * saveCommittee
	 *
	 * @param CommitteeForm 
	 * 
	 * @return CommitteeForm
	 */
	 
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public CommitteeForm saveCommittee(CommitteeForm committeeForm);
	
	
	/**
	 * Gets the committee.
	 *
	 * @param committeeId 
	 * @return committee
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{committeeId}")
	public CommitteeForm getCommittee(@PathParam("committeeId") Integer committeeId );
	
	
	
	/**
	 * updateCommittee.
	 *
	 * @param committeeId 
	 * 
	 * @return CommitteeForm
	 */
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public CommitteeForm updateCommittee(CommitteeForm committeeform);
	
	/**
	 * Delete Committee.
	 *
	 * @param committeeId 
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{committeeId}")
	public void deleteCommittee(@PathParam("committeeId") Integer committeeId );
	
	
}

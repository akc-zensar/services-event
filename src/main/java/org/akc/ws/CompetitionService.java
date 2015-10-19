package org.akc.ws;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.akc.dto.CompetitionForm;
import org.akc.util.EmsGenericResponse;

/**
 * Author: Ashok Doddi
 * 
 */
/**
 * CompetitionService service interface for all Competition services.
 * 
 */

@Produces(MediaType.APPLICATION_JSON)
@WebService(name = "competitionService")
public interface CompetitionService {

	/**
	 * method getCompetition is GET call, will get competition details based on
	 * competitionId and eventId.
	 *
	 * @param competitionId
	 *            ,eventId.
	 * @return CompetitionForm
	 * 
	 */

	@GET
	@Path("/{competitionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmsGenericResponse getCompetition(
			@QueryParam("eventId") Integer eventId,
			@PathParam("competitionId") Integer competitionId);

	/**
	 * method saveCompetition is POST call, will save new competition details
	 * based on given input JSON.
	 *
	 * @param competitionForm
	 * @return competitionForm
	 * */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Path("/competition")
	@Produces(MediaType.APPLICATION_JSON)
	public EmsGenericResponse saveCompetition(CompetitionForm competitionForm);

	/**
	 * method updateCompetition is PUT call, will update competition details
	 * based on given input JSON.
	 *
	 * @param CompetitionForm
	 * @return CompetitionForm
	 * */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	//@Path("/competition")
	
	public EmsGenericResponse updateCompetition(CompetitionForm competitionForm);

}

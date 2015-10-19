package org.akc.ws;

import java.util.List;

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

import org.akc.dto.ChairPersonForm;
import org.akc.dto.EventCompetitionForm;
import org.akc.dto.EventForm;

/**
 * User: chandra
 * Date: 09/08/15
 * EventService specification for services providing
 */
//@Path("/eventService")
@WebService(name = "eventService")
@Produces("application/json")
public interface EventService {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
   // @Path("/saveEvent")
    public EventForm saveEventForm(EventForm eventForm);
   
    @PUT
	@Consumes("application/json")
	@Produces("application/json")
	//@Path("/{eventId}")
	public EventForm updateEventForm(EventForm eventForm);
    
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{eventId}")
    public EventForm getEvent(@PathParam("eventId") Integer eventId);
    
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	//@Path("/event")
	public List<EventForm> getEvents(@QueryParam("clubId") Long clubId);
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{eventId}/competition")
	//public CompetitionForm getCompetitionTypes(CompetitionForm competitionForm);
	public List<EventCompetitionForm> getCompetitionTypes(@PathParam("eventId") Integer eventId);
	
	
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{eventId}/chairperson")
	public ChairPersonForm saveChairPerson(ChairPersonForm eventForm,@PathParam("eventId") Integer eventId );
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{eventId}/chairperson")
	public ChairPersonForm getChairPerson(@PathParam("eventId") Integer eventId );*/
	

}

package org.akc.ws;

import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author mt40569
 * It is rest interface to provides the master service to UI
 * The method call as a get and provide list of key value pair json response.  
 */
@Produces("application/json")
@WebService(name = "utilService")
public interface UtilService {
	
	@GET
	@Produces("application/json")
	@Path("/prefix")
	public Map<String,String> getPrefix();
	
	@GET
	@Produces("application/json")
	@Path("/suffix")
	public Map<String,String> getSufix();
	
	@GET
	@Produces("application/json")
	@Path("/state")
	public Map<Integer,String> getState();
	
	@GET
	@Produces("application/json")
	@Path("/status")
	public Map<Integer,String> getStatus(@QueryParam("category") Integer category);
	
	@GET
	@Produces("application/json")
	@Path("/eventsettings")
	public Map<String,String> getEventSettings();
	
	@GET
	@Produces("application/json")
	@Path("/timezone")
	public Map<String,String> getTimeZone();
	
	@GET
	@Produces("application/json")
	@Path("/judgingcategory")
	public Map<Integer,String> getJudgingCategory();
	
}

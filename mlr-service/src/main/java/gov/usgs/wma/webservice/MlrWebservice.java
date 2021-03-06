package gov.usgs.wma.webservice;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wma.data.service.DataService;
import gov.usgs.wma.model.MonitoringLocation;
import gov.usgs.wma.util.MlrInstanceSingleton;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.NotFoundException;


/**
 * This class is used as the front end to the reporting system and will be imported into
 * other jersey applications to enable reporting. Think of this as an "API middleware" class. 
 * 
 * @author thongsav
 */
@Path("/")
public class MlrWebservice {
	private static final Logger log = LoggerFactory.getLogger(MlrWebservice.class);
	
	/**
	 * May want to use dependency injection later
	 */
	//comment back in when DAO is hooked up
	DataService service = MlrInstanceSingleton.getDataService();
	
	/**
	 * Default Constructor
	 */
	public MlrWebservice() {
	}
	
	/**
	 * retrieves a specific location
	 * 
	 * @param req The raw HTTP request received from the UI
	 * @param id id for data to retrieve
	 * @return a location
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("monitoringLocation/{locationNumber}")
	public MonitoringLocation getMonitoringLocation(@Context final HttpServletRequest req, @PathParam("id") final Long id) {
		MonitoringLocation fetchedLocation = service.getMonitoringLocationById(id);
		
		if(fetchedLocation == null){
			throw new NotFoundException();
		}
		
		return fetchedLocation;
	}
	
	/**
	 * Attempts to create a location from the provided json. Returns the newly created site with IDs populated
	 * 
	 * @param newLocationJson json representing site to create
	 * @return The rendered HTML page representing the report
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("monitoringLocations")
	public MonitoringLocation createMonitoringLocation(final MonitoringLocation newLocationJson) {
		//TODO Call java core service when available
		return newLocationJson;
	}
	
	/**
	 * Attempts to update a location from the provided json. Returns the newly created site with IDs populated
	 * 
	 * @param newLocationJson json representing site to update
	 * @return The rendered HTML page representing the report
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("monitoringLocation/{locationNumber}")
	public MonitoringLocation updateMonitoringLocation(@Context final HttpServletRequest req, @PathParam("id") final Long id, final MonitoringLocation newLocationJson) {
		//TODO Call java core service when available
		newLocationJson.setId(id);
		return newLocationJson;
	}
	
	/**
	 * retrieves list of locations
	 * 
	 * @param query query to restrict locations
	 * @return a location
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("monitoringLocations")
	public List<MonitoringLocation> getLocations(@QueryParam("query") final String query) {
		//TODO: Convert query params to param map
		Map<String, Object> params = new HashMap<>();
		List<MonitoringLocation> fetchedLocations = service.getMonitoringLocations(params);
		
		return fetchedLocations;
	}
}

package si.gov.eugo.service;

import si.gov.eugo.model.Profession;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 1:11 PM
 */
@Path("api")
public interface EugoService {

    @GET
    @Path("professions/profession/")
    Profession getProfession(@QueryParam("uid") String id);

}

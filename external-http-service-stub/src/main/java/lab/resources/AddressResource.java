package lab.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/address")
public class AddressResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get() {
        return Response.ok("123 Coventry Street").build();
    }

}

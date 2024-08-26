package ru.veselkov.iprremote;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ru.veselkov.iprremote.service.RemoteServiceIpr;

@Path("/hello-world")
public class HelloResource {

    @EJB
    private RemoteServiceIpr remoteServiceIpr;

    @GET
    @Produces("text/plain")
    public String hello() {
        remoteServiceIpr.callRemote(null);
        return "Hello, World!";
    }
}
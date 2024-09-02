package ru.veselkov.iprremote;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ru.veselkov.iprremote.service.RemoteServiceIpr;
import ru.veselkov.iprremote.service.test.TestService;

@Path("/hello-world")
public class HelloResource {

    @EJB
    private TestService testService;

    @GET
    @Produces("text/plain")
    public String hello() {
        testService.test();
        return "Hello, World!";
    }
}
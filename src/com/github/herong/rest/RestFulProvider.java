package com.github.herong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class RestFulProvider {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getName() {
		return "herong";
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("/getName2/{n}")
	public String getName(@PathParam("n") String name) {
		return name;
	}

	
	
}

package com.example.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/temperature")
public class TemperatureController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ctf")
    public String celsiusToFahr(@QueryParam("value") double value) {
        final double fahrenheit = ((value * 9) / 5) + 32;
        return String.valueOf(fahrenheit);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ftc")
    public String fahrToCelsius(@QueryParam("value") double value) {
        final double celsius = (value - 32) * 5/9;
        return String.valueOf(celsius);
    }
}

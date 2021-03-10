package com.example.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloController {

    @GET
    public String sayHi(){
        return "Hello world";
    }
}

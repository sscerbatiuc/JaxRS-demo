package com.example.controller;

import com.example.model.Employee;
import com.example.model.EmployeeModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/employee")
public class EmployeeController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        final List<Employee> employeeList = EmployeeModel.getInstance().getEmployeeList();
        return Response.status(Response.Status.OK).entity(employeeList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) {
        final Optional<Employee> foundEmployee = EmployeeModel.getInstance().get(id);
        if (foundEmployee.isPresent()) {
            return Response.status(Response.Status.OK).entity(foundEmployee.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Employee employee) {
        EmployeeModel.getInstance().add(employee);
        return Response.status(Response.Status.OK).build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(@QueryParam("id") String id, Employee employee) {
        final boolean edited = EmployeeModel.getInstance().edit(id, employee);
        return edited ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.NOT_FOUND).build();
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") String id) {
        Employee deleted = EmployeeModel.getInstance().deleteEmployee(id);
        return deleted != null
                ? Response.status(Response.Status.OK).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}

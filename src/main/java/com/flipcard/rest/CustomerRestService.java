package com.flipcard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import com.flipcard.bean.Customer;

@Path("/customer")
public class CustomerRestService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerDetails(){
		Customer customer = new Customer();
		customer.setId(101);
		customer.setName("Flipcard");
		customer.setAddress("mumbai");
		return customer;
	}
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Customer customer){
		System.out.println("hit post service");
		System.out.println("value of title from UI "+customer.getId());
		System.out.println("value of singer from UI "+customer.getName());
		String result = "Track Saved: "+ customer;
		return Response.status(201).entity(result).build();
	}
	
	@DELETE
	@Path("/delete/{customerId}")
	public Response deleteCustomer(@PathParam("customerId") int id)throws URIReferenceException{
		return Response.status(200).entity("Track id "+id+" successfuly deleted").build();
	}
	
	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer updateCustomer(Customer customer){
		customer.setName(customer.getName()+" updated");
		return customer;
	}
}

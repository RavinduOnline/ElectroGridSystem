package com;

import model.Employee;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Employee")
public class Employeeservice {
	Employee EmployeeObj = new Employee();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readEmployee() {
		return EmployeeObj.readEmployee();
	}

	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmployee(@FormParam("name") String Name, 
			@FormParam("age") String age,
			@FormParam("address") String address) {
		String output = EmployeeObj.insertEmployee(Name, age, address);
		return output;

	}

		@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updateEmployee(String EmployeeData) {
		// Convert the input string to a JSON object
		JsonObject ProObject = new JsonParser().parse(EmployeeData).getAsJsonObject();
		
		String output = EmployeeObj.updateEmployee(Id, name, age, address);
		return output;
	}

	
}

package com;

import model.Bill;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Bill")
public class Billservice {
	Bill BillObj = new Bill();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBill() {
		return BillObj.readBill();
	}

	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBill(@FormParam("amount") String billamount, 
			@FormParam("date") String date, 
			@FormParam("time") String time, 
			@FormParam("cusid") String cusid) {
		String output = BillObj.inserBill(billamount, date, time, cusid);
		return output;

	}
	
	

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updateBill(String Billob) {
		// Convert the input string to a JSON object
		JsonObject ProObject = new JsonParser().parse(Billob).getAsJsonObject();

		// Read the values from the JSON object
		String Id = ProObject.get("id").getAsString();
		String billamount = ProObject.get("billamount").getAsString();
		String date = ProObject.get("date").getAsString();
		String time = ProObject.get("time").getAsString();
		String cusid = ProObject.get("cusid").getAsString();


		String output = BillObj.updateBill(billamount, date, time, cusid);
		return output;
	}


	
}
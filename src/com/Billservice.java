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
	


	
}
package com;

import model.Poweroutage;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Bill")
public class Poweoutageservice {

	}

	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPoweroutage(@FormParam("date") String date, 
			@FormParam("time") String time, 
			@FormParam("time") String empid, 
			@FormParam("cusid") String areacode) {
		String output = PoweroutageObj.inserPoweroutage(time, date, empid, areacode);
		return output;

	}
	
	

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updatePoweroutage(String Poweroutageob) {

		JsonObject ProObject = new JsonParser().parse(Poweroutageob).getAsJsonObject();

		String Id = ProObject.get("id").getAsString();
		String date = ProObject.get("date").getAsString();
		String time = ProObject.get("time").getAsString();
		String areacode = ProObject.get("areacode").getAsString();

		String output = PoweroutageObj.updatePoweroutag(time, date, areacode);
		return output;
	}

	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBill(String PoweroutageOb) {

		Document doc = Jsoup.parse(PoweroutageOb, "", Parser.xmlParser());


		String Id = doc.select("id").text();
		String output = PoweroutageObj.deletePoweroutag(Id);
		return output;
	}

	
}

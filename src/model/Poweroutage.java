package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Poweroutage {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/empmanagment?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String inserPoweroutage(String time, String date, String empid ,  String areacode) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into poweroutages(`time`, `date`,   `empid`, `areaid`)" + " values ( ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, time);
			preparedStmt.setString(3, date);
			preparedStmt.setString(4, empid);
			preparedStmt.setString(5, areacode);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Poweroutage Shedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	

	public String readPoweroutag() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Otage No</th><th>time</th><th>Date</th><th>Area</th></tr>";
			String query = "select * from poweroutages";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String Id = Integer.toString(rs.getInt("id"));
				String date = rs.getString("date");
				String time = rs.getString("time");
				String areacode = rs.getString("areacode");

				output += "<tr><td>" + Id + "</td>";
				output += "<td>" + time + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + areacode + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the PowerOtage.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	public String updatePoweroutag(String time, String date,  String areacode) {
		String output = "";

		try {
			
			}


		} catch (Exception e) {
			
		}

		return output;
	}

	
	

}
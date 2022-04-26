package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bill {

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

	public String inserBill(String billamount, String date, String time ,  String cusid) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into bills(`billamount`, `date`,   `time`, `cusid`)" + " values ( ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, billamount);
			preparedStmt.setString(3, date);
			preparedStmt.setString(4, time);
			preparedStmt.setString(5, cusid);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Bill.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	

	public String readBill() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Bill No</th><th>Cusid</th><th>Date</th><th>Amount</th><th>time</th></tr>";
			String query = "select * from customers";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String Id = Integer.toString(rs.getInt("id"));
				String date = rs.getString("date");
				String time = rs.getString("time");
				String amount = rs.getString("amount");
				String cusid = rs.getString("cusid");

				output += "<tr><td>" + Id + "</td>";
				output += "<td>" + cusid + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + time + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Bill.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	public String updateBill(String billamount, String date, String time ,  String cusid) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE bills SET billamount=?,date=?,time=?  WHERE id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);




}

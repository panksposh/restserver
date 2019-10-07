package com.pankaj.restserver.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	@RequestMapping(method = RequestMethod.GET, path = "/getname", produces = "text/html")
	public String getName() {
		return "Pankaj Poshirkar";
	}

	private Connection con;
	private PreparedStatement stmt;

	private void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "pankaj", "Happylearning@8677");
			String query = "select name from users where id=?";
			stmt = con.prepareStatement(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getname/{userId}", produces = "text/html")
	public String getUserName(@PathVariable int userId) {
		String userName = null;
		init();
		try {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userName = rs.getString(1);
				break ;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return userName;
	}
}
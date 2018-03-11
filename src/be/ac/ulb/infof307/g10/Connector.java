package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.Exception.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.Exception.UserAlreadyExistException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connector {

	private Connection connect() {
		Connection conn = null;
		String url = "jdbc:sqlite:SessionUser.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public byte[] sha256(String password) {
		MessageDigest digest;
		byte[] encodedhash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encodedhash;
	}
	
	public Session OpenSession(String userName, String Password) throws IncorrectPasswordException {
		//Hash the Password
		
		/*
		String HashMDP = Password;
		String sql = "SELECT UserName FROM User WHERE hashMDP = "+HashMDP+" AND UserName = "+ userName;
		try (Connection conn = this.connect();
			 Statement stmt  = conn.createStatement();
			 ResultSet rs    = stmt.executeQuery(sql)) {
			
			if (rs.next()) {
				return new Session(rs.getString("UserName"));
			}else{
				throw new IncorrectPasswordException();
			}
		} catch (SQLException e) {
			return null;
		}*/
		return null;
	}
	
	public Session CreateSession(String userName, String Password) throws UserAlreadyExistException {
		//Hash the Password
		//Create the user in DB
		return new Session(userName);
	}

	public Boolean destroyUser(String userName, String Password) throws IncorrectPasswordException {
		// Delete the user in the DB if the password is correct
		return true;
	}
}

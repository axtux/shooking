package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.Exception.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.Exception.UserAlreadyExistException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connector {

	private Connection connect() {
		Connection conn = null;
		String url = "jdbc:sqlite:db/genlog10.db";
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
		
		String HashMDP = Password; // TODO Hash
		String sql = "SELECT USER_ID FROM T_USERS WHERE USER_PAWD = ? AND USER_ID = ?";
		
		try (Connection conn = this.connect();
			 PreparedStatement pstmt  = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, HashMDP);
			pstmt.setString(2, userName);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return new Session(rs.getString("USER_ID"));
			}else{
				throw new IncorrectPasswordException();
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public Session CreateSession(String userName, String Password) throws UserAlreadyExistException {
		//Hash the Password

		String HashPW = Password; // TODO Hash
		String sql = "INSERT INTO T_USERS(USER_ID,USER_PAWD) VALUES(?,?)";
		
		try (Connection conn = this.connect();
			 PreparedStatement pstmt  = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, userName);
			pstmt.setString(2, HashPW);
			pstmt.executeUpdate();
			
			return new Session(userName);
		} catch (SQLException e) {
			throw new UserAlreadyExistException();
		}
	}

	public Boolean destroyUser(String userName, String Password) throws IncorrectPasswordException {
		// Delete the user in the DB if the password is correct
		
		String HashPW = Password; // TODO Hash
		String sql = "DELETE FROM T_USERS WHERE USER_ID = ? AND USER_PAWD = ?";
		
		try (Connection conn = this.connect();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userName);
			pstmt.setString(2, HashPW);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			throw new IncorrectPasswordException();
		}
	}
}

package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.Exception.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.Exception.UserAlreadyExistException;

import java.io.UnsupportedEncodingException;
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
	
	public static String sha256(String password) {
		MessageDigest digest;
		byte[] encodedhash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			return new String(encodedhash, "UTF-8");
		} catch (UnsupportedEncodingException e) { // this exception never append because "UTF-8" is a correct encoding
			return "";
		}
	}
	
	public Session openSession(String userName, String Password) throws IncorrectPasswordException {
		//Hash the Password
		
		String HashMDP = sha256(Password); // TODO Hash
		String sql = "SELECT USER_ID FROM T_USERS WHERE USER_PAWD = ? AND USER_ID = ?";
		
		try (Connection conn = this.connect();
			 PreparedStatement pstmt  = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, HashMDP);
			pstmt.setString(2, userName);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return new Session(rs.getString("USER_ID"));
			}else{
				System.out.println("ici");
				throw new IncorrectPasswordException();
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public Session createSession(String userName, String Password) throws UserAlreadyExistException {
		//Hash the Password

		String HashPW = sha256(Password); // TODO Hash
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
		
		String HashPW = sha256(Password); // TODO Hash
		String sql_userExist = "SELECT USER_ID FROM T_USERS WHERE USER_PAWD = ? AND USER_ID = ?";
		String sql_deleteUser = "DELETE FROM T_USERS WHERE USER_PAWD = ? AND USER_ID = ?";
		
		try (Connection conn = this.connect();
			 PreparedStatement pstmt_exist = conn.prepareStatement(sql_userExist);
			 PreparedStatement pstmt_del   = conn.prepareStatement(sql_deleteUser)) {
			
			pstmt_exist.setString(1, HashPW);
			pstmt_exist.setString(2, userName);
			pstmt_exist.executeQuery();
			ResultSet rs = pstmt_exist.executeQuery();
			
			if (rs.next()) { // The user exist
				pstmt_del.setString(1, HashPW);
				pstmt_del.setString(2, userName);
				pstmt_del.executeUpdate();
				return true;
				
			} else { // The user dont exist OR the password is incorrect
				throw new IncorrectPasswordException();
			}
			
		} catch (SQLException e) {
			throw new IncorrectPasswordException();
		}
	}
}

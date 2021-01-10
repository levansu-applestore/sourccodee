package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnect;
import model.User;

public class UserDAO {
	
	public static boolean kiemtradangnhap(String username, String password) throws SQLException {
		
		Connection connection=DBConnect.getConnection();
		PreparedStatement ps = connection.prepareStatement(
				"select * from user where username='" + username + "' and password='" + password + "' ");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
		
	}
	
	public static User getUser(String username, String password) throws SQLException {

		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select * from user where username='" + username + "' and password='" + password + "' ");
		User u = new User();
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
		}
		return u;
	}
	public static boolean getUserName(String username) throws SQLException {

		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select * from user where username='" + username +"'");
		User u = new User();
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	public static boolean them_user(User u) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into user values(null,?,?)");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());

		return ps.executeUpdate() ==1;

	}
	public static boolean ResetPassword(String username,String password) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("update user set password='" + password + "' where username='"+ username +"'");

		return ps.executeUpdate() ==1;

	}

}

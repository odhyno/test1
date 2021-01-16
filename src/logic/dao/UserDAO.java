package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.bean.UserBean;
import logic.utils.ConnectionDB;

public class UserDAO {

	static Connection con;

	// Funcs for LOGIN

	public static int checkIfRegistered(UserBean data) {
		
		int res = -1;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT flag FROM utenti WHERE username = '" + data.getUsername() + "' AND password = '" + data.getPassword() + "';";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			if (tempRs.first()) {
	
					res = tempRs.getInt(1);
					con.close();
					
					return res;

			}

			con.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	// Funcs for REGISTER

	public static void registerUser(UserBean usBean) {
		
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "INSERT INTO utenti (username,password,email,firstname,lastname,subsdate,birthdate,zone,instrplayed,band,nameband) "
					+ "VALUES ('" + usBean.getUsername() + "','" + usBean.getPassword() + "','"
					+ usBean.getEmail() + "','" + usBean.getFirstname() + "','" + usBean.getLastname() + "','" 
					+ usBean.getSubsDate() + "','" + usBean.getBirthDate() + "','" + usBean.getZone() + "','"
					+ usBean.getInstrPlayed() + "','" + usBean.getBand() + "','" + usBean.getNameBand() + "')";
			tempSt.executeQuery(sql);
						
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static String checkUsernameAlreadyTaken(String usname) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT username FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while (tempRs.next()) {
				String dummyUsName = tempRs.getString("username");
				if (dummyUsName.equals(usname)) {

					status = "trovato";
					con.close();
					return status;
				}

			}

			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		status = "non trovato";
		return status;
	}

	public String checkEmailAlreadyTaken(String email) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT email FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while (tempRs.next()) {
				String dummyEmail = tempRs.getString("email");
				if (dummyEmail.equals(email)) {

					status = "trovato";
					con.close();
					return status;
				}

			}

			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		status = "non trovato";
		return status;
	}

	// Funcs for RECOVERDATA

	public String getUserNameByEmail(String email) {

		Statement st;
		ResultSet rs;
		String username = null;

		try {

			con = ConnectionDB.dbConn();
			st = con.createStatement();
			String sql = "SELECT * from utenti WHERE email = '" + email + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {

				username = rs.getString(2);

			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return username;
	}

	public String getPasswordByEmail(String email) {

		Statement st;
		ResultSet rs;
		String password = null;

		try {

			con = ConnectionDB.dbConn();
			st = con.createStatement();
			String sql = "SELECT * from utenti WHERE email = '" + email + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {

				password = rs.getString(3);

			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return password;
	}

	public static String checkEmail(UserBean user) {

		String res;
		
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT password FROM utenti WHERE username = '" + user.getUsername() + "' AND email = '" + user.getEmail() +"'" ;
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			if (tempRs.first()) {
				
				res = tempRs.getString(1);
				con.close();
				return res;

			}

			con.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}

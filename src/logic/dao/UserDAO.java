package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import logic.actors.User;
import logic.utils.ConnectionDB;

public class UserDAO {

	static Connection con;

	// Funcs for LOGIN

	public String checkIfRegistered(String username, String password) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT username,password FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while (tempRs.next()) {
				String dummyUsername = tempRs.getString("username");
				String dummyPassword = tempRs.getString("password");
				if (dummyUsername.equals(username) && dummyPassword.equals(password)) {

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

	public void setLogged(String username) {

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "SELECT * FROM utenti where username = '" + username + "'";
			ResultSet tempRs = tempSt.executeQuery(sql);
			if (tempRs.getString("logged").equals("NON LOGGATO")) {
				tempRs.updateString("logged", "LOGGATO");
			} else {
				tempRs.updateString("logged", "NON LOGGATO");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Funcs for REGISTER

	public void registerUser(User user) {

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "INSERT INTO utenti (idUtente,username,password,email,firstname,lastname,subsdate,birthdate,zone,instrplayed,band,nameband,logged) "
					+ "VALUES ('" + idGenerator() + "','" + user.getUsername() + "','" + user.getPassword() + "','"
					+ user.getEmail() + "','" + user.getFirstname() + "','" + user.getLastname() + "','"
					+ user.getSubsDate() + "','" + user.getBirthDate() + "','" + user.getZone() + "','"
					+ user.getInstrPlayed() + "','" + user.getBand() + "','" + user.getNameBand() + "','"
					+ user.getLogged() + ")";
			tempSt.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int idGenerator() {

		int result = 0;
		int count = 0;

		try {
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT idUtente FROM utenti";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);
			while (tempRs.next()) {
				count++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result = count;
		return result;
	}

	public String checkUsernameAlreadyTaken(String usname) {

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

	public String checkEmail(String email) {

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

	public User getData(String username, String password) {

		User user = new User();
		try {

			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "SELECT * FROM utenti WHERE username = '" + username + "'";
			ResultSet tempRs = tempSt.executeQuery(sql);
			while (tempRs.next()) {
				user.setId(tempRs.getInt("idUtente"));
				user.setUsername(tempRs.getString("username"));
				user.setPassword(tempRs.getString("password"));
				user.setEmail(tempRs.getString("email"));
				user.setFirstname(tempRs.getString("firstname"));
				user.setLastname(tempRs.getString("lastname"));
				user.setSubsDate(tempRs.getString("subsdate"));
				user.setBirthDate(tempRs.getString("birthdate"));
				user.setZone(tempRs.getString("zone"));
				user.setInstrPlayed(tempRs.getString("instrplayed"));
				user.setBand(tempRs.getInt("band"));
				user.setNameBand(tempRs.getString("nameband"));
				System.out.println(tempRs.getString("logged"));

				String sql2 = "UPDATE utenti SET logged = 'LOGGATO' WHERE username = '" + username + "'";
				Statement tempSt2 = con.createStatement();
				tempSt2.executeQuery(sql2);
				Statement tempSt3 = con.createStatement();
				String sql3 = "SELECT logged FROM utenti WHERE username = '" + username + "'";
				ResultSet rs3 = tempSt3.executeQuery(sql3);
				if(rs3.next()) {
					user.setLogged(rs3.getString("logged"));
				}
				System.out.println(rs3.getString("logged"));
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;
	}

}

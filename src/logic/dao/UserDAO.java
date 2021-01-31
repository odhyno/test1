package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.entity.User;
import logic.utility.ConnectionDB;

public class UserDAO {

	static Connection con;

	private UserDAO() {
		// Default Constructor
	}

	// Funcs for LOGIN

	// funzione che verifica se un utente è registrato nel sistema
	public static int checkIfRegistered(User loginUser) {

		int res = -1;

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT flag FROM utenti WHERE username = '" + loginUser.getEntityUsername()
						+ "' AND password = '" + loginUser.getEntityPassword() + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				if (tempRs.first()) {

					res = tempRs.getInt(1);
					con.close();

					return res;

				}
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	// Funcs for REGISTER

	public static void registerUser(User user) {

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "INSERT INTO utenti (username,password,email,firstname,lastname,subsdate,birthdate) "
						+ "VALUES ('" + user.getEntityUsername() + "','" + user.getEntityPassword() + "','"
						+ user.getEntityEmail() + "','" + user.getEntityFirstname() + "','" + user.getEntityLastname()
						+ "','" + user.getEntitySubsDate() + "','" + user.getEntityBirthDate() + "')";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	//funzione che controlla se un username è già preso nel sistema
	public static String checkUsernameAlreadyTaken(String usname) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
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
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		status = "non trovato";
		return status;
	}

	//funzione che controlla se esiste una password legata a un username e una email
	public static String checkEmail(User user) {

		String res;

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT password FROM utenti WHERE username = '" + user.getEntityUsername()
						+ "' AND email = '" + user.getEntityEmail() + "'";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				if (tempRs.first()) {

					res = tempRs.getString(1);
					con.close();
					return res;

				}
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	//funzione che ritorna la lista di tutti gli utenti
	public static List<User> getUserList() {

		List<User> userList = new ArrayList<>();

		ResultSet tempRs;

		try {

			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "SELECT * FROM utenti";

				tempRs = tempSt.executeQuery(sql);

				while (tempRs.next()) {

					User user = new User();
					user.setEntityId(tempRs.getInt(1));
					user.setEntityUsername(tempRs.getString(2));
					user.setEntityPassword(tempRs.getString(3)); // Sarebbe meglio di no
					user.setEntityEmail(tempRs.getString(4));
					user.setEntityFirstname(tempRs.getString(5));
					user.setEntityLastname(tempRs.getString(6));
					user.setEntitySubsDate(tempRs.getString(7));
					user.setEntityBirthDate(tempRs.getString(8));

					userList.add(user);

				}
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userList;
	}

	// funzione che modifica il profilo dell'utente corrente
	public static int modifyProfile(User user) {

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "UPDATE utenti SET firstname = '" + user.getEntityFirstname() + "', " + "lastname = '"
						+ user.getEntityLastname() + "', " + "birthdate = '" + user.getEntityBirthDate()
						+ "' WHERE username = '" + user.getEntityUsername() + "'";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return 1;

	}
	
	//funzione che modifica i dati dell'utente corrente
	public static int modifyData(User user) {
		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "UPDATE utenti SET password = '" + user.getEntityPassword() + "', " + "email = '"
						+ user.getEntityEmail() + "' WHERE username = '" + user.getEntityUsername() + "'";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return 1;
	}

	// funzione che checka se si sta parlando con un utente registrato nel DB
	public static int checkUser(String ricevente) {

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT username FROM utenti WHERE username = '" + ricevente + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				if (tempRs.first()) {

					return 1;

				}

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;

	}

	// Funzione che mostra tutti gli utenti registati tranne il loggato

	public static List<String> showUsers() {

		List<String> usernameList = new ArrayList<>();

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT username FROM utenti;";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				while (tempRs.next()) {

					String string = tempRs.getString(1);

					usernameList.add(string);
				}

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return usernameList;
	}

	//funzione che controlla se un utente è registrato attraverso google
	public static User checkIfGoogleEmailRegistered(User user) {

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT username,flag FROM utenti WHERE email = '" + user.getEntityEmail() + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				if (tempRs.first()) {

					user.setEntityUsername(tempRs.getString(1));
					user.setEntityFlag(tempRs.getInt(2));

					con.close();

					return user;

				}
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		user.setEntityFlag(-1);

		return user;
	}

}

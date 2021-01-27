package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserBean;
import utility.ConnectionDB;

public class LoginDAO {

	static Connection con;
	
	private LoginDAO() {
		
	}

	// Funzione che fa il login in

	public static int checkIfRegistered(UserBean data) {
		
		int res = -1;

		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String tempQuery = "SELECT flag FROM utenti WHERE username = '" + data.getUsername() + "' AND password = '" + data.getPassword() + "';";
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
	
	// funzione che verifica se già esiste un utente con questo username nel sistema
	public static String checkUsernameAlreadyTaken(String usname) {

		String status = null;

		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()) {
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
	
	
	// funzione che inserisce un nuovo utente nel DB

		public static void registerUser(UserBean usBean) {
			
			try {
				con = ConnectionDB.dbConn();
				try(Statement tempSt = con.createStatement()) {
					String sql = "INSERT INTO utenti (username,password,email,firstname,lastname,subsdate,birthdate) "
							+ "VALUES ('" + usBean.getUsername() + "','" + usBean.getPassword() + "','"
							+ usBean.getEmail() + "','" + usBean.getFirstname() + "','" + usBean.getLastname() + "','" 
							+ usBean.getSubsDate() + "','" + usBean.getBirthDate() + "')";
					tempSt.executeQuery(sql);
				}
							
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		
		// funzione che ritorna la password di un utente per il recovery
		public static String checkEmail(UserBean user) {

			String res;
			
			try {
				con = ConnectionDB.dbConn();
				try(Statement tempSt = con.createStatement()) {
					String tempQuery = "SELECT password FROM utenti WHERE username = '" + user.getUsername() + "' AND email = '" + user.getEmail() +"'" ;
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

	
	
	
	
	
}

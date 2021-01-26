package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.UserBean;
import entity.User;
import utility.ConnectionDB;

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
					+ usBean.getSubsDate() + "','" + usBean.getBirthDate() + "')";
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
	

	
	public static List<User> getUserList(){
		
		List<User> userList = new ArrayList<User>();
		
		ResultSet tempRs;
		
		try {
			
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "SELECT * FROM utenti";
			
			tempRs = tempSt.executeQuery(sql);
			
			while(tempRs.next()) {
				
				User user = new User();
				user.setId(tempRs.getInt(1));
				user.setUsername(tempRs.getString(2));
				user.setPassword(tempRs.getString(3)); //Sarebbe meglio di no
				user.setEmail(tempRs.getString(4));
				user.setFirstname(tempRs.getString(5));
				user.setLastname(tempRs.getString(6));
				user.setSubsDate(tempRs.getString(7));
				user.setBirthDate(tempRs.getString(8));
				
				userList.add(user);
								
			}
			
			con.close();
		} catch (SQLException e){
			
			e.printStackTrace();
		}
		
		return userList;
	}

	public static void modifyProfile(UserBean user) {
		
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "UPDATE utenti SET firstname = '" + user.getFirstname() + "', "
					+ "lastname = '" + user.getLastname() + "', " + "birthdate = '" + user.getBirthDate() 
					+ "' WHERE username = '" + user.getUsername() + "'";
			tempSt.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public static void modifyData(UserBean user) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "UPDATE utenti SET password = '" + user.getPassword() + "', "
					+ "email = '" + user.getEmail() + "' WHERE username = '" + user.getUsername() + "'";
			tempSt.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	//funzione che checka se si sta parlando con un utente registrato nel DB
		public static int checkUser(String ricevente) {

			try {
				con = ConnectionDB.dbConn();
				Statement tempSt = con.createStatement();
				String tempQuery = "SELECT username FROM utenti WHERE username = '" + ricevente + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				if (tempRs.first()) {				
					
					return 1;
							
					
				}

				
				con.close();
				
			} catch (SQLException e) {
				
				

				e.printStackTrace();
			}

			return 0;

			
		}
		
		// Funzione che mostra tutti gli utenti registati tranne il loggato

		public synchronized static List<String> showUsers(String username) {

			List<String> usernameList = new ArrayList<String>();

			try {
				con = ConnectionDB.dbConn();
				Statement tempSt = con.createStatement();
				String tempQuery = "SELECT username FROM utenti WHERE username != '" + username + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				while(tempRs.next()) {
					
					String string = tempRs.getString(1);
							
					usernameList.add(string);
				}

				
				con.close();
				
			} catch (SQLException e) {
				
				

				e.printStackTrace();
			}

			return usernameList;
		}

}

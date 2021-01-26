package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.MessageBean;
import bean.NotifyBean;
import utility.ConnectionDB;

public class DAONotify {

	static Connection con;

	// funzione che regola il sistema di notifiche nel DB
	public synchronized static void addNotify(NotifyBean notify) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "UPDATE notifica SET valoreConosciuto = '" + notify.getValoreConosciuto() +
					"' WHERE username = '" + notify.getUsername()+ "';";
			tempSt.executeQuery(sql);
						
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}


	
	//funzione che ritorna il valoreConosciuto della notifica
	public synchronized static int getNotify(String username) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT valoreConosciuto FROM notifica WHERE username = '" + username + "';";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while(tempRs.next()) {
				
				int oldValue = tempRs.getInt(1);
						
				return oldValue;
			}

			
			con.close();
			
		} catch (SQLException e) {
			
			

			e.printStackTrace();
		}
		return -1;

	}

	//funzione che ritorna il valoreAttuale della notifica
	public synchronized static int getValoreNotifica(MessageBean messageBean) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT valoreAttuale FROM notifica WHERE username = '" + messageBean.getRicevente() + "';";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

			while(tempRs.next()) {
				
				int oldValue = tempRs.getInt(1);
						
				return oldValue;
			}

			
			con.close();
			
		} catch (SQLException e) {
			
			

			e.printStackTrace();
		}
		return -1;
		
	}

    // funzione che incrementa il valore attuale di 1
	public synchronized static void updateValoreNotifica(int i) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "UPDATE notifica SET valoreAttuale = '" + i + "'";
			tempSt.executeQuery(sql);
						
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}



	// funzione che inizializza il sistema di notifiche per un utente
	public static void inizializeNotify(String username) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "INSERT INTO notifica (username,valoreAttuale,valoreConosciuto) "
					+ "VALUES ('" + username + "','" + 0 + "','"
					+ 0 + "')";
			tempSt.executeQuery(sql);
						
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

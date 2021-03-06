package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.entity.Message;
import logic.entity.Notify;
import logic.utility.ConnectionDB;

public class NotifyDAO {

	private static Connection con;

	private NotifyDAO() {
		// Default Constructor
	}

	// funzione che regola il sistema di notifiche nel DB
	public static void addNotify(Notify notify) {
		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "UPDATE notifica SET valoreConosciuto = '" + notify.getValoreConosciuto()
						+ "' WHERE username = '" + notify.getUsername() + "';";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// funzione che ritorna il valoreConosciuto della notifica
	public static int getNotify(String username) {
		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT valoreConosciuto FROM notifica WHERE username = '" + username + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				while (tempRs.next()) {

					return tempRs.getInt(1);
				}

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return -1;

	}

	// funzione che ritorna il valoreAttuale della notifica
	public static int getValoreNotifica(Message message) {
		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT valoreAttuale FROM notifica WHERE username = '" + message.getRicevente()
						+ "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				while (tempRs.next()) {

					return tempRs.getInt(1);
				}

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return -1;

	}

	// funzione che incrementa il valore attuale di 1
	public static void updateValoreNotifica(int i) {
		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "UPDATE notifica SET valoreAttuale = '" + i + "'";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// funzione che inizializza il sistema di notifiche per un utente
	public static void inizializeNotify(String username) {
		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String sql = "INSERT INTO notifica (username,valoreAttuale,valoreConosciuto) " + "VALUES ('" + username
						+ "','" + 0 + "','" + 0 + "')";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	//funzione che verifica se  l'utente loggato ha una notifica
	public static int checkNotify(String username) {

		try {
			con = ConnectionDB.dbConn();
			try (Statement tempSt = con.createStatement()) {
				String tempQuery = "SELECT * FROM notifica WHERE username = '" + username + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				if (tempRs.first()) {

					int newValue = tempRs.getInt(2);

					int oldValue = tempRs.getInt(3);

					if (newValue > oldValue) {

						return newValue - oldValue;
					}
				}
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

}

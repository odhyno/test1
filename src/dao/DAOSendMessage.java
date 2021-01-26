package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.MessageBean;
import entity.Message;
import utility.ConnectionDB;

public class DAOSendMessage {

	
	static Connection con;

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

	
	//funzione che ritorna tutti i messaggi relativi a due specifici utenti
	public synchronized static List<Message> showMessages(MessageBean messageBean) {
		
		
		String mittente = messageBean.getMittente();
		String ricevente = messageBean.getRicevente();
		
		
		List<Message> messagesList = new ArrayList<Message>();

		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String tempQuery = "SELECT * FROM messaggi WHERE mittente = '" + mittente + "' AND ricevente = '" + ricevente + "' OR mittente = '" + ricevente + "' AND ricevente = '" + mittente+"';";
			ResultSet tempRs = tempSt.executeQuery(tempQuery);

				while(tempRs.next()) {
					
					Message message = new Message();
					message.setId(tempRs.getInt(1));
					message.setMittente(tempRs.getString(2));
					message.setRicevente(tempRs.getString(3));
					message.setTesto(tempRs.getString(4));
						
					messagesList.add(message);
				}

			
			con.close();
			
		} catch (SQLException e) {
			
			

			e.printStackTrace();
		}
		
		return messagesList;
		
		
		
	}

	
	// funzione che inserisce un nuovo messaggio nel DB
	public synchronized static void insertMessages(MessageBean messageBean) {
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "INSERT INTO messaggi (mittente,ricevente,testo) "
					+ "VALUES ('" + messageBean.getMittente() + "','" + messageBean.getRicevente() + "','"
					+ messageBean.getTesto() + "')";
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

	
	
   
}

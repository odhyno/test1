package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.entity.Message;
import logic.utility.ConnectionDB;

public class MessageDAO {

	
	static Connection con;

	private MessageDAO() {
		//Default Constructor
	}

	
	//funzione che ritorna tutti i messaggi relativi a due specifici utenti
	public static List<Message> showMessages(Message message) {
		
		
		String mittente = message.getMittente();
		String ricevente = message.getRicevente();
		
		
		List<Message> messagesList = new ArrayList<>();

		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String tempQuery = "SELECT * FROM messaggi WHERE mittente = '" + mittente + "' AND ricevente = '" + ricevente + "' OR mittente = '" + ricevente + "' AND ricevente = '" + mittente+"';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);
	
					while(tempRs.next()) {
						
						Message message2 = new Message();
						
						message2.setId(tempRs.getInt(1));
						message2.setMittente(tempRs.getString(2));
						message2.setRicevente(tempRs.getString(3));
						message2.setTesto(tempRs.getString(4));
						
						messagesList.add(message2);
					}

			}
			con.close();
			
		} catch (SQLException e) {
			
			

			e.printStackTrace();
		}
		
		return messagesList;
		
		
		
	}

	
	// funzione che inserisce un nuovo messaggio nel DB
	public static void insertMessages(Message message) {
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "INSERT INTO messaggi (mittente,ricevente,testo) "
						+ "VALUES ('" + message.getMittente() + "','" + message.getRicevente() + "','"
						+ message.getTesto() + "')";
				tempSt.executeQuery(sql);
			}			
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}


	

	
	
   
}

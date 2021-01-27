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

public class MessageDAO {

	
	static Connection con;

	private MessageDAO() {
		//Default Constructor
	}

	
	//funzione che ritorna tutti i messaggi relativi a due specifici utenti
	public static  synchronized List<Message> showMessages(MessageBean messageBean) {
		
		
		String mittente = messageBean.getMittente();
		String ricevente = messageBean.getRicevente();
		
		
		List<Message> messagesList = new ArrayList<>();

		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
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

			}
			con.close();
			
		} catch (SQLException e) {
			
			

			e.printStackTrace();
		}
		
		return messagesList;
		
		
		
	}

	
	// funzione che inserisce un nuovo messaggio nel DB
	public static synchronized void insertMessages(MessageBean messageBean) {
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "INSERT INTO messaggi (mittente,ricevente,testo) "
						+ "VALUES ('" + messageBean.getMittente() + "','" + messageBean.getRicevente() + "','"
						+ messageBean.getTesto() + "')";
				tempSt.executeQuery(sql);
			}			
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}


	

	
	
   
}

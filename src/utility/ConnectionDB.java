package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectionDB {

	
	
	private ConnectionDB() {
		
	}

	public static Connection dbConn() throws SQLException {

		// Connessione
		Connection con = null;

		try {

			Class.forName("org.mariadb.jdbc.Driver");

		} catch (Exception e) {
			
			// Create a Logger 
	        Logger logger = Logger.getLogger(ConnectionDB.class.getName()); 
	  
	        // log messages using log(Level level, String msg) 
	        logger.log(Level.WARNING, e.getMessage() ); 

		} // fine try/catch

		con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/SocialMusicDB?user=root"); // SocialMusicDB è il nome del DB

		return con;
	}

}


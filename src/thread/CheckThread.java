package thread;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.ObservableNotify;
import utility.ConnectionDB;

public class CheckThread implements Runnable{
	
	static Connection con;
	
	//private boolean run;
	
//	ObservableNotify notify = new ObservableNotify();
	
	String loggedUser;
	
	 public  CheckThread(String username) {
		 
		 this.loggedUser=username;
	}
	 
	 

	public synchronized void run() 
	    { 
		 
			 try {
				con = ConnectionDB.dbConn();
				Statement tempSt = con.createStatement();
				String tempQuery = "SELECT * FROM notifica WHERE username = '" + loggedUser + "';";
				ResultSet tempRs = tempSt.executeQuery(tempQuery);

				
				if (tempRs.first()) {
					
					int newValue=tempRs.getInt(2);
					
					int oldValue =tempRs.getInt(3);
					
					int difference;
							
					if(newValue > oldValue) {
								
						    System.out.println("cè una notifica");
							difference = newValue - oldValue;
							
							ObservableNotify notify = ObservableNotify.getInstance();
							notify.setValue(difference,loggedUser);
					}
				}
								
				con.close();
				
			} catch (SQLException e) {
				

				e.printStackTrace();
			}

	    }
}

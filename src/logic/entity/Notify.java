package logic.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.patterns.Observer;

public class Notify implements Observer {

	private String username;
	private int valoreAttuale;
	private int valoreConosciuto;
	private int notice;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getValoreAttuale() {
		return valoreAttuale;
	}

	public void setValoreAttuale(int valoreAttuale) {
		this.valoreAttuale = valoreAttuale;
	}

	public int getValoreConosciuto() {
		return valoreConosciuto;
	}

	public void setValoreConosciuto(int valoreConosciuto) {
		this.valoreConosciuto = valoreConosciuto;
	}

	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	@Override
	public void update() {
		
		  // Create a Logger 
        Logger logger = Logger.getLogger(Notify.class.getName()); 
  
        // log messages using log(Level level, String msg) 
        logger.log(Level.INFO, "Hai nuovi messaggi non letti"); 
	}
}

package logic.control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.bean.MessageBean;
import logic.bean.NotifyBean;
import logic.dao.NotifyDAO;
import logic.dao.MessageDAO;
import logic.dao.UserDAO;
import logic.entity.Message;
import logic.entity.ObservableNotify;
import logic.interfaces.Observer;



public class ControlSendMessage implements Observer {

	private static Observer instance = null;

    //Singleton
    
	
    public  static Observer getInstance()
    {

        if (instance == null) {

            instance = new ControlSendMessage();
         
        }

        return instance;

    }
    
    @Override
    public void add() {
    	ObservableNotify notify = ObservableNotify.getInstance();
    	notify.addObserver(instance);
    }
	
    @Override
    // funzione che torna tutti gli utenti
	public List<String> showUsers(String loggedUser)
    {
		
		 
		    
        //Inizializzo la lista di Stringhe e chiamo la DAO per avere tutti gli utenti
		    	
    	return UserDAO.showUsers(loggedUser);
    }
	
	
	
	
    @Override
    // funzione che torna tutti i messaggi con uno specifico utente
	public List<MessageBean> showMessages(MessageBean messageBean) {
		
		List<MessageBean> messageBeanList= new ArrayList<>();
	    
		
        //Inizializzo la lista di Stringhe e chiamo la DAO per avere tutti i messaggi
		List<Message> messages = MessageDAO.showMessages(messageBean);
		
		for(int i =0;i< messages.size();i++) {
			
			MessageBean msgBean = new MessageBean();
			
			msgBean.setMittente(messages.get(i).getMittente());
			msgBean.setRicevente(messages.get(i).getRicevente());
			msgBean.setTesto(messages.get(i).getTesto());
			
			messageBeanList.add(msgBean);
		}
		
		return messageBeanList;
		
		    	
	}

	
    @Override
	//funzione che inserisce il testo nel DB e incrementa di 1 il valore notifica
	public void inserText(MessageBean messageBean) {
		
		MessageDAO.insertMessages(messageBean);
		int value=NotifyDAO.getValoreNotifica(messageBean);
		NotifyDAO.updateValoreNotifica(value+1);
		
	}
	
	
    @Override
	//funzione che rimuove l' observer
	public void removeObserver() {
		
		ObservableNotify notify = ObservableNotify.getInstance();
		 notify.removeObserver(instance);
		
	}
	
	
	
	// funzione Observer che regola il numero di notifiche
	@Override
    public  synchronized  void update(NotifyBean notify) {
        
		  // Create a Logger 
        Logger logger = Logger.getLogger(ControlSendMessage.class.getName()); 
  
        // log messages using log(Level level, String msg) 
        logger.log(Level.INFO, " hai "+notify.getNotice() + " nuove notifiche"); 
        
		int oldValue=NotifyDAO.getNotify(notify.getUsername());
		 
		 int finalValue = oldValue+ notify.getNotice();
		 
		 notify.setValoreConosciuto(finalValue);
			        
	     NotifyDAO.addNotify(notify);
   }
	

	@Override
	//funzione che checka se si sta parlando con un utente presente nel DB
	public int checkUser(String ricevente) {
		
		return UserDAO.checkUser(ricevente);
		
	}
}
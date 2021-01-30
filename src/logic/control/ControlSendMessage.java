package logic.control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.bean.MessageBean;
import logic.bean.NotifyBean;
import logic.dao.UserDAO;
import logic.entity.Message;
import logic.patterns.FacadeDAO;
import logic.patterns.ObservableNotify;
import logic.patterns.Observer;

public class ControlSendMessage implements Observer {

	private static Observer instance = null;

	// Singleton

	public static Observer getInstance() {

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
	// funzione che torna tutti gli utenti tranne il loggato
	public List<String> showUsers(String loggedUser) {

		// Inizializzo la lista di Stringhe e chiamo la DAO per avere tutti gli utenti

		List<String> userlist = new FacadeDAO().showUsers();

		for (int i = 0; i < userlist.size(); i++) {

			if (userlist.get(i).equals(loggedUser)) {

				userlist.remove(i);
			}
		}

		return userlist;
	}

	@Override
	// funzione che torna tutti i messaggi con uno specifico utente
	public List<MessageBean> showMessages(MessageBean messageBean) {

		List<MessageBean> messageBeanList = new ArrayList<>();

		Message message = new Message();

		message.setMittente(messageBean.getMittente());
		message.setRicevente(messageBean.getRicevente());

		// Inizializzo la lista di Stringhe e chiamo la DAO per avere tutti i messaggi
		List<Message> messages = new FacadeDAO().showMessages(message);

		for (int i = 0; i < messages.size(); i++) {

			// MessageBean msgBean = new MessageBean();

			messageBean.setMittente(messages.get(i).getMittente());
			messageBean.setRicevente(messages.get(i).getRicevente());
			messageBean.setTesto(messages.get(i).getTesto());

			messageBeanList.add(messageBean);
		}

		return messageBeanList;

	}

	@Override
	// funzione che inserisce il testo nel DB e incrementa di 1 il valore notifica
	public int inserText(MessageBean messageBean) {

		if (messageBean.getMittente().length() == 0 || messageBean.getRicevente().length() == 0) {

			return -1;

		}
		Message message = new Message();

		message.setMittente(messageBean.getMittente());
		message.setRicevente(messageBean.getRicevente());
		message.setTesto(messageBean.getTesto());
		new FacadeDAO().insertMessage(message);

		return 1;

	}

	@Override
	// funzione che rimuove l' observer
	public void removeObserver() {

		ObservableNotify notify = ObservableNotify.getInstance();
		notify.removeObserver(instance);

	}

	// funzione Observer che regola il numero di notifiche
	@Override
	public synchronized void update(int value, String username) {

		// Create a Logger
		Logger logger = Logger.getLogger(ControlSendMessage.class.getName());

		// log messages using log(Level level, String msg)
		logger.log(Level.INFO, " hai " + value + " nuove notifiche");

		ObservableNotify notify = ObservableNotify.getInstance();

		notify.setEntityUsername(username);

		new FacadeDAO().updateNotify(notify);

	}

	@Override
	// funzione che checka se si sta parlando con un utente presente nel DB
	public int checkUser(String ricevente) {

		return UserDAO.checkUser(ricevente);

	}
}

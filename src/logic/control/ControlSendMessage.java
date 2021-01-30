package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.bean.MessageBean;
import logic.entity.Message;
import logic.entity.Notify;
import logic.patterns.FacadeDAO;

public class ControlSendMessage {

	private static ControlSendMessage instance = null;

	// Singleton

	public static ControlSendMessage getInstance() {

		if (instance == null) {

			instance = new ControlSendMessage();

		}

		return instance;

	}

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

	// funzione che inserisce il testo nel DB e incrementa di 1 il valore notifica
	public int insertText(MessageBean messageBean) {

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

	// funzione che checka se si sta parlando con un utente presente nel DB
	public int checkUser(String ricevente) {

		return new FacadeDAO().checkUser(ricevente);

	}

	// funzione che fa il check sulle notifiche
	public void checkNotify(String username) {
		int res = new FacadeDAO().checkNotify(username);

		if (res > 0) {

			Notify notify = new Notify();
			Message msg = new Message();

			msg.addObserver(notify);
			msg.setNotify(true);
			notify.setUsername(username);
			notify.setNotice(res);
			new FacadeDAO().updateNotify(notify);
		}

	}
}

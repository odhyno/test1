package logic.patterns;

import java.util.List;

import logic.dao.MessageDAO;
import logic.dao.NotifyDAO;
import logic.dao.PostDAO;
import logic.dao.UserDAO;
import logic.entity.Message;
import logic.entity.Notify;
import logic.entity.Post;
import logic.entity.User;

public class FacadeDAO {

	public int checkIfRegistered(User loginUser) {

		return UserDAO.checkIfRegistered(loginUser);
	}

	public User checkIfGoogleEmailRegistered(User user) {

		return UserDAO.checkIfGoogleEmailRegistered(user);
	}

	public String checkUsernameAlreadyTaken(String username) {

		return UserDAO.checkUsernameAlreadyTaken(username);
	}

	public int registerUser(User user) {

		UserDAO.registerUser(user);
		NotifyDAO.inizializeNotify(user.getEntityUsername());
		return 1;

	}

	public String checkEmail(User user) {

		return UserDAO.checkEmail(user);
	}

	public List<User> getUserList() {

		return UserDAO.getUserList();
	}

	public int modifyProfile(User user) {
		return UserDAO.modifyProfile(user);
	}

	public int modifyData(User user) {

		return UserDAO.modifyData(user);
	}

	public List<Post> getPostList() {

		return PostDAO.getPostList();
	}

	public int insertPost(Post post) {

		return PostDAO.insertPost(post);
	}

	public int deletePost(int entityId) {
		return PostDAO.deletePost(entityId);
	}

	public int modifyPost(Post post) {
		return PostDAO.modifyPost(post);
	}

	public int modifyTopicPost(Post post) {

		return PostDAO.modifyTopicPost(post);
	}

	public List<String> showUsers() {

		return UserDAO.showUsers();
	}

	public List<Message> showMessages(Message message) {

		return MessageDAO.showMessages(message);
	}

	public void insertMessage(Message message) {

		MessageDAO.insertMessages(message);
		int value = NotifyDAO.getValoreNotifica(message);
		NotifyDAO.updateValoreNotifica(value + 1);
	}

	public void updateNotify(Notify notify) {

		int oldValue = NotifyDAO.getNotify(notify.getUsername());

		int finalValue = oldValue + notify.getNotice();

		notify.setValoreConosciuto(finalValue);

		NotifyDAO.addNotify(notify);

	}

	public int checkNotify(String username) {

		return NotifyDAO.checkNotify(username);
	}

	public int checkUser(String ricevente) {
		return UserDAO.checkUser(ricevente);
	}

}

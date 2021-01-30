package logic.patterns;

import java.util.List;

import logic.dao.MessageDAO;
import logic.dao.NotifyDAO;
import logic.dao.PostDAO;
import logic.dao.UserDAO;
import logic.entity.Message;
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

	public void registerUser(User user) {

		UserDAO.registerUser(user);
		NotifyDAO.inizializeNotify(user.getEntityUsername());

	}

	public String checkEmail(User user) {

		return UserDAO.checkEmail(user);
	}

	public List<User> getUserList() {

		return UserDAO.getUserList();
	}

	public int modifyProfile(User user) {

		UserDAO.modifyProfile(user);
		return 1;
	}

	public int modifyData(User user) {

		UserDAO.modifyData(user);
		return 1;
	}

	public List<Post> getPostList() {

		return PostDAO.getPostList();
	}

	public int insertPost(Post post) {

		PostDAO.insertPost(post);
		return 1;
	}

	public int deletePost(int entityId) {
		PostDAO.deletePost(entityId);
		return 1;
	}

	public int modifyPost(Post post) {
		PostDAO.modifyPost(post);
		return 1;
	}

	public int modifyTopicPost(Post post) {

		PostDAO.modifyTopicPost(post);
		return 1;
	}

	public List<String> showUsers() {
		
		return UserDAO.showUsers();
	}

	public List<Message> showMessages(Message message) {
		
		return MessageDAO.showMessages(message);
	}

	public void insertMessage(Message message) {

		MessageDAO.insertMessages(message);
		int value=NotifyDAO.getValoreNotifica(message);
		NotifyDAO.updateValoreNotifica(value+1);
	}

	public void updateNotify(ObservableNotify notify) {

		int oldValue=NotifyDAO.getNotify(notify.getEntityUsername());
		 
		 int finalValue = oldValue+ notify.getEntityNotice();
		 
		 notify.setEntityValoreConosciuto(finalValue);
			        
	     NotifyDAO.addNotify(notify);
		
	}

}

package control;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import bean.PostBean;
import dao.PostDAO;
import entity.Post;
import boundary.WindowManager;

public class ControlTopicPost {
	
	public void insertTopicPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Insert Post Success");
		alert.setContentText("Success! Your Post has been inserted!");

		alert.showAndWait();
	}
	
	public void insertTopicPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You can't insert post with empty fields. Retry!");

		alert.showAndWait();
	}
	
	public void removeTopicPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Removed Successfully");
		alert.setContentText("Success! Your Post has been removed!");

		alert.showAndWait();
	}

	public void removeTopicPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}
	
	public void modifyTopicPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Modify Successfully");
		alert.setContentText("Success! Your Post has been modified!");

		alert.showAndWait();
	}

	public void modifyTopicPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Modify Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}

	public List<PostBean> getTopicPosts() {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
			
			if(post.get(i).getNomeSample().equals("null") && !post.get(i).getArgomento().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setArgomento(post.get(i).getArgomento());
					
				postBeanList.add(postBean);
				
			}
				
		}
		
		return postBeanList;
	}

	public List<PostBean> filterTopicPostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getAutore().equals(username) && !post.get(i).getArgomento().equals("null")) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setArgomento(post.get(i).getArgomento());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	}

	public void insertTopicPost(PostBean postBean) {
		
		//WindowManager win = WindowManager.getInstance();	
		
		if(postBean.getArgomento().length()==0 || postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0){
			
			insertTopicPostErrorAlert();
			//win.loadTopicPage();/////////////////////////////
			return;
		} else {
			
			Post post = new Post();
			
			post.setAutore(postBean.getAutore());
			post.setTitolo(postBean.getTitolo());
			post.setDescrizione(postBean.getDescrizione());
			post.setArgomento(postBean.getArgomento());
					
			PostDAO.insertPost(post);
			
			insertTopicPostAlert();
			//win.loadTopicPage();////////////////////////////////
			return;
		}	
		
	}

	public void removeTopicPost(int num) {
		
		WindowManager win = WindowManager.getInstance();
		
		List<PostBean> post = filterTopicPostByUsername(win.getLoggedUser().getUsername());
		
		if(num>=0 && num<post.size()) {
						
			PostDAO.deletePost(post.get(num).getId());
			removeTopicPostAlert();
			
		} else {
			
			removeTopicPostErrorAlert();
		}
		
	}

	public int checkId(int pos) {
		
		WindowManager win = WindowManager.getInstance();
		
		List<PostBean> post = filterTopicPostByUsername(win.getLoggedUser().getUsername());
		
		if(pos<0 || pos>post.size() ) {
			
			removeTopicPostErrorAlert();
			return -1;
		}
		
		return pos;
	}

	public void modifyTopicPost(PostBean postBean, int pos) {
		
		WindowManager win = WindowManager.getInstance();
		
		List<PostBean> post = filterTopicPostByUsername(win.getLoggedUser().getUsername());
				
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(pos).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(pos).getDescrizione());
			
		} else if (postBean.getArgomento().length()==0) {
			
			postBean.setArgomento(post.get(pos).getArgomento());
			
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0 && postBean.getArgomento().length()==0) {
			
			modifyTopicPostErrorAlert();
		}
			
			PostDAO.modifyTopicPost(post.get(pos).getId(), postBean);
			modifyTopicPostAlert();
	}

}

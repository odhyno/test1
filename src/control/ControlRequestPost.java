package control;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import bean.PostBean;
import dao.PostDAO;
import entity.Post;
import boundary.WindowManager;

public class ControlRequestPost {
	
	public void insertRequestPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Insert Post Success");
		alert.setContentText("Success! Your Post has been inserted!");

		alert.showAndWait();
	}
	
	public void insertRequestPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You can't insert post with empty fields. Retry!");

		alert.showAndWait();
	}
	
	public void removeRequestPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Removed Successfully");
		alert.setContentText("Success! Your Post has been removed!");

		alert.showAndWait();
	}

	public void removeRequestPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}
	
	public void modifyRequestPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Modify Successfully");
		alert.setContentText("Success! Your Post has been modified!");

		alert.showAndWait();
	}

	public void modifyRequestPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Modify Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}

	public List<PostBean> getRequestPosts() {

		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
			
			if(post.get(i).getNomeSample().equals("null") && post.get(i).getRisolto().equals("null") && post.get(i).getArgomento().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
					
				postBeanList.add(postBean);
				
			}
				
		}
		
		return postBeanList;
	}

	public void insertRequestPost(PostBean postBean) {
		
		//WindowManager win = WindowManager.getInstance();
		
		if(postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0) {
			
			insertRequestPostErrorAlert();
			//win.loadMemberBandPage();////////////////////////
			return;
			
		} else {
			
			Post post = new Post();
			
			post.setAutore(postBean.getAutore());
			post.setTitolo(postBean.getTitolo());
			post.setDescrizione(postBean.getDescrizione());
					
			PostDAO.insertPost(post);
			
			insertRequestPostAlert();
			//win.loadMemberBandPage();//////////////////////////
			return;
			
		}	
	}

	public List<PostBean> filterRequestPostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getAutore().equals(username) && post.get(i).getNomeSample().equals("null") && post.get(i).getRisolto().equals("null") && post.get(i).getArgomento().equals("null")) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	}
	
	public void removeRequestPost(int num) {
		
		WindowManager win = WindowManager.getInstance();
		
		List<PostBean> post = filterRequestPostByUsername(win.getLoggedUser().getUsername());
		
		if(num>=0 && num<post.size()) {
						
			PostDAO.deletePost(post.get(num).getId());
			removeRequestPostAlert();
			
		} else {
			
			removeRequestPostErrorAlert();
		}
		
	}

	public void modifyRequestPost(PostBean postBean, int pos) {
		
		WindowManager win = WindowManager.getInstance();
		
		List<PostBean> post = filterRequestPostByUsername(win.getLoggedUser().getUsername());
				
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(pos).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(pos).getDescrizione());
			
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0) {
			
			modifyRequestPostErrorAlert();
		}
			
			PostDAO.modifyPost(post.get(pos).getId(), postBean);
			modifyRequestPostAlert();
			
	}

	public int checkId(int pos) {
		
		WindowManager win = WindowManager.getInstance();
		
		List<PostBean> post = filterRequestPostByUsername(win.getLoggedUser().getUsername());
		
		if(pos<0 || pos>post.size() ) {
			
			removeRequestPostErrorAlert();
			return -1;
		}
		
		return pos;
	}
}

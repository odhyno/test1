package logic.control;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.bean.PostBean;
import logic.dao.PostDAO;
import logic.entity.Post;
import logic.utils.WindowManagerGUI;

public class ControlSamplePost {

	public void insertSamplePostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Insert Post Success");
		alert.setContentText("Success! Your Post has been inserted!");

		alert.showAndWait();
	}

	public void insertSamplePostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Insert Post Error");
		alert.setContentText("Error: You didn't insert any file. Retry!");

		alert.showAndWait();
	}
	
	public void removeSamplePostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Removed Successfully");
		alert.setContentText("Success! Your Post has been removed!");

		alert.showAndWait();
	}

	public void removeSamplePostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}
	
	public void modifySamplePostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Modify Successfully");
		alert.setContentText("Success! Your Post has been modified!");

		alert.showAndWait();
	}

	public void modifySamplePostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Modify Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}
	
	public void insertSamplePost(PostBean postBean) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		Post post = new Post();
		
		post.setAutore(win.getUser().getUsername());
		
		post.setTitolo(postBean.getTitolo());
		post.setArgomento(postBean.getArgomento());
		post.setDescrizione(postBean.getDescrizione());
		post.setNomeSample(postBean.getNomeSample());
				
		PostDAO.insertPost(post);

	/*	try {
			Files.copy(Paths.get(fl.getCanonicalPath()), Paths.get(
					"C:\\Users\\987018\\Desktop\\ISPW\\Progetto Social-Music\\Codice\\SocialMusic\\DB - Samples\\ "
							+ fl.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		insertSamplePostAlert();
		win.loadSamplePostPage();
	}
	
	public List<PostBean> filterSamplePostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<PostBean>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getAutore().equals(username) && post.get(i).getNomeSample() != null) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getId());
				postBean.setTitolo(post.get(i).getTitolo());
				postBean.setAutore(post.get(i).getAutore());
				postBean.setDescrizione(post.get(i).getDescrizione());
				postBean.setNomeSample(post.get(i).getNomeSample());
				postBean.setArgomento(post.get(i).getArgomento());
				postBean.setRisolto(post.get(i).getRisolto());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	
	}
	
	public void removeSamplePost(int num) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterSamplePostByUsername(win.getUser().getUsername());
		
		if(num>=0 && num<post.size()) {
						
			PostDAO.deletePost(post.get(num).getId());
			removeSamplePostAlert();
			
		} else {
			
			removeSamplePostErrorAlert();
		}
		
	}

	public void modifySamplePost(PostBean postBean, int pos) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterSamplePostByUsername(win.getUser().getUsername());
		
		//i=post.get(pos).getId();
		
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(pos).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(pos).getDescrizione());
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0) {
			modifySamplePostErrorAlert();
		}
		
		/*for(i=0;i<post.size();i++) {
			
			if(post.get(i).getId()==pos) {
				
				if(postBean.getTitolo().length()==0) {
					
					postBean.setTitolo(post.get(i).getTitolo());
					
				} else if(postBean.getDescrizione().length()==0) {
					
					postBean.setDescrizione(post.get(i).getDescrizione());
				}
				
			}
		}*/
		
	//	if(pos>=0 && pos<post.size()) {
			
			PostDAO.modifyPost(post.get(pos).getId(), postBean);
			modifySamplePostAlert();
			
	/*	} else {
			
			modifySamplePostErrorAlert();
		}		*/
	}

	public int checkId(int pos) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		List<PostBean> post = filterSamplePostByUsername(win.getUser().getUsername());
		
		if(pos<0 || pos>post.size() ) {
			
			removeSamplePostErrorAlert();
			return -1;
		}
		
		return pos;
	}
	
}

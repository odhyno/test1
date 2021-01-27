package control;

import java.util.ArrayList;
import java.util.List;
import bean.PostBean;
import dao.PostDAO;
import entity.Post;


public class ControlRequestPost {
	
	
	
	

	public List<PostBean> getRequestPosts() {

		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<>();
		
		
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

	public int insertRequestPost(PostBean postBean) {
		
		if(postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0) {
			
			return -1;
			
		} else {
			
			Post post = new Post();
			
			post.setAutore(postBean.getAutore());
			post.setTitolo(postBean.getTitolo());
			post.setDescrizione(postBean.getDescrizione());
					
			PostDAO.insertPost(post);
			
			return 1;
			
		}	
	}

	public List<PostBean> filterRequestPostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<>();
		
		
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
	
	public int removeRequestPost(PostBean post) {
		
		List<PostBean> postList = filterRequestPostByUsername(post.getAutore());
		
		if(post.getId()>=0 && post.getId()<postList.size()) {
			post.setId(postList.get(post.getId()).getId());			
			PostDAO.deletePost(post.getId());
			return 1;
			
		} else {
			
			return -1;
		}
		
	}

	public int modifyRequestPost(PostBean post) {

		
		List<PostBean> postList = filterRequestPostByUsername(post.getAutore());
				
		if(post.getTitolo().length()==0) {
			
			post.setTitolo(postList.get(post.getId()).getTitolo());
			
		} else if(post.getDescrizione().length()==0) {
			
			post.setDescrizione(postList.get(post.getId()).getDescrizione());
			
		} else if (post.getTitolo().length()==0 && post.getDescrizione().length()==0) {
			
			return -1;
		}
			post.setId(postList.get(post.getId()).getId());
			PostDAO.modifyPost( post);
			return 1;
			
	}

	public int checkId(PostBean post) {
		
		List<PostBean> postList = filterRequestPostByUsername(post.getAutore());
		
		if(post.getId()<0 || post.getId()>postList.size() ) {
			
			
			return -1;
		}
		
		return post.getId();
	}
}

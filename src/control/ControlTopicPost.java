package control;

import java.util.ArrayList;
import java.util.List;
import bean.PostBean;
import dao.PostDAO;
import entity.Post;


public class ControlTopicPost {
	
	
	
	

	public List<PostBean> getTopicPosts() {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<>();
		
		
		for (i = 0; i < post.size(); i++) {
			
			if(post.get(i).getEntityNomeSample().equals("null") && !post.get(i).getEntityArgomento().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getEntityId());
				postBean.setTitolo(post.get(i).getEntityTitolo());
				postBean.setAutore(post.get(i).getEntityAutore());
				postBean.setDescrizione(post.get(i).getEntityDescrizione());
				postBean.setArgomento(post.get(i).getEntityArgomento());
					
				postBeanList.add(postBean);
				
			}
				
		}
		
		return postBeanList;
	}

	public List<PostBean> filterTopicPostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getEntityAutore().equals(username) && !post.get(i).getEntityArgomento().equals("null")) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getEntityId());
				postBean.setTitolo(post.get(i).getEntityTitolo());
				postBean.setAutore(post.get(i).getEntityAutore());
				postBean.setDescrizione(post.get(i).getEntityDescrizione());
				postBean.setArgomento(post.get(i).getEntityArgomento());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	}

	public int insertTopicPost(PostBean postBean) {
		
		if(postBean.getArgomento().length()==0 || postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0){
			
			
			return -1;
		} else {
			
			Post post = new Post();
			
			post.setEntityAutore(postBean.getAutore());
			post.setEntityTitolo(postBean.getTitolo());
			post.setEntityDescrizione(postBean.getDescrizione());
			post.setEntityArgomento(postBean.getArgomento());
					
			PostDAO.insertPost(post);
			
			return 1;
		}	
		
	}

	public int removeTopicPost(PostBean post) {
		
		List<PostBean> postList = filterTopicPostByUsername(post.getAutore());
		
		if(post.getId()>=0 && post.getId()<postList.size()) {
						
			PostDAO.deletePost(postList.get(post.getId()).getId());
			return 1;
			
		} else {
			
			return -1;
		}
		
	}

	public int checkId(PostBean post) {
		
		List<PostBean> postList = filterTopicPostByUsername(post.getAutore());
		
		if(post.getId()<0 || post.getId()>postList.size() ) {
			
			
			return -1;
		}
		
		return post.getId();
	}

	public int modifyTopicPost(PostBean postBean) {
		
		List<PostBean> post = filterTopicPostByUsername(postBean.getAutore());
				
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(postBean.getId()).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(postBean.getId()).getDescrizione());
			
		} else if (postBean.getArgomento().length()==0) {
			
			postBean.setArgomento(post.get(postBean.getId()).getArgomento());
			
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0 && postBean.getArgomento().length()==0) {
			
			return -1;
		}
		
		postBean.setId(post.get(postBean.getId()).getId());
		PostDAO.modifyTopicPost(postBean);
			return 1;
	}

}

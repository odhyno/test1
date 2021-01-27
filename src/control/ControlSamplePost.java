package control;

import java.util.ArrayList;
import java.util.List;
import bean.PostBean;
import dao.PostDAO;
import entity.Post;

public class ControlSamplePost {


	
	public int insertSamplePost(PostBean postBean) {
		
		Post post = new Post();
		
		post.setEntityAutore(postBean.getAutore());
		
		post.setEntityTitolo(postBean.getTitolo());
		post.setEntityDescrizione(postBean.getDescrizione());
		post.setEntityNomeSample(postBean.getNomeSample());
				
		PostDAO.insertPost(post);
		
		return 1;

	}
	
	public List<PostBean> filterSamplePostByUsername(String username) {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<>();
		
		
		for (i = 0; i < post.size(); i++) {
						
			if(post.get(i).getEntityAutore().equals(username) && !post.get(i).getEntityNomeSample().equals("null")) {
								
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getEntityId());
				postBean.setTitolo(post.get(i).getEntityTitolo());
				postBean.setAutore(post.get(i).getEntityAutore());
				postBean.setDescrizione(post.get(i).getEntityDescrizione());
				postBean.setNomeSample(post.get(i).getEntityNomeSample());
				
				postBeanList.add(postBean);
				
			}
		}
		
		return postBeanList;
	
	}
	
	public int removeSamplePost(PostBean post) {
		
		
		List<PostBean> postList = filterSamplePostByUsername(post.getAutore());
		
		if(post.getId()>=0 && post.getId()<postList.size()) {
						
			PostDAO.deletePost(postList.get(post.getId()).getId());
			return 1;
			
		} else {
			
			return -1;
		}
		
	}

	public int modifySamplePost(PostBean postBean) {
		
		List<PostBean> post = filterSamplePostByUsername(postBean.getAutore());
				
		if(postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(post.get(postBean.getId()).getTitolo());
			
		} else if(postBean.getDescrizione().length()==0) {
			
			postBean.setDescrizione(post.get(postBean.getId()).getDescrizione());
		} else if (postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0) {
			return -1;
		}
			postBean.setId(post.get(postBean.getId()).getId());
			PostDAO.modifyPost( postBean);
			return 1;
	}

	public int checkId(PostBean post) {
		
		
		List<PostBean> postList = filterSamplePostByUsername(post.getAutore());
		
		if(post.getId()<0 || post.getId()>postList.size() ) {
			
			return -1;
		}
		
		return post.getId();
	}

	public List<PostBean> getSamplePosts() {
		
		int i;
		
		List<Post> post = PostDAO.getPostList();
		
		List<PostBean> postBeanList = new ArrayList<>();		
		
		for (i = 0; i < post.size(); i++) {
			
			if(!post.get(i).getEntityNomeSample().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getEntityId());
				postBean.setTitolo(post.get(i).getEntityTitolo());
				postBean.setAutore(post.get(i).getEntityAutore());
				postBean.setDescrizione(post.get(i).getEntityDescrizione());
				postBean.setNomeSample(post.get(i).getEntityNomeSample());

				postBeanList.add(postBean);	
			}
				
		}
		
		return postBeanList;
	}
	
}

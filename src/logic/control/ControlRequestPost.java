package logic.control;

import java.util.ArrayList;
import java.util.List;
import logic.bean.PostBean;
import logic.entity.Post;
import logic.patterns.FacadeDAO;


public class ControlRequestPost {
	
	private static ControlRequestPost instance = null;
    
    private ControlRequestPost()
    {
    	
    }

    //Singleton
    
    public static ControlRequestPost getInstance()
    {

        if (instance == null) {

            instance = new ControlRequestPost();

        }

        return instance;
        
    }

	
	
	
	
    // funzione che ritorna una lista di requestPost Beans
	public List<PostBean> getRequestPosts() {

		int i;
		
		List<Post> post = new FacadeDAO().getPostList();
		List<PostBean> postBeanList = new ArrayList<>();
		
		
		for (i = 0; i < post.size(); i++) {
			
			if(post.get(i).getEntityNomeSample().equals("null") && post.get(i).getEntityRisolto().equals("null") && post.get(i).getEntityArgomento().equals("null")) {
				
				PostBean postBean = new PostBean();
				
				postBean.setId(post.get(i).getEntityId());
				postBean.setTitolo(post.get(i).getEntityTitolo());
				postBean.setAutore(post.get(i).getEntityAutore());
				postBean.setDescrizione(post.get(i).getEntityDescrizione());
					
				postBeanList.add(postBean);
				
			}
				
		}
		
		return postBeanList;
	}
	
	
	
	//funzione che inserisce un nuovo requestPost nel sistema
	public int insertRequestPost(PostBean postBean) {
		
		if(postBean.getTitolo().length()==0 || postBean.getDescrizione().length()==0) {
			
			return -1;
			
		} else {
			
			Post post = new Post();
			
			post.setEntityAutore(postBean.getAutore());
			post.setEntityTitolo(postBean.getTitolo());
			post.setEntityDescrizione(postBean.getDescrizione());
				
			return new FacadeDAO().insertPost(post);
	
		}	
	}
	
	
	
	//funzione che ritorna tutti i requestPost filtrati per username
	public List<PostBean> filterRequestPostByUsername(String username)  {
				
				int i;
				
				List<Post> post = new FacadeDAO().getPostList();
				
				
					
				List<PostBean> postBeanList = new ArrayList<>();
				
				
				for (i = 0; i < post.size(); i++) {
								
					if(post.get(i).getEntityAutore().equals(username) && post.get(i).getEntityNomeSample().equals("null") && post.get(i).getEntityRisolto().equals("null") && post.get(i).getEntityArgomento().equals("null")) {
										
						PostBean postBean = new PostBean();
						
						postBean.setId(post.get(i).getEntityId());
						postBean.setTitolo(post.get(i).getEntityTitolo());
						postBean.setAutore(post.get(i).getEntityAutore());
						postBean.setDescrizione(post.get(i).getEntityDescrizione());
						
						postBeanList.add(postBean);
									
					}
				}
				
				if (postBeanList.size()==0) {
					return null;
				}
					
				
				return postBeanList;
	}
	
	
	//funzione che rimuove il requestPost con l'ID selezionato
	public int removeRequestPost(PostBean postBean) {
		
		List<PostBean> postList = filterRequestPostByUsername(postBean.getAutore());
		
		if(postBean.getId()>=0 && postBean.getId()<postList.size()) {
			
			Post post= new Post();			
			post.setEntityId(postList.get(postBean.getId()).getId());	
	
			return new FacadeDAO().deletePost(post.getEntityId());

			
		} else {
			
			return -1;
		}
		
	}
	
	
	
	//funzione che modifica un requestPost nel sistema
	public int modifyRequestPost(PostBean postBean) {

		
		List<PostBean> postList = filterRequestPostByUsername(postBean.getAutore());
		
		if(postBean.getTitolo().length()==0 && postBean.getDescrizione().length()==0) {
			
			return -1;
			
		} else if(postBean.getDescrizione().length()==0) {
			
			
			postBean.setDescrizione(postList.get(postBean.getId()).getDescrizione());
			
		} else if (postBean.getTitolo().length()==0) {
			
			postBean.setTitolo(postList.get(postBean.getId()).getTitolo());
			
		}
			
		Post post= new Post();			
		post.setEntityId(postList.get(postBean.getId()).getId());
		post.setEntityTitolo(postBean.getTitolo());	
		post.setEntityDescrizione(postBean.getDescrizione());	
		
		return new FacadeDAO().modifyPost( post);

	}
	
	
	//funzione che confronta l'ID inserito con quello di uno dei propri requestPost
	public int checkId(PostBean post) {
		
		List<PostBean> postList = filterRequestPostByUsername(post.getAutore());
		
		if(post.getId()<0 || post.getId()>postList.size() ) {
			
			
			return -1;
		}
		
		return post.getId();
	}
}

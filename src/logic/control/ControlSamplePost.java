package logic.control;

import java.util.ArrayList;
import java.util.List;
import logic.bean.PostBean;
import logic.entity.Post;
import logic.patterns.FacadeDAO;

public class ControlSamplePost {

	private static ControlSamplePost instance = null;

	private ControlSamplePost() {

	}

	// Singleton

	public static ControlSamplePost getInstance() {

		if (instance == null) {

			instance = new ControlSamplePost();

		}

		return instance;

	}

	// funzione che inserisce un samplepost nel sistema
	public int insertSamplePost(PostBean postBean) {

		Post post = new Post();

		post.setEntityAutore(postBean.getAutore());

		post.setEntityTitolo(postBean.getTitolo());
		post.setEntityDescrizione(postBean.getDescrizione());
		post.setEntityNomeSample(postBean.getNomeSample());

		return new FacadeDAO().insertPost(post);

	}

	// funzione che ritorna i samplepost inseriti dall'utente corrente
	public List<PostBean> filterSamplePostByUsername(String username) {

		int i;

		List<Post> post = new FacadeDAO().getPostList();

		List<PostBean> postBeanList = new ArrayList<>();

		for (i = 0; i < post.size(); i++) {

			if (post.get(i).getEntityAutore().equals(username) && !post.get(i).getEntityNomeSample().equals("null")) {

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

	// funzione che elimina un proprio samplepost
	public int removeSamplePost(PostBean post) {

		List<PostBean> postList = filterSamplePostByUsername(post.getAutore());

		if (post.getId() >= 0 && post.getId() < postList.size()) {

			return new FacadeDAO().deletePost(postList.get(post.getId()).getId());

		} else {

			return -1;
		}

	}

	// funzione che modifica un samplepost dell'utente corrente
	public int modifySamplePost(PostBean postBean) {

		List<PostBean> postList = filterSamplePostByUsername(postBean.getAutore());
		
		
		if (postBean.getTitolo().length() == 0 && postBean.getDescrizione().length() == 0) {
			return -1;
		 }
		
		if (postBean.getTitolo().length() == 0) {

			postBean.setTitolo(postList.get(postBean.getId()).getTitolo());

		}
		
		if (postBean.getDescrizione().length() == 0) {

			postBean.setDescrizione(postList.get(postBean.getId()).getDescrizione());
			
		
		}
		Post post = new Post();
		post.setEntityId(postList.get(postBean.getId()).getId());
		post.setEntityDescrizione(postBean.getDescrizione());
		post.setEntityTitolo(postBean.getTitolo());

		return new FacadeDAO().modifyPost(post);

	}

	// funzione che controlla se l'id del post appartiene all'utente corrente
	public int checkId(PostBean post) {

		List<PostBean> postList = filterSamplePostByUsername(post.getAutore());

		if (post.getId() < 0 || post.getId() > postList.size()) {

			return -1;
		}

		return post.getId();
	}

	// funzione che ritorna tutti i sampleposts nel sistema
	public List<PostBean> getSamplePosts() {

		int i;

		List<Post> post = new FacadeDAO().getPostList();

		List<PostBean> postBeanList = new ArrayList<>();

		for (i = 0; i < post.size(); i++) {

			if (!post.get(i).getEntityNomeSample().equals("null")) {

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

package logic.control;

import java.util.ArrayList;
import java.util.List;
import logic.bean.PostBean;
import logic.entity.Post;
import logic.patterns.FacadeDAO;

public class ControlTopicPost {

	private static ControlTopicPost instance = null;
	
	private ControlTopicPost() {
		
	}

	// singleton

	public static ControlTopicPost getInstance() {

		if (instance == null) {

			instance = new ControlTopicPost();

		}

		return instance;

	}

	// funzione che ritorna tutti i post di tipo topic
	public List<PostBean> getTopicPosts() {

		int i;

		List<Post> post = new FacadeDAO().getPostList();

		List<PostBean> postBeanList = new ArrayList<>();

		for (i = 0; i < post.size(); i++) {

			if (post.get(i).getEntityNomeSample().equals("null") && !post.get(i).getEntityArgomento().equals("null")) {

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

	// funzione che ritorna tutti i post di tipo topic appartenti all'utente
	// corrente
	public List<PostBean> filterTopicPostByUsername(String username) {

		int i;

		List<Post> post = new FacadeDAO().getPostList();

		List<PostBean> postBeanList = new ArrayList<>();

		for (i = 0; i < post.size(); i++) {

			if (post.get(i).getEntityAutore().equals(username) && !post.get(i).getEntityArgomento().equals("null")) {

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

	// funzione che inserisce un topic post nel sistema

	public int insertTopicPost(PostBean postBean) {

		if (postBean.getArgomento().length() == 0 || postBean.getTitolo().length() == 0
				|| postBean.getDescrizione().length() == 0) {

			return -1;
		} else {

			Post post = new Post();

			post.setEntityAutore(postBean.getAutore());
			post.setEntityTitolo(postBean.getTitolo());
			post.setEntityDescrizione(postBean.getDescrizione());
			post.setEntityArgomento(postBean.getArgomento());

			return new FacadeDAO().insertPost(post);
		}

	}

	// funzione che rimuove un topic post dell'utente corrente
	public int removeTopicPost(PostBean post) {

		List<PostBean> postList = filterTopicPostByUsername(post.getAutore());

		if (post.getId() >= 0 && post.getId() < postList.size()) {

			return new FacadeDAO().deletePost(postList.get(post.getId()).getId());

		} else {

			return -1;
		}

	}

	// funzione che controlla se un id inserito appartiene ad un post dell'utente
	// corrente
	public int checkId(PostBean post) {

		List<PostBean> postList = filterTopicPostByUsername(post.getAutore());

		if (post.getId() < 0 || post.getId() > postList.size()) {

			return -1;
		}

		return post.getId();
	}

	// funzione che modifica un topicpost
	public int modifyTopicPost(PostBean postBean) {

		List<PostBean> postList = filterTopicPostByUsername(postBean.getAutore());
		
		if (postBean.getTitolo().length() == 0 && postBean.getDescrizione().length() == 0
				&& postBean.getArgomento().length() == 0) {

			return -1;
		}else if (postBean.getTitolo().length() == 0) {

			postBean.setTitolo(postList.get(postBean.getId()).getTitolo());

		} else if (postBean.getDescrizione().length() == 0) {

			postBean.setDescrizione(postList.get(postBean.getId()).getDescrizione());

		} else if (postBean.getArgomento().length() == 0) {

			postBean.setArgomento(postList.get(postBean.getId()).getArgomento());

		}

		Post post = new Post();
		post.setEntityId(postList.get(postBean.getId()).getId());
		post.setEntityArgomento(postBean.getArgomento());
		post.setEntityTitolo(postBean.getTitolo());
		post.setEntityDescrizione(postBean.getDescrizione());

		return new FacadeDAO().modifyTopicPost(post);
	}

}

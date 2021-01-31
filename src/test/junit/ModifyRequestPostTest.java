package test.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import logic.bean.PostBean;
import logic.control.ControlRequestPost;

class ModifyRequestPostTest {

	@Test
	public void modifyRequestPostTest() {

		ControlRequestPost ctrlReqPost = ControlRequestPost.getInstance();
		PostBean postBean = new PostBean();

		postBean.setTitolo("Titolo modificato request");
		postBean.setAutore("gino");
		postBean.setDescrizione("descrizione modificata request");
		postBean.setId(0);

		int output = ctrlReqPost.modifyRequestPost(postBean);

		assertEquals(1, output);// fallisce se non c'è un post di tipo request nel database, per l'utente "gino"

	}

	@Test
	public void modifyEmptyFieldsRequestPostTest() {

		ControlRequestPost ctrlReqPost = ControlRequestPost.getInstance();
		PostBean postBean = new PostBean();

		postBean.setTitolo("");
		postBean.setAutore("gino");
		postBean.setDescrizione("");
		postBean.setId(0);

		int output = ctrlReqPost.modifyRequestPost(postBean);

		assertEquals(-1, output);

	}

}

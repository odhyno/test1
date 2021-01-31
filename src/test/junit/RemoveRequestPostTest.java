package test.junit;

//Corsico Alessandro
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.bean.PostBean;
import logic.control.ControlRequestPost;

class RemoveRequestPostTest {
	
	@Test
	public void removeRequestPostTest() {
		
		ControlRequestPost ctrlReqPost = ControlRequestPost.getInstance();
		PostBean postBean = new PostBean();
		
		postBean.setAutore("gino");
		postBean.setId(0);
		
		int output = ctrlReqPost.removeRequestPost(postBean);

		assertEquals(1, output);
	}
	
	
	@Test
	public void removeRequestPostWrongIdTest() {
		
		ControlRequestPost ctrlReqPost = ControlRequestPost.getInstance();
		PostBean postBean = new PostBean();
		
		postBean.setAutore("gino");
		postBean.setId(100);
		
		int output = ctrlReqPost.removeRequestPost(postBean);

		assertEquals(-1, output);
	}
	

}

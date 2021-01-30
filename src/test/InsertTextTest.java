package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.bean.MessageBean;
import logic.control.ControlSendMessage;
import logic.patterns.Observer;

class InsertTextTest {

	@Test
	public void insertTextTest() {

		Observer ctrlsendmessage = ControlSendMessage.getInstance();
		MessageBean messageBean = new MessageBean();

		messageBean.setMittente("gino");
		messageBean.setRicevente("admin");
		messageBean.setTesto("test Junit");

		int output = ctrlsendmessage.inserText(messageBean);

		assertEquals(1, output);
	}

	@Test
	public void checkUserTest() {

		Observer ctrlsendmessage = ControlSendMessage.getInstance();

		MessageBean messageBean = new MessageBean();
		messageBean.setRicevente("admin");

		int output = ctrlsendmessage.checkUser(messageBean.getRicevente());

		assertEquals(1, output);
	}

}

package test.junit;


//Monnati Leonardo
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.bean.MessageBean;
import logic.control.ControlSendMessage;

class InsertTextTest {

	@Test
	public void insertTextTest() {

		ControlSendMessage ctrlsendmessage = ControlSendMessage.getInstance();
		MessageBean messageBean = new MessageBean();

		messageBean.setMittente("gino");
		messageBean.setRicevente("admin");
		messageBean.setTesto("test Junit");

		int output = ctrlsendmessage.insertText(messageBean);

		assertEquals(1, output);
	}

	@Test
	public void checkUserTest() {

		ControlSendMessage ctrlsendmessage = ControlSendMessage.getInstance();

		MessageBean messageBean = new MessageBean();
		messageBean.setRicevente("admin");

		int output = ctrlsendmessage.checkUser(messageBean.getRicevente());

		assertEquals(1, output);
	}

}

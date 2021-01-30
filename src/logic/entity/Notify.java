package logic.entity;

import logic.patterns.Observer;

public class Notify extends Observer {

	String username;
	int valoreAttuale;
	int valoreConosciuto;
	int notice;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getValoreAttuale() {
		return valoreAttuale;
	}

	public void setValoreAttuale(int valoreAttuale) {
		this.valoreAttuale = valoreAttuale;
	}

	public int getValoreConosciuto() {
		return valoreConosciuto;
	}

	public void setValoreConosciuto(int valoreConosciuto) {
		this.valoreConosciuto = valoreConosciuto;
	}

	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	@Override
	public void update() {
		System.out.println("Hai nuovi messaggi non letti");
	}
}

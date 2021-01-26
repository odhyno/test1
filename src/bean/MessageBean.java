package bean;

public class MessageBean {

	private int id;
	private String mittente;
	private String ricevente;
	private String testo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMittente() {
		return mittente;
	}
	public void setMittente(String mittente) {
		this.mittente = mittente;
	}
	public String getRicevente() {
		return ricevente;
	}
	public void setRicevente(String ricevente) {
		this.ricevente = ricevente;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
}

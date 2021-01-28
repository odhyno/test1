package bean;

public class MessageBean {

	private int idBean;
	private String mittenteBean;
	private String riceventeBean;
	private String testoBean;
	
	public int getId() {
		return idBean;
	}
	public void setId(int id) {
		this.idBean = id;
	}
	public String getMittente() {
		return mittenteBean;
	}
	public void setMittente(String mittente) {
		this.mittenteBean = mittente;
	}
	public String getRicevente() {
		return riceventeBean;
	}
	public void setRicevente(String ricevente) {
		this.riceventeBean = ricevente;
	}
	public String getTesto() {
		return testoBean;
	}
	public void setTesto(String testo) {
		this.testoBean = testo;
	}
}

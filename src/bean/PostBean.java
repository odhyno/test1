package bean;

public class PostBean {
	
	private int idBean;

	private String titoloBean;
	private String autoreBean;
	private String descrizioneBean;
	
	private String nomeSampleBean;
	
	private String argomentoBean;
	
	private String risoltoBean;

	public int getId() {
		return idBean;
	}

	public void setId(int id) {
		this.idBean = id;
	}
	
	public String getTitolo() {
		return titoloBean;
	}

	public void setTitolo(String titolo) {
		this.titoloBean = titolo;
	}

	public String getAutore() {
		return autoreBean;
	}

	public void setAutore(String autore) {
		this.autoreBean = autore;
	}

	public String getDescrizione() {
		return descrizioneBean;
	}

	public void setDescrizione(String descrizione) {
		this.descrizioneBean = descrizione;
	}

	public String getNomeSample() {
		return nomeSampleBean;
	}

	public void setNomeSample(String nomeSample) {
		this.nomeSampleBean = nomeSample;
	}

	public String getArgomento() {
		return argomentoBean;
	}

	public void setArgomento(String argomento) {
		this.argomentoBean = argomento;
	}

	public String getRisolto() {
		return risoltoBean;
	}

	public void setRisolto(String risolto) {
		this.risoltoBean = risolto;
	}
	

}

package entity;

public class Post {
	
	private int id;
	
	private String titolo;
	private String autore;
	private String descrizione;
	
	private String nomeSample;
	
	private String argomento;
	
	private String risolto;
	
	public Post(int int1, String string, String string2, String string3, String string4, String string5,
			String string6) {
	}

	public Post() {
	}

	public int getEntityId() {
		return id;
	}

	public void setEntityId(int id) {
		this.id = id;
	}
	
	public String getEntityTitolo() {
		return titolo;
	}
	
	public void setEntityTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEntityAutore() {
		return autore;
	}

	public void setEntityAutore(String autore) {
		this.autore = autore;
	}

	public String getEntityDescrizione() {
		return descrizione;
	}

	public void setEntityDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getEntityNomeSample() {
		return nomeSample;
	}

	public void setEntityNomeSample(String nomeSample) {
		this.nomeSample = nomeSample;
	}

	public String getEntityArgomento() {
		return argomento;
	}

	public void setEntityArgomento(String argomento) {
		this.argomento = argomento;
	}

	public String getEntityRisolto() {
		return risolto;
	}

	public void setEntityRisolto(String risolto) {
		this.risolto = risolto;
	}

}

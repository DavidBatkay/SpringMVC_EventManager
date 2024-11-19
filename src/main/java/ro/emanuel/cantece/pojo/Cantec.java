package ro.emanuel.cantece.pojo;

public class Cantec {
	
	private int id;
	private String titlu;
	private String autor;
	private String linkPartitura;
	private String versuri;
	private int nrVoturi;
	 
	public Cantec() {
		 
	}
	
	public Cantec(int id, String titlu, String autor, String linkPartitura, String versuri, int nrVoturi) {
		super();
		this.id = id;
		this.titlu = titlu;
		this.autor = autor;
		this.linkPartitura = linkPartitura;
		this.versuri = versuri;
		this.nrVoturi = nrVoturi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLinkPartitura() {
		return linkPartitura;
	}

	public void setLinkPartitura(String linkPartitura) {
		this.linkPartitura = linkPartitura;
	}

	public String getVersuri() {
		return versuri;
	}

	public void setVersuri(String versuri) {
		this.versuri = versuri;
	}

	public int getNrVoturi() {
		return nrVoturi;
	}

	public void setNrVoturi(int nrVoturi) {
		this.nrVoturi = nrVoturi;
	}
	
	

}

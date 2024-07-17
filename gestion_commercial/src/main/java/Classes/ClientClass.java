package Classes;

import java.io.Serializable;

public class ClientClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IDClient;
	private String nom;
	private String adresse;
	private int cp;
	private String ville;
	
	 public int getIDClient() {
	        return IDClient;
	    }

	    public void setIDClient(int IDClient) {
	        this.IDClient = IDClient;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public int getCp() {
	        return cp;
	    }

	    public void setCp(int cp) {
	        this.cp = cp;
	    }

	    public String getVille() {
	        return ville;
	    }

	    public void setVille(String ville) {
	        this.ville = ville;
	    }

		public ClientClass(String nom, String adresse, int cp, String ville) {
			super();
			this.nom = nom;
			this.adresse = adresse;
			this.cp = cp;
			this.ville = ville;
		}

		public ClientClass() {
			super();
		}
		
	    
}

package Classes;

import java.io.Serializable;

public class ClassFamilles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int IDFAM;
	private String intitule;
	public int getIDFAM() {
		return IDFAM;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setIDFAM(int iDFAM) {
		IDFAM = iDFAM;
	}
	public ClassFamilles(String intitule) {
		super();
		this.intitule = intitule;
	}
	public ClassFamilles() {
		super();
	}
	 @Override
	    public String toString() {
	        return "ClassFamilles{" +	                
	                ", IDFAM=" + IDFAM +
	                ", intitule='" + intitule + '\'' +
	                '}';
	    }
}
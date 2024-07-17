package Classes;

import java.io.Serializable;
import java.util.List;

public class ClassProduits implements Serializable {

    private static final long serialVersionUID = 1L;
    private int IDProduit;
    private int IDFAM;
    private String designation;
    private int stkinvent;
    private int stkactual;
    private int prixuht;
    private String photo;
    private String intitule;
    private List<ClassFamilles> familles;
   

    public List<ClassFamilles> getFamilles() {
		return familles;
	}

	public void setFamilles(List<ClassFamilles> familles) {
		this.familles = familles;
	}

	public int getIDProduit() {
        return IDProduit;
    }

    public void setIDProduit(int IDProduit) {
        this.IDProduit = IDProduit;
    }

    public int getIDFAM() {
        return IDFAM;
    }

    public void setIDFAM(int IDFAM) {
        this.IDFAM = IDFAM;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getStkinvent() {
        return stkinvent;
    }

    public void setStkinvent(int stkinvent) {
        this.stkinvent = stkinvent;
    }

    public int getStkactual() {
        return stkactual;
    }

    public void setStkactual(int stkactual) {
        this.stkactual = stkactual;
    }

    public int getPrixuht() {
        return prixuht;
    }

    public void setPrixuht(int prixuht) {
        this.prixuht = prixuht;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    // Getter and setter methods for intitule
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public ClassProduits(int IDProduit, int IDFAM, String designation, int stkinvent, int stkactual, int prixuht, String photo, String intitule) {
        this.IDProduit = IDProduit;
        this.IDFAM = IDFAM;
        this.designation = designation;
        this.stkinvent = stkinvent;
        this.stkactual = stkactual;
        this.prixuht = prixuht;
        this.photo = photo;
        this.intitule = intitule;
    }

    public ClassProduits() {
    }

    @Override
    public String toString() {
        return "ClassProduits{" +
                "IDProduit=" + IDProduit +
                ", IDFAM=" + IDFAM +
                ", designation='" + designation + '\'' +
                ", stkinvent=" + stkinvent +
                ", stkactual=" + stkactual +
                ", prixuht=" + prixuht +
                ", photo='" + photo + '\'' +
                ", intitule='" + intitule + '\'' +
                '}';
    }
}

package Classes;

import java.io.Serializable;

public class ClassDetailCMD implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IDligneCMD;
	private int IDProduit;
	private int QT;
	private int prixVT;
	
	public int getIDLigneCMD() {
        return IDligneCMD;
    }

    public void setIDLigneCMD(int IDligneCMD) {
        this.IDligneCMD = IDligneCMD;
    }

    public int getIDProduit() {
        return IDProduit;
    }

    public void setIDProduit(int IDProduit) {
        this.IDProduit = IDProduit;
    }

    public int getQT() {
        return QT;
    }

    public void setQT(int QT) {
        this.QT = QT;
    }

    public int getPrixVT() {
        return prixVT;
    }

    public void setPrixVT(int prixVT) {
        this.prixVT = prixVT;
    }

	public ClassDetailCMD(int iDProduit, int qT, int prixVT) {
		super();
		IDProduit = iDProduit;
		QT = qT;
		this.prixVT = prixVT;
	}

	public ClassDetailCMD() {
		super();
	}
    

}

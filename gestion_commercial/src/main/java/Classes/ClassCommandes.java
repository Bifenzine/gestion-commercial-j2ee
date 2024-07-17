package Classes;

import java.io.Serializable;

public class ClassCommandes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int NumCMD;
	private int IDClient;
	private String dteCmd;
	private String commentaires;
	private String etatCMD;
	
	 public int getNumCMD() {
	        return NumCMD;
	    }

	    public void setNumCMD(int numCMD) {
	        NumCMD = numCMD;
	    }

	    public int getIDClient() {
	        return IDClient;
	    }

	    public void setIDClient(int IDClient) {
	        this.IDClient = IDClient;
	    }

	    public String getDteCmd() {
	        return dteCmd;
	    }

	    public void setDteCmd(String dteCmd) {
	        this.dteCmd = dteCmd;
	    }

	    public String getCommentaires() {
	        return commentaires;
	    }

	    public void setCommentaires(String commentaires) {
	        this.commentaires = commentaires;
	    }

	    public String getEtatCMD() {
	        return etatCMD;
	    }

	    public void setEtatCMD(String etatCMD) {
	        this.etatCMD = etatCMD;
	    }

		public ClassCommandes(int iDClient, String dteCmd, String commentaires, String etatCMD) {
			super();
			IDClient = iDClient;
			this.dteCmd = dteCmd;
			this.commentaires = commentaires;
			this.etatCMD = etatCMD;
		}

		public ClassCommandes() {
			super();
		}
		
	    
}

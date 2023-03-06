package modèlePourEtudiants;


public class Cliente {

	    private String nom;
	    private String prenom;
	    private String add1;
	    private String CP;
	    private String ville;
	    private String tel;
	    private String mail;

	    public Cliente(String nom, String prenom, String add1, String CP, String ville, String tel, String mail ) {
	        this.nom=nom;
	        this.prenom=prenom;
	        this.add1=add1;
	        this.CP=CP;
	        this.ville=ville;
	        this.tel=tel;
	        this.mail=mail;

	    }

	    public String getNom() {
	        return this.nom;
	    }

	    public String getPrenom() {
	        return this.prenom;
	    }

	    public String getAdd1() {
	        return this.add1;
	    }

	    public String  getCP() {
	        return this.CP;
	    }

	    public String getVille() {
	        return this.ville;
	    }

	    public String getTel() {
	        return this.tel;
	    }

	    public String getMail() {
	        return this.mail;
	    }
}

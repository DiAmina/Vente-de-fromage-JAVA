package mod�lePourEtudiants;

public class ArticlePanier {
	
	private String nom;
	private float prix;
	private int quantit�;
	
	public ArticlePanier(String nom, float prix, int quantit�) {
		this.nom = nom;
		this.prix = prix;
		this.quantit� = quantit�;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	
	public float prixQuantit�() {
		return this.prix * this.quantit�;
	}
	
	public String toString() {
		return this.getNom() + "  |  " + this.getPrix() + "  |  " + this.getQuantit�() + "  |  " + this.prixQuantit�() + "\n";
	}

}

package modèlePourEtudiants;

public class ArticlePanier {
	
	private String nom;
	private float prix;
	private int quantité;
	
	public ArticlePanier(String nom, float prix, int quantité) {
		this.nom = nom;
		this.prix = prix;
		this.quantité = quantité;
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

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	
	public float prixQuantité() {
		return this.prix * this.quantité;
	}
	
	public String toString() {
		return this.getNom() + "  |  " + this.getPrix() + "  |  " + this.getQuantité() + "  |  " + this.prixQuantité() + "\n";
	}

}

package modèlePourEtudiants;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	List<ArticlePanier> sélection;
	
	public Panier() {
		this.sélection = new ArrayList<ArticlePanier>();
	}
	public void ajouterArticle(ArticlePanier s) {
		this.sélection.add(s);
	}
	public List<ArticlePanier> getSelection() {
		return this.sélection;
	}
	
	public float prixPanier() {
		float résultat = 0;
		for (int i = 0 ; i < this.sélection.size() ; i++) {
			résultat += this.getSelection().get(i).prixQuantité();
		}
		//résultat = Math.round(résultat*100.0F)/ 100.0F;
		return résultat;
	}
	
	public ArticlePanier getArticlePanier(int i) {
		return this.sélection.get(i);
	}
	
	public void viderPanier() {
		while (this.sélection.size() != 0) {
			this.sélection.remove(0);
		}
	}
	
}

package mod�lePourEtudiants;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	List<ArticlePanier> s�lection;
	
	public Panier() {
		this.s�lection = new ArrayList<ArticlePanier>();
	}
	public void ajouterArticle(ArticlePanier s) {
		this.s�lection.add(s);
	}
	public List<ArticlePanier> getSelection() {
		return this.s�lection;
	}
	
	public float prixPanier() {
		float r�sultat = 0;
		for (int i = 0 ; i < this.s�lection.size() ; i++) {
			r�sultat += this.getSelection().get(i).prixQuantit�();
		}
		//r�sultat = Math.round(r�sultat*100.0F)/ 100.0F;
		return r�sultat;
	}
	
	public ArticlePanier getArticlePanier(int i) {
		return this.s�lection.get(i);
	}
	
	public void viderPanier() {
		while (this.s�lection.size() != 0) {
			this.s�lection.remove(0);
		}
	}
	
}

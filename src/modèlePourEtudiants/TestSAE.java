package modèlePourEtudiants;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSAE {

	Fromage[] fromages;
	
	@Before
    public void setUp() throws IllegalArgumentException{
		Fromage fromages[] = GenerationFromages.générationBaseFromages().getLesFromages();
    }

    @After
    public void tearDown() throws IllegalArgumentException {
        fromages = null;
    }
    
    @Test
    public void testRecupérationArticlesFromage() {
       // assertEquals(String.valueOf(this.fromage.getArticlesFromage(0)),"[Brebis au Bleu, 250 g, Prix TTC : 8.2 €, Brebis au Bleu, 500 g, Prix TTC : 16.4 €, Brebis au Bleu, 1 kg, Prix TTC : 32.8 €]");
    	Fromage f = new Fromage("");
    	Article a1 = new Article(f , "", 2.0F);
    	List<Article> l = new LinkedList<Article>();
        l.add(a1);
        f.setArticles(l);
        assertEquals(f.getArticles(), l);
    }

    
    @Test
    public void testAjoutPanier() {
    	Panier p = new Panier();
		ArticlePanier a = new ArticlePanier ("", 0.0F, 1);
		ArticlePanier b = new ArticlePanier ("", 0.0F, 1);
		p.ajouterArticle(a);
		assertEquals(p.getSelection().size(),1);
		p.ajouterArticle(b);
		assertEquals(p.getSelection().size(),2);
    }
    
    @Test
    public void testSuppressionPanier() {
    	Panier p = new Panier();
		ArticlePanier a = new ArticlePanier ("", 0.0F, 1);
		p.ajouterArticle(a);
		p.viderPanier();
		assertEquals(p.getSelection().size(),0);
    }
   
    
    @Test
    public void calculFacture() { 
    	Panier p = new Panier();
    	ArticlePanier a = new ArticlePanier ("", 3.0F, 1);
		ArticlePanier b = new ArticlePanier ("", 5.0F, 1);
		p.ajouterArticle(a);
		p.ajouterArticle(b);
    	float prixFacture = a.prixQuantité() + b.prixQuantité();
    	assertEquals(prixFacture, p.prixPanier(), 0.0F);
    }
    
    @Test
    public void miseAJourDesStocks() {
    	Panier p = new Panier();
    	Fromage f = new Fromage("");
    	Article a1 = new Article(f , "", 2.0F);
    	a1.setQuantitéEnStock(10);
    	int quantitéMax = a1.getQuantitéEnStock();
        ArticlePanier a2 = new ArticlePanier(f.getDésignation(), a1.getPrixTTC(), 2);
        a1.setQuantitéEnStock(quantitéMax - a2.getQuantité());
        p.ajouterArticle(a2);
        assertEquals(quantitéMax - a2.getQuantité(), a1.getQuantitéEnStock());
    }

}

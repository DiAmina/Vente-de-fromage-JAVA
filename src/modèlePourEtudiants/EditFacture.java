package modèlePourEtudiants;


public class EditFacture {
	
	private Cliente c;
	private Panier p;
	
	public EditFacture(Cliente c, Panier p) {
		this.p=p;
		this.c=c;
	}
	
	@Override 
	public String toString() {
		String s = "";
		s = "Facture de votre commande chez Fromagerie OcciFromages \n \n"
		+ "Toulouse, le mardi 14 juin 2022 \n \n"
		+ "Informations client :\n"
		+ "Nom :" + c.getNom() + "\n"
		+ "Prénom : " + c.getPrenom() + "\n"
		+ "Adresse : " + c.getAdd1() + "\n"
		+ "Code postal : " + c.getCP() + "\n"
		+ "Ville : " + c.getVille() + "\n"
		+ "Téléphone : " + c.getTel() + "\n"
		+ "E-mail : " + c.getMail() + "\n \n"
		
		+ "Détail de la commande :\n";
		for (int i = 0 ; i < p.getSelection().size() ; i++) {
			s += i+1 + ": Article : " + p.getArticlePanier(i).getNom() + "   |   " + p.getArticlePanier(i).getPrix() + "€" + "   |   " + "Qte : " + p.getArticlePanier(i).getQuantité() + "   |   " + "Prix total : " + p.getArticlePanier(i).prixQuantité() + "\n";
		}
		
		s += "\n \n"
		+ "TOTAL TTC COMMANDE : " + p.prixPanier() + " €";
		
		return s;
	}
	
	

}

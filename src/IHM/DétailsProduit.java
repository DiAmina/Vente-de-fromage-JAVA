package IHM;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import modèlePourEtudiants.*;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DétailsProduit extends JDialog {
	
	private JSpinner quantité;
	private JComboBox article;
	private int quantitéMax;

	/**
	 * Create the dialog.
	 */
	public DétailsProduit(Fromage fromage, Panier panier) {
				
		Article[] prixPoids = new Article[fromage.getArticles().size()];
		for(int i = 0 ; i < fromage.getArticles().size() ; i++) {
			prixPoids[i] = fromage.getArticles().get(i);
		}
		
		setBounds(100, 100, 512, 342);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				buttonPane.setLayout(new BorderLayout(0, 0));
			}
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel, BorderLayout.WEST);
				{
					article = new JComboBox(prixPoids);
					article.setBackground(new Color(255, 239, 213));
					panel.add(article);
				}
				{
					quantité = new JSpinner();
					quantité.setModel(new SpinnerNumberModel(1, 1, prixPoids[quantitéMax].getQuantitéEnStock(), 1));
					panel.add(quantité);
				}
			}
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel, BorderLayout.SOUTH);
				{
					JButton AjouterAuApanier = new JButton("Ajouter au panier");
					
					AjouterAuApanier.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							ArticlePanier nouvelArticle = new ArticlePanier(fromage.getDésignation(), (float) ((Article) article.getSelectedItem()).getPrixTTC(),(int) quantité.getValue());
							panier.ajouterArticle(nouvelArticle);
							((Article) article.getSelectedItem()).setQuantitéEnStock(((Article) article.getSelectedItem()).getQuantitéEnStock() - (int) quantité.getValue());
							setVisible(false);
						}
					});
					AjouterAuApanier.setBackground(new Color(50, 205, 50));
					panel.add(AjouterAuApanier);
				}
				{
					JButton cancelButton = new JButton("Annuler");
					cancelButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							setVisible(false);
						}
					});
					cancelButton.setBackground(new Color(220, 20, 60));
					cancelButton.setActionCommand("Annuler");
					panel.add(cancelButton);
				}
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JTextPane descriptionProduit = new JTextPane();
				scrollPane.setViewportView(descriptionProduit);
				descriptionProduit.setText(fromage.toString() + "\n" + fromage.getDescription());
				{
					JPanel panel = new JPanel();
					panel.setBackground(new Color(255, 215, 0));
					getContentPane().add(panel, BorderLayout.NORTH);
					{
						JLabel Titre = new JLabel("Description du produit");
						Titre.setIcon(new ImageIcon(DétailsProduit.class.getResource("/IHM/fromage.png")));
						Titre.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel.add(Titre);
					}
				}
			}
		}
	}

}

package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modèlePourEtudiants.*;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenêtrePanier extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public FenêtrePanier(Panier panier) {
		setVisible(true);
		setBounds(100, 100, 563, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JRadioButton Chronopost = new JRadioButton("Colissimo \u00E0 domicile: 2,99 \u20AC");
				Chronopost.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel.add(Chronopost);
				
				
			
				JRadioButton Colissimo = new JRadioButton("Colissimo en point relais : 4,9 \u20AC");
				Colissimo.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel.add(Colissimo);
			
				JRadioButton Mondial_Relay = new JRadioButton("Mondial Relay : 2,69 \u20AC");
				Mondial_Relay.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel.add(Mondial_Relay);
				
				Colissimo.addActionListener(event -> {
		            Colissimo.setSelected(true);
		            Mondial_Relay.setSelected(false);
		            Chronopost.setSelected(false);
		            
		        });

		        Chronopost.addActionListener(event -> {
		            Colissimo.setSelected(false);
		            Mondial_Relay.setSelected(false);
		            Chronopost.setSelected(true);
		        });

		        Mondial_Relay.addActionListener(event -> {
		            Colissimo.setSelected(false);
		            Mondial_Relay.setSelected(true);
		            Chronopost.setSelected(false);
		        });
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					JList listePanier = new JList(panier.getSelection().toArray());
					scrollPane.setViewportView(listePanier);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
			{
				JButton Valider = new JButton("Valider le panier");
				Valider.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						FenêtreClient f = new FenêtreClient(panier);
						setVisible(false);
					}
				});
				Valider.setBackground(new Color(50, 205, 50));
				Valider.setFont(new Font("Tahoma", Font.BOLD, 14));
				buttonPane.add(Valider);
			}
			{
				JButton Vider = new JButton("Vider le panier");
				Vider.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						panier.viderPanier();
					}
				});
				Vider.setBackground(new Color(255, 0, 0));
				Vider.setFont(new Font("Tahoma", Font.BOLD, 14));
				buttonPane.add(Vider);
			}
			{
				JButton Continuer = new JButton("Continuez les achats");
				Continuer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				Continuer.setBackground(new Color(224, 255, 255));
				Continuer.setFont(new Font("Tahoma", Font.BOLD, 14));
				buttonPane.add(Continuer);
			}
		}
		{
			JPanel header = new JPanel();
			header.setBackground(new Color(255, 204, 51));
			FlowLayout fl_header = (FlowLayout) header.getLayout();
			fl_header.setAlignment(FlowLayout.LEFT);
			getContentPane().add(header, BorderLayout.NORTH);
			{
				JLabel Titre = new JLabel("Panier");
				Titre.setIcon(new ImageIcon(FenêtrePanier.class.getResource("/IHM/panier-a-nourriture.png")));
				//lblNewLabel.setIcon(new ImageIcon(FenêtrePanier2.class.getResource("/ihm/panier-a-nourriture.png")));
				Titre.setFont(new Font("Tahoma", Font.BOLD, 16));
				header.add(Titre);
			}
		}
	}

}

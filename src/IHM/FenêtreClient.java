package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modèlePourEtudiants.*;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FenêtreClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField champsNom;
	private JTextField champsPrénom;
	private JTextField champsAdresse1;
	private JTextField champsAdresse2;
	private JTextField champsCodePostal;
	private JTextField champsVille;
	private JTextField champsTéléphone;
	private JTextField champsMail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FenêtreClient dialog = new FenêtreClient(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FenêtreClient(Panier panier) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel champsSaisie = new JPanel();
			contentPanel.add(champsSaisie);
			champsSaisie.setLayout(new GridLayout(8, 2, 0, 0));
			{
				JLabel Nom = new JLabel("Nom");
				Nom.setBackground(new Color(255, 255, 255));
				Nom.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Nom);
			}
			{
				champsNom = new JTextField();
				champsSaisie.add(champsNom);
				champsNom.setColumns(25);
			}
			{
				JLabel Prénom = new JLabel("Pr\u00E9nom");
				Prénom.setBackground(new Color(255, 255, 255));
				Prénom.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Prénom);
			}
			{
				champsPrénom = new JTextField();
				champsSaisie.add(champsPrénom);
				champsPrénom.setColumns(10);
			}
			{
				JLabel Adresse_1 = new JLabel("Adresse 1");
				Adresse_1.setBackground(new Color(255, 255, 255));
				Adresse_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Adresse_1);
			}
			{
				champsAdresse1 = new JTextField();
				champsSaisie.add(champsAdresse1);
				champsAdresse1.setColumns(10);
			}
			{
				JLabel Adresse_2 = new JLabel("Adresse 2");
				Adresse_2.setBackground(new Color(255, 255, 255));
				Adresse_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Adresse_2);
			}
			{
				champsAdresse2 = new JTextField();
				champsSaisie.add(champsAdresse2);
				champsAdresse2.setColumns(10);
			}
			{
				JLabel CodePostal = new JLabel("Code postal");
				CodePostal.setBackground(new Color(255, 255, 255));
				CodePostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(CodePostal);
			}
			{
				champsCodePostal = new JTextField();
				champsSaisie.add(champsCodePostal);
				champsCodePostal.setColumns(10);
			}
			{
				JLabel Ville = new JLabel("Ville");
				Ville.setBackground(new Color(255, 255, 255));
				Ville.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Ville);
			}
			{
				champsVille = new JTextField();
				champsSaisie.add(champsVille);
				champsVille.setColumns(10);
			}
			{
				JLabel Téléphone = new JLabel("T\u00E9l\u00E9phone");
				Téléphone.setBackground(new Color(255, 255, 255));
				Téléphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Téléphone);
			}
			{
				champsTéléphone = new JTextField();
				champsSaisie.add(champsTéléphone);
				champsTéléphone.setColumns(10);
			}
			{
				JLabel Mail = new JLabel("Mail");
				Mail.setBackground(new Color(255, 255, 255));
				Mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Mail);
			}
			{
				champsMail = new JTextField();
				champsSaisie.add(champsMail);
				champsMail.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(50, 205, 50));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nom = champsNom.getText();
						String prenom = champsPrénom.getText();
						String add1 = champsAdresse1.getText();
						String cp = champsCodePostal.getText();
						String ville = champsVille.getText();
						String tel = champsTéléphone.getText();
						String mail = champsMail.getText();
						Cliente c = new Cliente(champsNom.getText(), champsPrénom.getText(), champsAdresse1.getText(), champsCodePostal.getText(), champsVille.getText(), 
								champsTéléphone.getText(), champsMail.getText());
							
						FenêtreFacture f = new FenêtreFacture(c, panier);
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setBackground(new Color(175, 238, 238));
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel Titre = new JPanel();
			Titre.setBackground(new Color(255, 235, 205));
			getContentPane().add(Titre, BorderLayout.NORTH);
			{
				JLabel lblNewLabel_1 = new JLabel("Information du client");
				lblNewLabel_1.setIcon(new ImageIcon(FenêtreClient.class.getResource("/IHM/user.png")));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				Titre.add(lblNewLabel_1);
			}
		}
	}

}

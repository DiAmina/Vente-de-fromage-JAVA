package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mod�lePourEtudiants.*;

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

public class Fen�treClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField champsNom;
	private JTextField champsPr�nom;
	private JTextField champsAdresse1;
	private JTextField champsAdresse2;
	private JTextField champsCodePostal;
	private JTextField champsVille;
	private JTextField champsT�l�phone;
	private JTextField champsMail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Fen�treClient dialog = new Fen�treClient(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fen�treClient(Panier panier) {
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
				JLabel Pr�nom = new JLabel("Pr\u00E9nom");
				Pr�nom.setBackground(new Color(255, 255, 255));
				Pr�nom.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(Pr�nom);
			}
			{
				champsPr�nom = new JTextField();
				champsSaisie.add(champsPr�nom);
				champsPr�nom.setColumns(10);
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
				JLabel T�l�phone = new JLabel("T\u00E9l\u00E9phone");
				T�l�phone.setBackground(new Color(255, 255, 255));
				T�l�phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
				champsSaisie.add(T�l�phone);
			}
			{
				champsT�l�phone = new JTextField();
				champsSaisie.add(champsT�l�phone);
				champsT�l�phone.setColumns(10);
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
						String prenom = champsPr�nom.getText();
						String add1 = champsAdresse1.getText();
						String cp = champsCodePostal.getText();
						String ville = champsVille.getText();
						String tel = champsT�l�phone.getText();
						String mail = champsMail.getText();
						Cliente c = new Cliente(champsNom.getText(), champsPr�nom.getText(), champsAdresse1.getText(), champsCodePostal.getText(), champsVille.getText(), 
								champsT�l�phone.getText(), champsMail.getText());
							
						Fen�treFacture f = new Fen�treFacture(c, panier);
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
				lblNewLabel_1.setIcon(new ImageIcon(Fen�treClient.class.getResource("/IHM/user.png")));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				Titre.add(lblNewLabel_1);
			}
		}
	}

}

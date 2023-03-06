package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import modèlePourEtudiants.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FenêtreFacture extends JDialog {

	private final JPanel contentPanel = new JPanel();
	EditFacture facture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FenêtreFacture dialog = new FenêtreFacture(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FenêtreFacture(Cliente c, Panier p) {
		facture = new EditFacture(c, p);
		setVisible(true);
		setBounds(100, 100, 700, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JTextPane affichageFacture = new JTextPane();
				affichageFacture.setText(facture.toString());
				affichageFacture.setEditable(false);
				scrollPane.setViewportView(affichageFacture);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Quitter");
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
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 228, 181));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel Titre = new JLabel("Facture de la commande  ");
				Titre.setIcon(new ImageIcon(FenêtreFacture.class.getResource("/IHM/facture-dachat.png")));
				Titre.setFont(new Font("Tahoma", Font.BOLD, 17));
				panel.add(Titre);
			}
			{
				JLabel Logo = new JLabel("");
				Logo.setIcon(new ImageIcon(FenêtreFacture.class.getResource("/IHM/Culte_de_du_fromage_2_-removebg-preview2-removebg-preview.png")));
				panel.add(Logo, BorderLayout.EAST);
			}
		}
	}

}

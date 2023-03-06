package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class FenêtreContact extends JDialog {

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FenêtreContact dialog = new FenêtreContact();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FenêtreContact() {
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 737, 510);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 215, 0));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Nous contactez   ");
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel.setIcon(new ImageIcon(IHM.FenêtreContact.class.getResource("/IHM/courriel-de-contact.png")));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("OCCI'FROMA \u00E0 votre service");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("OCCI'FROMA");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("118 route de Narbonne 31077");
				lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Appelez-nous au :");
				lblNewLabel_4.setIcon(new ImageIcon(IHM.FenêtreContact.class.getResource("/IHM/appel.png")));
				lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("           06 28 74 10 00 03");
				lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Envoyez-nous un mail au :");
				lblNewLabel_6.setIcon(new ImageIcon(IHM.FenêtreContact.class.getResource("/IHM/email.png")));
				lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("          contact@occifroma.com");
				lblNewLabel_7.setForeground(new Color(102, 204, 255));
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblNewLabel_7);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Retour");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

package IHM;
import modèlePourEtudiants.*;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JList;

import java.util.*;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class PageAccueil {
	
	private Fromage[] fromages = GenerationFromages.générationBaseFromages().getLesFromages();
	private List<Fromage> fromagesBrebis;
	private List<Fromage> fromagesChèvres;
	private List<Fromage> fromagesVaches;
	private Panier panier;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAccueil window = new PageAccueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageAccueil() {
		
		fromagesBrebis = new ArrayList<Fromage>();
		for (Fromage v : fromages) {
			if(v.getTypeFromage() == TypeLait.BREBIS) {
				fromagesBrebis.add(v);
			}
		}
		
		fromagesChèvres = new ArrayList<Fromage>();
		for (Fromage v : fromages) {
			if(v.getTypeFromage() == TypeLait.CHEVRE) {
				fromagesChèvres.add(v);;
			}
		}
		
		fromagesVaches = new ArrayList<Fromage>();
		for (Fromage v : fromages) {
			if(v.getTypeFromage() == TypeLait.VACHE) {
				fromagesVaches.add(v);;
			}
		}
		
		panier = new Panier();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 844, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane Contenu = new JScrollPane();
		Contenu.setToolTipText("");
		frame.getContentPane().add(Contenu, BorderLayout.CENTER);
		
		JList listeFromages = new JList(fromages);
		listeFromages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fromage f = (Fromage) listeFromages.getSelectedValue();
				DétailsProduit d = new DétailsProduit(f, panier);
				d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				d.setVisible(true);
			}
		});
		Contenu.setViewportView(listeFromages);
		
		JPanel Menu = new JPanel();
		Menu.setBackground(new Color(255, 215, 0));
		frame.getContentPane().add(Menu, BorderLayout.NORTH);
		Menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(PageAccueil.class.getResource("/IHM/Culte_de_du_fromage_2_-removebg-preview2-removebg-preview.png")));
		Menu.add(Logo);
		//lblNewLabel.setIcon(new ImageIcon(PageAcceuil.class.getResource("/ihm/Culte_de_du_fromage_2_-removebg-preview2-removebg-preview.png")));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		Menu.add(menuBar);
		
		JMenu Brebis = new JMenu("Brebis");
		Brebis.setIcon(new ImageIcon(PageAccueil.class.getResource("/IHM/mouton.png")));
		Brebis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listeFromages.setListData(fromagesBrebis.toArray());
			}
		});
		//mnNewMenu.setIcon(new ImageIcon(PageAcceuil.class.getResource("/ihm/mouton.png")));
		Brebis.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(Brebis);
		
		JMenu Chèvres = new JMenu("Ch\u00E8vre");
		Chèvres.setIcon(new ImageIcon(PageAccueil.class.getResource("/IHM/ch\u00E8vre.png")));
		Chèvres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listeFromages.setListData(fromagesChèvres.toArray());
			}
		});
		
		//mnNewMenu_1.setIcon(new ImageIcon(PageAcceuil.class.getResource("/ihm/ch\u00E8vre.png")));
		Chèvres.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(Chèvres);
		
		JMenu Vaches = new JMenu("Vache");
		Vaches.setIcon(new ImageIcon(PageAccueil.class.getResource("/IHM/vache-sacree.png")));
		Vaches.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listeFromages.setListData(fromagesVaches.toArray());
			}
		});
		//mnNewMenu_2.setIcon(new ImageIcon(PageAcceuil.class.getResource("/ihm/vache-sacree.png")));
		Vaches.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(Vaches);
		
		JMenu Tous = new JMenu("Tous");
		Tous.setIcon(new ImageIcon(PageAccueil.class.getResource("/IHM/applications.png")));
		//mnNewMenu_3.setIcon(new ImageIcon(PageAcceuil.class.getResource("/ihm/applications.png")));
		Tous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listeFromages.setListData(fromages);
			}
		});
		Tous.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(Tous);
		
		JMenu Contact = new JMenu("Contact");
		Contact.setIcon(null);
		Contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenêtreContact f = new FenêtreContact();
			}
			
		});
		Contact.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(Contact);
		
		JButton Panier = new JButton("Panier");
		Panier.setIcon(new ImageIcon(PageAccueil.class.getResource("/IHM/panier-en-osier.png")));
		Panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenêtrePanier fPanier = new FenêtrePanier(panier);
			}
		});
		
		Panier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prixPanier.get
			}
			
		});
		Panier.setBackground(new Color(255, 250, 205));
		Panier.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnNewButton.setIcon(new ImageIcon(PageAcceuil.class.getResource("/ihm/panier-en-osier.png")));
		Menu.add(Panier);
	}

}

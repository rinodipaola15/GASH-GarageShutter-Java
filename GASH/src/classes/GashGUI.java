 package classes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import exceptions.NegValueException;
import interfaces.Vendibile;

public class GashGUI {

	private Gash gash;
	private StartupClass st;
	private JFrame frame;
	private final Action action = new SwingAction();
	private int width = 1130, height = 820;

	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	public static String statoGUI;
	private static JTextArea txtSpace;
	private static JTextField messageField;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private JButton btnNewButton_3;
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private JButton btnNewButton_6;
	private final Action action_6 = new SwingAction_6();
	private JButton btnNewButton_7;
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JButton btnNewButton_13;
	private JButton btnNewButton_14;
	private JButton btnNewButton_15;
	private JButton btnNewButton_16;
	private JButton btnNewButton_17;
	private JButton btnNewButton_18;
	private JButton btnNewButton_19;
	private JButton btnNewButton_20;
	private JButton btnNewButton_21;
	private JButton btnNewButton_22;
	private JButton btnNewButton_23;
	private JButton btnNewButton_24;
	
	private final Action action_9 = new SwingAction_9();
	private final Action action_10 = new SwingAction_10();
	private final Action action_11 = new SwingAction_11();
	private final Action action_12 = new SwingAction_12();
	private final Action action_13 = new SwingAction_13();
	private final Action action_14 = new SwingAction_14();
	private final Action action_15 = new SwingAction_15();
	private final Action action_16 = new SwingAction_16();
	private final Action action_17 = new SwingAction_17();
	private final Action action_18 = new SwingAction_18();
	private final Action action_19 = new SwingAction_19();
	private final Action action_20 = new SwingAction_20();
	private final Action action_21 = new SwingAction_21();
	private final Action action_22 = new SwingAction_22();
	private final Action action_23 = new SwingAction_23();
	private final Action action_24 = new SwingAction_24();
	private final Action action_25 = new SwingAction_25();
	private JButton btnNewButton_26;
	private JButton btnNewButton_27;
	private JButton btnNewButton_28;
	private final Action action_26 = new SwingAction_26();
	private final Action action_27 = new SwingAction_27();
	private final Action action_28 = new SwingAction_28();
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GashGUI window = new GashGUI();
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
	public GashGUI() {
		initialize();
		gash = Gash.getInstance();
		st = new StartupClass(gash);
		
		statoGUI="enabled";
		GashGUI.printInfo("Benvenuto", null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 17));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(452, -11, 200, 200);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);

		//Icona Programma
		BufferedImage img = null;
		try {
			img = ImageIO.read(GashGUI.class.getResource("/img/GASH.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel.setIcon(imageIcon);

		frame.getContentPane().add(lblNewLabel);

		//Pulsanti
		JButton btnNewButton = new JButton("Nuovo tipo di porta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.setBounds(33, 190, 230, 54);
		frame.getContentPane().add(btnNewButton);

		txtSpace = new JTextArea();

		txtSpace.setEditable(false);
		txtSpace.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSpace.setLineWrap(true);
		txtSpace.setBackground(SystemColor.menu);
		// txtSpace.setBounds(33, 398, 2000, 2000);
		txtSpace.setColumns(10);

		JScrollPane sp = new JScrollPane(txtSpace);
		sp.setBounds(100, 520, 932, 235);
		frame.getContentPane().add(sp);

		btnNewButton_1 = new JButton("Elimina porta");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(33, 254, 108, 40);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("Modifica nome");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(33, 304, 230, 45);
		frame.getContentPane().add(btnNewButton_2);

		messageField = new JTextField();
		messageField.setFont(new Font("Arial", Font.PLAIN, 12));
		messageField.setHorizontalAlignment(SwingConstants.CENTER);
		messageField.setBounds(267, 461, 576, 49);
		frame.getContentPane().add(messageField);
		messageField.setColumns(10);

		JButton btnNewButton_2_1 = new JButton("Ricerca Porta");
		btnNewButton_2_1.setAction(action_3);
		btnNewButton_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2_1.setBounds(153, 254, 110, 40);
		frame.getContentPane().add(btnNewButton_2_1);
		
		btnNewButton_4 = new JButton("Nuovo Ordine");
		btnNewButton_4.setAction(action_5);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_4.setBounds(303, 190, 230, 54);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Visualizza Catalogo");
		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_5.setAction(action_4);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(33, 359, 230, 45);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Visualizza Ordini");
		btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_6.setAction(action_6);
		btnNewButton_6.setBounds(303, 254, 230, 40);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Nuova vendita porte");
		btnNewButton_7.setAction(action_7);
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_7.setBounds(574, 190, 230, 54);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Nuova vendita ricambio");
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setAction(action_8);
		btnNewButton_8.setBounds(574, 254, 230, 40);
		frame.getContentPane().add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("Nuovo Fornitore");
		btnNewButton_9.setAction(action_9);
		btnNewButton_9.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_9.setBounds(303, 303, 230, 40);
		frame.getContentPane().add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("Ricerca Fornitore");
		btnNewButton_10.setAction(action_10);
		btnNewButton_10.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_10.setBounds(303, 353, 112, 40);
		frame.getContentPane().add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("Modifica dati Fornitore");
		btnNewButton_11.setAction(action_11);
		btnNewButton_11.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_11.setBounds(303, 403, 230, 40);
		frame.getContentPane().add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("Elimina Fornitore");
		btnNewButton_12.setAction(action_12);
		btnNewButton_12.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_12.setBounds(421, 353, 112, 40);
		frame.getContentPane().add(btnNewButton_12);
		
		btnNewButton_13 = new JButton("Ricerca vendita");
		btnNewButton_13.setAction(action_13);
		btnNewButton_13.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_13.setBounds(574, 303, 230, 40);
		frame.getContentPane().add(btnNewButton_13);
		
		btnNewButton_14 = new JButton("Gestione Ordine");
		btnNewButton_14.setAction(action_14);
		btnNewButton_14.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_14.setBounds(842, 190, 230, 54);
		frame.getContentPane().add(btnNewButton_14);
		
		btnNewButton_15 = new JButton("Ordini in arrivo");
		btnNewButton_15.setAction(action_15);
		btnNewButton_15.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_15.setBounds(842, 254, 108, 40);
		frame.getContentPane().add(btnNewButton_15);
		
		btnNewButton_16 = new JButton("Nuovo Cliente");
		btnNewButton_16.setAction(action_16);
		btnNewButton_16.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_16.setBounds(842, 304, 230, 40);
		frame.getContentPane().add(btnNewButton_16);
		
		btnNewButton_17 = new JButton("Ricerca Cliente");
		btnNewButton_17.setAction(action_17);
		btnNewButton_17.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_17.setBounds(842, 353, 108, 40);
		frame.getContentPane().add(btnNewButton_17);
		
		btnNewButton_18 = new JButton("Elimina Cliente");
		btnNewButton_18.setAction(action_18);
		btnNewButton_18.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_18.setBounds(960, 353, 112, 40);
		frame.getContentPane().add(btnNewButton_18);
		
		btnNewButton_19 = new JButton("Modifica dati Cliente");
		btnNewButton_19.setAction(action_19);
		btnNewButton_19.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_19.setBounds(842, 403, 230, 40);
		frame.getContentPane().add(btnNewButton_19);
		
		btnNewButton_20 = new JButton("Visualizza vendite");
		btnNewButton_20.setAction(action_20);
		btnNewButton_20.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_20.setBounds(574, 353, 230, 40);
		frame.getContentPane().add(btnNewButton_20);
		
		btnNewButton_21 = new JButton("Ricerca vendite cliente");
		btnNewButton_21.setAction(action_21);
		btnNewButton_21.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_21.setBounds(574, 403, 230, 40);
		frame.getContentPane().add(btnNewButton_21);
		
		btnNewButton_22 = new JButton("Modifica Componente");
		btnNewButton_22.setAction(action_22);
		btnNewButton_22.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_22.setBounds(33, 95, 108, 52);
		frame.getContentPane().add(btnNewButton_22);
		
		btnNewButton_23 = new JButton("Elimina Componente");
		btnNewButton_23.setAction(action_23);
		btnNewButton_23.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_23.setBounds(155, 95, 108, 52);
		frame.getContentPane().add(btnNewButton_23);
		
		btnNewButton_24 = new JButton("Ricerca Componente");
		btnNewButton_24.setAction(action_24);
		btnNewButton_24.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_24.setBounds(33, 32, 230, 53); 
		frame.getContentPane().add(btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("Ordini processati");
		btnNewButton_25.setAction(action_25);
		btnNewButton_25.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_25.setBounds(960, 254, 112, 40);
		frame.getContentPane().add(btnNewButton_25);
		
		btnNewButton_26 = new JButton("Segnala Consegna Vendita");
		btnNewButton_26.setAction(action_26);
		btnNewButton_26.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_26.setBounds(842, 32, 230, 53);
		frame.getContentPane().add(btnNewButton_26);
		
		btnNewButton_27 = new JButton("Vendite in consegna");
		btnNewButton_27.setAction(action_27);
		btnNewButton_27.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_27.setBounds(842, 95, 108, 52);
		frame.getContentPane().add(btnNewButton_27);
		
		btnNewButton_28 = new JButton("Vendite consegnate");
		btnNewButton_28.setAction(action_28);
		btnNewButton_28.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_28.setBounds(960, 95, 112, 52);
		frame.getContentPane().add(btnNewButton_28);


	}
	
	
	//*************************
	// Caso d'uso 2
	//*************************
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Nuovo tipo di porta");
			putValue(SHORT_DESCRIPTION, "Creazione nuovo tipo di porta");
		}

		public void actionPerformed(ActionEvent e) {
			
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice della nuova porta","Nuovo Tipo di porta", JOptionPane.QUESTION_MESSAGE);
			String nome = JOptionPane.showInputDialog(null, "Inserisci nome della nuova porta", "Nuovo Tipo di porta",JOptionPane.QUESTION_MESSAGE);
			
			Boolean notexists=gash.nuovoTipoPorta(codice, nome);
			if(notexists) {
			do {
				try {
					String codicec = JOptionPane.showInputDialog(null, "Inserisci codice componente","AggiungiComponentePorta", JOptionPane.QUESTION_MESSAGE);
					int quantità = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci il numero di componenti","AggiungiComponentePorta", JOptionPane.QUESTION_MESSAGE));
					gash.aggiungiComponentePorta(codicec, quantità);

				} catch (NegValueException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}

			} while (JOptionPane.showConfirmDialog(null, "Vuoi inserire un altro componente?","AggiungiComponentePorta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
			
			Boolean a;
			do{
				String codiceLm = JOptionPane.showInputDialog(null, "Inserisci codice della lamiera da usare","associaLamieraPorta", JOptionPane.QUESTION_MESSAGE);
				a=gash.associaLamieraPorta(codiceLm);
			}while(!a);
			gash.confermaTipoPorta();

		}else {
			JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
		}
		}
	}

// *************************
// Estensioni Caso d'uso 2
// *************************
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Elimina Porta");
			putValue(SHORT_DESCRIPTION, "Elimina Porta usando codice");

		}

		public void actionPerformed(ActionEvent e) {
			String codicePorta = JOptionPane.showInputDialog(null, "Inserisci codice della porta da eliminare","Elimina Porta", JOptionPane.QUESTION_MESSAGE);
			gash.eliminaPorta(codicePorta);

		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Modifica informazioni porta");
			putValue(SHORT_DESCRIPTION, "Modifica Informazioni Porta usando codice");
		}

		public void actionPerformed(ActionEvent e) {

			String[] options = { "Codice", "Nome", "Aggiungi componente Porta","Rimuovi componente porta","Rimuovi Lamiera Associata","Aggiungi Lamiera"};
			String codicePorta = JOptionPane.showInputDialog(null, "Inserisci codice della porta da modificare","Modifica Porta", JOptionPane.QUESTION_MESSAGE);
			if (gash.selezionaPorta(codicePorta)) {
				
				String scelta = (String) JOptionPane.showInputDialog(null, "Cosa vuoi modificare?","Scelta modifica", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				switch (scelta) {
				case "Codice": {
					String codice = JOptionPane.showInputDialog(null, "Inserisci nuovo codice per la porta","Modifica Porta", JOptionPane.QUESTION_MESSAGE);
					gash.modificaCodicePorta(codice);
				 break;		
				}
				case "Nome": {
					String nome = JOptionPane.showInputDialog(null, "Inserisci nuovo nome per la porta","Modifica Porta", JOptionPane.QUESTION_MESSAGE);
					if (!nome.isEmpty())
						gash.modificaNomePorta(nome);
					else
						JOptionPane.showMessageDialog(null, "Errore il nuovo nome non può essere nullo","Modifica Porta", JOptionPane.ERROR_MESSAGE);
					break;
				}
				case "Aggiungi componente Porta": {
					String codice = JOptionPane.showInputDialog(null, "Inserisci codice componente da inserire","Modifica Porta", JOptionPane.QUESTION_MESSAGE);
					int quantità = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci quantità componente","Modifica Porta", JOptionPane.QUESTION_MESSAGE));
					gash.aggiungiComponenteSingolo(codice, quantità);
					break;
				}
				case "Rimuovi componente porta": {
					String codice = JOptionPane.showInputDialog(null, "Inserisci codice componente da togliere","Modifica Porta", JOptionPane.QUESTION_MESSAGE);
					gash.rimuoviComponenteSingolo(codice);
					break;
				}
				case "Rimuovi Lamiera Associata": {
					gash.rimuoviLamiera();
					break;
				}
				case "Aggiungi Lamiera": {
					String codice = JOptionPane.showInputDialog(null, "Inserisci codice Lamiera da associare","Modifica Porta", JOptionPane.QUESTION_MESSAGE);
					gash.aggiungiLamiera(codice);
					break;
				}
				default:
					break;
				}

			}
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Ricerca Porta");
			putValue(SHORT_DESCRIPTION, "Ricerca di una porta tramite codice");
		}

		public void actionPerformed(ActionEvent e) {
			String codicePorta = JOptionPane.showInputDialog(null, "Inserisci codice da ricercare", "Ricerca Porta",JOptionPane.QUESTION_MESSAGE);
			TipoPorta tp=gash.ricercaPorta(codicePorta);
			GashGUI.printInfo("Porta con codice: "+codicePorta,tp.toString());
		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Visualizza Catalogo");
			putValue(SHORT_DESCRIPTION, "Mostra tutte le porte disponibili");
		}

		public void actionPerformed(ActionEvent e) {
			gash.visualizzaCatalogo();
		}
	}

	public static void printInfo(String message, String txt) {
		txtSpace.setText(txt);
		messageField.setText(message);

	}

	
	// Caso d'uso UC1
	// *************************
	
	private class SwingAction_5 extends AbstractAction {
		
		public SwingAction_5() {
			putValue(NAME, "Nuovo ordine");
			putValue(SHORT_DESCRIPTION, "Creazione di un nuovo ordine");
		}
		
		public void actionPerformed(ActionEvent e) {
					
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice del nuovo ordine", "Nuovo ordine", JOptionPane.QUESTION_MESSAGE);
			Boolean notexists = gash.nuovoOrdine(codice);
			
			if( notexists) {
					
				boolean sf;
				do {
				String codicef = JOptionPane.showInputDialog(null, "Seleziona fornitore","Nuovo ordine", JOptionPane.QUESTION_MESSAGE);
				sf = gash.selezionaFornitore(codicef);
				} while(sf==false);
	
				do {

					try {
						
						String codicec = JOptionPane.showInputDialog(null, "Inserisci codice componente da ordinare","nuovaRigaDiOrdine", JOptionPane.QUESTION_MESSAGE);
						int quantita = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci il numero di componenti di questo tipo da ordinare","nuovaRigaDiOrdine", JOptionPane.QUESTION_MESSAGE));
								gash.nuovaRigaDiOrdine(codicec, quantita);
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);


					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}

				} while (JOptionPane.showConfirmDialog(null, "Vuoi inserire un altro componente nell'ordine?","nuovaRigaDiOrdine", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
				
								gash.confermaOrdine();
				

			}else {
				JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Visualizza Ordini");
			putValue(SHORT_DESCRIPTION, "Visualizza tutti gli ordini ai fornitori");
		}
		public void actionPerformed(ActionEvent e) {
			gash.visualizzaOrdini();
			
		}
	}

	//*************************
	// Caso d'uso UC3
	//*************************
	
	private class SwingAction_7 extends AbstractAction {
		
		public SwingAction_7() {
			putValue(NAME, "Nuova vendita porte");
			putValue(SHORT_DESCRIPTION, "Creazione di una nuova vendita di porte per garage");
		}
		
		public void actionPerformed(ActionEvent e) {		
			
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice della nuova vendita di porte", "Nuova vendita porte per garage", JOptionPane.QUESTION_MESSAGE);
			Boolean notexists = gash.nuovaVenditaPorte(codice);
			
			if(notexists) {
				
				boolean sc;
				do {
				String codicec = JOptionPane.showInputDialog(null, "Inserisci codice fiscale del cliente","Nuova vendita porta per garage", JOptionPane.QUESTION_MESSAGE);
				sc = gash.selezionaDatiClientePorte(codicec);
				} while(sc==false);
	
				do {

					try {
						
						String codicep = JOptionPane.showInputDialog(null, "Inserisci codice porta da aggiungere alla vendita","nuovaRigaDiVenditaPorte", JOptionPane.QUESTION_MESSAGE);
						double altezzaPorta = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserisci l'altezza della porta","nuovaRigaDiVenditaPorte", JOptionPane.QUESTION_MESSAGE));
						double larghezzaPorta = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserisci la larghezza della porta","nuovaRigaDiVenditaPorte", JOptionPane.QUESTION_MESSAGE));
						String indirizzo = JOptionPane.showInputDialog(null, "Inserisci indirizzo in cui effettuare la consegna","nuovaRigaDiVenditaPorte", JOptionPane.QUESTION_MESSAGE);
						gash.nuovaRigaDiVenditaPorte(codicep, altezzaPorta, larghezzaPorta);
						gash.inserisciDettagliConsegnaPorte(indirizzo);
					
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}

				} while (JOptionPane.showConfirmDialog(null, "Vuoi aggiungere un'altra porta alla vendita?","nuovaRigaDiOrdine", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

				
				Double totale=gash.calcolaTotaleVenditaPorte();
				Double tot=(double) Math.round(totale*100)/100;
				JOptionPane.showMessageDialog(null, "Totale Vendita: "+tot+"€", "Vendita Porte", JOptionPane.INFORMATION_MESSAGE);
				
				if(JOptionPane.showConfirmDialog(null,"Vuoi confermare la Vendita?","Vendita Porte", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					gash.confermaVenditaPorte();
				} catch (NegValueException e1) {
					e1.printStackTrace();
				}

			}else {
				JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	}
		
	//*************************
	// Caso d'uso UC5
	//*************************
		
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "Nuova vendita ricambio");
			putValue(SHORT_DESCRIPTION, "Creazione di una nuova vendita di ricambi");
		}
		public void actionPerformed(ActionEvent e) {
			String codice= JOptionPane.showInputDialog(null, "Inserisci codice nuova Vendita di ricambi","Vendita Ricambi", JOptionPane.QUESTION_MESSAGE);
			
			if(codice!=null && gash.nuovaVenditaComponenti(codice)  ) {
				String codiceCliente= JOptionPane.showInputDialog(null, "Inserisci codice fiscale del cliente da associare alla vendita","Vendita Ricambi", JOptionPane.QUESTION_MESSAGE);
				if(gash.selezionaDatiClienteRicambio(codiceCliente)) {
					
					do {
						String codiceVendibile= JOptionPane.showInputDialog(null, "Inserisci codice Componente vendibile richiesto dal cliente","Vendita Ricambi", JOptionPane.QUESTION_MESSAGE);
						try {
							int quantita=Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire la quantità richiesta","Vendita Ricambi", JOptionPane.QUESTION_MESSAGE)); 
							gash.nuovaRigaDiComponente(codiceVendibile,quantita);
							
						} catch (NegValueException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
							ex.printStackTrace();
						}
					}while(JOptionPane.showConfirmDialog(null,"Vuoi inserire un altro componente vendibile alla vendita?","Vendita Ricambi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
					
					Double totale=gash.calcolaTotaleVenditaComponenti();
					Double tot=(double) Math.round(totale*100)/100;
					JOptionPane.showMessageDialog(null, "Totale Vendita Ricambi: "+tot+"€", "Vendita Ricambi", JOptionPane.INFORMATION_MESSAGE);
					
						if(JOptionPane.showConfirmDialog(null,"Vuoi confermare la Vendita?","Vendita Ricambi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							try {
								gash.confermaVenditaVendibile();
							} catch (NegValueException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
							}
						}
				}else {
					JOptionPane.showMessageDialog(null, "Cliente non trovato o codice Fiscale nullo", "Errore", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
	}
	
	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Nuovo Fornitore");
			putValue(SHORT_DESCRIPTION, "Inserimento di un nuovo fornitore");
		}
		public void actionPerformed(ActionEvent e) {			
			String[] options2 = {"mq", "unitario"};
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice del nuovo fornitore","Gestisci fornitore", JOptionPane.QUESTION_MESSAGE);
			String nome = JOptionPane.showInputDialog(null, "Inserisci nome del nuovo fornitore","Gestisci fornitore", JOptionPane.QUESTION_MESSAGE);
			Boolean notexists = gash.nuovoFornitore(codice,nome);
			if(notexists) {
				do {
					try {
						String codicec = JOptionPane.showInputDialog(null, "Inserisci codice componente","AggiungiComponenteFornitore", JOptionPane.QUESTION_MESSAGE);
						String nomec = JOptionPane.showInputDialog(null, "Inserisci nome componente","AggiungiComponenteFornitore", JOptionPane.QUESTION_MESSAGE);					
						double prezzoc = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserisci prezzo componente","AggiungiComponenteFornitore", JOptionPane.QUESTION_MESSAGE));
						String unitadimisurac = (String) JOptionPane.showInputDialog(null, "Inserisci unità di misura del componente da inserire","AggiungiComponenteFornitore", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
						gash.aggiungiComponenteFornitore(codicec, nomec, prezzoc, unitadimisurac);
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
				} while (JOptionPane.showConfirmDialog(null, "Vuoi inserire un altro componente?","AggiungiComponenteFornitore", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
				gash.confermaFornitore();
			}else {
				JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		
		}
	}
	
	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "Ricerca Fornitore");
			putValue(SHORT_DESCRIPTION, "Ricerca un fornitore tramite il codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codiceFornitore = JOptionPane.showInputDialog(null, "Inserisci codice fornitore da ricercare", "Ricerca Fornitore",JOptionPane.QUESTION_MESSAGE);
			Fornitore f = gash.ricercaFornitore(codiceFornitore);
			if(f!=null) {
				JOptionPane.showMessageDialog(null,"Fornitore con codice: "+codiceFornitore+" trovato");
				GashGUI.printInfo("Fornitore con codice: "+codiceFornitore, f.toString());
			} else {
				JOptionPane.showMessageDialog(null,"Non esistono fornitori con codice: "+codiceFornitore);
			}
		}
	}
	private class SwingAction_11 extends AbstractAction {
		public SwingAction_11() {
			putValue(NAME, "Modifica dati Fornitore");
			putValue(SHORT_DESCRIPTION, "Modifica informazioni fornitore usando codice");
		}
		public void actionPerformed(ActionEvent e) {		
			
			String[] options = {"Codice", "Nome", "Aggiungi componente fornitore", "Rimuovi componente fornitore"};
			String codiceFornitore = JOptionPane.showInputDialog(null, "Inserisci codice del fornitore da modificare","Modifica Forniore", JOptionPane.QUESTION_MESSAGE);
			if (gash.trovaFornitore(codiceFornitore)) {
				
				String scelta = (String) JOptionPane.showInputDialog(null, "Cosa vuoi modificare?","Scelta modifica", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				switch (scelta) {
				case "Codice": {
					String codice = JOptionPane.showInputDialog(null, "Inserisci nuovo codice del fornitore","Modifica fornitore", JOptionPane.QUESTION_MESSAGE);
					gash.modificaCodiceFornitore(codice);
				 break;		
				}
				case "Nome": {
					String nome = JOptionPane.showInputDialog(null, "Inserisci nuovo nome del fornitore","Modifica fornitore", JOptionPane.QUESTION_MESSAGE);
						gash.modificaNomeFornitore(nome);
					break;
				}
				case "Aggiungi componente fornitore": {
					try {
						String[] options2 = {"mq", "unitario"};
						String codicec = JOptionPane.showInputDialog(null, "Inserisci codice del componente da inserire","Modifica fornitore", JOptionPane.QUESTION_MESSAGE);
						String nomec = JOptionPane.showInputDialog(null, "Inserisci nome del componente da inserire","Modifica fornitore", JOptionPane.QUESTION_MESSAGE);
						double prezzoc = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserisci prezzo del componente da inserire","Modifica fornitore", JOptionPane.QUESTION_MESSAGE));
						String unitadimisurac = (String) JOptionPane.showInputDialog(null, "Inserisci unità di misura del componente da inserire","Modifica fornitore", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
						gash.aggiungiComponenteFornitore(codicec, nomec, prezzoc, unitadimisurac);
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
					break;
				}
				case "Rimuovi componente fornitore": {
					String codice = JOptionPane.showInputDialog(null, "Inserisci codice componente da eliminare","Modifica fornitore", JOptionPane.QUESTION_MESSAGE);
					gash.rimuoviComponenteFornitore(codice);
					break;
				}
				default:
					break;
				}
			}
		}
	}
	
	private class SwingAction_12 extends AbstractAction {
		public SwingAction_12() {
			putValue(NAME, "Elimina Fornitore");
			putValue(SHORT_DESCRIPTION, "Elimina un fornitore inserendo il codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codiceFornitore = JOptionPane.showInputDialog(null, "Inserisci codice del fornitore da eliminare","Elimina Fornitore", JOptionPane.QUESTION_MESSAGE);
			gash.eliminaFornitore(codiceFornitore);
		}
	}
	
	//*************************
		// Caso d'uso 7
		//*************************
	
	private class SwingAction_13 extends AbstractAction {
		public SwingAction_13() {
			putValue(NAME, "Ricerca vendita");
			putValue(SHORT_DESCRIPTION, "Ricerca vendita tramite codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codice= JOptionPane.showInputDialog(null, "Inserisci codice vendita da ricercare", "Ricerca vendite",JOptionPane.QUESTION_MESSAGE);
			Vendita v = gash.ricercaVendita(codice);
			GashGUI.printInfo("Vendita con codice: "+codice, v.toString());			
		}
	}
	
	private class SwingAction_14 extends AbstractAction {
		public SwingAction_14() {
			putValue(NAME, "Arrivo Ordine");
			putValue(SHORT_DESCRIPTION, "Inserisce nel Sistema i componenti consegnati relativi a un Ordine");
		}
		public void actionPerformed(ActionEvent e) {
			String codiceOrdine = JOptionPane.showInputDialog(null, "Inserisci codice ordine al Fornitore arrivato ","Arrivo ordine", JOptionPane.QUESTION_MESSAGE);
			try {
				gash.arrivoOrdine(codiceOrdine);
			} catch (NegValueException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingAction_15 extends AbstractAction {
		public SwingAction_15() {
			putValue(NAME, "Ordini in arrivo");
			putValue(SHORT_DESCRIPTION, "Visualizza tutti gli ordini in arrivo");
		}
		public void actionPerformed(ActionEvent e) {
			LinkedList<Ordine> ordiniInArrivo;
			ordiniInArrivo = gash.visualizzaOrdiniInArrivo();
			if(ordiniInArrivo!=null) {
				GashGUI.printInfo("Ordini in arrivo: ", ordiniInArrivo.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Nessun ordine in arrivo","Gestisci Consegne", JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	private class SwingAction_16 extends AbstractAction {
		public SwingAction_16() {
			putValue(NAME, "Nuovo Cliente");
			putValue(SHORT_DESCRIPTION, "Inserimento di un nuovo cliente");
		}
		public void actionPerformed(ActionEvent e) {
			
			try {
			String codiceFiscale = JOptionPane.showInputDialog(null, "Inserisci codice fiscale del nuovo cliente","Gestisci cliente", JOptionPane.QUESTION_MESSAGE);
			String denominazione = JOptionPane.showInputDialog(null, "Inserisci nome e cognome o ragione sociale del nuovo cliente","Gestisci cliente", JOptionPane.QUESTION_MESSAGE);
			String domicilioFiscale = JOptionPane.showInputDialog(null, "Inserisci domicilio fiscale del nuovo cliente","Gestisci cliente", JOptionPane.QUESTION_MESSAGE);
			String email = JOptionPane.showInputDialog(null, "Inserisci email del nuovo cliente","Gestisci cliente", JOptionPane.QUESTION_MESSAGE);
			int partitaiva = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci partita IVA del nuovo cliente","Gestisci cliente", JOptionPane.QUESTION_MESSAGE));			
			
			Boolean notexists = gash.nuovoCliente(codiceFiscale, denominazione, partitaiva, domicilioFiscale, email);
			if(notexists) {
				gash.confermaCliente();
			}else {
				JOptionPane.showMessageDialog(null, "Inserimento annullato: Errori nell'inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
			}
			} catch (NegValueException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	private class SwingAction_17 extends AbstractAction {
		public SwingAction_17() {
			putValue(NAME, "Ricerca Cliente");
			putValue(SHORT_DESCRIPTION, "Ricerca un cliente tramite il codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codiceFiscale = JOptionPane.showInputDialog(null, "Inserisci codice fiscale del cliente da ricercare", "Ricerca Cliente",JOptionPane.QUESTION_MESSAGE);
			Cliente c = gash.ricercaCliente(codiceFiscale);
			if(c!=null) {
				JOptionPane.showMessageDialog(null,"Cliente con codice: "+codiceFiscale+" trovato");
				GashGUI.printInfo("Cliente con codice: "+codiceFiscale, c.toString());
			} else {
				JOptionPane.showMessageDialog(null,"Non esistono clienti con codice: "+codiceFiscale);
			}			
		}
	}
	
	private class SwingAction_18 extends AbstractAction {
		public SwingAction_18() {
			putValue(NAME, "Elimina Cliente");
			putValue(SHORT_DESCRIPTION, "Elimina un cliente inserendo il codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codiceFiscale = JOptionPane.showInputDialog(null, "Inserisci codice fiscale del cliente da eliminare","Elimina cliente", JOptionPane.QUESTION_MESSAGE);
			gash.eliminaCliente(codiceFiscale);
		}
	}
	private class SwingAction_19 extends AbstractAction {
		public SwingAction_19() {
			putValue(NAME, "Modifica dati Cliente");
			putValue(SHORT_DESCRIPTION, "Modifica informazioni cliente usando codice");
		}
		public void actionPerformed(ActionEvent e) {
			
			String[] options = {"Codice fiscale", "Denominazione", "Partita IVA", "Domicilio fiscale", "Email"};
			String codiceFiscale = JOptionPane.showInputDialog(null, "Inserisci codice fiscale del cliente da modificare","Modifica cliente", JOptionPane.QUESTION_MESSAGE);
			if (gash.trovaCliente(codiceFiscale)) {
				
				String scelta = (String) JOptionPane.showInputDialog(null, "Cosa vuoi modificare?","Scelta modifica", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				switch (scelta) {
				case "Codice fiscale": {
					String nuovoCodice = JOptionPane.showInputDialog(null, "Inserisci nuovo codice fiscale del cliente","Modifica cliente", JOptionPane.QUESTION_MESSAGE);
					gash.modificaCodiceFiscale(nuovoCodice);
				 break;		
				}
				case "Denominazione": {
					String denominazione = JOptionPane.showInputDialog(null, "Inserisci nuova denominazione del cliente","Modifica cliente", JOptionPane.QUESTION_MESSAGE);
						gash.modificaDenominazione(denominazione);
					break;
				}
				case "Partita IVA": {
					try {
						int partitaiva = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci nuova partita IVA del cliente","Modifica cliente", JOptionPane.QUESTION_MESSAGE));
						gash.modificaPartitaIVA(partitaiva);
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
					break;
				}
				case "Domicilio fiscale": {
					String domicilioFiscale = JOptionPane.showInputDialog(null, "Inserisci nuovo domicilio fiscale del cliente","Modifica cliente", JOptionPane.QUESTION_MESSAGE);
					gash.modificaDomicilioFiscale(domicilioFiscale);
					break;
				}
				case "Email": {
					String nuovaEmail = JOptionPane.showInputDialog(null, "Inserisci nuova email del cliente","Modifica cliente", JOptionPane.QUESTION_MESSAGE);
					gash.modificaEmail(nuovaEmail);
				 break;		
				}
				default:
					break;
				}
			}	
		}
	}
	
	// *************************
	// Estensioni Caso d'uso 7
	// *************************
	
	private class SwingAction_20 extends AbstractAction {
		public SwingAction_20() {
			putValue(NAME, "Visualizza vendite");
			putValue(SHORT_DESCRIPTION, "Visualizza tutte le vendite");
		}
		public void actionPerformed(ActionEvent e) {
			gash.visualizzaVendite();
		}
	}
	private class SwingAction_21 extends AbstractAction {
		public SwingAction_21() {
			putValue(NAME, "Ricerca vendite cliente");
			putValue(SHORT_DESCRIPTION, "Ricerca tutte le vendite di un cliente");
		}
		public void actionPerformed(ActionEvent e) {
			LinkedList<Vendita> listaVendite;
			String codiceFiscale = JOptionPane.showInputDialog(null, "Inserisci codice fiscale del cliente","Ricerca vendite", JOptionPane.QUESTION_MESSAGE);
			listaVendite = gash.ricercaVenditeCliente(codiceFiscale);
			if(listaVendite!=null) {
				GashGUI.printInfo("Vendite cliente: ", listaVendite.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Errore: codice fiscale nullo o nessuna vendita associata al cliente","Ricerca vendite", JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	
	// *************************
			// Estensioni Caso d'uso 10
			// *************************
	
	private class SwingAction_22 extends AbstractAction {
		public SwingAction_22() {
			putValue(NAME, "Modifica Componente");
			putValue(SHORT_DESCRIPTION, "Modifica informazioni componente usando codice");
		}
		public void actionPerformed(ActionEvent e) {
			
			String[] options = {"Codice", "Nome", "Quantita", "Prezzo"};
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice del componente da modificare","Modifica Componente", JOptionPane.QUESTION_MESSAGE);
			if (gash.trovaComponente(codice)) {
				Vendibile v = gash.ricercaComponente(codice);
				String scelta = (String) JOptionPane.showInputDialog(null, "Cosa vuoi modificare?","Scelta modifica", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				switch (scelta) {
				case "Codice": {
					String nuovoCodice = JOptionPane.showInputDialog(null, "Inserisci nuovo codice del componente","Modifica Componente", JOptionPane.QUESTION_MESSAGE);
					gash.modificaCodiceComponente(nuovoCodice);
				 break;		
				}
				case "Nome": {
					String nuovoNome = JOptionPane.showInputDialog(null, "Inserisci nuovo nome del cliente","Modifica Componente", JOptionPane.QUESTION_MESSAGE);
						gash.modificaNomeComponente(nuovoNome);
					break;
				}
				case "Quantita": {
					try {
						int quantita;
						double mq;
						if(v instanceof ComponenteSingolo) {
							quantita = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci nuova quantita' del componente","Modifica componente", JOptionPane.QUESTION_MESSAGE));
							gash.modificaQuantitaComponente(quantita);
						}
						else {
							mq = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserisci nuovi mq del componente","Modifica componente", JOptionPane.QUESTION_MESSAGE));
							gash.modificaMqComponente(mq);
						}
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
					break;
				}
				case "Prezzo": {
					try {
						double prezzo = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserisci nuovo prezzo del componente","Modifica Componente", JOptionPane.QUESTION_MESSAGE));
						gash.modificaPrezzoComponente(prezzo);
					} catch (NegValueException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Formato Errato!", "Errore", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
						break;
					}
				default:
					break;
				}
			}	
		}
	}
		
	private class SwingAction_23 extends AbstractAction {
		public SwingAction_23() {
			putValue(NAME, "Elimina Componente");
			putValue(SHORT_DESCRIPTION, "Elimina un componente inserendo il codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice del componente da eliminare","Elimina Componente", JOptionPane.QUESTION_MESSAGE);
			gash.eliminaComponente(codice);
		}
	}
	private class SwingAction_24 extends AbstractAction {
		public SwingAction_24() {
			putValue(NAME, "Ricerca Componente");
			putValue(SHORT_DESCRIPTION, "Ricerca un componente inserendo il codice");
		}
		public void actionPerformed(ActionEvent e) {
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice del componente da ricercare", "Ricerca Componente",JOptionPane.QUESTION_MESSAGE);
			Vendibile v = gash.ricercaComponente(codice);
			if(v!=null) {
				JOptionPane.showMessageDialog(null,"Componente con codice: "+codice+" trovato");
				GashGUI.printInfo("Componente con codice: "+codice, v.toString());
			} else {
				JOptionPane.showMessageDialog(null,"Non esistono componenti con codice: "+codice);
			}	
		}
	}
	private class SwingAction_25 extends AbstractAction {
		public SwingAction_25() {
			putValue(NAME, "Ordini processati");
			putValue(SHORT_DESCRIPTION, "Visualizza tutti gli ordini processati");
		}
		public void actionPerformed(ActionEvent e) {
			LinkedList<Ordine> ordiniProcessati;
			ordiniProcessati = gash.visualizzaOrdiniProcessati();
			if(ordiniProcessati!=null) {
				GashGUI.printInfo("Ordini processati: ", ordiniProcessati.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Nessun ordine processato","Gestisci Consegne", JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	private class SwingAction_26 extends AbstractAction {
		public SwingAction_26() {
			putValue(NAME, "Segnala Consegna Vendita");
			putValue(SHORT_DESCRIPTION, "Setta lo stato di una vendita in Consegnato");
		}
		public void actionPerformed(ActionEvent e) {
			String codice = JOptionPane.showInputDialog(null, "Inserisci codice vendita","Gestisci Consegne", JOptionPane.QUESTION_MESSAGE);
			gash.segnalaConsegnaVendita(codice);
		}
	}
	private class SwingAction_27 extends AbstractAction {
		public SwingAction_27() {
			putValue(NAME, "Vendite in consegna");
			putValue(SHORT_DESCRIPTION, "Visualizza tutte le vendite non ancora consegnate");
		}
		public void actionPerformed(ActionEvent e) {
			LinkedList<Vendita> venditeInConsegna;
			venditeInConsegna = gash.visualizzaVenditeInConsegna();
			if(venditeInConsegna!=null) {
				GashGUI.printInfo("Vendite in consegna: ", venditeInConsegna.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Nessuna vendita in consegna","Gestisci Consegne", JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	private class SwingAction_28 extends AbstractAction {
		public SwingAction_28() {
			putValue(NAME, "Vendite consegnate");
			putValue(SHORT_DESCRIPTION, "Visualizza tutte le vendite già consegnate");
		}
		public void actionPerformed(ActionEvent e) {
			LinkedList<Vendita> venditeConsegnate;
			venditeConsegnate = gash.visualizzaVenditeConsegnate();
			if(venditeConsegnate!=null) {
				GashGUI.printInfo("Vendite consegnate: ", venditeConsegnate.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Nessuna vendita consegnata","Gestisci Consegne", JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	
}

	

	


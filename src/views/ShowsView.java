package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.ShowDAO;
import models.Show;
import utils.ShowsHelper;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class ShowsView {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblTitle;
	private JLabel lblRelease_year;
	private JLabel lblCountry;
	private JLabel lblDirector;
	private JLabel lblCast;
	private JLabel lblDuration;
	private JLabel lblDescription;
	private JLabel lblType;
	private JLabel lblRating;
	private JLabel lblListed_In;
	private JButton btnVolverABuscar;
	private JButton btnSigueinte;
	private JButton btnAtras;
	private JButton btnFavourite;
	private ShowDAO showdao;
	private int contShows;
	private ArrayList<Show> shows;
	private String nombreFichero;
	private String separador;

	/**
	 * Create the application.
	 */
	public ShowsView(int contShows, String searchFilter, String txtABuscar, String nombreFichero, String separador) {
		this.shows = new ArrayList<Show>();
		this.showdao = new ShowDAO();
		this.shows = showdao.search(searchFilter, txtABuscar);
		this.nombreFichero = nombreFichero;
		this.separador = separador;
		
		initialize();
		this.frame.setVisible(true);
		printShow();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);

		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/Netflix-icon4.png")));
		lblNewLabel.setBounds(0, 0, 70, 86);
		frame.getContentPane().add(lblNewLabel);

		lblTitle = new JLabel();
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Yu Gothic UI", Font.BOLD, 41));
		lblTitle.setBounds(94, 65, 831, 105);
		frame.getContentPane().add(lblTitle);

		lblRelease_year = new JLabel();
		lblRelease_year.setForeground(Color.WHITE);
		lblRelease_year.setFont(new Font("Yu Gothic UI", Font.PLAIN, 19));
		lblRelease_year.setBounds(623, 217, 151, 51);
		frame.getContentPane().add(lblRelease_year);

		lblCountry = new JLabel();
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
		lblCountry.setBounds(121, 367, 442, 60);
		frame.getContentPane().add(lblCountry);

		lblDirector = new JLabel();
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
		lblDirector.setBounds(121, 483, 335, 51);
		frame.getContentPane().add(lblDirector);

		lblCast = new JLabel();
		lblCast.setForeground(Color.GRAY);
		lblCast.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
		lblCast.setBounds(121, 427, 831, 60);
		frame.getContentPane().add(lblCast);

		lblDuration = new JLabel();
		lblDuration.setToolTipText("");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("Yu Gothic UI", Font.PLAIN, 19));
		lblDuration.setBounds(121, 217, 269, 51);
		frame.getContentPane().add(lblDuration);

		lblDescription = new JLabel();
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Yu Gothic UI", Font.PLAIN, 19));
		lblDescription.setBounds(121, 279, 792, 60);
		frame.getContentPane().add(lblDescription);

		lblType = new JLabel();
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Yu Gothic UI", Font.PLAIN, 19));
		lblType.setBounds(678, 367, 151, 60);
		frame.getContentPane().add(lblType);

		lblRating = new JLabel();
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Yu Gothic UI", Font.PLAIN, 19));
		lblRating.setBounds(456, 212, 135, 60);
		frame.getContentPane().add(lblRating);

		lblListed_In = new JLabel();
		lblListed_In.setForeground(Color.WHITE);
		lblListed_In.setFont(new Font("Yu Gothic UI", Font.PLAIN, 19));
		lblListed_In.setBounds(121, 151, 781, 60);
		frame.getContentPane().add(lblListed_In);

		btnVolverABuscar = new JButton("Volver a buscar");
		btnVolverABuscar.setForeground(Color.WHITE);
		btnVolverABuscar.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnVolverABuscar.setBackground(new Color(255, 69, 0));
		btnVolverABuscar.setBounds(810, 11, 222, 41);
		frame.getContentPane().add(btnVolverABuscar);

		btnSigueinte = new JButton("");
		btnSigueinte.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/flecha-derecha.png")));
		btnSigueinte.setForeground(Color.WHITE);
		btnSigueinte.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnSigueinte.setBackground(Color.BLACK);
		btnSigueinte.setBounds(962, 267, 70, 41);
		frame.getContentPane().add(btnSigueinte);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/flecha-izquierda.png")));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnAtras.setBackground(new Color(255, 69, 0));
		btnAtras.setBounds(10, 267, 70, 41);
		frame.getContentPane().add(btnAtras);

		btnFavourite = new JButton("");
		btnFavourite.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/estrella33.png")));
		btnFavourite.setBackground(Color.BLACK);
		btnFavourite.setBounds(921, 116, 60, 60);
		frame.getContentPane().add(btnFavourite);
		frame.setBounds(100, 100, 1056, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void configureListeners() {
		btnFavourite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFavourite.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/estrella-rellena33.png")));
				Show s = shows.get(contShows);
				
				boolean existe = new File("src/assets/files/" + nombreFichero + ".csv").exists();
				
				if(existe) separador = new ShowsHelper().getSeparador(nombreFichero);
				
				new ShowsHelper().aniadirFavs(nombreFichero, separador, s);
			}

		});

		btnSigueinte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printDelante();
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAtras();
			}
		});
	}

	private void printShow() {
		Show s = shows.get(contShows);
		lblTitle.setText(s.getTitle());
		lblRelease_year.setText(s.getRelease_year());
		lblCountry.setText("Country: " + s.getCountry());
		lblDirector.setText("Directed by: " + s.getDirector());
		lblCast.setText("Cast: " + s.getCast());
		lblDuration.setText(s.getDuration());
		lblDescription.setText(s.getDescription());
		lblType.setText(s.getType());
		lblRating.setText(s.getRating());
		lblListed_In.setText(s.getListed_in());
	}

	private void printAtras() {
		btnFavourite.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/estrella33.png")));
		contShows--;
		if (contShows < 0) {
			contShows = shows.size() - 1;
		}
		printShow();
	}

	private void printDelante() {
		btnFavourite.setIcon(new ImageIcon(ShowsView.class.getResource("/assets/estrella33.png")));
		contShows++;
		if (contShows == shows.size()) {
			contShows = 0;
		}
		printShow();
	}
	
}

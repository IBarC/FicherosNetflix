package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ShowDAO;
import models.Show;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchView {

	private JFrame frame;
	private String email;
	private JLabel lblNewLabel;
	private JLabel lblComienzaBuscandoTu;
	private JButton btnAnio;
	private JButton btnCerrarSesion;
	private JButton btnNombre;
	private JButton btnPais;
	private JButton btnDirector;
	private String nombreFichero;
	private String separador;

	/**
	 * Create the application.
	 */
	public SearchView(String email, String nombreFichero, String separador) {
		this.email = email;
		this.nombreFichero = nombreFichero;
		this.separador = separador;
		initialize();

		this.frame.setVisible(true);
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
		lblNewLabel.setIcon(new ImageIcon(SearchView.class.getResource("/assets/Netflix-icon4.png")));
		lblNewLabel.setBounds(0, 0, 70, 86);
		frame.getContentPane().add(lblNewLabel);

		lblComienzaBuscandoTu = new JLabel("Comienza buscando tu show favorito");
		lblComienzaBuscandoTu.setToolTipText("");
		lblComienzaBuscandoTu.setForeground(Color.WHITE);
		lblComienzaBuscandoTu.setFont(new Font("Yu Gothic UI", Font.BOLD, 46));
		lblComienzaBuscandoTu.setBounds(118, 137, 831, 105);
		frame.getContentPane().add(lblComienzaBuscandoTu);

		btnAnio = new JButton("A\u00F1o");
		btnAnio.setForeground(Color.WHITE);
		btnAnio.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnAnio.setBackground(new Color(255, 69, 0));
		btnAnio.setBounds(564, 404, 208, 41);
		frame.getContentPane().add(btnAnio);

		btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnCerrarSesion.setBackground(new Color(255, 69, 0));
		btnCerrarSesion.setBounds(824, 17, 208, 41);
		frame.getContentPane().add(btnCerrarSesion);

		btnNombre = new JButton("Nombre");
		btnNombre.setForeground(Color.WHITE);
		btnNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnNombre.setBackground(new Color(255, 69, 0));
		btnNombre.setBounds(214, 289, 208, 41);
		frame.getContentPane().add(btnNombre);

		btnPais = new JButton("Pa\u00EDs");
		btnPais.setForeground(Color.WHITE);
		btnPais.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnPais.setBackground(new Color(255, 69, 0));
		btnPais.setBounds(564, 289, 208, 41);
		frame.getContentPane().add(btnPais);

		btnDirector = new JButton("Director");
		btnDirector.setForeground(Color.WHITE);
		btnDirector.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnDirector.setBackground(new Color(255, 69, 0));
		btnDirector.setBounds(214, 404, 208, 41);
		frame.getContentPane().add(btnDirector);
		frame.setBounds(100, 100, 1056, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void configureListeners() {
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToShows("title");
			}
		});

		btnPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToShows("country");
			}
		});

		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToShows("director");
			}
		});

		btnAnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToShows("release_year");
			}
		});
	}

	private void goToShows(String searchFilter) {
		String txtABuscar = JOptionPane.showInputDialog("Introduce la búsqueda por favor");
		if (txtABuscar.isEmpty() || txtABuscar.equals(null)) {
			JOptionPane.showMessageDialog(btnAnio, "El campo de búsqueda no puede estar vacio");
		} else {
			frame.dispose();
			new ShowsView(0, searchFilter, txtABuscar, nombreFichero, separador);
		}

	}

}

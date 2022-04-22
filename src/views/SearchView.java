package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SearchView {

	private JFrame frame;
	private String email;

	/**
	 * Create the application.
	 */
	public SearchView(String email) {
		initialize();
		this.email = email;
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Irene\\Desktop\\CFGS\\1\u00BA\\Programacion\\Netflix\\src\\assets\\Netflix-icon4.png"));
		lblNewLabel.setBounds(0, 0, 70, 86);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblComienzaBuscandoTu = new JLabel("Comienza buscando tu show favorito");
		lblComienzaBuscandoTu.setToolTipText("");
		lblComienzaBuscandoTu.setForeground(Color.WHITE);
		lblComienzaBuscandoTu.setFont(new Font("Yu Gothic UI", Font.BOLD, 46));
		lblComienzaBuscandoTu.setBounds(118, 137, 831, 105);
		frame.getContentPane().add(lblComienzaBuscandoTu);
		
		JButton btnAnio = new JButton("A\u00F1o");
		btnAnio.setForeground(Color.WHITE);
		btnAnio.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnAnio.setBackground(new Color(255, 69, 0));
		btnAnio.setBounds(564, 404, 208, 41);
		frame.getContentPane().add(btnAnio);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnCerrarSesion.setBackground(new Color(255, 69, 0));
		btnCerrarSesion.setBounds(824, 17, 208, 41);
		frame.getContentPane().add(btnCerrarSesion);
		
		JButton btnFecha = new JButton("Nombre");
		btnFecha.setForeground(Color.WHITE);
		btnFecha.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnFecha.setBackground(new Color(255, 69, 0));
		btnFecha.setBounds(214, 289, 208, 41);
		frame.getContentPane().add(btnFecha);
		
		JButton btnPais = new JButton("Pa\u00EDs");
		btnPais.setForeground(Color.WHITE);
		btnPais.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnPais.setBackground(new Color(255, 69, 0));
		btnPais.setBounds(564, 289, 208, 41);
		frame.getContentPane().add(btnPais);
		
		JButton btnDirector = new JButton("Director");
		btnDirector.setForeground(Color.WHITE);
		btnDirector.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnDirector.setBackground(new Color(255, 69, 0));
		btnDirector.setBounds(214, 404, 208, 41);
		frame.getContentPane().add(btnDirector);
		frame.setBounds(100, 100, 1056, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {

	}

	private void configureListeners() {

	}

}

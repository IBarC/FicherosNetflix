package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;

import javax.swing.JTextField;

public class RegisterView {

	private JFrame frame;
	private JLabel logo;
	// private JLabel fondo;
	private JButton btnIniciarSesion;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JLabel lblNewLabel_3;
	private JTextField txtUsuario;
	private JPasswordField password;
	private JPasswordField repeatPassword;
	private JLabel lblNewLabel;
	private JTextField txtCorreo;
	private JLabel lblEmain;
	private JLabel lblContrasea;
	private JLabel lblRepetirContrasenia;
	private JButton btnCrearCuenta;
	private UsuarioDAO usuariodao;

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
		usuariodao = new UsuarioDAO();
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
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(
				"C:\\Users\\Irene\\Desktop\\CFGS\\1\u00BA\\Programacion\\Netflix\\src\\assets\\Netflix2.png"));
		logo.setBounds(27, 27, 238, 90);
		frame.getContentPane().add(logo);
		// frame.setIconImage(new ImageIcon("/assets/Fondo-inicio.jpg").getImage());

//			fondo = new JLabel("");
//			fondo.setIcon(new ImageIcon("C:\\Users\\Irene\\Desktop\\CFGS\\1\u00BA\\Programacion\\Netflix\\src\\assets\\Fondo-inicio.jpg"));
//			fondo.setBounds(837, 391, 1289, 699);
//			frame.getContentPane().add(fondo);

		btnIniciarSesion = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesion.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnIniciarSesion.setBackground(new Color(255, 69, 0));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBounds(788, 49, 208, 41);
		frame.getContentPane().add(btnIniciarSesion);

		lblNewLabel_2 = new JLabel("Todas las pel\u00EDculas y series");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 46));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(241, 83, 572, 105);
		frame.getContentPane().add(lblNewLabel_2);

		label = new JLabel();
		label.setBounds(469, 302, 49, 14);
		frame.getContentPane().add(label);

		lblNewLabel_3 = new JLabel("que desees, y mucho m\u00E1s.");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 46));
		lblNewLabel_3.setBounds(241, 138, 572, 105);
		frame.getContentPane().add(lblNewLabel_3);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtUsuario.setBounds(311, 254, 429, 41);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		password.setBounds(311, 397, 429, 41);
		frame.getContentPane().add(password);

		repeatPassword = new JPasswordField();
		repeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		repeatPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		repeatPassword.setBounds(311, 468, 429, 41);
		frame.getContentPane().add(repeatPassword);

		btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnCrearCuenta.setBackground(new Color(255, 69, 0));
		btnCrearCuenta.setBounds(810, 493, 208, 41);
		frame.getContentPane().add(btnCrearCuenta);

		lblNewLabel = new JLabel("Nombre de usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(120, 254, 181, 41);
		frame.getContentPane().add(lblNewLabel);

		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(311, 323, 429, 41);
		frame.getContentPane().add(txtCorreo);

		lblEmain = new JLabel("Correo electr\u00F3nico:");
		lblEmain.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmain.setForeground(Color.LIGHT_GRAY);
		lblEmain.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblEmain.setBounds(120, 323, 181, 41);
		frame.getContentPane().add(lblEmain);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.LIGHT_GRAY);
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblContrasea.setBounds(120, 397, 181, 41);
		frame.getContentPane().add(lblContrasea);

		lblRepetirContrasenia = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirContrasenia.setForeground(Color.LIGHT_GRAY);
		lblRepetirContrasenia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblRepetirContrasenia.setBounds(120, 468, 181, 41);
		frame.getContentPane().add(lblRepetirContrasenia);
		frame.setBounds(100, 100, 1056, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void configureListeners() {
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginView();
			}
		});

		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarUsuario();
			}
		});
	}

	private boolean comprobarUsuario() {
		// comprueba con un select que tanto el usuario como el email no existen en la
		// base de datos
		// si no estan que compruebe que las contraseñas son iguales
		// si todo esta bien --> comprobarCodigo()
		String usuario = this.txtUsuario.getText();
		String email = this.txtCorreo.getText();

		if (usuariodao.buscarNombre(usuario) || usuariodao.buscarEmail(email)) {

		}

		return false;
	}

	private int generarCodigo() {
		return (int) (Math.random() * 10000 + 1);
	}

	private void comprobarCodigo() {
		// si el codigo que manda es correcto crea el usuario
		// mientras que el codigo introducido sea invalido mandará correos con codigos
		// distintos hasta que meta el correcto
	}
}

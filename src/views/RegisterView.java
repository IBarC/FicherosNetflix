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
import models.Usuario;
import snippet.Emailing;
import utils.EmailHelper;

import javax.swing.JTextField;

public class RegisterView {

	private JFrame frame;
	private JLabel logo;
	// private JLabel fondo;
	private JButton btnIniciarSesion;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JLabel lblNewLabel_3;
	private JPasswordField password;
	private JPasswordField repeatPassword;
	private JTextField txtCorreo;
	private JLabel lblEmain;
	private JLabel lblContrasea;
	private JLabel lblRepetirContrasenia;
	private JButton btnCrearCuenta;
	private UsuarioDAO usuariodao;
	private JButton btnValidarCdigo;

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
		logo.setIcon(new ImageIcon(RegisterView.class.getResource("/assets/Netflix2.png")));
		logo.setBounds(27, 27, 238, 90);
		frame.getContentPane().add(logo);

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
		lblNewLabel_2.setBounds(241, 103, 572, 105);
		frame.getContentPane().add(lblNewLabel_2);

		label = new JLabel();
		label.setBounds(469, 302, 49, 14);
		frame.getContentPane().add(label);

		lblNewLabel_3 = new JLabel("que desees, y mucho m\u00E1s.");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 46));
		lblNewLabel_3.setBounds(241, 158, 572, 105);
		frame.getContentPane().add(lblNewLabel_3);

		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		password.setBounds(311, 376, 429, 41);
		frame.getContentPane().add(password);

		repeatPassword = new JPasswordField();
		repeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		repeatPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		repeatPassword.setBounds(311, 447, 429, 41);
		frame.getContentPane().add(repeatPassword);

		btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnCrearCuenta.setBackground(new Color(255, 69, 0));
		btnCrearCuenta.setBounds(810, 493, 208, 41);
		frame.getContentPane().add(btnCrearCuenta);

		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(311, 302, 429, 41);
		frame.getContentPane().add(txtCorreo);

		lblEmain = new JLabel("Correo electr\u00F3nico:");
		lblEmain.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmain.setForeground(Color.LIGHT_GRAY);
		lblEmain.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblEmain.setBounds(120, 302, 181, 41);
		frame.getContentPane().add(lblEmain);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.LIGHT_GRAY);
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblContrasea.setBounds(120, 376, 181, 41);
		frame.getContentPane().add(lblContrasea);

		lblRepetirContrasenia = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirContrasenia.setForeground(Color.LIGHT_GRAY);
		lblRepetirContrasenia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblRepetirContrasenia.setBounds(120, 447, 181, 41);
		frame.getContentPane().add(lblRepetirContrasenia);

		btnValidarCdigo = new JButton("Validar cuenta");
		btnValidarCdigo.setForeground(Color.WHITE);
		btnValidarCdigo.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnValidarCdigo.setBackground(new Color(255, 69, 0));
		btnValidarCdigo.setBounds(810, 431, 208, 41);
		frame.getContentPane().add(btnValidarCdigo);
		frame.setBounds(100, 100, 1056, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void configureListeners() {
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginView();
			}
		});

		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarUsuario();
			}
		});

		btnValidarCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailIntroducido = JOptionPane.showInputDialog(btnCrearCuenta,
						"Por favor introduzca su correo.");
				if (usuariodao.buscarEmail(emailIntroducido)) {
					JOptionPane.showMessageDialog(btnCrearCuenta,
							"Hemos enviado un código al correo introducido. Por favor revise su bandeja de entrada");

					if (comprobarCodigo(emailIntroducido)) {
						JOptionPane.showMessageDialog(btnCrearCuenta, "La cuenta se ha validado con éxito");
						frame.dispose();
						new LoginView();
					}
				} else {
					JOptionPane.showMessageDialog(btnCrearCuenta,
							"El correo no existe. Cree primero una cuenta antes de intentar validarla.");
				}
			}
		});
	}

	private void comprobarUsuario() {
		// comprueba con un select que tanto el usuario como el email no existen en la
		// base de datos
		// si no estan que compruebe que las contraseñas son iguales
		// si todo esta bien --> comprobarCodigo()
		String email = this.txtCorreo.getText();
		String passw1 = new String(this.password.getPassword());
		String passw2 = new String(this.repeatPassword.getPassword());

		if (email.isEmpty() || passw1.isEmpty() || passw2.isEmpty()) {
			JOptionPane.showMessageDialog(btnCrearCuenta, "Los campos no pueden estar vacios");
		} else if (usuariodao.buscarEmail(email)) {
			JOptionPane.showMessageDialog(btnCrearCuenta, "El nombre de usuario o el correo ya existe");
		} else {
			if (passw1.equals(passw2)) {
				String hashPassword = Emailing.hashIt(passw1, passw1);
				usuariodao.register(new Usuario(hashPassword, email));
				JOptionPane.showMessageDialog(btnCrearCuenta,
						"La cuenta se ha creado con éxito.\nHemos enviado un código al correo introducido. Por favor revise su bandeja de entrada");
				comprobarCodigo(email);
			} else {
				JOptionPane.showMessageDialog(btnCrearCuenta, "Las contraseñas no coinciden");
			}
		}
	}

	private int generarCodigo() {
		return (int) (Math.random() * (10000 - 1000 + 1) + 1000);
	}

	/**
	 * 
		// si el codigo que manda es correcto crea el usuario
		// mientras que el codigo introducido sea invalido mandará correos con codigos
		// distintos hasta que meta el correcto
	 * @param correo
	 * @return
	 */
	private boolean comprobarCodigo(String correo) {
		String codigoGenerado = generarCodigo() + ""; // Código que tiene que introducir el usuario
		EmailHelper.sendValidationCode(correo, codigoGenerado);
		String codigoIntroducido = JOptionPane.showInputDialog(btnCrearCuenta,
				"Escriba aquí el código que ha recibido.");
		if (!codigoGenerado.equals(codigoIntroducido)) {
			JOptionPane.showMessageDialog(btnCrearCuenta, "El código introducido es incorrecto");
		} else {
			usuariodao.insertCode(codigoGenerado, correo);
			JOptionPane.showMessageDialog(btnCrearCuenta, "La cuenta se ha validado con éxito");
			frame.dispose();
			new LoginView();
			return true;
		}
		return false;
	}
}

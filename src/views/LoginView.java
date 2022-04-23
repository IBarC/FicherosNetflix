package views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;
import snippet.Emailing;
import utils.EmailHelper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoginView {

	private JFrame frLogin;
	private UsuarioDAO usuarioDAO;
	private JLabel logo;
	private JLabel lblNewLabel;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField password;
	private JButton btnIniciarSesion;
	private JButton btnCrearCuenta;
	private JButton btnValidarCdigo;
	private JLabel lblAparece;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		this.usuarioDAO = new UsuarioDAO();
		this.frLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frLogin = new JFrame();
		frLogin.getContentPane().setBackground(Color.BLACK);
		frLogin.setBounds(100, 100, 1056, 582);
		frLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		frLogin.getContentPane().setLayout(null);

		logo = new JLabel("");
		logo.setIcon(new ImageIcon(LoginView.class.getResource("/assets/Netflix2.png")));
		logo.setBounds(27, 27, 238, 90);
		frLogin.getContentPane().add(logo);

		lblNewLabel = new JLabel("Iniciar sesi\u00F3n");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 46));
		lblNewLabel.setBounds(367, 116, 322, 105);
		frLogin.getContentPane().add(lblNewLabel);

		lblUsuario = new JLabel("Nombre de usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.LIGHT_GRAY);
		lblUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblUsuario.setBounds(157, 277, 181, 41);
		frLogin.getContentPane().add(lblUsuario);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.LIGHT_GRAY);
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblContrasea.setBounds(157, 362, 181, 41);
		frLogin.getContentPane().add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(370, 277, 429, 41);
		frLogin.getContentPane().add(txtUsuario);

		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		password.setBounds(370, 362, 429, 41);
		frLogin.getContentPane().add(password);

		btnIniciarSesion = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnIniciarSesion.setBackground(new Color(255, 69, 0));
		btnIniciarSesion.setBounds(416, 468, 208, 41);
		frLogin.getContentPane().add(btnIniciarSesion);

		btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnCrearCuenta.setBackground(new Color(255, 69, 0));
		btnCrearCuenta.setBounds(10, 493, 208, 41);
		frLogin.getContentPane().add(btnCrearCuenta);

		btnValidarCdigo = new JButton("Validar cuenta");
		btnValidarCdigo.setForeground(Color.WHITE);
		btnValidarCdigo.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		btnValidarCdigo.setBackground(new Color(255, 69, 0));
		btnValidarCdigo.setBounds(824, 493, 208, 41);
		frLogin.getContentPane().add(btnValidarCdigo);

		lblAparece = new JLabel("");
		lblAparece.setBounds(880, 79, 49, 14);
		frLogin.getContentPane().add(lblAparece);
	}

	private void configureListeners() {
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLogin();
			}
		});

		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frLogin.dispose();
				new RegisterView();
			}
		});

		btnValidarCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailIntroducido = JOptionPane.showInputDialog(btnValidarCdigo,
						"Por favor introduzca su correo.");
				if (usuarioDAO.buscarEmail(emailIntroducido)) {
					JOptionPane.showMessageDialog(btnCrearCuenta,
							"Hemos enviado un código al correo introducido. Por favor revise su bandeja de entrada");

					if (comprobarCodigo(emailIntroducido)) {
						JOptionPane.showMessageDialog(btnCrearCuenta, "La cuenta se ha validado con éxito");
						frLogin.setVisible(false);
						new LoginView();
					}
				} else {
					JOptionPane.showMessageDialog(btnCrearCuenta,
							"El correo no existe. Cree primero una cuenta antes de intentar validarla.");
				}
			}
		});
	}

	private void comprobarLogin() {
		String usuario = txtUsuario.getText();
		String passw = new String(password.getPassword());

		if (usuario.isEmpty() || passw.isEmpty()) {
			JOptionPane.showMessageDialog(btnCrearCuenta, "Los campos no pueden estar vacios");
		} else if (usuario.contains("@gmail.com") || usuario.contains("@iespablopicasso.es")) {
			if (usuarioDAO.buscarEmail(usuario)) {
				if (usuarioDAO.loginEmail(new Usuario(Emailing.hashIt(passw, passw), usuario))) {
					String nombreFichero = configFichero(); // primero pide la configuración del ficehero
					String separador= configSeparador();// pregunta por el separador que se quiere utilizar
					frLogin.dispose();
					new SearchView(usuario, nombreFichero, separador);
				}
			} else {
				JOptionPane.showMessageDialog(btnIniciarSesion, "El usuario no existe");
			}
		} else {
			JOptionPane.showMessageDialog(btnIniciarSesion, "La dirección de correo no es válida");
		}
	}

	private int generarCodigo() {
		return (int) (Math.random() * (10000 - 1000 + 1) + 1000);
	}

	/**
	 * 
	 * // si el codigo que manda es correcto crea el usuario // mientras que el
	 * codigo introducido sea invalido mandará correos con codigos // distintos
	 * hasta que meta el correcto
	 * 
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
			usuarioDAO.insertCode(codigoGenerado, correo);
			JOptionPane.showMessageDialog(btnCrearCuenta, "La cuenta se ha validado con éxito");
			return true;
		}
		return false;

	}

	private String configFichero() {
		String nombreFichero = JOptionPane.showInputDialog("Antes de realizar la búsqueda nos gustaría saber el nombre"
				+ "\ndel fichero que quieres usar para introducir tus shows favoritos.");

		
		return nombreFichero;
	}

	private String configSeparador() {
		String[] opciones = { "Coma", "Punto y coma", "Tabulador" };
		String separador = (String) JOptionPane.showInternalInputDialog(lblAparece, "¿Qué separador quieres usar?",
				"Elije el separador", JOptionPane.QUESTION_MESSAGE, null, opciones, "Coma");
		// saber que es lo que devuelve y a raiz de ahi elegir el separador
		// correspondiente
		
		if(separador.equals("Coma")) separador=",";
		if(separador.equals("Punto y coma")) separador=";";
		if(separador.equals("Tabulador")) separador="\t";

		return separador;
	}

}

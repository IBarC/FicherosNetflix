package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView {

	private JFrame frLogin;
	private JTextField inputUsu;
	private JLabel lblUsuario;
	private JLabel lblContr;
	private JLabel titulo;
	private JButton inicioS;
	private JButton registrarse;
	private JPasswordField inputContr;
	private UsuarioDAO usuarioDAO;

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
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setForeground(new Color(192, 192, 192));
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(219, 170, 59, 26);
		frLogin.getContentPane().add(lblUsuario);

		inicioS = new JButton("Iniciar sesi\u00F3n");

		inicioS.setFont(new Font("Segoe UI", Font.BOLD, 14));
		inicioS.setBounds(752, 43, 176, 48);
		frLogin.getContentPane().add(inicioS);

		lblContr = new JLabel("Contrase\u00F1a:");
		lblContr.setForeground(new Color(192, 192, 192));
		lblContr.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblContr.setBounds(196, 207, 82, 26);
		frLogin.getContentPane().add(lblContr);

		registrarse = new JButton("Reg\u00EDstrate");
		registrarse.setFont(new Font("Segoe UI", Font.BOLD, 14));
		registrarse.setBounds(416, 381, 234, 54);
		frLogin.getContentPane().add(registrarse);

		titulo = new JLabel("Netflix");
		titulo.setForeground(Color.LIGHT_GRAY);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Bauhaus 93", Font.PLAIN, 60));
		titulo.setBounds(94, 39, 275, 48);
		frLogin.getContentPane().add(titulo);

		inputUsu = new JTextField();
		inputUsu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		inputUsu.setBounds(452, 148, 183, 26);
		frLogin.getContentPane().add(inputUsu);
		inputUsu.setColumns(10);

		inputContr = new JPasswordField();
		inputContr.setBounds(416, 271, 183, 26);
		frLogin.getContentPane().add(inputContr);
	}
	
	private void configureListeners() {
		inicioS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = inputUsu.getText();
				String password = new String(inputContr.getPassword());
				Usuario usuario = new Usuario(0, username, password);
				boolean compLogin = usuarioDAO.login(usuario);
				comprobarLogin(compLogin, username);
			}
		});

		inputContr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String username = inputUsu.getText();
					String password = new String(inputContr.getPassword());
					Usuario usuario = new Usuario(0, username, password);
					boolean compLogin = usuarioDAO.login(usuario);
					comprobarLogin(compLogin, username);
				}
			}
		});

		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Registro(frLogin);
				frLogin.setVisible(false);
			}
		});
	}
	
	/**
	 * Comprueba que el usuario y la contraseña se encuentra dentro de los usuarios
	 * disponibles. Si es correcta te lleva a la pokedex de ese usuario
	 */
	private void comprobarLogin(boolean compLogin, String username) {

//		int i = 0;
//		boolean usuCorrecto = false;
//		do {
//			if (compLogin) {
//				//new WelcomeView(username);
//				frLogin.setVisible(false); // Se oculta la visibilidad
//				usuCorrecto = true;
//			} else {
//				i++;
//			}
//		} while (i < Almacen.usuarios.size() && !usuCorrecto);
//
//		if (!usuCorrecto) {
//			JOptionPane.showMessageDialog(inicioS, "Login incorrecto");
//		}
	}

}

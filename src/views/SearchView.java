package views;

import java.awt.Color;

import javax.swing.JFrame;

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

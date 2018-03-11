package Othello;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import FinalGame.Menu;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinWindow extends JFrame {

	private JFrame frame;
	JLabel lblNewLabel_1;
	JLabel label;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_3;
	JLabel lblPlayerScore;
	private JButton btnMainMenu;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinWindow window = new WinWindow();
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
	public WinWindow() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img=new ImageIcon(this.getClass().getResource("winnerbig.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(56, 80, 350, 200);
		getContentPane().add(lblNewLabel);
		
	    lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(102, 11, 264, 58);
		getContentPane().add(lblNewLabel_1);
		Image img2=new ImageIcon(this.getClass().getResource("backgroundlarge.jpg")).getImage();
		
		 lblNewLabel_3 = new JLabel("Player1 Score :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(250, 250, 210));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(102, 291, 162, 26);
		getContentPane().add(lblNewLabel_3);
		
		 lblPlayerScore = new JLabel("Player2 Score :");
		lblPlayerScore.setForeground(new Color(255, 255, 255));
		lblPlayerScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlayerScore.setBackground(Color.WHITE);
		lblPlayerScore.setBounds(102, 328, 162, 26);
		getContentPane().add(lblPlayerScore);
		Image img3=new ImageIcon(this.getClass().getResource("backgroundlarge.jpg")).getImage();
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Board.resetarray();
				try {
					Welcomeothello window = new Welcomeothello();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(67, 365, 121, 26);
		getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(new Color(255, 255, 0));
		btnExit.setBounds(198, 365, 82, 26);
		getContentPane().add(btnExit);
		
		
		 label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setForeground(new Color(255, 255, 0));
		label.setBounds(274, 291, 46, 26);
		getContentPane().add(label);
		
		 lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(274, 328, 46, 23);
		getContentPane().add(lblNewLabel_4);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMainMenu.setBackground(Color.YELLOW);
		btnMainMenu.setBounds(290, 365, 121, 26);
		getContentPane().add(btnMainMenu);
		
		lblNewLabel_2 = new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("backgroundlarge.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img4));
		lblNewLabel_2.setBounds(0, 0, 476, 454);
		getContentPane().add(lblNewLabel_2);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

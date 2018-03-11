package game2048;
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
	JLabel label;

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
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("win.jpg")).getImage();
		 lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(56, 80, 350, 200);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_3 = new JLabel("Your Score :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(250, 250, 210));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(125, 291, 139, 26);
		getContentPane().add(lblNewLabel_3);
		
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Board.resetarray();
				try {
					game2048 window = new game2048();
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
		btnNewButton.setBounds(68, 338, 121, 26);
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
		btnExit.setBounds(199, 338, 82, 26);
		getContentPane().add(btnExit);
		
		
		 label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setForeground(new Color(255, 255, 0));
		label.setBounds(274, 291, 46, 26);
		getContentPane().add(label);
		
		JButton btnMainMenu = new JButton("Main Menu");
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
		btnMainMenu.setBounds(291, 338, 121, 26);
		getContentPane().add(btnMainMenu);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("background2.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img5));
		lblNewLabel_1.setBounds(0, 0, 476, 420);
		getContentPane().add(lblNewLabel_1);
		
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

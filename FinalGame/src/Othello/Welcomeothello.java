package Othello;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Welcomeothello {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcomeothello window = new Welcomeothello();
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
	public Welcomeothello() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Image img7=new ImageIcon(this.getClass().getResource("othelloicon.png")).getImage();
		frame.setIconImage(img7);
		frame.setBounds(new Rectangle(100,100,702,504));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlayerVsComputer = new JButton("Player  VS  Computer");
		btnPlayerVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.resetarray();
				try {
					GUIComputer window = new GUIComputer();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		btnPlayerVsComputer.setForeground(Color.YELLOW);
		btnPlayerVsComputer.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPlayerVsComputer.setBackground(new Color(0, 102, 0));
		btnPlayerVsComputer.setBounds(180, 365, 354, 60);
		frame.getContentPane().add(btnPlayerVsComputer);
		
		JButton btnPlayerVsPlayer = new JButton("Player1  VS  Player2");
		btnPlayerVsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Board.resetarray();
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		btnPlayerVsPlayer.setForeground(Color.YELLOW);
		btnPlayerVsPlayer.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPlayerVsPlayer.setBackground(new Color(0, 102, 0));
		btnPlayerVsPlayer.setBounds(180, 263, 354, 60);
		frame.getContentPane().add(btnPlayerVsPlayer);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("othellobackground2.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 0, 686, 469);
		frame.getContentPane().add(lblNewLabel);
	}
}

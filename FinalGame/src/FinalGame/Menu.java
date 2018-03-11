package FinalGame;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import game2048.*;
import Othello.*;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Welcomeothello window = new Welcomeothello();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		Image img=new ImageIcon(this.getClass().getResource("othelloimg.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(45, 100, 287, 280);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
			    	Image img=new ImageIcon(this.getClass().getResource("othello name.png")).getImage();
					btnNewButton.setIcon(new ImageIcon(img));
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	
			    	Image img=new ImageIcon(this.getClass().getResource("othelloimg.png")).getImage();
					btnNewButton.setIcon(new ImageIcon(img));
			    }
			});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Welcome2048 window = new Welcome2048();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		Image img2=new ImageIcon(this.getClass().getResource("2048img.jpg")).getImage();
		button.setIcon(new ImageIcon(img2));
		button.setBackground(Color.WHITE);
		button.setBounds(375, 100, 287, 280);
		
		button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
		    	Image img=new ImageIcon(this.getClass().getResource("2048 name.png")).getImage();
		    	button.setIcon(new ImageIcon(img));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	
		    	Image img=new ImageIcon(this.getClass().getResource("2048img.jpg")).getImage();
		    	button.setIcon(new ImageIcon(img));
		    }
		});
		
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		Image img3=new ImageIcon(this.getClass().getResource("background2.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(0, 0, 713, 453);
		frame.getContentPane().add(lblNewLabel);
		
	}
}

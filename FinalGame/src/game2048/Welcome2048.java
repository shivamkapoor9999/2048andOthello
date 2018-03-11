package game2048;
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
import java.awt.SystemColor;

public class Welcome2048 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome2048 window = new Welcome2048();
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
	public Welcome2048() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(100,100,592,500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlayerVsComputer = new JButton("START GAME");
		btnPlayerVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnPlayerVsComputer.setForeground(Color.YELLOW);
		btnPlayerVsComputer.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPlayerVsComputer.setBackground(SystemColor.desktop);
		btnPlayerVsComputer.setBounds(139, 364, 291, 60);
		frame.getContentPane().add(btnPlayerVsComputer);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("2048cover2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 0, 584, 462);
		frame.getContentPane().add(lblNewLabel);
	}
}

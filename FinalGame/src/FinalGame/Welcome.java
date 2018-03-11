package FinalGame;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Menu window = new Menu();
			window.frame.setVisible(true);
		} catch (Exception ed) {
			ed.printStackTrace();
		}
	    frame.dispose();
	}
	
	

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("back.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img5));
		lblNewLabel.setBounds(0, 0, 716, 453);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}

}

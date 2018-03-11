package game2048;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import FinalGame.Menu;
import FinalGame.Welcome;

import java.awt.SystemColor;

public class game2048 {

	public JFrame frame;
	int boardSize=4;
	Board B=new Board(boardSize);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game2048 window = new game2048();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//generate random no and put no into board;
	public int randomFunc()
	{
		
	  return Math.random() > 0.1 ? 2 : 4;
	}
	public Pair randomGenerator()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Pair> arr=new ArrayList<>();
		for(int i=0;i<B.board.length;i++)
		{
			for(int j=0;j<B.board[0].length;j++)
			{
				if(B.board[i][j]==0)
				{
					Pair p=new Pair(i,j);
					arr.add(p);
				}
			}
		}
		Random rand = new Random();
		
		int value=randomFunc();
		if(arr.size()==0)
		{
			//System.out.println("Invalid move");
			return null;
		}
		int index2=rand.nextInt(arr.size());
		Pair temppair=arr.get(index2);
		B.board[temppair.i][temppair.j]=value;
		return temppair;
	}
	public void showImageOnCell(MyLabel[][] labels)
	{
		for(int i=0;i<B.board.length;i++)
		{
			for(int j=0;j<B.board[0].length;j++)
			{
				if(B.board[i][j]==0)
				{
					Image img=new ImageIcon(this.getClass().getResource("blank.jpg")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				if(B.board[i][j]==2)
				{
					Image img=new ImageIcon(this.getClass().getResource("2.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==4)
				{
					Image img=new ImageIcon(this.getClass().getResource("4.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==8)
				{
					Image img=new ImageIcon(this.getClass().getResource("8.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==16)
				{
					Image img=new ImageIcon(this.getClass().getResource("16.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==32)
				{
					Image img=new ImageIcon(this.getClass().getResource("32.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==64)
				{
					Image img=new ImageIcon(this.getClass().getResource("64.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==128)
				{
					Image img=new ImageIcon(this.getClass().getResource("128.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==256)
				{
					Image img=new ImageIcon(this.getClass().getResource("256.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==512)
				{
					Image img=new ImageIcon(this.getClass().getResource("512.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==1024)
				{
					Image img=new ImageIcon(this.getClass().getResource("1024.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				else if(B.board[i][j]==2048)
				{
					Image img=new ImageIcon(this.getClass().getResource("2048.png")).getImage();
					labels[i][j].setIcon(new ImageIcon(img));
				}
				
			}
		}
	}
	public void clearBoard(MyLabel[][] labels)
	{
		for(int i=0;i<B.board.length;i++)
		{
			for(int j=0;j<B.board[0].length;j++)
			{
				labels[i][j].setIcon(null);
			}
		}
	}
	public void playSound(String soundName)
	 {
	   try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("button-3.wav"));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    clip.start( );
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }
	/*public boolean checkGameEnd(Pair p)
	{
		int i=p.i;
		int j=p.j;
		if(i<3&&B.board[i+1][j]==B.board[i][j])
		{
			return false;
		}
		if(i>0&&B.board[i-1][j]==B.board[i][j])
		{
			return false;
		}
		if(j<3&&B.board[i][j+1]==B.board[i][j])
		{
			return false;
		}
		if(j>0&&B.board[i][j-1]==B.board[i][j])
		{
			return false;
		}
		return true;
	}*/

	/**
	 * Create the application.
	 */
	public game2048() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 102));
		frame.setBounds(100, 100, 675, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setBounds(39, 28, 325, 325);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.windowBorder, 5));
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(458, 87, 94, 82);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SCORE");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setBounds(0, 11, 95, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 45, 74, 26);
		panel_1.add(lblNewLabel_1);
		
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
		btnNewButton.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		btnNewButton.setForeground(new Color(0, 51, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(458, 188, 106, 30);
		 btnNewButton.setFocusable(false);
		frame.getContentPane().add(btnNewButton);
		
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
		btnMainMenu.setForeground(new Color(0, 51, 255));
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMainMenu.setFocusable(false);
		btnMainMenu.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		btnMainMenu.setBounds(458, 239, 106, 30);
		frame.getContentPane().add(btnMainMenu);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("background2.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(0, 0, 659, 422);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
		
		/*JButton btnNewButton = new JButton("New Game");
		btnNewButton.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(455, 121, 108, 23);
		frame.getContentPane().add(btnNewButton);
		*/
		
		
		String playerName="shivam kapoor";
		Player P=new Player(playerName);
		
		MyLabel[][] labels=new MyLabel[4][4];
		int x=5,y=5;
		for(int i=0;i<4;i++)
		{
		    x=5;
			for(int j=0;j<4;j++)
			{
				labels[i][j]=new MyLabel(i,j);
				labels[i][j].setBounds(x, y,75,75);
				
				labels[i][j].setFont(new Font("Tahoma", Font.BOLD, 20));
				labels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				labels[i][j].setVerticalAlignment(SwingConstants.CENTER);
				panel.add(labels[i][j]);
				//frame.getContentPane().add(labels[i][j]);
				x=x+80;
			}
			y=y+80;
		}
		randomGenerator();
		randomGenerator();
		/*for(int i=0;i<B.board.length;i++)
		{
			for(int j=0;j<B.board[0].length;j++)
			{
				System.out.print(B.board[i][j]+" ");
			}
			System.out.println();
		}*/
		showImageOnCell(labels);
		frame.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e) {

			//up=1;
			//down=2;
			//right=3;
			//left=4;
	        int key = e.getKeyCode();
	        Pair p;
	        
	        if (key == KeyEvent.VK_LEFT) {
	        	playSound("button-3.wav");
	            B.move(4);
	           showImageOnCell(labels);
	           
	           /* p=randomGenerator();
	            clearBoard(labels);
	           
	            showImageOnCell(labels);
	           lblNewLabel_1.setText(Integer.toString(B.score));
	            int end=B.isGameEnd();
	            if(end==1)
	            {
	            	 WinWindow newFrame=new WinWindow();
					    newFrame.setVisible(true);
					    newFrame.label.setText(Integer.toString(B.score));
					    newFrame.setBounds(100, 100,476,429);
	            }
	            else if(end==2)
	            {
	            	if(p!=null&&checkGameEnd(p))
	            	{
	            		//Exit game
	            		 gameOver newFrame=new gameOver();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
	            		
	            	}
	            }*/
	            
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        	
	        	playSound("button-3.wav");
	           B.move(3);
	          showImageOnCell(labels);
	           
	          /* p=randomGenerator();
	           clearBoard(labels);
	          
	           showImageOnCell(labels);
	           lblNewLabel_1.setText(Integer.toString(B.score));
	           int end=B.isGameEnd();
	           if(end==1)
	            {
	            	 WinWindow newFrame=new WinWindow();
					    newFrame.setVisible(true);
					    newFrame.label.setText(Integer.toString(B.score));
					    newFrame.setBounds(100, 100,476,429);
	            }
	            else if(end==2)
	            {
	            	if(p!=null&&checkGameEnd(p))
	            	{
	            		//Exit game
	            		 gameOver newFrame=new gameOver();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
	            		
	            	}
	            }*/
	        }

	        if (key == KeyEvent.VK_UP) {
	        	
	        	playSound("button-3.wav");
	            B.move(1);
	           showImageOnCell(labels);
	          
	          /* p=randomGenerator();
	           clearBoard(labels);
	         
	            showImageOnCell(labels);
	           lblNewLabel_1.setText(Integer.toString(B.score));
	            int end=B.isGameEnd();
	            if(end==1)
	            {
	            	 WinWindow newFrame=new WinWindow();
					    newFrame.setVisible(true);
					    newFrame.label.setText(Integer.toString(B.score));
					    newFrame.setBounds(100, 100,476,429);
	            }
	            else if(end==2)
	            {
	            	if(p!=null&&checkGameEnd(p))
	            	{
	            		//Exit game
	            		 gameOver newFrame=new gameOver();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
	            		
	            	}
	            }*/
	        }

	        if (key == KeyEvent.VK_DOWN) {
	        	
	        	playSound("button-3.wav");
	           B.move(2);
	           showImageOnCell(labels);
	           
	           /*p=randomGenerator();
	           clearBoard(labels);
	          
	           showImageOnCell(labels);
	           lblNewLabel_1.setText(Integer.toString(B.score));
	          // randomGenerator();
	           int end=B.isGameEnd();
	           if(end==1)
	            {
	            	 WinWindow newFrame=new WinWindow();
					    newFrame.setVisible(true);
					    newFrame.label.setText(Integer.toString(B.score));
					    newFrame.setBounds(100, 100,476,429);
	            }
	            else if(end==2)
	            {
	            	if(p!=null&&checkGameEnd(p))
	            	{
	            		//Exit game
	            		 gameOver newFrame=new gameOver();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
	            		
	            	}
	            }*/
	        }
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			 int key =arg0.getKeyCode();
		        Pair p;
		        
		        if (key == KeyEvent.VK_LEFT) {
		        	
		           /* B.move(4);
		           showImageOnCell(labels);*/
		        	
		           
		            p=randomGenerator();
		            clearBoard(labels);
		           
		            showImageOnCell(labels);
		           lblNewLabel_1.setText(Integer.toString(B.score));
		            int end=B.isGameEnd();
		            if(end==1)
		            {
		            	 WinWindow newFrame=new WinWindow();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
						   // frame.dispose();
		            }
		            else if(end==2)
		            {
		            	if(p!=null&&B.checkGameEnd())
		            	{
		            		//Exit game
		            		 gameOver newFrame=new gameOver();
							    newFrame.setVisible(true);
							    newFrame.label.setText(Integer.toString(B.score));
							    newFrame.setBounds(100, 100,476,429);
							    //frame.dispose();
		            		
		            	}
		            }
		            
		        }

		        if (key == KeyEvent.VK_RIGHT) {
		        	
		          /* B.move(3);
		          showImageOnCell(labels);*/
		           
		           p=randomGenerator();
		           clearBoard(labels);
		          
		           showImageOnCell(labels);
		           lblNewLabel_1.setText(Integer.toString(B.score));
		           int end=B.isGameEnd();
		           if(end==1)
		            {
		            	 WinWindow newFrame=new WinWindow();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
						    //frame.dispose();
		            }
		            else if(end==2)
		            {
		            	if(p!=null&&B.checkGameEnd())
		            	{
		            		//Exit game
		            		 gameOver newFrame=new gameOver();
							    newFrame.setVisible(true);
							    newFrame.label.setText(Integer.toString(B.score));
							    newFrame.setBounds(100, 100,476,429);
							   // frame.dispose();
		            		
		            	}
		            }
		        }

		        if (key == KeyEvent.VK_UP) {
		        	
		           /* B.move(1);
		           showImageOnCell(labels);*/
		          
		           p=randomGenerator();
		           clearBoard(labels);
		         
		            showImageOnCell(labels);
		           lblNewLabel_1.setText(Integer.toString(B.score));
		            int end=B.isGameEnd();
		            if(end==1)
		            {
		            	 WinWindow newFrame=new WinWindow();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
						   // frame.dispose();
		            }
		            else if(end==2)
		            {
		            	if(p!=null&&B.checkGameEnd())
		            	{
		            		//Exit game
		            		 gameOver newFrame=new gameOver();
							    newFrame.setVisible(true);
							    newFrame.label.setText(Integer.toString(B.score));
							    newFrame.setBounds(100, 100,476,429);
							    //frame.dispose();
		            		
		            	}
		            }
		        }

		        if (key == KeyEvent.VK_DOWN) {
		        	
		          /* B.move(2);
		           showImageOnCell(labels);*/
		           
		           p=randomGenerator();
		           clearBoard(labels);
		          
		           showImageOnCell(labels);
		           lblNewLabel_1.setText(Integer.toString(B.score));
		          // randomGenerator();
		           int end=B.isGameEnd();
		           if(end==1)
		            {
		            	 WinWindow newFrame=new WinWindow();
						    newFrame.setVisible(true);
						    newFrame.label.setText(Integer.toString(B.score));
						    newFrame.setBounds(100, 100,476,429);
						    //frame.dispose();
		            }
		            else if(end==2)
		            {
		            	if(p!=null&&B.checkGameEnd())
		            	{
		            		//Exit game
		            		 gameOver newFrame=new gameOver();
							    newFrame.setVisible(true);
							    newFrame.label.setText(Integer.toString(B.score));
							    newFrame.setBounds(100, 100,476,429);
							    //frame.dispose();
		            		
		            	}
		            }
		        }
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		} });
		 
		
		
		
	}
}

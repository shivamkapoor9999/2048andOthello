package Othello;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import FinalGame.Menu;
import FinalGame.Welcome;
import game2048.game2048;

import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;



public class GUI {

	JFrame frame;
	private boolean playerturn=true;
	static ArrayList<predictedcell> array=new ArrayList<predictedcell>();
	int gamestart=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void showpredictedcells(ArrayList<predictedcell> array,MyButton[][] Button)
	{
		ablebutton(Button);
		for(int i=0;i<array.size();i++)
		{
			//Button[array.get(i).a][array.get(i).b].setBackground(new Color(51, 204, 0));
			MyButton but=Button[array.get(i).a][array.get(i).b];
			 but.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	MyButton But=(MyButton)(evt.getSource());
			    	But.setBackground(new Color(51, 204, 0));
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	MyButton But=(MyButton)(evt.getSource());
			    	But.setBackground(new Color(0, 128, 0));
			    }
			});
		}
		disablebutton(Button);
	}
	public static void hidecell(ArrayList<predictedcell> array,MyButton[][] Button)
	{
		for(int i=0;i<array.size();i++)
		{
			//Button[array.get(i).a][array.get(i).b].setBackground(new Color(0, 128, 0));
			MyButton but=Button[array.get(i).a][array.get(i).b];
			 but.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	MyButton But=(MyButton)(evt.getSource());
				    	But.setBackground(new Color(0, 128, 0));
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	MyButton But=(MyButton)(evt.getSource());
				    	But.setBackground(new Color(0, 128, 0));
				    }
				});
		}
	}
	public static void showimage(MyButton[][] Buttons)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(Board.array[i][j]==1)
				{
					//black image;
					Image img2=new ImageIcon(Buttons[i][j].getClass().getResource("blackcellextrasmall.jpg")).getImage();
					Buttons[i][j].setIcon(new ImageIcon(img2));
				}
				else if(Board.array[i][j]==0)
				{
					//white image;
					Image img2=new ImageIcon(Buttons[i][j].getClass().getResource("whitecellextrasmall.jpg")).getImage();
					Buttons[i][j].setIcon(new ImageIcon(img2));
				}
			}
		}
	}
	public static Total count(MyButton[][] Buttons)
	{
		Total t=new Total();
		int count1=0;
		int count2=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(Board.array[i][j]==1)
				{
					count1++;
				}
				else if(Board.array[i][j]==0)
				{
					count2++;
				}
			}
		}
		t.black=count1;
		t.white=count2;
		return t;
	}
	public static void disablebutton(MyButton[][] Buttons)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				int flag=0;
				for(int k=0;k<array.size();k++)
				{
				    if((i==array.get(k).a&&j==array.get(k).b)||(Board.array[i][j])==1||(Board.array[i][j]==0))
				    {
				    	flag=1;
				    	break;
				    }
				}
				if(flag==0)
				{
					Buttons[i][j].setEnabled(false);
				}
			}
		}
	}
	public static void ablebutton(MyButton[][] Buttons)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				Buttons[i][j].setEnabled(true);
			}
		}
	}
	public static boolean isboardfull(MyButton[][] Buttons)
	{
		int flag=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(Board.array[i][j]==-1)
				{
					flag=1;
					break;
				}
			}
		}
		if(flag==0)
			return true;
		else
			return false;
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
	
	

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(new Rectangle(100,100,702,504));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED, 3, true));
		//panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 102, 51));
		panel.setBounds(493, 18, 169, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelPlayer1 = new JLabel("Player 1");
		labelPlayer1.setForeground(Color.YELLOW);
		Image img=new ImageIcon(this.getClass().getResource("blackcellextrasmall.jpg")).getImage();
		labelPlayer1.setIcon(new ImageIcon(img));
		labelPlayer1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPlayer1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelPlayer1.setBounds(0, 5, 135, 50);
		panel.add(labelPlayer1);
		
		JLabel player1Score = new JLabel("");
		player1Score.setFont(new Font("Tahoma", Font.BOLD, 22));
		player1Score.setForeground(new Color(255, 102, 0));
		player1Score.setBounds(101, 53, 46, 25);
		panel.add(player1Score);
		
		JLabel labelTotal1 = new JLabel("Total :-");
		labelTotal1.setForeground(Color.YELLOW);
		labelTotal1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTotal1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelTotal1.setBounds(0, 53, 91, 29);
		panel.add(labelTotal1);
		
		JPanel panel_1 = new JPanel();
		//panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(0, 102, 51));
		panel_1.setLayout(null);
		panel_1.setBounds(493, 123, 169, 83);
		frame.getContentPane().add(panel_1);
		
		JLabel labelPlayer2 = new JLabel("Player 2");
		labelPlayer2.setForeground(Color.YELLOW);
		Image img2=new ImageIcon(this.getClass().getResource("whitecellextrasmall.jpg")).getImage();
		labelPlayer2.setIcon(new ImageIcon(img2));
		labelPlayer2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPlayer2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelPlayer2.setBounds(0, 5, 135, 50);
		panel_1.add(labelPlayer2);
		
		JLabel player2score = new JLabel("");
		player2score.setFont(new Font("Tahoma", Font.BOLD, 22));
		player2score.setForeground(new Color(255, 102, 0));
		player2score.setBounds(101, 56, 46, 25);
		panel_1.add(player2score);
		
		JLabel labelTotal2 = new JLabel("Total :-");
		labelTotal2.setForeground(Color.YELLOW);
		labelTotal2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTotal2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelTotal2.setBounds(0, 54, 91, 29);
		panel_1.add(labelTotal2);
		
		JButton btnNewButton_1 = new JButton("Start New Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_1.setBackground(new Color(0, 102, 0));
		
		btnNewButton_1.setForeground(new Color(255, 204, 0));
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(506, 237, 135, 37);
		frame.getContentPane().add(btnNewButton_1);
		
	
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
			}
		});
		btnExit.setForeground(new Color(255, 204, 0));
		btnExit.setBackground(new Color(0, 102, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(526, 314, 89, 23);
		frame.getContentPane().add(btnExit);
		
		
		int a=10;
		int b=11;
		MyButton[][] Buttons=new MyButton[8][8];
		
		for(int i=0;i<8;i++)
		{
			a=10;
			for(int j=0;j<8;j++)
			{
				Buttons[i][j]=new MyButton(i,j);
				Buttons[i][j].setBounds(a,b,55,55);
				Buttons[i][j].setBackground(new Color(0, 128, 0));
				frame.getContentPane().add(Buttons[i][j]);
				a=a+55;
			}
			b=b+55;
		}
		JButton btnNewButton_2 = new JButton("Pass");
		btnNewButton_2.setForeground(new Color(255, 204, 0));
		btnNewButton_2.setBackground(new Color(0, 102, 0));
		if(array==null||gamestart==0)
		{
			btnNewButton_2.setEnabled(true);
		}
		else{
			btnNewButton_2.setEnabled(false);
		}
		showimage(Buttons);
		Total t=count(Buttons);
		player1Score.setText(Integer.toString(t.black));
		player2score.setText(Integer.toString(t.white));
		array=GameManager.cellprediction(1);
		showpredictedcells(array,Buttons);
		for(int i=0;i<8;i++)
		{
			
			for(int j=0;j<8;j++)
			{
				Buttons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MyButton But=(MyButton)(e.getSource());
						if(playerturn==true)
						{
							//player1=1 black
							 playSound("button-3.wav");
							gamestart=1;
							int valid=GameManager.dochanges(But.x,But.y,1);
							if(valid==1)
							{
								if(array==null||gamestart==0)
								{
									btnNewButton_2.setEnabled(true);
								}
								else{
									btnNewButton_2.setEnabled(false);
								}
							hidecell(array,Buttons);
							showimage(Buttons);
							array=GameManager.cellprediction(0);
							showpredictedcells(array,Buttons);
							
							Total t=count(Buttons);
							player1Score.setText(Integer.toString(t.black));
							player2score.setText(Integer.toString(t.white));
							panel.setBorder(new LineBorder(null));
							panel_1.setBorder(new LineBorder(Color.RED, 3, true));
							playerturn=!playerturn;
							if(isboardfull(Buttons))
							{
								int black=Integer.parseInt(player1Score.getText());
								int white=Integer.parseInt(player2score.getText());
								if(black>white)
								{
									 WinWindow newFrame=new WinWindow();
									    newFrame.setVisible(true);
									    newFrame.label.setText(Integer.toString(t.black));
										   newFrame.lblNewLabel_4.setText(Integer.toString(t.white));
									    newFrame.setBounds(200,100,500,500);
									    newFrame.lblNewLabel_1.setText("Player 1");
									    frame.dispose();
								}
								else if(white>black)
								{
									 WinWindow newFrame=new WinWindow();
									    newFrame.setVisible(true);
									    newFrame.label.setText(Integer.toString(t.black));
										   newFrame.lblNewLabel_4.setText(Integer.toString(t.white));
									    newFrame.setBounds(200,100,500,500);
									    newFrame.lblNewLabel_1.setText("Player 2");
									    frame.dispose();
								}
								ablebutton(Buttons);
							}
							}
		
						}
						else{
							//player2=0 white
							 playSound("button-3.wav");
							int valid=GameManager.dochanges(But.x,But.y,0);
							if(valid==1)
							{
								if(array==null||gamestart==0)
								{
									btnNewButton_2.setEnabled(true);
								}
								else{
									btnNewButton_2.setEnabled(false);
								}
							hidecell(array,Buttons);
							showimage(Buttons);
							array=GameManager.cellprediction(1);
							showpredictedcells(array,Buttons);
							
							Total t=count(Buttons);
							player1Score.setText(Integer.toString(t.black));
							player2score.setText(Integer.toString(t.white));
							panel_1.setBorder(new LineBorder(null));
							panel.setBorder(new LineBorder(Color.RED, 3, true));
							playerturn=!playerturn;
							if(isboardfull(Buttons))
							{
								int black=Integer.parseInt(player1Score.getText());
								int white=Integer.parseInt(player2score.getText());
								if(black>white)
								{
									 WinWindow newFrame=new WinWindow();
									   newFrame.label.setText(Integer.toString(t.black));
									   newFrame.lblNewLabel_4.setText(Integer.toString(t.white));
									    newFrame.setVisible(true);
									    newFrame.setBounds(200,100,500,500);
									    newFrame.lblNewLabel_1.setText("Player 1");
									    frame.dispose();
								}
								else if(white>black)
								{
									 WinWindow newFrame=new WinWindow();
									 newFrame.label.setText(Integer.toString(t.black));
									   newFrame.lblNewLabel_4.setText(Integer.toString(t.white));
									    newFrame.setVisible(true);
									    newFrame.setBounds(200,100,500,500);
									    newFrame.lblNewLabel_1.setText("Player 2");
									    frame.dispose();
								}
								ablebutton(Buttons);
							}
							}
						}
						
					}
					});
				
			}
	
		}
		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(array==null||gamestart==0)
				{
					
				if(playerturn==true)
				{
					//player1 convert ti player2
					hidecell(array,Buttons);
					showimage(Buttons);
					array=GameManager.cellprediction(0);
					showpredictedcells(array,Buttons);
					
					Total t=count(Buttons);
					player1Score.setText(Integer.toString(t.black));
					player2score.setText(Integer.toString(t.white));
					panel.setBorder(new LineBorder(null));
					panel_1.setBorder(new LineBorder(Color.RED, 3, true));
					playerturn=!playerturn;
					
				}
				else{
					//player2 convert to player1
					hidecell(array,Buttons);
					showimage(Buttons);
					array=GameManager.cellprediction(1);
					showpredictedcells(array,Buttons);
					
					Total t=count(Buttons);
					player1Score.setText(Integer.toString(t.black));
					player2score.setText(Integer.toString(t.white));
					panel_1.setBorder(new LineBorder(null));
					panel.setBorder(new LineBorder(Color.RED, 3, true));
					playerturn=!playerturn;
					
				}
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(526, 280, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			    frame.dispose();
			}
		});
		btnMainMenu.setForeground(new Color(255, 204, 0));
		btnMainMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMainMenu.setBackground(new Color(0, 102, 0));
		btnMainMenu.setBounds(519, 348, 112, 37);
		frame.getContentPane().add(btnMainMenu);
		
		JLabel lblNewLabel = new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("backgroundlarge.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img4));
		lblNewLabel.setBounds(0, 0, 696, 466);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
	public Rectangle getFrameBounds() {
		return frame.getBounds();
	}
	public void setFrameBounds(Rectangle bounds) {
		frame.setBounds(bounds);
	}
	public Rectangle getFrameBound() {
		return frame.getBounds();
	}
	public void setFrameBound(Rectangle bounds_1) {
		frame.setBounds(bounds_1);
	}
}

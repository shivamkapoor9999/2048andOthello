package game2048;
import java.util.Queue;
import java.util.LinkedList;
public class Board {
	public int[][] board;
	public int boardSize;
	public int score=0;
	public Board(int boardSize)
	{
		this.boardSize=boardSize;
		board=new int[this.boardSize][this.boardSize];
	}
	public void removeSpaces(int direction)
	{
		//up=1;
		//down=2;
		//right=3;
		//left=4;
		Queue<Integer> queue=new LinkedList<>();
		if(direction==2)
		{
			for(int j=0;j<4;j++)
			{
				for(int i=3;i>=0;i--)
				{
					if(board[i][j]!=0)
						queue.add(board[i][j]);
				}
				//System.out.println(queue.size());
				for(int i=3;i>=0;i--)
				{
					if(queue.size()!=0)
					{
					board[i][j]=queue.peek();
					queue.remove();
					}
					else{
						board[i][j]=0;
					}
				}
				/*for(int i=0;i<4;i++)
				{
					System.out.print(board[j][i]+" ");
				}
				System.out.println();*/
			}
		}
		else if(direction==1)
		{
			for(int j=0;j<4;j++)
			{
				for(int i=0;i<4;i++)
				{
					if(board[i][j]!=0)
						queue.add(board[i][j]);
				}
				for(int i=0;i<4;i++)
				{
					if(queue.size()!=0)
					{
					board[i][j]=queue.peek();
					queue.remove();
					}
					else{
						board[i][j]=0;
					}
				}
			}
		}
		else if(direction==4)
		{
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(board[i][j]!=0)
						queue.add(board[i][j]);
				}
				for(int j=0;j<4;j++)
				{
					if(queue.size()!=0)
					{
					board[i][j]=queue.peek();
					queue.remove();
					}
					else{
						board[i][j]=0;
					}
				}
			}
		}
		else if(direction==3)
		{

			for(int i=0;i<4;i++)
			{
				for(int j=3;j>=0;j--)
				{
					if(board[i][j]!=0)
						queue.add(board[i][j]);
				}
				for(int j=3;j>=0;j--)
				{
					if(queue.size()!=0)
					{
					board[i][j]=queue.peek();
					queue.remove();
					}
					else{
						board[i][j]=0;
					}
				}
			}
		}
		
		
	}
	public void move(int direction)
	{
		
		//up=1;
		//down=2;
		//right=3;
		//left=4;
		this.removeSpaces(direction);
		if(direction==2)
		{
			for(int j=0;j<4;j++)
			{
				for(int i=0;i<3;)
				{
					if(board[i][j]!=0)
					{
						if(board[i][j]==board[i+1][j])
						{
							board[i+1][j]=board[i+1][j]+board[i][j];
							score=score+board[i+1][j];
							board[i][j]=0;
							i++;
						}
						
					}
					i++;
				}
			}
		}
		else if(direction==1)
		{
			for(int j=0;j<4;j++)
			{
				for(int i=3;i>0;)
				{
					if(board[i][j]!=0)
					{
						if(board[i][j]==board[i-1][j])
						{
							board[i-1][j]=board[i-1][j]+board[i][j];
							score=score+board[i-1][j];
							board[i][j]=0;
							i--;
						}
						
					}
					i--;
				}
			}
		}
		else if(direction==3)
		{
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<3;)
				{
					if(board[i][j]!=0)
					{
						if(board[i][j]==board[i][j+1])
						{
							board[i][j+1]=board[i][j+1]+board[i][j];
							score=score+board[i][j+1];
							board[i][j]=0;
							j++;
						}
						
					}
					j++;
				}
			}
		}
		else if(direction==4)
		{
			for(int i=0;i<4;i++)
			{
				for(int j=3;j>0;)
				{
					if(board[i][j]!=0)
					{
						if(board[i][j]==board[i][j-1])
						{
							board[i][j-1]=board[i][j-1]+board[i][j];
							
							score=score+board[i][j-1];
							board[i][j]=0;
							j--;
						}
					}
					j--;
				}
			}
		}
		this.removeSpaces(direction);
		
	}
	public int isGameEnd()
	{
		int flag=0;
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(board[i][j]==2048)
				{
					return 1;
				}
				if(board[i][j]==0)
				{
					flag=1;
					break;
				}
			}
		}
		if(flag==0)
		{
			return 2;
		}
		else{
			return 3;
		}
	}
	public boolean checkGameEnd()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length-1;j++)
			{
				if(board[i][j]==board[i][j+1])
				{
					return false;
				}
			}
		}
		for(int j=0;j<board.length;j++)
		{
			for(int i=0;i<board.length-1;i++)
			{
				if(board[i][j]==board[i+1][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
}

package Othello;
import java.util.ArrayList;
public class GameManager {
	public static ArrayList<predictedcell> cellprediction(int player)
	{
		ArrayList<predictedcell> arr=new ArrayList<predictedcell>();
		int p;
		int count;
		if(player==0)
		{
			p=1;
		}
		else{
			p=0;
		}
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(Board.array[i][j]==player)
				{
					//east
					count=0;
					for(int tj=j+1;tj<7;tj++)
					{
						if(Board.array[i][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i][j+count+1]==-1)
						{
							predictedcell predic=new predictedcell(i,j+count+1);
							arr.add(predic);
						}
					}
					//west
					count=0;
					for(int tj=j-1;tj>0;tj--)
					{
						if(Board.array[i][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i][j-count-1]==-1)
						{
							predictedcell predic=new predictedcell(i,j-count-1);
							arr.add(predic);
						}
					}
					//north
					count=0;
					for(int ti=i-1;ti>0;ti--)
					{
						if(Board.array[ti][j]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i-count-1][j]==-1)
						{
							predictedcell predic=new predictedcell(i-count-1,j);
							arr.add(predic);
						}
					}
					//south
					count=0;
					for(int ti=i+1;ti<7;ti++)
					{
						if(Board.array[ti][j]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i+count+1][j]==-1)
						{
							predictedcell predic=new predictedcell(i+count+1,j);
							arr.add(predic);
						}
					}
					//east-north
					count=0;
					for(int ti=i-1,tj=j+1;ti>0&&tj<7;ti--,tj++)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i-count-1][j+count+1]==-1)
						{
							predictedcell predic=new predictedcell(i-count-1,j+count+1);
							arr.add(predic);
						}
					}
					//west-north
					count=0;
					for(int ti=i-1,tj=j-1;ti>0&&tj>0;ti--,tj--)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i-count-1][j-count-1]==-1)
						{
							predictedcell predic=new predictedcell(i-count-1,j-count-1);
							arr.add(predic);
						}
					}
					//east-south
					count=0;
					for(int ti=i+1,tj=j+1;ti<7&&tj<7;ti++,tj++)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i+count+1][j+count+1]==-1)
						{
							predictedcell predic=new predictedcell(i+count+1,j+count+1);
							arr.add(predic);
						}
					}
					//west-south
					count=0;
					for(int ti=i+1,tj=j-1;ti<7&&tj>0;ti++,tj--)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i+count+1][j-count-1]==-1)
						{
							predictedcell predic=new predictedcell(i+count+1,j-count-1);
							arr.add(predic);
						}
					}
					
				}
			}
		}
		
		return arr;
	}
	
	public static int dochanges(int i,int j,int player)
	{
		if(Board.array[i][j]==1||Board.array[i][j]==0)
		{
			return 0;
		}
		Board.array[i][j]=player;
		int p;
		int count;
		if(player==0)
		{
			p=1;
		}
		else{
			p=0;
		}
		
					//east
					count=0;
					for(int tj=j+1;tj<7;tj++)
					{
						if(Board.array[i][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i][j+count+1]==player)
						{
							int h=j+count+1;
							for(int tj=j+1;tj<h;tj++)
							{
								Board.array[i][tj]=player;
							}
						}
					}
					//west
					count=0;
					for(int tj=j-1;tj>0;tj--)
					{
						if(Board.array[i][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i][j-count-1]==player)
						{
							int h=j-count-1;
							for(int tj=j-1;tj>h;tj--)
							{
								Board.array[i][tj]=player;
							}
						}
					}
					//north
					count=0;
					for(int ti=i-1;ti>0;ti--)
					{
						if(Board.array[ti][j]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i-count-1][j]==player)
						{
							int h=i-count-1;
							for(int ti=i-1;ti>h;ti--)
							{
								Board.array[ti][j]=player;
							}
						}
					}
					//south
					count=0;
					for(int ti=i+1;ti<7;ti++)
					{
						if(Board.array[ti][j]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i+count+1][j]==player)
						{
							int h=i+count+1;
							for(int ti=i+1;ti<h;ti++)
							{
								Board.array[ti][j]=player;
							}
						}
					}
					//east-north
					count=0;
					for(int ti=i-1,tj=j+1;ti>0&&tj<7;ti--,tj++)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i-count-1][j+count+1]==player)
						{
							int h=i-count-1;
							int f=j+count+1;
							for(int ti=i-1,tj=j+1;ti>h&&tj<f;ti--,tj++)
							{
								Board.array[ti][tj]=player;
							}
						}
					}
					//west-north
					count=0;
					for(int ti=i-1,tj=j-1;ti>0&&tj>0;ti--,tj--)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i-count-1][j-count-1]==player)
						{
							int h=i-count-1;
							int f=j-count-1;
							for(int ti=i-1,tj=j-1;ti>h&&tj>f;ti--,tj--)
							{
								Board.array[ti][tj]=player;
							}
						}
					}
					//east-south
					count=0;
					for(int ti=i+1,tj=j+1;ti<7&&tj<7;ti++,tj++)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i+count+1][j+count+1]==player)
						{
							int h=i+count+1;
							int f=j+count+1;
							for(int ti=i+1,tj=j+1;ti<h&&tj<f;ti++,tj++)
							{
								Board.array[ti][tj]=player;
							}
						}
					}
					//west-south
					count=0;
					for(int ti=i+1,tj=j-1;ti<7&&tj>0;ti++,tj--)
					{
						if(Board.array[ti][tj]==p)
						{
							count++;
						}
						else{
							break;
						}
					}
					if(count>=1)
					{
						if(Board.array[i+count+1][j-count-1]==player)
						{
							int h=i+count+1;
							int f=j-count-1;
							for(int ti=i+1,tj=j-1;ti<h&&tj>f;ti++,tj--)
							{
								Board.array[ti][tj]=player;
							}
						}
					}
					return 1;
					
				
	}
}

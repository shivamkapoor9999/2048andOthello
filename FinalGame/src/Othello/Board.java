package Othello;

public class Board {
	static int[][] array={{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,1,0,-1,-1,-1},
	{-1,-1,-1,0,1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1}};
	
	public static void resetarray()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				array[i][j]=-1;
			}
		}
		array[3][3]=1;
		array[3][4]=0;
		array[4][3]=0;
		array[4][4]=1;
	}
}

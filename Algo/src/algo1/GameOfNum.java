package algo1;

import java.util.Arrays;

public class GameOfNum {
	public static int[][] BuildMath(int[] game){
		int size= game.length;
		int [][]ans= new int[size][size];
		for(int i=0;i<size;i++)
			ans[i][i]=game[i];
		for(int i = size-2; i >=0 ; i--) {
			for(int j = i+1; j < size; j++){
				int x=game[i]-ans[i+1][j];
				int y= game[j]-ans[i][j-1];
				int max= Math.max(x, y);
				ans[i][j]=max;				
			}
		}
		return ans;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,3,6,5,3,6};
		int[][] math =BuildMath(arr);
		int n= math.length;
		int i=0;
		int j=n-1;
		int first=0;
		int second=0;
		int player1=0;
		int player2=0;
		//player one turn
		for (int turn=0; turn<n; turn+=2)  {
			if(i==j) {
				first=i;
				player1+=arr[i];
			}
			else {
			if(arr[i]-math[i+1][j]>arr[j]-math[i][j-1]) {
				first=i;
				player1=player1+arr[i];
				i++;

			}
			else {
				first=j;
				player1=player1+arr[j];
				j--;

			}
			//player second turn
			if(j>i) {
				if(arr[i]-math[i+1][j]>arr[j]-math[i][j-1]) {
					second=i;
					player2=player2+arr[i];
					i++;

				}
				else {
					second=j;
					player2=player2+arr[j];
					j--;

				}

			}
			else player2+= arr[j];//if the last round and player 2 doesnt have any choice 
			}
			System.out.println("player1 take the number : "+arr[first]);
			System.out.println("player2 take the number : "+arr[second]);
			System.out.println();
			System.out.println("sum of player1= "+player1);
			System.out.println("sum of player2= "+player2);
			System.out.println();

		}

		System.out.println("sum of player1= "+player1);
		System.out.println("sum of player2= "+player2);
		for(int k=0;k<math.length;k++) System.out.println(Arrays.toString(math[k]));
	}
}

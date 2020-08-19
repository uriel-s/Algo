package lcm;

import maxmax.max;

final class lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="uriel";
		String s2="urielsachslamakahahazah";
		int [][]m = BuildMatrix(s1, s2);
		int i=m.length-1;
		int j=m[0].length-1;	
		int Lcm= m[i][j];
		String ans="";
	int start=0;
		while(start<Lcm) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				ans= s1.charAt(i-1)+ans;
				i--;
				j--;
				start++;
	
			}
			else if(m[i-1][j]==m[i][j-1])	i--;
			else j--;
			
		}
	System.out.println(ans);
	}


	public static int[][] BuildMatrix(String s1, String s2){
		//		String lcm="";
		int row =s1.length()+1;
		int col = s2.length()+1;		
		int[][] M= new int[row][col];
		for(int i =0;i<row;i++) M[i][0]=0;
		for(int j=0; j<col;j++)M[0][j]=0;
		
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))  M[i][j]=M[i-1][j-1]+1;
				else {
					int x= M[i][j-1];
					int y= M[i-1][j];
					M[i][j]=Math.max(x, y);
				}
			}
		}

		return M;
	}
}

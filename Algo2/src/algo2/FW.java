package algo2;

public class FW {

	public static void main(String[] args) {

		int n=3;
		int m =2;
		int size = (n+1)*(m+1);
		int[][] Matrix=initRibs(n,m);	
		//print (Matrix);
		System.out.println();
		System.out.println();
		boolean[][] Matrix2 = {{true,true,false,false,false},{true,true,false,false,false},
				{false,false,true,true,false},{false,false,true,true,false},{false,false,false,false,true}};
		//	HowManyComponents(Matrix);
	}

	public static int[][] initRibs(int n, int m) {
		System.out.println("The maximum value of the first bottle(n) = "+n);
		System.out.println("The maximum value of the second bottle(m) = "+m);
		System.out.println("********************["+n+","+m+"]********************");
		System.out.println("*********************************************\n"); 

		int dim = (n+1)*(m+1);//  מספר הקודקודים בגרף 
		int mat[][] = new int[dim][dim];
		int ind1, ind2;   
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=m; j++) {     ind1 = getIndex(i,j,m); 
			mat[ind1][getIndex(0,j,m)] = 1; // Rib 1 
			mat[ind1][getIndex(n,j,m)] = 1; // Rib 2
			mat[ind1][getIndex(i,0,m)] = 1; // Rib 3 
			mat[ind1][getIndex(i,m,m)] = 1; // Rib 4 
			ind2 = getIndex(Math.min(i+j,n), i+j-Math.min(i+j,n),m); 
			mat[ind1][ind2] = 1; // Rib 5 
			ind2 = getIndex(i+j-Math.min(i+j,m), Math.min(i+j,m),m);
			mat[ind1][ind2] = 1; // Rib 6 
			}
		}    
		for (int t=0; t<dim; t++) mat[t][t] = 0;
		return mat;
	}



	public static	int[][]	Find_Neighbor2(int matrix[][]){//get matrix of Neighbor and return matrix all shortest passes
		int n = matrix.length;
		int [][] ans = new int[n][n];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j]=Math.min(matrix[i][k]+matrix[k][j],matrix[i][j]);
				}
			}
		}
		return ans;}



	public static String[][] ConnectPossibleVertex(boolean mat[][],int m) {
		int dim = mat.length;
		int a0=0, b0=0, a1=0, b1=0;
		String path[][] = new String[dim][dim];
		for (int i=0; i<dim; i++) {
			for (int j=0; j<dim; j++) {
				a0 = i / (m+1);
				b0 = i % (m+1);
				a1 = j / (m+1);
				b1 = j % (m+1);
				if (mat[i][j]==true) path[i][j] =
						"["+a0+","+b0+"]-D->["+a1+","+b1+"]";
				else path[i][j] = new String();
			}
		}
		for (int k=0; k<dim; k++) {
			for (int i=0; i<dim; i++) {
				for (int j=0; j<dim; j++) {
					if (mat[i][j]==false) {
						mat[i][j] = mat[i][k] && mat[k][j];
						if (mat[i][j] == true) {
							path[i][j] =
							path[i][k] + " >-i-> " + path[k][j];
						}
					}
				}
			}
		}
		return path;
	}





private static int getIndex(int i, int j, int n) {
	return (n+1)*i +j;
}

public static void print(boolean  [][] matrix ){
	int n  =matrix.length;
	int m  =matrix[0].length;
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < m; j++) {
			System.out.print(matrix[i][j]+"\t");

		}
		System.out.println();
	}

}


public static int HowManyComponents(boolean matAfterFW[][]) {
	int count = 0;
	int dim = matAfterFW.length;
	int comps[] = new int[dim];
	for (int i=0; i<dim; i++) {
		if (comps[i]==0) count++;
		for (int j=i; j<dim; j++) {
			if (comps[j]==0 && matAfterFW[i][j]) {comps[j] = count;}// System.out.println(comps[j]) ;}
		}
	}
	System.out.println("num of combs = "+count);

	for (int i=0; i<comps.length; i++) {    System.out.println(i+" combs : " + comps[i]);   }   



	String cs[] = new String[count]; 
	for (int i=0; i<count; i++) {    cs[i] = "";   }   
	for (int i=0; i<dim; i++) cs[comps[i]-1] = cs[comps[i]-1]+ i +"\t";
	for (int i=0; i<count; i++) System.out.println(cs[i].toString());

	return count;

}
}
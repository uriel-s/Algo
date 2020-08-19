package algo1;

public class Fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(fibo(6));
	}

	public static int fibo(int n) {
		int[][] m = {{1,1},{1,0}};
		int[][] ans = fibo(m,n-1);
		return ans[0][0];
	}

	private static int[][] fibo(int[][] m, int n) {
		int[][]A={{1,0},{0,1}};
		if(n==0) return A; 
		if(n%2==0) return fibo(matrixSq2Multi(m,m),n/2);
		return matrixSq2Multi (m ,fibo(matrixSq2Multi(m,m),(n-1)/2));
	}

	static int[][] matrixSq2Multi(int[][] m1, int m2[][]){
	int[][]ans = new int [2][2];
	ans[0][0] = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];
	ans[0][1] = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];
	ans[1][0] = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];
	ans[1][1] = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1];
	return ans;
}
	
	
}

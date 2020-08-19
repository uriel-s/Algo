package LIS;

import java.util.Arrays;

public class Lis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int [] arr= new int[]{8,4,12,2,14,10,3,5,6,7};
int[] ans= Lis(arr);
System.out.println( Arrays.toString(ans) );  
	}

	
	public static int[]Lis(int arr[]){
		int lis=1;
		int n= arr.length;
		int[][] m= new int[n][n];
		m[0][0]=arr[0];
		for(int i=1;i<n;i++) {
		int index= BSB(m,lis,arr[i])	;
		System.out.println("index from bsb = "+index);
		for(int j=0;j<index;j++)  m[index][j]=m[index-1][j];
		m[index][index]=arr[i];
		//need to check
		if(index==lis) lis++;
		//for(int j=0;j<n;j++)System.out.println(  Arrays.toString(m[j]) );  

		}
		
		int ans[]= new int[lis];
		for(int i=0;i<lis;i++) {
			ans[i]=m[lis-1][i];

		}
		
		return ans;	
	}


	private static int BSB(int[][] m, int lis, int x) {
		// TODO Auto-generated method stub
	if (x<m[0][0]) return 0;
	if (x>m[lis-1][lis-1])return lis;
	int start =0; int end =lis;
		while(start<=end) {
			if(start==end) return start;
			int mid =(start+end)/2;
		if(m[mid][mid]==x)return mid;
			if(x<m[mid][mid]) end=mid;
			else start=mid+1;
		}		
		return -1; 
	}




}

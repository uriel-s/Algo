package AirPlane;

import java.util.ArrayList;

public class BestPath {
	int teta;
	double BestPrice ;
	int Npaths;
	int NumOfTurns;
	//int NumOfOptimalPaths;
	double SecondPrice;
	int Npaths2;
	int NumOfTurns2;
	int NumOfOptimalPaths2;
	ArrayList<String> AllPaths;
	ArrayList<String> AllPaths2;
	Node[][]mat;

	public static class Node{
		double x;
		double y;
		double price;
		int Npaths;
		int Nchanges;
		boolean InPath;
		String way;
		public Node(double x,double y) {
			this.x=x;
			this.y=y;
			this.price=0;
			this.Nchanges=0;
			this.Npaths=1;
			this.InPath=false;
			this.way="";
		}
	}

	//constructor
	public BestPath() {


	} 

	//constructor
	public BestPath(Node[][]nodes,int teta ) {
		int Bounds=0;
		this.teta=teta;
		this.mat=nodes;
		this.AllPaths=new ArrayList<>();
		this.AllPaths2=new ArrayList<>();
		BestPath(mat);//send to build the matrix
		//CheapestPaths2();
		//getAllCheapestPaths();		

	} 



	public int getNumOfCheapestPaths() {

		//int n= mat.length-1;
		//int m= mat[0].length-1;
		//
		//return this.mat[n][m].Npaths;
		return this.Npaths;}


	public double getCheapestPrice(){
		//		int n= mat.length-1;
		//		int m= mat[0].length-1;
		//		return this.mat[n][m].price;	}
		return this.BestPrice;}
	//פונקציית מעטפת
	public ArrayList<String> getAllCheapestPaths(){
		int n=mat.length-1;
		int m=mat[0].length-1;
		return buildPaths(mat,n,m,"") ;	
	}


	//building all the paths recursive
	public ArrayList<String> buildPaths(Node[][]mat,int i,int j,String path){

		mat[i][j].InPath=true;//pait all the node that are in one(or more) Best path
		if (i==0 && j==0)
		{ 
			this.AllPaths.add(path);
		}
		else	if (i==0 && j>0)
		{
			buildPaths(mat,  i,  j-1, "0" + path);
		}

		else if (i>0 && j==0)
		{ 
			buildPaths(mat,  i-1,  j, "1" + path);
		}


		else	if (mat[i][j-1].price + mat[i][j-1].x < mat[i-1][j].price + mat[i-1][j].y)
		{
			buildPaths(mat,  i,  j-1, "0" + path);
		}

		else	if (mat[i][j-1].price + mat[i][j-1].x > mat[i-1][j].price + mat[i-1][j].y)
		{
			buildPaths(mat,  i-1,  j, "1" + path);
		} 
		else // they are equals
		{
			buildPaths(mat,  i-1,  j, "1" + path);
			buildPaths(mat,  i,  j-1, "0" + path);
		}

		return AllPaths;
	}



	public int getNumOfOptimalPaths(){
		int min= Integer.MAX_VALUE;
		int ans=0;
		for(int i =0;i<AllPaths.size();i++)
		{
			String s= AllPaths.get(i);
			int Changes= NumOfChanges(s);
			if (Changes<min) {//if there are optimalier Paths
				min = Changes; 
				ans =1;
			}
			else	if (Changes==min) ans++;// if there one more optimal paths
		}
		this.NumOfTurns=min;
		return ans; 
	}



	private int NumOfChanges(String s) {
		if(s.length()<2) return 1;
		int ans=0;	
		char a= s.charAt(0);
		for(int i=1;i<s.length();i++) {
			char b= s.charAt(i);
			if(b!=a) ans++;
			a=b;
		}	

		return ans;
	}



	public int printNumOfTurns() {
		getNumOfOptimalPaths();
		return this.NumOfTurns;
	}


	public ArrayList<String> getAllOptimalPaths(){
		int Changes =printNumOfTurns();
		ArrayList<String> ans= new ArrayList<String>();
		for(int i=0;i<AllPaths.size();i++) {
			String	s=AllPaths.get(i);
			if(NumOfChanges(s)==Changes) ans.add(s);
		}
		return ans;
	}



	public void BestPath(Node[][] mat){
		int n= mat.length;
		int m = mat[0].length;
		mat[0][0].price=0;
		for (int j = 1; j < mat[0].length; j++) {//intit the first row
			mat[0][j].price = mat[0][j-1].price + mat[0][j-1].x;
			mat[0][j].Npaths=1;

		}
		for (int i = 1; i < mat.length; i++) {//init the frist col
			mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y;
			mat[i][0].Npaths=1;
		}

		//init all the others Nodes in the Matrix 
		for(int i=1;i<n ;i++) {
			for (int j=1;j<m;j++) {
				double A= mat[i-1][j].y+mat[i-1][j].price;
				double B=mat[i][j-1].x+mat[i][j-1].price;
				//(take way from left Node or From up Node or from Both
				if(A<B) {
					mat[i][j].price= A; 
					mat[i][j].Npaths=mat[i-1][j].Npaths;
				}
				else if(A>B) {
					mat[i][j].price= B;
					mat[i][j].Npaths=mat[i][j-1].Npaths;
				}
				else {//a=b
					mat[i][j].price= B;
					mat[i][j].Npaths= mat[i][j-1].Npaths+mat[i-1][j].Npaths;
				}

			}
		}
		this.BestPrice=mat[n-1][m-1].price;
		this.Npaths=mat[n-1][m-1].Npaths;
		//  System.out.println("this is the num of paths "+mat[n-1][m-1].Npaths);

	}


	public double ShortPathBetween(Node[][] mat,int p1,int q1,int p2,int q2 ) {

				for(int i=0;i<mat.length;i++) {
					for (int j=0;j<mat[0].length;j++) {
						mat[i][j].way="";
					}
				}
		mat[p1][q1].price=0;
		mat[p1][q1].way="";
		for (int j = q1+1; j <= q2; j++) {//intit the first row
			mat[p1][j].price = mat[p1][j-1].price + mat[p1][j-1].x;
			mat[p1][j].way=mat[p1][j-1].way+"0";
		}
		for (int i = p1+1; i <=p2; i++) {//init the frist col
			mat[i][q1].price = mat[i-1][q1].price + mat[i-1][q1].y;
			mat[i][q1].way=mat[i-1][q1].way+"1";
		}
		for(int i=p1+1;i<=p2 ;i++) {
			for (int j=q1+1;j<=q2;j++) {
				double A= mat[i-1][j].y+mat[i-1][j].price;
				double B=mat[i][j-1].x+mat[i][j-1].price;
				//(take way from left Node or From up Node or from Both
				if(A<B) {
					mat[i][j].price= A; 
					mat[i][j].way=mat[i-1][j].way+"1";
				}
				else if(A>B) {//a=b
					mat[i][j].price= B;
					mat[i][j].way=mat[i][j-1].way+"0";
				}
				else {
					mat[i][j].price= B;
					mat[i][j].way=mat[i][j-1].way+"0";
				}

			}
		}

		return mat[p2][q2].price;		
	}

	public void CheapestPaths2()
	{ 				
		AllPaths2.clear();
		int NumOFCheapedt=0;
		double bestPrice=this.BestPrice;
		double second_price=Integer.MAX_VALUE;
		int n =mat.length;
		int m= mat[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//	if(!mat[i][j].InPath) {
				mat[i][j].way="";
				double first=ShortPathBetween(mat,0,0,i,j);
				String s= mat[i][j].way;	
				double End=ShortPathBetween(mat,i,j,n-1,m-1);
				String t=mat[n-1][m-1].way;
				s=s+t;
				double total=first+End;
				if(total==second_price ) {
					if(!AllPaths2.contains(s)) {
						NumOFCheapedt++;
						AllPaths2.add(s);

					}
				}
				if(total<second_price && total>bestPrice) {
					AllPaths2.clear();
					AllPaths2.add(s);
					second_price=total;
					NumOFCheapedt=1;
				}
			}
			//}
		}
		this.SecondPrice=second_price;
		this.Npaths2=NumOFCheapedt;

	}

	public int getNumOfCheapestPaths2()
	{ CheapestPaths2();
	return this.Npaths2;
	}

	public double getCheapestPrice2() {
		CheapestPaths2();
		if(this.SecondPrice==Integer.MAX_VALUE) return 0;
		return this.SecondPrice;
	}

	public ArrayList<String> getAllCheapestPaths2()
	{		CheapestPaths2();

		return this.AllPaths2;
	}

	public ArrayList<String> getAllOptimalPaths2(){		
		ArrayList<String> ans = new ArrayList<>();
		int min= Integer.MAX_VALUE;
		for(int i =0;i<AllPaths2.size();i++)
		{
			String s= AllPaths2.get(i);
			int Changes= NumOfChanges(s);
			 if (Changes==min) ans.add(s);// if there one more optimal paths

			if (Changes<min) {//if there are optimalier Paths
				ans.clear();
				ans.add(s);
				min = Changes; 
				NumOfTurns2 =Changes;
			}
		}
		this.NumOfOptimalPaths2=ans.size();
		return ans; 
	}
	public int getNumOfTurns2()
	{
		return NumOfTurns2;	
	}

	public int getNumOfOptimalPaths2()
	{ getAllOptimalPaths2();
		return NumOfOptimalPaths2;
	}

}







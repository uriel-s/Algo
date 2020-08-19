package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class tree {
	ArrayList<Integer>[] graph;//input the  child of every ver;
	int root;

	tree(ArrayList<Integer>[] g){
		graph=g;
		int root;
	}


//	public static void main(String[] args) {
//		int[][] graph = {
//				{0,0,0,1,0,0},
//				{0,0,0,1,1,1},
//				{0,0,0,1,1,1},
//				{1,1,1,0,0,0},
//				{0,1,1,0,0,0},				
//				{0,1,1,0,0,0},
//		};
//		Vector v = null ;
//		v.add(graph);
//		Vector v2 = null ;
//		v2.add(graph);
//	}
	
	public boolean isomorphsim(tree t1, tree t2) {
		int root1=getRoot(t1);
		int root2=getRoot(t2);

		return 		put_string(t1.root)==put_string(t2.root);
	}

	private int getRoot(tree t2) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String put_string(int v) {
		ArrayList<Integer> ch = graph[v];
		if(ch.size()==0) return "01";
		String ans ="0";
		ArrayList<String> strigns= new ArrayList<String>();

		for(int i=0;i<ch.size();i++) {
			strigns.add(put_string (ch.get(i)));
		}
		Collections.sort(strigns);
		for(String string : strigns) 
			ans += string;
		ans+="1";

		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer>[] g = new ArrayList[11]; 
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(1);
		g[1].add(0);g[1].add(2);g[1].add(5);
		g[2].add(1);g[2].add(3);
		g[3].add(2);
		g[4].add(5);
		g[5].add(1);g[5].add(4);g[5].add(6);g[5].add(8);
		g[6].add(5);g[6].add(7);
		g[7].add(6);
		g[8].add(5);g[8].add(9);
		g[9].add(8);g[9].add(10);
		g[10].add(9);
		
		ArrayList<Integer>[] g2 = new ArrayList[11]; 
		for (int i = 0; i < g2.length; i++) {
			g2[i] = new ArrayList<Integer>();
		}
		g2[0].add(1);g2[0].add(10);
		g2[1].add(0);g2[1].add(2);g2[1].add(5);
		g2[2].add(1);g2[2].add(3);
		g2[3].add(2);
		g2[4].add(5);
		g2[5].add(1);g2[5].add(4);g2[5].add(6);g2[5].add(8);
		g2[6].add(5);g2[6].add(7);
		g2[7].add(6);
		g2[8].add(5);g2[8].add(9);
		g2[9].add(8);
		g2[10].add(0);
		tree gg1 = new tree(g);
		tree gg2 = new tree(g2);

		System.out.println( gg1.isomorphsim(gg1,gg2) );		
	}

}




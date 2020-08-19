package euler;
import java.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class IsTree {

	public static void main(String[] args) {
		IsTree m = new IsTree();
		int[] tree={1,3,1,3,1,2,1,2};
		tree=m.tree_from_degree(tree);
		System.out.println(Arrays.toString(tree));
	}

	public boolean check_if_tree(int[]degree) {//בודר האם גרף כשיר הוא עץ
		int sum=0;
		for (int i = 0; i < degree.length; i++) 
			sum+=degree[i];
		return(sum==2*(degree.length-1) );
	}

	//return parents array (tree)
	public	int[] tree_from_degree(int[]degree) {
		check_if_tree(degree);
		int tree[]= new int[degree.length];
		Arrays.sort(degree);
		int v=0;
		while(degree[v]==1) {
			v++;
		}
		for (int i = 0; i < tree.length-2; i++) {
			tree[i]=v;
			degree[v]--;
			if(degree[v]==1) v++;
		}
		tree[tree.length-2]	=tree.length-1;
		tree[tree.length-1]=-1;//root have no parents
		return tree;
	}
}

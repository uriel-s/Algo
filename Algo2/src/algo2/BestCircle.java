package algo2;

import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BestCircle {
	int  p_array[];
	int  n_array[];
	int sum_of_array;
	int begin;
	int end;
	int sum_of_Circle;
	int size;


	public static void main(String[] args) {
		int arr[]= {1,-1,0,2};	
		BestCircle best= new BestCircle(arr);
		best.get_best_circle();
      best.printResult();
	}


	public BestCircle(int[] arr) {
		int len =arr.length;
		sum_of_array=arr[0];
		p_array= new int[len];
		n_array = new int[len];
		sum_of_array=0;
		for(int i=0; i<arr.length;i++) {
			p_array[i]=arr[i];
			n_array[i]=-1*arr[i];
			sum_of_array+=arr[i];
		}
	}
	public int get_best_circle() {

		best_array pos_best= new best_array(p_array); 
		pos_best.get_best();	
		best_array n_best= new best_array(n_array); 
		n_best.get_best();		

		if(pos_best.max<=0) {
			sum_of_Circle=pos_best.max;
			begin= pos_best.begin;
			end= pos_best.end;
			size=1;
			return sum_of_Circle;
		}

		if(pos_best.max>=sum_of_array+n_best.max) {
			sum_of_Circle=pos_best.max;
			begin= pos_best.begin;
			end= pos_best.end;
			size=pos_best.size;
			return sum_of_Circle;
		}

		else {
			sum_of_Circle=  sum_of_array+ n_best.max;
			begin= n_best.end+1;
			end= n_best.begin-1;
			size=p_array.length-begin+end+1;
			return sum_of_Circle;
		}
	}

	public void printResult() {
		System.out.println("the Array is11: "+ Arrays.toString(p_array));
		System.out.println("= = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("the start index is: " + begin);
		System.out.println("the end index is: " + end);
		System.out.print(" the max sub Array is: [\t");
		for (int i = 0; i < size; i++) { // האיברים כמות פ"ע מעגלית הדפסה
			System.out.print(p_array[(i+begin) % p_array.length]+"\t");
			}
		System.out.println("]");
		System.out.println("the max sum is: " + sum_of_Circle);
		System.out.println("============================================");
	}
}

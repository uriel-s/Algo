package algo2;
import java.util.Arrays;



public class best_array {
	int size;
	int begin;
	int end;
	int max;
	int arr[];
	int help[];
	public best_array(int[] a){
		size=0;
		begin=0;
		end=0;
		arr=a;
		help = new int[a.length];
		max=arr[0];
	}
	
	public static void main(String[] args) {
		int arr[]= {-3,-3,0,1,-1,1};	
		best_array best=new best_array(arr);
		best.get_best();
		best.printResult();
		}

	public int get_best() {
		int t_begin;
		int t_sum ;  
		int i =0;
		while(arr[i]<=0) {
			i++;
			if(i==arr.length) return max;//if all of them are negative
			if (arr[i]>max) {
				max=arr[i]; 
				begin=end=i;
			}
		}
		t_begin= begin;
		t_sum=0;
		while(i<arr.length)		{ 
			help[i]=t_sum+arr[i];
			t_sum=help[i];
			if(help[i]<=0) {
				t_begin=i+1;
				t_sum=0;
			}
			else if (help[i]==max) {
				if (end-begin>i-t_begin) {
					begin =t_begin;
					end=i;
				}
			}
			else if(help[i]>max) { 
				begin= t_begin;
				max=help[i];
				end=i;
			}
			i++;
		}
		
		return max;
	}


	/**
	 * this function help to print the result of Best
	 */
	public void printResult() {
		System.out.println("the Array is: "+ Arrays.toString(arr));
		System.out.println("= = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("the start index is: " + begin);
		System.out.println("the end index is: " + end);
		System.out.print(" the max sub Array is: [\t");
		for (int i = begin; i <= end; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("]");
		System.out.println("the max sum is: " + max);
		System.out.println("============================================");
	}
}









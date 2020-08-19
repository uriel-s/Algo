package algo1;

public class MinandMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,3,4,2,7,8,180,12,15,11,14,13,1600,0,-1,2000,-2,-10};
		System.out.println(MaxAndMin_LessStep(arr));

	}


	public static int MaxAndMin_LessStep(int arr[]) {
		int n=arr.length;
		int max = arr[0];
		int min = arr[0];
		int countOfStep = 0;
		for (int i=1; i<arr.length-1; i=i+2) { // 2 של בדילוג, המערך חצי על ריצה
			countOfStep++;
			if (arr[i]>arr[i+1]) {
				countOfStep = countOfStep + 2;
				if (arr[i]>max) max = arr[i];
				if (arr[i+1]<min) min = arr[i+1];
				//בדיוק אותה השוואה, רק כאן האיבר השני גדול מהראשון //
			} else
			{
				countOfStep = countOfStep + 2;
				if (arr[i+1]>max) max = arr[i+1];
				if (arr[i]<min) min = arr[i];
			}
			
		}
		if(n%2==0) 
		{countOfStep++;
		if(arr[n-1]>max) max=arr[n-1];
		else if(arr[n-1]<min)
		{ min=arr[n-1];
		countOfStep++;
		}

		}
		System.out.println("this is n: "+n);
		System.out.println("min= "+min);
		System.out.println("max= "+max);

		return countOfStep;
	}

}


package LIS;

import java.util.Arrays;

public class LISLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr= new int[]{8,4,12,2,14,10,1};
	System.out.println(LISL(arr));
	}
	
	
	public static int bsb(int[] t,int a ,int len) {
		if(a<t[0])return 0;
		if (a>t[len])return len+1;
		int start=0;
		while(start<=len) {
			if(start==len)return start;
			int mid=(start+len)/2;
			if(t[mid]==a)return mid;
			if(t[mid]<a) start=mid+1;
			else len=mid;
		}
		return -1;
	}

	public static int LISL(int arr[]) {
		int len=0;
		int index;
		int n= arr.length;
		int []t= new int[n];
		t[0]=arr[0];
		len++;
		System.out.println( Arrays.toString(t) );

		for(int i=1;i<n;i++) {
			index=	bsb(t,arr[i],len);
			t[index]=arr[i];
			if(index>len)len++;
			System.out.println( Arrays.toString(t) );

		}

		return len;
	}
}

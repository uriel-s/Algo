package maxmax;

public class max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int[] arr= {1,14,2,155,166,23,0};
	maxmax2(arr);
	}

	public static int maxmax2(Node[] a,int low,int high) {
		int index=low;

		if (low < high)
		{

			int mid= (low+high)/2;
			int i= maxmax2(a,low,mid);
			int j= maxmax2(a,mid+1,high);
			if(a[i].data>a[j].data) {
				a[i].st.push(a[j].data);
				index=i;
			}
			else {
				a[j].st.push(a[i].data);
				index=j;
			}
		}

		return index;

	}




	public static void maxmax2(int[] arr) {
		int n= arr.length;
		int index;
		Node[] A= new Node [n];
		for (int i=0;i<n;i++)	A[i]=new Node(arr[i]);	
		index=maxmax2(A,0,n-1);
		int max1=arr[index];
		Node node =new Node(0);
		node = A[index];
		int max2=node.st.pop();
		while(!node.st.isEmpty()) {
			int tmp =node.st.pop();
			if(tmp>max2) max2=tmp;
		}
	System.out.println("max1 is : "+max1);
	System.out.println("max2 is : "+max2);

	}


}

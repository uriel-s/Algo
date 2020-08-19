//
//public class GlassBall {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	
//	
//	public int Balls3(int n) {
//	int numofchecks=0;
//	int f3[]= new int[n+1];
//	if (n==1)return numofchecks=1;
//	if (n==2||n==3) return numofchecks=2;
//	int f2[]= new int[n+1];
//	for(int i =0; i<n;i++) f2[i] =Balls2(i);
//	
//	
//	
//	
//	return floor;
//	}
//	
//	
//	
//	public int Balls2(int ball,int[] arr) {
//		int n=arr.length;
//		int p=1;
//		int numofchecks=0;
//		while(p*(p+1)/2>n) p++;
//		int floor=p;
//		int step=p-1;
//		while(arr[floor]>ball) {
//			numofchecks++;
//			floor=floor+step;
//			step=step-1;
//		}
//		System.out.println("frist ball broke in floor :"+ floor);
//
//		floor=floor-step+1;
//		while(arr[floor]>ball) {
//			floor++ ;
//			numofchecks++;
//		}
//		return numofchecks;
//	}
//
//}

package algo1;

public class power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int x= 4;
int n= 10;
System.out.println(powerrec (x, n));
	}

	public static  int powerLoop (int x,int n) {
int result=1;
while(n!=0) {
	if(n%2==1) result =result*x;
	x=x*x;
	n=n/2;
			
}
	return result;
	}
	
	
	public static  int powerrec (int x,int n) {
if(n==0)return 1;

if(n%2==0) return powerrec (x*x,n/2);
 return x* powerrec(x*x,(n)/2);

         }
	}

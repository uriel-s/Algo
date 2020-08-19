 package algo1;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class rabbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
list list = new  list();
list.add(0);
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
listNot m= new listNot();
m.add((17));
m.add((27));
m.add((147));
m.add((117));
m.Tail.Next=list.Head;

	Node rabit= m.Head;
	Node tar= m.Head;
boolean ans=false;
boolean flag=true;
Node start = null;
int counter;

while(flag) {
	if(rabit.Next==null||tar.Next==null||rabit.Next.Next==null) {
		System.out.println("not a circle +yasmin is very fat");
		flag=false;
	}
	else {
		tar=tar.Next;
	rabit=rabit.Next.Next;
	if(tar.data==rabit.data)
		{ans = true;
		System.out.println("yasmin stiil very fat");
		start=tar;
		flag=false;
		}
	}
}
	System.out.println(start.data);
rabit=m.Head;
tar=start;
while(tar!=rabit)
{
	//System.out.println(rabit.data);
	tar=tar.Next;
  rabit=rabit.Next;
	}
	
System.out.println(rabit.data);

	}
}

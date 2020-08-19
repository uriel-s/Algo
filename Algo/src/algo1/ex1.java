package algo1;

import java.awt.List;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		list list =new list();
		boolean ans = false;
		int len=0;

		list.add(10);
		list.add(12);
		list.add(21);
		list.add(13);
		list.add(12);
		list.add(12);

     	 list.Head.data=1;
		Node tmp =list.Head.Next;
		while(ans==false)
		{
			int counter=1;
			while(tmp.data!=1) {
				counter++;
				tmp=tmp.Next;
			}
			tmp.data=0;
			len=counter;
			while(counter>0) {
				counter--;
				tmp=tmp.prev;
			}
			if (tmp.data==0) ans=true;
			else tmp=tmp.Next;
		}
		System.out.println("number of car ="+len);

	}
}

package algo1;

public class listNot {
	Node Head;
	Node Tail;

	public listNot() {
		Head=Tail=null;
	}

	public void add(int data) {
		if(Head==null) {
			Head= new Node(data);
			Head.Next=null;
			Head.prev=null;
			 Tail=Head;     }
		
		else {
			Node n = new Node(data);
		Tail.Next=n;
		n.prev=Tail;
		Tail=n;
			
		}
	
	}
}




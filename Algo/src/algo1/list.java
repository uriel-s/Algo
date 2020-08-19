package algo1;

public class list {
	Node Head;
	Node Tail;

	public list() {
		Head=Tail=null;
	}

	public void add(int data) {
		if(Head==null) {
			Head= new Node(data);
			Head.Next=Head;
			Head.prev=Head;
			Tail=Head;}
		else {
			Node n = new Node(data);
		Head.prev=n;
		n.Next=Head;
		n.prev=Tail;
		Tail.Next=n;
		Tail=n;
		}
	
	}
}




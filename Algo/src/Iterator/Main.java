package Iterator;

public class Main 
{
	public static void main(String[] args) 
	{
		ShapeStorage storage = new ShapeStorage();
		
		storage.addShape(new Shape("Circle"));
		storage.addShape(new Shape("Rectangle"));
		storage.addShape(new Shape("Square"));
		storage.addShape(new Shape("Triangle"));
		storage.addShape(new Shape("Ellipse"));

		
		Iterator iterator = storage.iterator();

		while (iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
	}
}

package Iterator;

public class ShapeStorage
{
	private static final int CAPACITY = 5;
	private Shape[] shapes = new Shape[CAPACITY];
	private int size = 0;
	
	public void addShape(Shape s) 
	{
		if(size<CAPACITY)
			shapes[size++] = s;
	}
	
	public Iterator iterator()
	{
		return new ShapeIterator(shapes);
	}
}

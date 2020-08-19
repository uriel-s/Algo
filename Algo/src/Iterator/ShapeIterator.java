package Iterator;

public class ShapeIterator implements Iterator                                                       
{
	private Shape[] shapes;
	private int pos;

	public ShapeIterator(Shape[] shapes) 
	{
		this.shapes = shapes;
	}

	@Override
	public boolean hasNext()
	{
		if (pos >= shapes.length || shapes[pos] == null)
			return false;
		return true;
	}


	@Override
	public Shape next() 
	{
		return shapes[pos++];
	}

	@Override
	public void remove() 
	{
		if (pos <= 0)
			throw new IllegalStateException("Illegal pos.");
		
		if (shapes[pos - 1] != null)
		{
			for (int i = pos - 1; i < (shapes.length - 1); i++) 
			{
				shapes[i] = shapes[i + 1];
			}
			
			shapes[shapes.length - 1] = null;
		}
	}
}
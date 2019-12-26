package shapes;

public class DrawingShape implements Drawable{

	@Override
	public void draw(Shape s) {
		
		if(s instanceof Rectangle)
		{
			System.out.println("Drawing rectangle...");
		}
		else if(s instanceof Square)
		{
			System.out.println("Drawing square");
		}
	}

}

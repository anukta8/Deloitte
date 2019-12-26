package shapes;

public class Rectangle extends Shape {

	public Rectangle(double length, double width)
	{
		super(length,width);
	}
	
	@Override
	public void computeArea() {
		System.out.println("Area of rect="+(length*width));

	}

	@Override
	public void computePerimeter() {
		System.out.println("Perimeter of rect="+(2*(length+width)));

	}
		@Override 
		public String toString() {
			return "REctangle";
		
	}

}

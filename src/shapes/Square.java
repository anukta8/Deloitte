package shapes;

public class Square extends Shape {

	public Square(double length)
	{
		super(length);
	
	}

	@Override
	public void computeArea() {
		System.out.println("Area of square:"+(length*length));

	}

	@Override
	public void computePerimeter() {
		System.out.println("perimeter of square:"+(4*length));

	}
	
	@Override 
	public String toString() {
		return "Square";
	

}
}
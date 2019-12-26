package shapes;

public class ShapeTest {

	public static void main(String[] args) {
	
		Shape box = new Rectangle(20,30);
		box.computeArea();
		System.out.println(box.toString());
		
		Shape sq = new Square(10);
		sq.computeArea();
		sq.computePerimeter();
		System.out.println(sq.toString());

		DrawingShape sd = new DrawingShape();
		draw(sd,box);
		draw(sd,sq);
		
		//Anonymous class
		Drawable d = new Drawable() {
			@Override
			public void draw(Shape s)
			{
				if(s instanceof Rectangle)
					System.out.println("Drawing rect using drawble...");
				else
					System.out.println("drawing square using drawable....");
			
				}
		};
		
		draw(d,sq);
		draw(new MyDrawable(), sq);
	}

	public static void draw(Drawable d, Shape s)
	{
		d.draw(s);
	}
	
	static class MyDrawable implements Drawable{
		
		@Override
		public void draw(Shape s)
	
		{
			if(s instanceof Rectangle)
				System.out.println("Drawing rectangle shape using MyDrawable");
			if(s instanceof Square)
				System.out.println("Drawing square shape using MyDrawables");
		}
		
	}
	
}

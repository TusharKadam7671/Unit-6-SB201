package com.masai;

public class Drawshapes {
	
	private Shape shape;

	
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	
	public void drawShapes()
	{
		shape.draw();
	}
	

}

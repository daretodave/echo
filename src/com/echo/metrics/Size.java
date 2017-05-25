package com.echo.metrics;

public class Size {
	
	public Value width;
	public Value height;
	
	public Size() {
	}
	
	public void update() {
		width. compute();
		height.compute();
	}
	
	public void setWidth(Value width) {
		this.width = width;
		width.update();
	}
	
	public void setHeight(Value height) {
		this.height = height;
		height.update();
	}
	
	public void setWidth(float width) {
		this.width  = Value.simple(width);
		this.width.update();
	}
	
	public void setHeight(float height) {
		this.height  = Value.simple(height);
		this.height.update();
	}
	
	public void size(Value width, Value height) {
		this.width = width;
		this.height = height;
		update();
	}
	
	public void size(float width, float height) {
		this.width  = Value.simple(width);
		this.height = Value.simple(height);
		update();
	}
	
	public float getWidth() {
		return width.resolve;
	}
	
	public float getHeight() {
		return height.resolve;
	}

}

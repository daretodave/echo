package com.echo.metrics;

public class Location {
	
	public Value x;
	public Value y;
	
	public Value.Simple offsetx;
	public Value.Simple offsety;
	
	public Location() {
		this.offsetx = Value.simple(0F);
		this.offsety = Value.simple(0F);
		this.x = Value.simple(0F);
		this.y = Value.simple(0F);
	}

	public void update() {
		x.compute();
		y.compute();
	}
	
	public void setX(Value x) {
		this.x = x;
		x.update();
	}
	
	public void setY(Value y) {
		this.y = y;
		y.update();
	}
	
	public void setX(float x) {
		this.x = Value.simple(x);
		this.x.update();
	}
	
	public void setY(float y) {
		this.y = Value.simple(y);
		this.y.update();
	}
	
	public void locate(Value x, Value y) {
		this.x = x;
		this.y = y;
		update();
	}
	
	public void locate(float x, float y) {
		this.x = Value.simple(x);
		this.y = Value.simple(y);
		update();
	}
	
	public float getX() {
		return x.resolve + offsetx.resolve;
	}
	
	public float getY() {
		return y.resolve + offsety.resolve;
	}
	
	public void offset(float x, float y) {
		offsetx.setValue(offsetx.resolve + x);
		offsety.setValue(offsety.resolve + y);
	}
	
	public float getOffsetX() {
		return offsetx.resolve;
	}
	
	public float getOffsetY() {
		return offsety.resolve;
	}
	
}

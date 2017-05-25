package com.echo.model;

public class Style {
	
	private int[] pallet;
	private int outline;
	
	private Approach approach;
	
	public static final int PRIMARY_COLOR = 0;
	
	public enum Approach {
		FILL,
		OUTLINE,
		FILL_AND_OUTLINE
	}
	
	public enum Gradient {
		LINEAR,  //down/up/left/right/diagonally
		RADIAL   //defined by it's center
	}
	
	public void setColor(int index, int color) {
		pallet[index] = color;
	}
	
	public void setColor(int color) {
		setColor(PRIMARY_COLOR, color);
	}
	
	public int getColor(int index) {
		return pallet[index];
	}
	
	public int getColor() {
		return getColor(PRIMARY_COLOR);
	}
 	
	public Style() {
		this.pallet = new int[16];
	}

	public int getOutline() {
		return outline;
	}

	public void setOutline(int outline) {
		this.outline = outline;
	}

	public Approach getApproach() {
		return approach;
	}

	public void setApproach(Approach approach) {
		this.approach = approach;
	}

}

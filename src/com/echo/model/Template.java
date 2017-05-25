package com.echo.model;

import java.util.Iterator;

public class Template implements Iterable<float[]> {

	private final float[][] xy;
	private final int size;
	
	public static final Template RECTANGLE = new Template(
			
		0.0F, 0.0F,
		1.0F, 0.0F,
		1.0F, 1.0F,
		0.0F, 1.0F,
		
		0.0F, 0.0F
	);

	public Template(float[] x, float[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException(
					"The template's x and y coordinates should have equal buffer lengths.");
		}
		this.size = Math.min(x.length, y.length);
		this.xy = new float[size][2];
		for (int i = 0; i < size; i++) {
			this.xy[i][0] = x[i];
			this.xy[i][1] = y[i];
		}
	}
	
	public Template(float[][] xy) {
		this.size = xy.length;
		this.xy = xy;
	}
	
	public Template(float... xy) {
		this.size = xy.length/2;
		this.xy = new float[size][2];
		for (int i = 0, o = 0; i < size; i++, o += 2) {
			this.xy[i][0] = xy[o];
			this.xy[i][1] = xy[o+1];
		}
	}

	public float length() {
		return size;
	}

	@Override
	public Iterator<float[]> iterator() {
		return new Iterator<float[]>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public float[] next() {
				return xy[index++];
			}

			@Override
			public void remove() {
			}
		};
	}

}

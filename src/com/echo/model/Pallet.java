package com.echo.model;

import java.util.HashMap;

public class Pallet {
	
	private HashMap<Integer, Layer> bucket;
	private Layer layer;
	
	public Pallet() {
		bucket = new HashMap<Integer, Layer>();
	}
	
	public void setLayer(int state, Layer layer) {
		this.bucket.put(state, layer);
	}
	
	protected void update(int state, int... order) {
		layer = bucket.get(state); //see if layer is pre-defined
		if(layer == null) {
			for(int presidence : order) {
				if((presidence & state) == state) {
					layer = bucket.get(presidence);
				}
				if(layer != null)
					break;
			}
		}
	}
	
	public Layer getLayer() {
		return layer;
	}

}

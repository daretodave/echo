package com.echo.components;

import com.echo.metrics.Value;
import com.echo.model.Entity;
import com.echo.model.Layer;
import com.echo.model.Pallet;
import com.echo.model.State;
import com.echo.model.Template;

public class Panel extends Entity {
	
	public Panel() {
	}

	@Override
	public Value getDefaultedWidth() {
		return Value.MATCH_PARENT;
	}

	@Override
	public Value getDefaultedHeight() {
		return Value.MATCH_PARENT;
	}

	@Override
	public void pallet(Pallet underlay, Pallet overlay) {
		Layer netural = new Layer(Template.RECTANGLE);
		underlay.setLayer(State.NEUTRAL, netural);
	}

}

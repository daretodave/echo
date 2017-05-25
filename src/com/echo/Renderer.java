package com.echo;

import java.util.Collection;
import java.util.Map;

import com.echo.metrics.Value;
import com.echo.model.Entity;
import com.echo.model.EntityGroup;
import com.echo.model.Layer;
import com.echo.model.Pallet;
import com.echo.model.Style;
import com.echo.model.Template;

public abstract class Renderer extends EntityGroup {
	
	public void render() {
		render(getMap().values());
	}
	
	private void render(Collection<Entity> elements) {
		for(Entity entity : elements) {
			render(entity);
		}
	}
	
	private void render(Entity element) {
		float x = element.getLocation().getX();
		float y = element.getLocation().getY();
		float w = element.getSize().getWidth();
		float h = element.getSize().getHeight();
		render(element.getPallet().getLayer(), x, y, w, h);
		if(element instanceof EntityGroup) {
			render(((EntityGroup)element).getMap().values());
		}
		render(element.getOverlay().getLayer(), x, y, w, h);
	}
	
	public void render(Layer layer, float x, float y, float w, float h) {
		if(layer == null) {
			return;
		}
		render(layer.getTemplate(), layer.getStyle(), x, y, w, h);
	}
	
	public abstract void render(Template template, Style style, float x, float y, float w, float h);
	
	public Renderer() {
		super();
	}
	
	public abstract void open();
	public abstract void close();
	public abstract boolean isOpened();

	@Override
	public Value getDefaultedWidth() {
		return null;
	}

	@Override
	public Value getDefaultedHeight() {
		return null;
	}
	
	@Override
	public void build(Map<Integer, Entity> map) {
	}

	@Override
	public void pallet(Pallet underlay, Pallet overlay) {
	}


}

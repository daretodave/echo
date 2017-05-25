package com.echo.model;

import com.echo.metrics.Location;
import com.echo.metrics.Size;
import com.echo.metrics.Value;

public abstract class Entity {
	
	private int[] presidence = { //Presidency when layer is not found
		State.FOCUSED, State.PRESSED, State.HOVERED, State.NEUTRAL, State.DISABLED, 
	};
	
	private Pallet underlay;
	private Pallet overlay;
	private Location location;
	private Size size;
	private int id;
	
	private boolean attached;
	private Entity parent;
	
	public abstract Value getDefaultedWidth();
	public abstract Value getDefaultedHeight();
	
	public abstract void pallet(Pallet underlay, Pallet overlay);
	
	public Entity() {
		underlay = new Pallet();
		overlay  = new Pallet();
		location = new Location();
		size     = new Size();
	}
	
	public void build() {
		if(size.width == null)
			size.width  = getDefaultedWidth();
		if(size.height == null)
			size.height = getDefaultedHeight();
		if(size.width == Value.MATCH_PARENT && parent != null) {
			size.setWidth(new Value() {
				@Override
				public float compute() {
					return parent.getSize().getWidth();
				}
			});
		}
		if(size.height == Value.MATCH_PARENT && parent != null) {
			size.setHeight(new Value() {
				@Override
				public float compute() {
					return parent.getSize().getHeight();
				}
			});
		}
		size.update();
		pallet(underlay, overlay);
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Size getSize() {
		return size;
	}
	
	private void update() {
		underlay.update(state, presidence);
		overlay. update(state,  presidence);
	}
	
	public void setDrawnPresidence(int... states) {
		this.presidence = states;
	}
	
	public Pallet getPallet() {
		return underlay;
	}
	
	public Pallet getOverlay() {
		return overlay;
	}
	
	private int state;
	private int always;
	private int never;

	public boolean isState(int state) {
		return (this.state & state) == state;
	}
	
	public boolean isAlways(int state) {
		return (this.always & state) == state;
	}
	
	public boolean isNever(int state) {
		return (this.never & state) == state;
	}
	
	public void never(int state, boolean neverInState) {
		if(neverInState) {
			if(!isNever(state)) {
				this.never |= state;
			}
		} else {
			if(isNever(state)) {
				this.never &= ~state;
			}
		}
	}
	
	public void always(int state, boolean alwaysInState) {
		if(alwaysInState) {
			if(!isAlways(state)) {
				this.always |= state;
			}
			state(state, true);
		} else {
			if(isAlways(state)) {
				this.always &= ~state;
			}
		}
	}
	
	public void state(int state, boolean inState) {
		if(inState) {
			if(!isState(state) && !isNever(state)) {
				this.state |= state;
				onStateChange(state, true);
			}
		} else {
			if(isState(state) && !isAlways(state)) {
				this.state &= ~state;
				onStateChange(state, false);
			}
		}
	}
	
	private void onStateChange(int state, boolean inState) {
		
		update();
	}
	public int getId() {
		return id;
	}
	protected void unattach() {
		this.id = 0;
		attached = false;
		parent = null;
	}
	protected void setId(int id, Entity parent) {
		if(attached) {
			throw new RuntimeException("Component is already attached to another entity");
		}
		this.parent = parent;
		this.id = id;
		this.attached = true;
		build();
		update();
	}
	
	public boolean isAttached() {
		return attached;
	}
	
}

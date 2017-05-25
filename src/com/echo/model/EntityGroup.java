package com.echo.model;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityGroup extends Entity {
	
	private Map<Integer, Entity> map;
	
	public EntityGroup() {
		super();
		this.map = new HashMap<>();
	}
	
	public abstract void build(Map<Integer, Entity> map);
	
	protected void add(int id, Entity entity) {
		map.put(id, entity);
		entity.setId(id, this);
	}
	
	public int add(Entity entity) {
		while(true) {
			int id = (int) (Math.random() * Integer.MAX_VALUE);
			if(map.get(id) == null) {
				map.put(id, entity);
				entity.setId(id, this);
				return id;
			}
		}
	}
	
	
	
	public Entity getElement(int id) {
		return map.get(id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getElement(int id, T type) {
		return (T) getElement(id);
	}
	
	@Override
	public void build() {
		super.build();
		build(map);
		for(Entity entity : map.values()) {
			entity.build();
		}
	}

	public Map<Integer, Entity> getMap() {
		return map;
	}
	
}

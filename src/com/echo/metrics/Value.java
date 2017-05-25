package com.echo.metrics;

public abstract class Value {

	public float resolve;
	
	public static Value MATCH_PARENT = null;
	
	public void update() {
		this.resolve = compute();
	}
	
	public abstract float compute();
	
	public static Value.Simple simple(float value) {
		return new Value.Simple(value);
	}
	
	public static class Simple extends Value {
		
		private float value;
		
		public void setValue(float value) {
			this.value = value;
		}
		
		private Simple(float value) {
			this.value = value;
		}

		@Override
		public float compute() {
			return value;
		}
		
	}
	
}

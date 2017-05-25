package com.echo.model;

public class Layer {
	
	public Template getTemplate() {
		return template;
	}

	public Style getStyle() {
		return style;
	}

	private final Template template;
	private final Style style;
	private Layer extenstion;
	
	public Layer(Template template) {
		this.template = template;
		this.style = new Style();
	}

	public Layer getExtenstion() {
		return extenstion;
	}

	public void setExtenstion(Layer extenstion) {
		this.extenstion = extenstion;
	}

}

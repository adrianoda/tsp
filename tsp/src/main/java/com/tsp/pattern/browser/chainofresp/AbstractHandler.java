package com.tsp.pattern.browser.chainofresp;

import com.tsp.pattern.browser.libraries.Element;
import com.tsp.pattern.browser.libraries.Viewer;

public abstract class AbstractHandler {
	
	private AbstractHandler nextHandler;
	
	private Viewer viewer;

	public AbstractHandler(Viewer viewer) {
		this.viewer = viewer;
	}

	// Template method
	public void handle(Element element) {
		if(canHandle(element)) {
			Element re = render(element);
			viewer.doview(re);
		} else if(nextHandler != null){
			nextHandler.handle(element);
		}
	}

	protected abstract boolean canHandle(Element element);

	protected abstract Element render(Element element);

	public void addHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}


}

package com.tsp.pattern.browser.chainofresp;

import com.tsp.pattern.browser.libraries.Element;
import com.tsp.pattern.browser.libraries.RenderHTML;
import com.tsp.pattern.browser.libraries.Viewer;

public class HandlerHTML extends AbstractHandler {
	
	private RenderHTML render;

	public HandlerHTML(Viewer viewer, RenderHTML render) {
		super(viewer);
		this.render = render;
	}
	
	@Override
	protected boolean canHandle(Element element) {
		return "HTML".equals(element.getKind());
	}

	@Override
	protected Element render(Element element) {
		return render.dorender(element);
	}

}

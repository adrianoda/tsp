package com.tsp.pattern.browser.chainofresp;

import com.tsp.pattern.browser.libraries.DTD;
import com.tsp.pattern.browser.libraries.Element;
import com.tsp.pattern.browser.libraries.RenderXML;
import com.tsp.pattern.browser.libraries.Viewer;

public class HandlerXML extends AbstractHandler {

	private RenderXML render;
	private DTD dtd;

	public HandlerXML(Viewer viewer, RenderXML render, DTD dtd) {
		super(viewer);
		this.render = render;
		this.dtd = dtd;
	}

	@Override
	protected boolean canHandle(Element element) {
		return "XML".equals(element.getKind());
	}

	@Override
	protected Element render(Element element) {
		return render.dorender(element, dtd);
	}

}

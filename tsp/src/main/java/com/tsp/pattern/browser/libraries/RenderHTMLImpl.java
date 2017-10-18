package com.tsp.pattern.browser.libraries;

public class RenderHTMLImpl implements RenderHTML {

	@Override
	public Element dorender(Element e) {
		e.setContent(e.getContent().replaceAll("<p>", "").replaceAll("</p>", ""));
		return e;
	}

}

package com.tsp.pattern.browser.libraries;

public class ViewerImpl implements Viewer {

	@Override
	public int doview(Element e) {
		System.out.print(e.getContent());
		return 0;
	}

}

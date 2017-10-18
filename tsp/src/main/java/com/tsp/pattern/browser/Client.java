package com.tsp.pattern.browser;

import java.util.Arrays;
import java.util.List;

import com.tsp.pattern.browser.chainofresp.AbstractHandler;
import com.tsp.pattern.browser.chainofresp.HandlerHTML;
import com.tsp.pattern.browser.chainofresp.HandlerXML;
import com.tsp.pattern.browser.libraries.DTD;
import com.tsp.pattern.browser.libraries.Element;
import com.tsp.pattern.browser.libraries.RenderHTMLImpl;
import com.tsp.pattern.browser.libraries.RenderXMLImpl;
import com.tsp.pattern.browser.libraries.Viewer;
import com.tsp.pattern.browser.libraries.ViewerImpl;

public class Client {

	public static void main(String[] args) {
		// DAG = Composite
		Element e1 = new Element("HTML", "<p>Ciao, </p>");
		Element e2 = new Element("HTML", "<p>Una </p>");
		List<Element> l1 = Arrays.asList(new Element("HTML", "<p>Oggi </p>"), new Element("HTML", "<p>è </p>"), e2);
		e1.setLinks(l1);
		List<Element> l2 = Arrays.asList(new Element("HTML", "<p>Bella </p>"), new Element("HTML", "<p>Giornata </p>"));
		e2.setLinks(l2);

		// Iterator + Chain of responsability
		// AbstractFactory can be used to create handlers and renderer
		Viewer viewer = new ViewerImpl();
		AbstractHandler rootHandler = new HandlerXML(viewer, new RenderXMLImpl(), new DTD());
		AbstractHandler nextHandler = new HandlerHTML(viewer, new RenderHTMLImpl());
		rootHandler.addHandler(nextHandler);
		DagIterator iterator = new DagIterator(e1);
		while (iterator.hasNext()) {
			Element elem = iterator.next();
			rootHandler.handle(elem);
		}
	}

}

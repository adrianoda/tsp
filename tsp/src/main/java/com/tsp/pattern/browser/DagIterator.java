package com.tsp.pattern.browser;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.tsp.pattern.browser.libraries.Element;

public class DagIterator implements Iterator<Element> {

	private Stack<Element> stack;

	public DagIterator(Element root) {
		stack = new Stack<>();
		stack.push(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public Element next() {
		Element element = stack.pop();
		List<Element> links = element.getLinks();
		if (links != null && !links.isEmpty()) {
			for (int i=links.size()-1; i>=0; i--) {
				stack.push(links.get(i));
			}
		}
		return element;
	}

}

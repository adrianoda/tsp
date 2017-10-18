package com.tsp.pattern.browser.libraries;

import java.util.List;

public class Element {
	
	private String kind;
	
	private String content;
	
	private List<Element> links;
	
	public Element() {}
	
	public Element(String kind, String content) {
		this.kind = kind;
		this.content = content;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Element [kind=" + kind + ", content=" + content + "]";
	}

	public List<Element> getLinks() {
		return links;
	}

	public void setLinks(List<Element> links) {
		this.links = links;
	}
	
}

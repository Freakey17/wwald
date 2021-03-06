package org.wwald.view.components;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.link.Link;

public class SimpleViewPageLink extends Link {
	private Class<? extends Page> responseView;
	private PageParameters parameters;
	
	public SimpleViewPageLink(String id) {
		this(id, null);
	}
	
	public SimpleViewPageLink(String id, Class<? extends Page> responseView) {
		super(id);
		this.responseView = responseView;
	}

	public SimpleViewPageLink(String id, Class<? extends Page> responseView, PageParameters parameters) {
		this(id, responseView);
		this.parameters = parameters;
	}
	
	@Override
	public void onClick() {
		if(this.responseView != null) {
			if(this.parameters != null) {
				setResponsePage(this.responseView, this.parameters);
			}
			else {
				setResponsePage(this.responseView);
			}
		}
	}
}

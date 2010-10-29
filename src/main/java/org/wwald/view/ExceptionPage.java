package org.wwald.view;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.wwald.WWALDConstants;
import org.wwald.WicketIdConstants;

public class ExceptionPage extends BasePage {

	public ExceptionPage(PageParameters parameters) {
		super(parameters);
//		String msg = parameters.getKey(WWALDConstants.ERROR_MESSAGES);
//		msg = (msg == null) ? "" : msg;
//		MultiLineLabel label = new MultiLineLabel(WicketIdConstants.MESSAGES, msg);
//		add(label);
	}

	@Override
	public Panel getSidebar() {
		return new EmptyPanel(WicketIdConstants.RHS_SIDEBAR);
	}

}

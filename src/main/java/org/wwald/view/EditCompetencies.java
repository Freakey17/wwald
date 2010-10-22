package org.wwald.view;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.wwald.WWALDApplication;
import org.wwald.WWALDConstants;
import org.wwald.model.ConnectionPool;
import org.wwald.model.Permission;

public class EditCompetencies extends AccessControlledPage {
	public EditCompetencies(PageParameters parameters) {
		super(parameters);
		String courseId = parameters.getString(WWALDConstants.SELECTED_COURSE);
		add(new Label("course.name", courseId));
		add(getCoursesEditForm(courseId, parameters));
	}

	private Form getCoursesEditForm(final String courseId, final PageParameters pageParams) {
		Form editCompetenciesForm = new Form("competencies.edit.form") {
			@Override
			public void onSubmit() {
				TextArea textArea = (TextArea)get(0);
				WWALDApplication app = (WWALDApplication)getApplication();
				app.getDataFacade().updateCompetenciesWikiContents(ConnectionPool.getConnection(), courseId, textArea.getModelObject());
				setResponsePage(CoursePage.class, pageParams);
			}
		};
		TextArea editCompetenciesFormTextArea = new TextArea("competencies.edit.form.textarea", new Model(getCompetenciesWikiContents(courseId)));
		editCompetenciesForm.add(editCompetenciesFormTextArea);
		return editCompetenciesForm;
	}

	private Serializable getCompetenciesWikiContents(String courseId) {
		WWALDApplication app = (WWALDApplication)getApplication();
		return app.getDataFacade().retreiveCompetenciesWiki(ConnectionPool.getConnection(), courseId);
	}

	@Override
	public Panel getSidebar() {
		return new EmptyPanel("rhs_sidebar");
	}

	@Override
	protected Permission getRequiredPermission() {
		return Permission.EDIT_COURSE;
	}
}

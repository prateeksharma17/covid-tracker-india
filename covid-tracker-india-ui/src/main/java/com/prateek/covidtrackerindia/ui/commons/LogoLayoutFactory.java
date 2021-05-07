package com.prateek.covidtrackerindia.ui.commons;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class LogoLayoutFactory implements UIComponentBuilder{
	
	private class LogoLayout extends VerticalLayout{
		
		
		private static final long serialVersionUID = -5912729666007207422L;
		private Embedded logo;
		
		public LogoLayout init() {
			logo = new Embedded();
			logo.setSource(new ThemeResource("../../images/logo.png"));
			logo.setWidth("498px");
			logo.setHeight("241px");			
			return this;
		}
		
		public LogoLayout layout() {
			addComponent(logo);
			setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
			return this;
		}
		
	}	

	@Override
	public Component createComponent() {
		return new LogoLayout().init().layout();
	}

}

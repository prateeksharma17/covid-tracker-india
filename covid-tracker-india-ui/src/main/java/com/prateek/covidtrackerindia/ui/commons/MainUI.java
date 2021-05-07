package com.prateek.covidtrackerindia.ui.commons;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=MainUI.NAME)
@Title("COVID-19 TRACKER INDIA")
@Theme("valo")
public class MainUI extends UI{
	
	
	private static final long serialVersionUID = 6017944752202441817L;

	public static final String NAME = "/ui";
	
		
	@Autowired
	private LogoLayoutFactory logoLayoutFactory; 
	
	@Autowired
	private ContentLayoutFactory contentLayoutFactory; 

	@Override
	protected void init(VaadinRequest request) {		
		
		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel logoPanel = new Panel();
		logoPanel.setWidth("38%");
		logoPanel.setHeightUndefined();		
		
		Panel contentPanel = new Panel();
		contentPanel.setWidth("75%");
		contentPanel.setHeight("100%");
		
		Component logo = logoLayoutFactory.createComponent();
		Component content = contentLayoutFactory.createComponent();
		
		logoPanel.setContent(logo);		
		contentPanel.setContent(content);
		
		rootLayout.addComponent(logoPanel);		
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);		
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);		
		rootLayout.setExpandRatio(contentPanel, 1);
		
		rootLayout.setSpacing(true);
		
		setContent(rootLayout);			
		
	}

}

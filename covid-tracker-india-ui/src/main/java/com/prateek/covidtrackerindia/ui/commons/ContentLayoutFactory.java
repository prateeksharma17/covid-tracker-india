package com.prateek.covidtrackerindia.ui.commons;


import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.service.TrackCovidDataService;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.prateek.covidtrackerindia.utils.StringUtils;

@org.springframework.stereotype.Component
public class ContentLayoutFactory implements UIComponentBuilder{

	private class ContentLayout extends VerticalLayout implements Button.ClickListener, ValueChangeListener{
		
		
		private static final long serialVersionUID = -6670274507571653855L;

		private MainData data;
		
		private Button getButton;
		
		private Component mainGrid;
		
		private ComboBox statesComboBox;
		
		private Component stateGrid;		
				
		public ContentLayout init() {
			
			getButton = new Button(StringUtils.GET_DATA.getString());
			getButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			getButton.setIcon(FontAwesome.DATABASE);			
			getButton.addClickListener(this);			
								
			return this;
		}
		
		public ContentLayout layout() {
			setMargin(true);
			addComponent(getButton);
									
			setComponentAlignment(getButton, Alignment.TOP_CENTER);		
			
			setSpacing(true);
			
			return this;
		}

		@Override
		public void buttonClick(ClickEvent event) {
			data = trackCovidDataService.getDataFromAPI();	
			
			trackCovidDataService.indexDataToElastic(data);
						
			if(mainGrid!=null) {
				mainGrid.setVisible(false);
				removeComponent(mainGrid);				
			}
			
			if(statesComboBox!=null) {		
				statesComboBox.setVisible(false);
				removeComponent(statesComboBox);				
			}
			
			if(stateGrid!=null) {
				stateGrid.setVisible(false);
				removeComponent(stateGrid);
			}			
			
			mainGrid = mainGridLayoutFactory.createComponent(data);
			mainGrid.setVisible(true);
			addComponent(mainGrid);
			
			statesComboBox = statesComboBoxLayoutFactory.createComponent(data);
			statesComboBox.setVisible(true);
			statesComboBox.addValueChangeListener(this);
			addComponent(statesComboBox);
			setComponentAlignment(statesComboBox, Alignment.MIDDLE_CENTER);			
		}

		@Override
		public void valueChange(ValueChangeEvent event) {
			String selectedItem = (String) event.getProperty().getValue();
			if(stateGrid!=null)
				removeComponent(stateGrid);
			
			stateGrid = stateGridLayoutFactory.createComponent(data, selectedItem);
			stateGrid.setVisible(true);
			addComponent(stateGrid);
		}		
		
	}	
	
	@Autowired
	private StateGridLayoutFactory stateGridLayoutFactory;
	
	@Autowired
	private StatesComboBoxLayoutFactory statesComboBoxLayoutFactory;
	
	@Autowired
	private MainGridLayoutFactory mainGridLayoutFactory; 
	
	@Autowired
	private TrackCovidDataService trackCovidDataService;
	
	@Override
	public Component createComponent() {
		return new ContentLayout().init().layout();
	}

}

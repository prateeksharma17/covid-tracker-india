package com.prateek.covidtrackerindia.ui.commons;

import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.service.TrackCovidDataService;
import com.prateek.covidtrackerindia.utils.StringUtils;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StatesComboBoxLayoutFactory {
	
	private class StatesComboBoxLayout extends VerticalLayout{
		
		
		private static final long serialVersionUID = 2827081672805725397L;
		private ComboBox states;
		
		public StatesComboBoxLayout init() {			
			setMargin(true);			
			states = new ComboBox(StringUtils.SELECT_STATE.getString());			
			return this;
		}
		
		public ComboBox layout(MainData data) {
			states.addItems(trackCovidDataService.getListOfStates(data));
			states.setCaption("Select State");
			states.setIcon(FontAwesome.SEARCH);
			states.setWidth("40%");
			
			return states;
		}
		
	}	
	
	
	@Autowired
	private TrackCovidDataService trackCovidDataService;
	
		
	public ComboBox createComponent(MainData data) {
		return new StatesComboBoxLayout().init().layout(data);
	}

}

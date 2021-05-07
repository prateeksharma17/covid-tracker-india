package com.prateek.covidtrackerindia.ui.commons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.model.entity.RegionData;
import com.prateek.covidtrackerindia.service.TrackCovidDataService;
import com.prateek.covidtrackerindia.utils.AppUtilities;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StateGridLayoutFactory {
	
	private List<RegionData> regionDataList;
	private BeanItemContainer<RegionData> container;
	
	private class StateGridLayout extends VerticalLayout{
		
		
		private static final long serialVersionUID = -5539408846042350852L;
		private Grid stateTable;
		
		public StateGridLayout init() {
			setMargin(true);			
			container = new BeanItemContainer<>(RegionData.class, regionDataList);			
			stateTable = new Grid(container);			
			stateTable.removeColumn("region");						
			stateTable.setImmediate(true);			
			
			return this;
		}
		
		
		public StateGridLayout load(MainData data, String region) {
			RegionData regionData = trackCovidDataService.getRegionData(data, region);
			regionDataList = new ArrayList<>();
			regionDataList.add(regionData);		
			return this;
		}
		
		
		public StateGridLayout layout(MainData data, String region) {
			stateTable.setWidth("100%");
			stateTable.setHeightMode(HeightMode.ROW);
			stateTable.setHeightByRows(2);
			stateTable.setCaptionAsHtml(true);
			
			String istFormatDate = AppUtilities.getIstFormatDate(data.getLastUpdatedAtApify());	
			
			stateTable.setCaption("<h3><b>"+region+" Statistics, Updated at "+istFormatDate+"</center></b>");
			stateTable.setIcon(FontAwesome.BOOKMARK);
			addComponent(stateTable);			
			return this;
		}		
		
	}
	
	@Autowired
	private TrackCovidDataService trackCovidDataService;	
	
	public Component createComponent(MainData data, String region) {
		return new StateGridLayout().load(data, region).init().layout(data, region);
	}
	
	public void refreshTable(MainData data, String region) {
		if(regionDataList!=null) {
			regionDataList.clear();
		}else {
			regionDataList = new ArrayList<>();
		}
		regionDataList.add(trackCovidDataService.getRegionData(data, region));
		container.removeAllItems();
		container.addAll(regionDataList);
	}

}

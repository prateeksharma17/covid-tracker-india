package com.prateek.covidtrackerindia.ui.commons;

import java.util.ArrayList;
import java.util.List;

import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.utils.AppUtilities;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class MainGridLayoutFactory {
	
	private List<MainData> mainDataList;
	private BeanItemContainer<MainData> container;
	
	private class MainGridLayout extends VerticalLayout{
		
		
		private static final long serialVersionUID = -8781630328696041254L;
		private Grid mainTable;
		
		public MainGridLayout init() {
			setMargin(true);			
			container = new BeanItemContainer<>(MainData.class, mainDataList);			
			mainTable = new Grid(container);			
			mainTable.removeColumn("id");
			mainTable.removeColumn("sourceUrl");
			mainTable.removeColumn("lastUpdatedAtApify");
			mainTable.removeColumn("readMe");
			mainTable.removeColumn("regionData");			
			mainTable.setImmediate(true);			
			
			return this;
		}
		
		
		public MainGridLayout load(MainData data) {
			mainDataList = new ArrayList<>();
			mainDataList.add(data);		
			return this;
		}
		
		
		public MainGridLayout layout(MainData data) {
			mainTable.setWidth("100%");
			mainTable.setHeightMode(HeightMode.ROW);
			mainTable.setHeightByRows(2);
			mainTable.setCaptionAsHtml(true);
			
			String istFormatDate = AppUtilities.getIstFormatDate(data.getLastUpdatedAtApify());			
			
			mainTable.setCaption("<h3><b>All States Combined Statistics, Updated at "+istFormatDate+"</center></b>");
			mainTable.setIcon(FontAwesome.TABLE);
			addComponent(mainTable);			
			return this;
		}
		
		
	}	

	
	public Component createComponent(MainData data) {
		return new MainGridLayout().load(data).init().layout(data);
	}
	
	public void refreshTable(MainData data) {
		if(mainDataList!=null) {
			mainDataList.clear();
		}else {
			mainDataList = new ArrayList<>();
		}
		mainDataList.add(data);
		container.removeAllItems();
		container.addAll(mainDataList);
	}

}

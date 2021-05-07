package com.prateek.covidtrackerindia.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.model.entity.RegionData;


public class AppUtilities {	
	
	private static final Logger LOG = LoggerFactory.getLogger(AppUtilities.class);

	public static MainData convertMapToData(Map<String,Object> dataMap) {
		
		MainData data = new MainData();
		
		data.setActiveCases((Integer)dataMap.get("activeCases"));
		data.setActiveCasesNew((Integer)dataMap.get("activeCasesNew"));
		data.setRecovered((Integer)dataMap.get("recovered"));
		data.setRecoveredNew((Integer)dataMap.get("recoveredNew"));
		data.setDeaths((Integer)dataMap.get("deaths"));
		data.setDeathsNew((Integer)dataMap.get("deathsNew"));
		data.setPreviousDayTests((Integer)dataMap.get("previousDayTests"));
		data.setTotalCases((Integer)dataMap.get("totalCases"));
		data.setSourceUrl((String)dataMap.get("sourceUrl"));
		data.setLastUpdatedAtApify((String)dataMap.get("lastUpdatedAtApify"));
		data.setReadMe((String)dataMap.get("readMe"));
		
		List<LinkedHashMap<String,Object>> regionMapList = (List<LinkedHashMap<String,Object>>) dataMap.get("regionData");
		
		List<RegionData> regionDataList = getRegionDataFromList(regionMapList);
		
		data.setRegionData(regionDataList);
		
		return data;
	}

	
	private static List<RegionData> getRegionDataFromList(List<LinkedHashMap<String, Object>> regionMapList) {
		List<RegionData> regionDataList = new ArrayList<>();
		
		for(LinkedHashMap<String, Object> regionMap : regionMapList) {			
			RegionData regionData = new RegionData();
			
			regionData.setRegion((String)regionMap.get("region"));
			regionData.setActiveCases((Integer)regionMap.get("activeCases"));
			regionData.setNewInfected((Integer)regionMap.get("newInfected"));
			regionData.setRecovered((Integer)regionMap.get("recovered"));
			regionData.setNewRecovered((Integer)regionMap.get("newRecovered"));
			regionData.setDeceased((Integer)regionMap.get("deceased"));
			regionData.setNewDeceased((Integer)regionMap.get("newDeceased"));
			regionData.setTotalInfected((Integer)regionMap.get("totalInfected"));
			
			regionDataList.add(regionData);			
		}		
				
		return regionDataList;
	}


	public static String getIstFormatDate(String inputDateString) {
		String outputDateString = null;
		try {
			DateFormat istFormat = new SimpleDateFormat();
			TimeZone istTime = TimeZone.getTimeZone("IST");
		 
			istFormat.setTimeZone(istTime);
		
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			Date inputDate = inputFormat.parse(inputDateString);
			
			outputDateString = istFormat.format(inputDate);
		
		}catch(ParseException ex) {
			LOG.error(ex.getMessage());
		}
		
		return outputDateString;
	}


}

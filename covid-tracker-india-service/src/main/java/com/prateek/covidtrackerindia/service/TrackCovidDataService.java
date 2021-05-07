package com.prateek.covidtrackerindia.service;


import java.util.List;

import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.model.entity.RegionData;

public interface TrackCovidDataService {
	
	MainData getDataFromAPI();
	
	void indexDataToElastic(MainData data);
	
	List<String> getListOfStates(MainData data);
	
	RegionData getRegionData(MainData data, String region);
	
}

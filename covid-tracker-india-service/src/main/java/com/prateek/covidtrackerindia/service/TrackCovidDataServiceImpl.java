package com.prateek.covidtrackerindia.service;

import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prateek.covidtrackerindia.model.entity.MainData;
import com.prateek.covidtrackerindia.model.entity.RegionData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prateek.covidtrackerindia.utils.AppUtilities;
import com.prateek.covidtrackerindia.utils.StringUtils;

@Service
public class TrackCovidDataServiceImpl implements TrackCovidDataService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TrackCovidDataServiceImpl.class);
	
	public MainData getDataFromAPI() {
		
		MainData data = null;
		
		try {
			
			URL url = new URL(StringUtils.API_LINK.getString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> dataMap = mapper.readValue(responseStream, LinkedHashMap.class);			
			data = AppUtilities.convertMapToData(dataMap);
			
			LOG.info("Data fetched from API : "+data.toString());
			
			return data;		
			
		}catch(IOException ex) {
			LOG.error(ex.getMessage());
		}
		
		return data;
	}
	

	@Override
	public List<String> getListOfStates(MainData data) {
		List<String> states = new ArrayList<>();
		
		List<RegionData> regionDataList = data.getRegionData();
		for(RegionData regionData : regionDataList) {
			states.add(regionData.getRegion());
		}
		
		LOG.info("List of States : "+states);
		return states;		
	}
	

	@Override
	public RegionData getRegionData(MainData data, String region) {
		RegionData output = null;
		for(RegionData regionData : data.getRegionData()) {
			if(regionData.getRegion().equalsIgnoreCase(region)) {
				output = regionData;
				break;
			}
		}		
		return output;		
	}
	

	@Override
	public void indexDataToElastic(MainData data) {
		try {			
			URL url = new URL(StringUtils.ELASTICSEARCH_LINK.getString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);
			
			ObjectMapper mapper = new ObjectMapper();
			String inputJsonString = mapper.writeValueAsString(data);
			
			LOG.info("Indexing JSON to Elasticsearch : "+inputJsonString);
			
			try(OutputStream os = connection.getOutputStream()) {
			    byte[] input = inputJsonString.getBytes("utf-8");
			    os.write(input, 0, input.length);			
			}
			
			try(BufferedReader br = new BufferedReader(
				new InputStreamReader(connection.getInputStream(), "utf-8"))) {
				   StringBuilder response = new StringBuilder();
				   String responseLine = null;
				   while ((responseLine = br.readLine()) != null) {
				       response.append(responseLine.trim());
				    }
				   LOG.info("Response from Elasticsearch : "+response.toString());
			}			
			
		}catch(IOException ex) {
			LOG.error(ex.getMessage());
		}		
	}	

}

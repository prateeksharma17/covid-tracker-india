package com.prateek.covidtrackerindia.utils;

public enum StringUtils {
	
	API_LINK("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true."),
	GET_DATA("Get Current Statistics"),
	SELECT_STATE("Select Region"),
	ELASTICSEARCH_LINK("http://104.251.211.4:9200/covid-tracker-india/doc");	
	
	private final String string;
	
	private StringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}

}

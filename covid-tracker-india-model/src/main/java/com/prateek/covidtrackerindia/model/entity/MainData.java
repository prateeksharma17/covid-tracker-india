package com.prateek.covidtrackerindia.model.entity;

import java.util.List;

public class MainData {
	
	
	private String id;
	
	private Integer activeCases;
	
	private Integer activeCasesNew;
	
	private Integer recovered;
	
	private Integer recoveredNew;
	
	private Integer deaths;
	
	private Integer deathsNew;
	
	private Integer previousDayTests;
	
	private Integer totalCases;
	
	private String sourceUrl;
	
	private String lastUpdatedAtApify;
	
	private String readMe;
	
	private List<RegionData> regionData;

	public MainData() {
		//Default Constructor
	}

	public MainData(String id, Integer activeCases, Integer activeCasesNew, Integer recovered, Integer recoveredNew,
			Integer deaths, Integer deathsNew, Integer previousDayTests, Integer totalCases, String sourceUrl,
			String lastUpdatedAtApify, String readMe, List<RegionData> regionData) {		
		this.id = id;
		this.activeCases = activeCases;
		this.activeCasesNew = activeCasesNew;
		this.recovered = recovered;
		this.recoveredNew = recoveredNew;
		this.deaths = deaths;
		this.deathsNew = deathsNew;
		this.previousDayTests = previousDayTests;
		this.totalCases = totalCases;
		this.sourceUrl = sourceUrl;
		this.lastUpdatedAtApify = lastUpdatedAtApify;
		this.readMe = readMe;
		this.regionData = regionData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(Integer activeCases) {
		this.activeCases = activeCases;
	}

	public Integer getActiveCasesNew() {
		return activeCasesNew;
	}

	public void setActiveCasesNew(Integer activeCasesNew) {
		this.activeCasesNew = activeCasesNew;
	}

	public Integer getRecovered() {
		return recovered;
	}

	public void setRecovered(Integer recovered) {
		this.recovered = recovered;
	}

	public Integer getRecoveredNew() {
		return recoveredNew;
	}

	public void setRecoveredNew(Integer recoveredNew) {
		this.recoveredNew = recoveredNew;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getDeathsNew() {
		return deathsNew;
	}

	public void setDeathsNew(Integer deathsNew) {
		this.deathsNew = deathsNew;
	}

	public Integer getPreviousDayTests() {
		return previousDayTests;
	}

	public void setPreviousDayTests(Integer previousDayTests) {
		this.previousDayTests = previousDayTests;
	}

	public Integer getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Integer totalCases) {
		this.totalCases = totalCases;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getLastUpdatedAtApify() {
		return lastUpdatedAtApify;
	}

	public void setLastUpdatedAtApify(String lastUpdatedAtApify) {
		this.lastUpdatedAtApify = lastUpdatedAtApify;
	}

	public String getReadMe() {
		return readMe;
	}

	public void setReadMe(String readMe) {
		this.readMe = readMe;
	}

	public List<RegionData> getRegionData() {
		return regionData;
	}

	public void setRegionData(List<RegionData> regionData) {
		this.regionData = regionData;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", activeCases=" + activeCases + ", activeCasesNew=" + activeCasesNew + ", recovered="
				+ recovered + ", recoveredNew=" + recoveredNew + ", deaths=" + deaths + ", deathsNew=" + deathsNew
				+ ", previousDayTests=" + previousDayTests + ", totalCases=" + totalCases + ", sourceUrl=" + sourceUrl
				+ ", lastUpdatedAtApify=" + lastUpdatedAtApify + ", readMe=" + readMe + ", regionData=" + regionData
				+ "]";
	}	

}

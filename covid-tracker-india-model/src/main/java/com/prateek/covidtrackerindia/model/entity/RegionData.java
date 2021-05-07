package com.prateek.covidtrackerindia.model.entity;

public class RegionData {
	
	private String region;
	private Integer activeCases;
	private Integer newInfected;
	private Integer recovered;
	private Integer newRecovered;
	private Integer deceased;
	private Integer newDeceased;
	private Integer totalInfected;
	
	public RegionData() {
		//Default Constructor
	}

	public RegionData(String region, Integer activeCases, Integer newInfected, Integer recovered, Integer newRecovered,
			Integer deceased, Integer newDeceased, Integer totalInfected) {
		super();
		this.region = region;
		this.activeCases = activeCases;
		this.newInfected = newInfected;
		this.recovered = recovered;
		this.newRecovered = newRecovered;
		this.deceased = deceased;
		this.newDeceased = newDeceased;
		this.totalInfected = totalInfected;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(Integer activeCases) {
		this.activeCases = activeCases;
	}

	public Integer getNewInfected() {
		return newInfected;
	}

	public void setNewInfected(Integer newInfected) {
		this.newInfected = newInfected;
	}

	public Integer getRecovered() {
		return recovered;
	}

	public void setRecovered(Integer recovered) {
		this.recovered = recovered;
	}

	public Integer getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(Integer newRecovered) {
		this.newRecovered = newRecovered;
	}

	public Integer getDeceased() {
		return deceased;
	}

	public void setDeceased(Integer deceased) {
		this.deceased = deceased;
	}

	public Integer getNewDeceased() {
		return newDeceased;
	}

	public void setNewDeceased(Integer newDeceased) {
		this.newDeceased = newDeceased;
	}

	public Integer getTotalInfected() {
		return totalInfected;
	}

	public void setTotalInfected(Integer totalInfected) {
		this.totalInfected = totalInfected;
	}

	@Override
	public String toString() {
		return "RegionData [region=" + region + ", activeCases=" + activeCases + ", newInfected=" + newInfected
				+ ", recovered=" + recovered + ", newRecovered=" + newRecovered + ", deceased=" + deceased
				+ ", newDeceased=" + newDeceased + ", totalInfected=" + totalInfected + "]";
	}	
	
}
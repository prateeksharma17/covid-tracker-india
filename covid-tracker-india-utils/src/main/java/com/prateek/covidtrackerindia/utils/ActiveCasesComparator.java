package com.prateek.covidtrackerindia.utils;

import java.util.Comparator;

import com.prateek.covidtrackerindia.model.entity.RegionData;

public class ActiveCasesComparator implements Comparator<RegionData>{

	@Override
	public int compare(RegionData o1, RegionData o2) {
		return o2.getActiveCases().compareTo(o1.getActiveCases());
	}

}

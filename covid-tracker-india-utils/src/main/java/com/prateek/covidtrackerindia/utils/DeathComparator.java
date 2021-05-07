package com.prateek.covidtrackerindia.utils;

import java.util.Comparator;

import com.prateek.covidtrackerindia.model.entity.RegionData;

public class DeathComparator implements Comparator<RegionData>{

	@Override
	public int compare(RegionData o1, RegionData o2) {
		return o2.getDeceased().compareTo(o1.getDeceased());
	}

}

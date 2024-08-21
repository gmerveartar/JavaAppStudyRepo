package org.csystem.app.earthquake.data.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EarthquakeDetailsSave {
    public RegionInfo regionInfo;
    public EarthquakeAddress earthquakeAddress;
    public EarthquakeInfo earthquakeInfo;
    public EarthquakeCountryInfo earthquakeCountryInfo;
}

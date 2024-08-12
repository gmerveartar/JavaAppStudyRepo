package org.csystem.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class GeonamesEarthquakeDetails {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String datetime;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double depth;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double latitude;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double longitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String earthquakeId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double magnitude;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String locality;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String street;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String postalCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String distance;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryName;

}

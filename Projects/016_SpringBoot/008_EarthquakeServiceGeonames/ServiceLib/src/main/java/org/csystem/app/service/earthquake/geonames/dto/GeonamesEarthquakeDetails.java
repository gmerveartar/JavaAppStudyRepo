package org.csystem.app.service.earthquake.geonames.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeonamesEarthquakeDetails {
    @JsonProperty("info")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GeonamesEarthquakeDetailsInfo geonamesEarthquakeDetailsInfo;

    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GeonamesEarthquakeDetailsAddress geonamesEarthquakeDetailsAddress;

    @JsonProperty("countryInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GeonamesEarthquakeDetailsCountryInfo geonamesEarthquakeDetailsCountryInfo;

}

/*

JSON Template :

{
    "earthquakes": [
        "info": {
            "dateTime": "Test",
            "depth": 10,
            "latitude": 10.10,
            "longitude": 10.20,
            "earthquakeId": "Test",
            "magnitude": 3.4
        }
        "address": {
            "locality": "Test",
            "street": "Test",
            "postalCode": "Test",
        }
        "countryInfo": {
            "distance": "0",
            "countryCode": "UK",
            "countryName": "United Kingdom"
        }
    ]
}

*/
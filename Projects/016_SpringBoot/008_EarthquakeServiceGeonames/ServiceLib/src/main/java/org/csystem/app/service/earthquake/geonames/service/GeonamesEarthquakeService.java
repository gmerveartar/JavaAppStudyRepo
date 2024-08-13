package org.csystem.app.service.earthquake.geonames.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.service.earthquake.geonames.dto.*;
import org.csystem.app.service.earthquake.geonames.mapper.IGeonamesMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GeonamesEarthquakeService {
    private static final String EARTHQUAKE_URL_FORMAT = "http://api.geonames.org/earthquakesJSON?north=%f&south=%f&east=%f&west=%f&username=csystem";
    private static final String COUNTRY_CODE_URL_FORMAT = "http://api.geonames.org/countryCodeJSON?lat=%f&lng=%f&username=csystem";
    private static final String ADDRESS_URL_FORMAT = "http://api.geonames.org/addressJSON?lat=%f8&lng=%f&username=csystem";

    private final RestTemplate m_restTemplate;
    private final IGeonamesMapper m_geonamesMapper;

    private GeonamesEarthquakeInfo findEarthquakes(double north, double south, double east, double west)
    {
        var url = String.format(EARTHQUAKE_URL_FORMAT, north, south, east, west);

        return m_restTemplate.getForObject(url, GeonamesEarthquakeInfo.class);
    }

    private GeonamesCountryCode findCountryCode(double latitude, double longitude)
    {
        var url = String.format(COUNTRY_CODE_URL_FORMAT, latitude, longitude);

        return m_restTemplate.getForObject(url, GeonamesCountryCode.class);
    }

    private GeonamesAddress findAddress(double latitude, double longitude)
    {
        var url = String.format(ADDRESS_URL_FORMAT, latitude, longitude);

        return m_restTemplate.getForObject(url, GeonamesAddress.class);
    }

    private GeonamesEarthquakeDetails toGeonamesEarthquakeDetails(GeonamesEarthquake geonamesEarthquake,
                                                                  GeonamesAddress geonamesAddress,
                                                                  GeonamesCountryCode geonamesCountryCode)
    {
        var details = new GeonamesEarthquakeDetails();

        details.geonamesEarthquakeDetailsInfo = m_geonamesMapper.toGeonamesEarthquakeDetailsInfo(geonamesEarthquake);
        details.geonamesEarthquakeDetailsAddress = m_geonamesMapper.toGeonamesEarthquakeDetailsAddress(geonamesAddress);
        details.geonamesEarthquakeDetailsCountryInfo = m_geonamesMapper.toGeonamesEarthquakeDetailsCountryInfo(geonamesCountryCode);

        return details;
    }

    private void earthquakeInfoDetailsCallBack(GeonamesEarthquake geonamesEarthquake, List<GeonamesEarthquakeDetails> details)
    {
        var address = findAddress(geonamesEarthquake.lat, geonamesEarthquake.lng);
        var countryCode = findCountryCode(geonamesEarthquake.lat, geonamesEarthquake.lng);

        details.add(toGeonamesEarthquakeDetails(geonamesEarthquake, address, countryCode));
    }

    private GeonamesEarthquakeInfoDetails toGeonamesEarthquakeInfoDetails(GeonamesEarthquakeInfo geonamesEarthquakeInfo)
    {
        var details = new GeonamesEarthquakeInfoDetails();

        details.earthquakes = new ArrayList<>();

        geonamesEarthquakeInfo.earthquakes.forEach(e -> earthquakeInfoDetailsCallBack(e, details.earthquakes));

        return details;
    }

    public GeonamesEarthquakeService(RestTemplate restTemplate, IGeonamesMapper geonamesMapper)
    {
        m_restTemplate = restTemplate;
        m_geonamesMapper = geonamesMapper;
    }

    public GeonamesEarthquakeInfoDetails findEarthquakesDetails(double north, double south, double east, double west)
    {
        var earthquake = findEarthquakes(north, south, east, west);

        return toGeonamesEarthquakeInfoDetails(earthquake);
    }
}

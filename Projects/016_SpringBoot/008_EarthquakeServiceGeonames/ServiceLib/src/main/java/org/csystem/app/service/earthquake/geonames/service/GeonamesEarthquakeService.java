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

    private GeonamesAdress findAddress(double latitude, double longitude)
    {
        var url = String.format(ADDRESS_URL_FORMAT, latitude, longitude);

        return m_restTemplate.getForObject(url, GeonamesAdress.class);
    }

    private GeonamesEarthquakeDetailsInfo toGeonamesEarthquakeDetailsInfo(GeonamesEarthquakeInfo geonamesEarthquakeInfo)
    {
        var detailsInfo = new GeonamesEarthquakeDetailsInfo();

        detailsInfo.earthquakes = new ArrayList<>();

        geonamesEarthquakeInfo.earthquakes.forEach(e -> earthquakeInfoDetailsInfoCallBack(e, detailsInfo.earthquakes));

        return detailsInfo;
    }

    private void earthquakeInfoDetailsInfoCallBack(GeonamesEarthquake geonamesEarthquake, List<GeonamesEarthquakeDetails> details)
    {
        var address = findAddress(geonamesEarthquake.lat, geonamesEarthquake.lng);
        var countryCode = findCountryCode(geonamesEarthquake.lat, geonamesEarthquake.lng);

        details.add(m_geonamesMapper.toGeonamesEarthquakeDetails(geonamesEarthquake, address, countryCode));
    }

    public GeonamesEarthquakeService(RestTemplate restTemplate, IGeonamesMapper geonamesMapper)
    {
        m_restTemplate = restTemplate;
        m_geonamesMapper = geonamesMapper;
    }

    public GeonamesEarthquakeDetailsInfo findEarthquakesDetails(double north, double south, double east, double west)
    {
        var earthquake = findEarthquakes(north, south, east, west);

        return toGeonamesEarthquakeDetailsInfo(earthquake);
    }
}

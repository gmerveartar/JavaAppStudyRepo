package org.csystem.app.earthquake.data;

import org.csystem.app.earthquake.data.entity.*;
import org.csystem.app.earthquake.data.repository.IRegionInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class SaveQueryInfoTest {
    @Autowired
    private IRegionInfoRepository m_regionInfoRepository;

    @Test
    public void test()
    {
        var earthquake = new EarthquakeDetailsSave();

        earthquake.regionInfo = new RegionInfo();
        earthquake.regionInfo.east = 23.4;
        earthquake.regionInfo.west = 21.4;
        earthquake.regionInfo.north = 20.4;
        earthquake.regionInfo.south = 29.4;

        earthquake.earthquakeInfo = new EarthquakeInfo();
        earthquake.earthquakeInfo.datetime = "2023-02-06 04:00:00";
        earthquake.earthquakeInfo.depth = 100;
        earthquake.earthquakeInfo.latitude = 45.67;
        earthquake.earthquakeInfo.longitude = 40.67;
        earthquake.earthquakeInfo.earthquakeId = "Test Earthquake";
        earthquake.earthquakeInfo.magnitude = 7.6;

        earthquake.earthquakeAddress = new EarthquakeAddress();

        earthquake.earthquakeCountryInfo = new EarthquakeCountryInfo();
        m_regionInfoRepository.saveEarthquake(earthquake);

        assertDoesNotThrow(() ->m_regionInfoRepository.saveEarthquakeQueryInfo(1));
    }
}

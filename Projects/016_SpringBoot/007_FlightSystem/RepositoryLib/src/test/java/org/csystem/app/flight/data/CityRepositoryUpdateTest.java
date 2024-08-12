
package org.csystem.app.flight.data;

import org.csystem.app.flight.data.constant.TestConstant;
import org.csystem.app.flight.data.entity.City;
import org.csystem.app.flight.data.repository.ICityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPERTY_FILE)
public class CityRepositoryUpdateTest {
    @Autowired
    private ICityRepository m_cityRepository;

    @Test
    public void test()
    {
        var oldCity = "Soroti";
        var newCity = new City(1, "Zonguldak");

        m_cityRepository.updateCity(newCity);

        var cityName = m_cityRepository.findById(1L).get().getName();

        Assertions.assertEquals(newCity.getName(), cityName);
        Assertions.assertNotEquals(newCity.getName(), oldCity);

    }
}

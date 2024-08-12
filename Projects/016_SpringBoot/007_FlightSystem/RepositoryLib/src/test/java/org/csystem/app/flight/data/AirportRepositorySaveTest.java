package org.csystem.app.flight.data;

import org.csystem.app.flight.data.constant.TestConstant;
import org.csystem.app.flight.data.entity.Airport;
import org.csystem.app.flight.data.entity.City;
import org.csystem.app.flight.data.repository.IAirportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPERTY_FILE)
public class AirportRepositorySaveTest {
    @Autowired
    private IAirportRepository m_airportRepository;

    @Test
    public void test()
    {
        var airport = new Airport(0, "Sabiha Gökçen Airport", 3, LocalDate.of(2000,1,1),
                LocalDateTime.of(2013, 5, 3, 12,30,25));
        var expectedId = 1001L;

        m_airportRepository.save(airport);

        Assertions.assertEquals(expectedId, airport.getId());
    }

}


package org.csystem.app.flight.data;

import org.csystem.app.flight.data.constant.TestConstant;
import org.csystem.app.flight.data.repository.IAirportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPERTY_FILE)
public class AirportRepositoryFindByNameContainsTest {
    @Autowired
    private IAirportRepository m_airportRepository;

    @Test
    public void test()
    {
        var text = "Green";
        var expected_count = 4L;
        var count = StreamSupport.stream(m_airportRepository.findByNameContains(text).spliterator(),false).count();

        assertEquals(expected_count, count);
    }
}



package org.csystem.app.flight.data;

import org.csystem.app.flight.data.constant.TestConstant;
import org.csystem.app.flight.data.repository.ICityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPERTY_FILE)
public class CityRepositoryFindAllTest {
    @Autowired
    private ICityRepository m_cityRepository;

    @Test
    public void test()
    {
        var expectedCount = 1000L;
        var count = StreamSupport.stream(m_cityRepository.findAll().spliterator(), false).count();

        Assertions.assertEquals(expectedCount, count);
    }
}

package org.csystem.app.flight.data;

import org.csystem.app.flight.data.constant.TestConstant;
import org.csystem.app.flight.data.repository.ICityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = TestConstant.UNITTEST_PROPERTY_FILE)
public class CityRepositoryFindByIdTest {
    @Autowired
    private ICityRepository m_cityRepository;

    @Test
    public void givenValue_whenId_then_found()
    {
        var name = "Santa Cruz";
        var id = 6L;

        Assertions.assertEquals(name, m_cityRepository.findById(id).get().getName());
    }
    @Test
    public void givenValue_whenId_then_OptionalNotEmpty()
    {
        var id = 6L;

        Assertions.assertTrue(m_cityRepository.findById(id).isPresent());
    }

    @Test
    public void givenValue_whenId_then_OptionalEmpty()
    {
        var id = 1001L;

        Assertions.assertTrue(m_cityRepository.findById(id).isEmpty());
    }
}

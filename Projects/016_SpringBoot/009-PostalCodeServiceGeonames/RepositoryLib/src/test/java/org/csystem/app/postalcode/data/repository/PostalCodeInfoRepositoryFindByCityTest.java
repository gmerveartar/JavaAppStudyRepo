package org.csystem.app.postalcode.data.repository;

import org.csystem.app.postalcode.data.dal.PostalCodeAppDataHelper;
import org.csystem.app.postalcode.data.entity.PostalCode;
import org.csystem.app.postalcode.data.mapper.IPostalCodeMapper;

import org.csystem.app.postalcodes.geonames.service.service.GeonamesPostalCodeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@SpringBootApplication
@TestPropertySource(locations = "classpath:application-unittest.properties")
@EntityScan(basePackages = "org.csystem")
@ComponentScan(basePackages = "org.csystem")
public class PostalCodeInfoRepositoryFindByCityTest {
    @Autowired
    private PostalCodeAppDataHelper m_postalCodeAppDataHelper;

    @Autowired
    private IPostalCodeInfoRepository m_postalCodeInfoRepository;

    @Autowired
    private GeonamesPostalCodeService m_geonamesPostalCodeService;

    @Autowired
    private IPostalCodeMapper m_mapper;

    @BeforeEach
    public void setUp()
    {
        var postalCodeValue = "67000";

        var geonamesPostalCodes = m_geonamesPostalCodeService.findPostalCodes(postalCodeValue);

        var postalCode = new PostalCode();
        postalCode.postalCode = postalCodeValue;

        m_postalCodeAppDataHelper.savePostalCodes(postalCode, m_mapper.toPostalCodeInfo(geonamesPostalCodes.postalCodes));
    }

    @Test
    public void test()
    {
        var cityName = "Zonguldak";
        var expectedCount = 10;

        var postalCodes = m_postalCodeInfoRepository.findByCity(cityName);
        var postalCodesCount = postalCodes.size();

        Assertions.assertEquals(expectedCount, postalCodesCount);
    }
}

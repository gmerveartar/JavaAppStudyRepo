package org.csystem.app.postalcode.data.repository;

import org.csystem.app.postalcode.repository.IPostalCodeInfoRepository;
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
@EnableJpaRepositories(basePackages = "org.csystem")
@EntityScan(basePackages = "org.csystem")
public class PostalCodeInfoRepositoryFindByAdminNameTest {
    @Autowired
    public IPostalCodeInfoRepository postalCodeInfoRepository;

    @Test
    public void test()
    {

    }

}

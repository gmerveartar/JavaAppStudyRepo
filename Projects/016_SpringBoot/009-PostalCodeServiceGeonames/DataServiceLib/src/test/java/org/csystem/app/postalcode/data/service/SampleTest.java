package org.csystem.app.postalcode.data.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
public class SampleTest {
    @Autowired
    private PostalCodeDataService m_postalCodeDataService;

    @Test
    public void test()
    {

    }
}

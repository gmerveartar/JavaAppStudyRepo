package org.csystem.app.postalcode.data.service;


import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcode.data.dal.PostalCodeAppDataHelper;
import org.csystem.app.postalcodes.geonames.service.service.GeonamesPostalCodeService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostalCodeDataService {
    private final PostalCodeAppDataHelper m_postalCodeAppDataHelper;
    private final GeonamesPostalCodeService m_geonamesPostalCodeService;


    public PostalCodeDataService(PostalCodeAppDataHelper postalCodeAppDataHelper, GeonamesPostalCodeService geonamesPostalCodeService)
    {
        m_postalCodeAppDataHelper = postalCodeAppDataHelper;
        m_geonamesPostalCodeService = geonamesPostalCodeService;
    }


}

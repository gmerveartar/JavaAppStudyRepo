package org.csystem.app.service.earthquake.geonames.mapper;

import org.csystem.app.service.earthquake.geonames.dto.GeonamesAdress;
import org.csystem.app.service.earthquake.geonames.dto.GeonamesCountryCode;
import org.csystem.app.service.earthquake.geonames.dto.GeonamesEarthquake;
import org.csystem.app.service.earthquake.geonames.dto.GeonamesEarthquakeDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(implementationName = "GeonamesMapperImpl", componentModel = "spring")
public interface IGeonamesMapper {
    @Mapping(source = "geonamesEarthquake.eqid", target = "earthquakeId")
    @Mapping(source = "geonamesEarthquake.lat", target = "latitude")
    @Mapping(source = "geonamesEarthquake.lng", target = "longitude")
    @Mapping(source = "geonamesAddress.postalcode", target = "postalCode")
    @Mapping(source = "geonamesCountryCode.distance", target = "distance")
    @Mapping(source = "geonamesCountryCode.countryCode", target = "countryCode")
    GeonamesEarthquakeDetails toGeonamesEarthquakeDetails(GeonamesEarthquake geonamesEarthquake,
                                                          GeonamesAdress geonamesAddress,
                                                          GeonamesCountryCode geonamesCountryCode);

}

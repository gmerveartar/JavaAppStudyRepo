package org.csystem.app.flight.data.service;


import org.csystem.app.flight.data.dal.FlightSystemDataHelper;
import org.csystem.app.flight.data.entity.City;
import org.csystem.app.flight.data.repository.CityRepository;
import org.csystem.app.flight.data.service.dto.CityDTO;
import org.csystem.app.flight.data.service.dto.CitySaveDTO;
import org.csystem.app.flight.data.service.mapper.MapperInject;
import org.csystem.data.exception.repository.RepositoryException;
import org.csystem.data.exception.service.DataServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FlightSystemDataService {
    private static final Logger log = LoggerFactory.getLogger(FlightSystemDataService.class);
    private final FlightSystemDataHelper m_flightSystemDataHelper;
    private final MapperInject m_mapperInject;

    public FlightSystemDataService(FlightSystemDataHelper flightSystemDataHelper, MapperInject mapperInject)
    {
        m_flightSystemDataHelper = flightSystemDataHelper;
        m_mapperInject = mapperInject;
    }

    public void deleteCityById(long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    public Iterable<CityDTO> findAllCities()
    {
        try {
            log.info("FlightSystemDataService.findAllCities");

            throw new UnsupportedOperationException("Not implemented yet!..");
        }
        catch (RepositoryException ex) {
            log.error("FlightSystemDataService.findAllCities: Exception -> Repository Exception, Message -> {}", ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.findAllCities -> Repository Exception", ex);
        }
        catch (Throwable ex) {
            log.error("FlightSystemDataService.findAllCities: Exception -> {}, Message -> {}", ex.getClass().getSimpleName(), ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.findAllCities -> Exception", ex);
        }
    }

    public Iterable<CityDTO> findCityById()
    {
        try {
            log.info("FlightSystemDataService.findCityById");

            throw new UnsupportedOperationException("Not implemented yet!..");
        }
        catch (RepositoryException ex) {
            log.error("FlightSystemDataService.findCityById: Exception -> Repository Exception, Message -> {}", ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.findCityById -> Repository Exception", ex);
        }
        catch (Throwable ex) {
            log.error("FlightSystemDataService.findCityById: Exception -> {}, Message -> {}", ex.getClass().getSimpleName(), ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.findCityById -> Exception", ex);
        }
    }

    public Iterable<CityDTO> findCityByName(String name)
    {
        try {
            log.info("FlightSystemDataService.findCityByName");

            throw new UnsupportedOperationException("Not implemented yet!..");
        }
        catch (RepositoryException ex) {
            log.error("FlightSystemDataService.findCityByName: Exception -> Repository Exception, Message -> {}", ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.findCityByName -> Repository Exception", ex);
        }
        catch (Throwable ex) {
            log.error("FlightSystemDataService.findCityByName: Exception -> {}, Message -> {}", ex.getClass().getSimpleName(), ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.findCityByName -> Exception", ex);
        }
    }


    public CitySaveDTO saveCity(CitySaveDTO citySaveDTO)
    {
        try {
            log.info("FlightSystemDataService.saveCity: City -> {}", citySaveDTO.toString());

            m_flightSystemDataHelper.saveCity(m_mapperInject.getCityMapper().toCity(citySaveDTO));
            return citySaveDTO;
        }
        catch (RepositoryException ex) {
            log.error("FlightSystemDataService.saveCity: City -> {},  Exception -> Repository Exception, Message -> {}",
                    citySaveDTO.toString(), ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.saveCity -> Repository Exception", ex);
        }
        catch (Throwable ex) {
            log.error("FlightSystemDataService.saveCity: City -> {},  Exception -> {}, Message -> {}",
                    citySaveDTO.toString(), ex.getClass().getSimpleName(), ex.getMessage());
            throw new DataServiceException("FlightSystemDataService.saveCity -> Exception", ex);
        }
    }
}

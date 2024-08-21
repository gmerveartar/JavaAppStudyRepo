package org.csystem.app.earthquake.data.repository;


import lombok.extern.slf4j.Slf4j;
import org.csystem.app.earthquake.data.entity.*;
import org.csystem.data.exception.repository.RepositoryException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
@Slf4j
public class RegionInfoRepository implements IRegionInfoRepository {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String FIND_DETAILS_BY_REGION_INFO = """            
            select\s
            ei.latitude, ei.longitude, ei.depth, ei.datetime, ei.magnitude, ei.earthquake_id,\s
            eai.locality, eai.street, eai.postal_code,\s
            eci.distance, eci.country_code, eci.country_name\s
            from\s
            region_info ri inner join earthquake_info ei on ei.region_info_id = ri.region_info_id\s
            inner join earthquake_address_info eai on eai.region_info_id = ri.region_info_id\s
            inner join earthquake_country_info eci on eci.region_info_id = ri.region_info_id
            where abs(east - :east) < 0.00001 and abs(west - :west) < 0.00001 and abs(north - :north) < 0.00001\s
            and abs(south - :south) < 0.00001;
            """;

    private static final String SAVE_REGION_INFO_SQL = """
            insert into region_info (east, west, north, south) values (:east, :west, :north, :south)
            """;
    private static final String SAVE_EARTHQUAKE_INFO_SQL = """
            insert into earthquake_info (region_info_id, datetime, depth, latitude, longitude, earthquake_id, magnitude)\s
            values (:region_info_id, :datetime, :depth, :latitude, :longitude, :earthquake_id, :magnitude)
            """;

    private static final String SAVE_EARTHQUAKE_COUNTRY_INFO_SQL = """
            insert into earthquake_country_info (region_info_id, distance, country_code, country_name)
            values (:region_info_id, :distance, :country_code, :country_name)\s
            """;

    private static final String SAVE_EARTHQUAKE_ADDRESS_INFO_SQL = """
            insert into earthquake_address_info (region_info_id, locality, street, postal_code)\s
            values (:region_info_id, :locality, :street, :postal_code)
            """;

    private static final String SAVE_EARTHQUAKE_QUERY_INFO_SQL = """
            insert into earthquake_query_info (region_info_id) values (:region_info_id)
            """;

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private void saveEarthquakeAddress(EarthquakeAddress earthquakeAddress)
    {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("locality", earthquakeAddress.locality);
        paramMap.put("street", earthquakeAddress.street);
        paramMap.put("postal_code", earthquakeAddress.postalCode);
        paramMap.put("region_info_id", earthquakeAddress.regionInfoId);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_ADDRESS_INFO_SQL, paramMap);
    }

    private void saveEarthquakeCountryInfo(EarthquakeCountryInfo earthquakeCountryInfo)
    {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("distance", earthquakeCountryInfo.distance);
        paramMap.put("country_code", earthquakeCountryInfo.countryCode);
        paramMap.put("country_name", earthquakeCountryInfo.countryName);
        paramMap.put("region_info_id", earthquakeCountryInfo.regionInfoId);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_COUNTRY_INFO_SQL, paramMap);
    }

    private void saveEarthquakeInfo(EarthquakeInfo earthquakeInfo) throws SQLException
    {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("datetime", LocalDateTime.parse(earthquakeInfo.datetime, FORMATTER));
        paramMap.put("depth", earthquakeInfo.depth);
        paramMap.put("latitude", earthquakeInfo.latitude);
        paramMap.put("longitude", earthquakeInfo.longitude);
        paramMap.put("earthquake_id", earthquakeInfo.earthquakeId);
        paramMap.put("magnitude", earthquakeInfo.magnitude);
        paramMap.put("region_info_id", earthquakeInfo.regionInfoId);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_INFO_SQL, paramMap);
    }

    public long saveRegionInfo(RegionInfo regionInfo) throws SQLException
    {
        var paramSource = new BeanPropertySqlParameterSource(regionInfo);
        var keyHolder = new GeneratedKeyHolder();

        if (m_namedParameterJdbcTemplate.update(SAVE_REGION_INFO_SQL, paramSource, keyHolder) != 1)
            throw new SQLException();

        return (long)keyHolder.getKeyList().get(0).get("region_info_id");
    }

    @Override
    public void saveEarthquakeQueryInfo(long regionInfoId)
    {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("region_info_id", regionInfoId);

        m_namedParameterJdbcTemplate.update(SAVE_EARTHQUAKE_QUERY_INFO_SQL, paramMap);

    }

    public RegionInfoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    @Transactional
    public void saveEarthquake(EarthquakeDetailsSave earthquakeDetailsSave)
    {
        try {
            var regionInfoId = saveRegionInfo(earthquakeDetailsSave.regionInfo);

            log.info("saveRegionInfo -> Generated Region info id = {}", regionInfoId);

            earthquakeDetailsSave.earthquakeInfo.regionInfoId = regionInfoId;
            earthquakeDetailsSave.earthquakeAddress.regionInfoId = regionInfoId;
            earthquakeDetailsSave.earthquakeCountryInfo.regionInfoId = regionInfoId;

            saveEarthquakeInfo(earthquakeDetailsSave.earthquakeInfo);
            saveEarthquakeCountryInfo(earthquakeDetailsSave.earthquakeCountryInfo);
            saveEarthquakeAddress(earthquakeDetailsSave.earthquakeAddress);
            saveEarthquakeQueryInfo(regionInfoId);
        }
        catch (SQLException ex) {
            log.error("RegionInfoRepository.saveEarthquake -> Message: {}", ex.getMessage());
            throw new RepositoryException("RegionInfoRepository.saveEarthquake", ex);
        }
    }



    @Override
    public Iterable<EarthquakeDetails> findByRegionInfo(double east, double west, double north, double south)
    {
        throw new UnsupportedOperationException("TODO");
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public long count()
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public void delete(RegionInfo entity)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public void deleteAll(Iterable<? extends RegionInfo> entities)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public void deleteById(Long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public boolean existsById(Long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public Iterable<RegionInfo> findAll()
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public Iterable<RegionInfo> findAllById(Iterable<Long> ids)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public Optional<RegionInfo> findById(Long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public <S extends RegionInfo> S save(S entity)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }

    @Override
    public <S extends RegionInfo> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not implemented yet!..");
    }
}

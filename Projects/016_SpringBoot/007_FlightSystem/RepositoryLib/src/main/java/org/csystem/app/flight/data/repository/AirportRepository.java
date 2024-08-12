package org.csystem.app.flight.data.repository;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.flight.data.entity.Airport;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
@Lazy
@Slf4j
public class AirportRepository implements  IAirportRepository {
    private static final String SAVE_SQL = "INSERT INTO airports (name, city_id, open_date, register_date_time) VALUES " +
            "(:name, :cityId, :openDate, :registerDateTime)";
    private static final String FIND_BY_NAME_CONTAINS_SQL = "SELECT * FROM airports WHERE name LIKE :pattern";
    private static final String FIND_BY_CITY_ID_SQL = "SELECT * FROM find_airport_by_cityId(:id)";


    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private static void fillAirport(ResultSet rs, ArrayList<Airport> airports) throws SQLException
    {
            do {
                var id = rs.getLong(1);
                var name = rs.getString(2);
                var cityId = rs.getLong(3);
                var openDate = rs.getDate(4).toLocalDate();
                var registerDateTime = rs.getTimestamp(5).toLocalDateTime();

                airports.add(new Airport(id, name, cityId, openDate, registerDateTime));
            } while (rs.next());
    }

    public AirportRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Iterable<Airport> findAllById(Iterable<Integer> integers)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Iterable<Airport> findByCityId(long cityId)
    {
        var airports = new ArrayList<Airport>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("id", cityId);

        m_namedParameterJdbcTemplate.query(FIND_BY_CITY_ID_SQL, paramMap, (ResultSet rs) -> fillAirport(rs, airports));

        return airports;
    }

    @Override
    public Iterable<Airport> findByNameContains(String text)
    {
        log.info("AirportRepository.findByNameContains -> text = {}", text);
        var airports = new ArrayList<Airport>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("pattern", String.format("%%%s%%", text));

        m_namedParameterJdbcTemplate.query(FIND_BY_NAME_CONTAINS_SQL, paramMap, (ResultSet rs) -> fillAirport(rs, airports));

        return airports;
    }

    @Override
    public <S extends Airport> S save(S airport)
    {
        var parameterSource = new BeanPropertySqlParameterSource(airport);
        var keyHolder =  new GeneratedKeyHolder();

        parameterSource.registerSqlType("openDate", Types.DATE);
        parameterSource.registerSqlType("registerDateTime", Types.TIMESTAMP);

        m_namedParameterJdbcTemplate.update(SAVE_SQL, parameterSource, keyHolder);
        airport.setId((long)keyHolder.getKeys().get("airport_id"));

        return airport;
    }

    //////////////////////////////////////////
    @Override
    public long count()
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void delete(Airport entity)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteAll(Iterable<? extends Airport> entities)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteById(Integer integer)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public boolean existsById(Integer integer)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public Iterable<Airport> findAll()
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public Optional<Airport> findById(Integer integer)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public <S extends Airport> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }
}

package org.csystem.app.flight.data.repository;

import org.csystem.app.flight.data.entity.City;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
@Lazy
public class CityRepository implements ICityRepository {
    private static final String DELETE_BY_ID_SQL = "CALL sp_delete_city_by_id(:id)";
    private static final String FIND_ALL_SQL = "SELECT * FROM find_all_cities()";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM find_city_by_id(:id)";
    private static final String FIND_BY_NAME_SQL = "SELECT * FROM find_city_by_name(:name)";
    private static final String SAVE_SQL = "SELECT * FROM insert_city(:name)";
    private static final String UPDATE_SQL = "CALL sp_update_city(:id, :name)";


    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private void fillCities(ArrayList<City> cities,  ResultSet rs) throws SQLException  //RowCallbackHandler functional interface - abstract method implementation
    {
        do
            cities.add(new City(rs.getLong(1), rs.getString(2)));    // Db column indexes start from 1.
                                                                                            // rs.getLong(1) = city_id, rs.getString(2) = name at "cities" table in DB
                                                                                            // rs.getLong("city_id") = city_id, rs.getString("name") = name at "cities" table in DB
                                                                                            // using column indexes is rather faster than using column labels.
        while (rs.next());
    }

    public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void deleteById(Long id)
    {
        var paramaterMap = new HashMap<String, Object>();

        paramaterMap.put("id", id);

        m_namedParameterJdbcTemplate.update(DELETE_BY_ID_SQL, paramaterMap);
    }

    @Override
    public boolean existsById(Long id)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public Iterable<City> findByName(String name)
    {
        var cities = new ArrayList<City>();
        var parameterMap = new HashMap<String, Object>();

        parameterMap.put("name", name);

        m_namedParameterJdbcTemplate.query(FIND_BY_NAME_SQL, parameterMap, (ResultSet rs) -> fillCities(cities, rs));

        return cities;
    }


    @Override
    public Iterable<City> findAll()
    {
        var cities = new ArrayList<City>();

        m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, rs -> {fillCities(cities, rs);});

        return cities;
    }

    @Override
    public Optional<City> findById(Long id)
    {
        var cities = new ArrayList<City>();
        var parameterMap = new HashMap<String, Object>();

        parameterMap.put("id", id);  // <FIND_BY_ID_SQL = "SELECT * FROM cities WHERE ID = :id";>
                                     // this :id is the first parameter, matches with the City entity's id field.

        m_namedParameterJdbcTemplate.query(FIND_BY_ID_SQL, parameterMap, (ResultSet rs) -> fillCities(cities, rs));

        return cities.isEmpty() ? Optional.empty() : Optional.of(cities.get(0));
    }


    @Override
    public <S extends City> S save(S city)
    {
        var parameterMap = new HashMap<String, Object>();

        parameterMap.put("name", city.getName());
        m_namedParameterJdbcTemplate.query(SAVE_SQL, parameterMap, (ResultSet rs) -> city.setId(rs.getLong(1)));

        return city;
    }

    ////////////////////// Bunu Berkay ile yazacağız /////////////////
    @Override
    public City updateCity(City city)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }
    ////////////////////// Bunu Berkay ile yazacağız ////////////////

//////////////////////////////////////////////////////////////

    @Override
    public long count()
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void delete(City entity)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteAll(Iterable<? extends City> entities)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public Iterable<City> findAllById(Iterable<Long> ids)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }

    @Override
    public <S extends City> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not implemented yet!.. ");
    }
}

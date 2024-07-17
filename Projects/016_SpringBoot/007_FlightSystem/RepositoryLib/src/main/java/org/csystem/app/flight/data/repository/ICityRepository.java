package org.csystem.app.flight.data.repository;

import org.csystem.app.flight.data.entity.City;
import org.csystem.data.exception.repository.ICrudRepository;

import java.util.Optional;

public interface ICityRepository extends ICrudRepository<City, Long> {
    Iterable<City> findByName(String name);
}

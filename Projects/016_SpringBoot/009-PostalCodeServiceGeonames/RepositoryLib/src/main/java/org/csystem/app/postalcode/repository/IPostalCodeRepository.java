package org.csystem.app.postalcode.repository;

import org.csystem.app.postalcode.entity.PostalCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostalCodeRepository extends CrudRepository<PostalCode, Long> {
    Iterable<PostalCode> findByPostalCodeBetween(@Param("first") long first,  //Kütüphaneden kullanacaksak @Param ile işaretlemek gerekiyor.
                                                 @Param("last") long last);

}

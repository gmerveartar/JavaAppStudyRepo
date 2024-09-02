package org.csystem.app.postalcode.repository;

import org.csystem.app.postalcode.entity.PostalCode;
import org.csystem.app.postalcode.entity.PostalCodeInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostalCodeInfoRepository extends CrudRepository<PostalCodeInfo, Long> {
    @Query(value = "select pi from PostalCodeInfo pi where pi.adminName1 = :adminName")
    Iterable<PostalCodeInfo> findByAdminName1(@Param("adminName") String adminName);
    Iterable<PostalCodeInfo> findByAdminName1Contains(@Param("text") String text);

}

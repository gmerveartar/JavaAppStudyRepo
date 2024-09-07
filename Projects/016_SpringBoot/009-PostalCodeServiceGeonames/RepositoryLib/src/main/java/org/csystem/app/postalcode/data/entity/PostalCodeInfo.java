package org.csystem.app.postalcode.data.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "postal_code_info")
public class PostalCodeInfo {       //POJO (Plain Old Java Object)  -- (One to Many) A postalCode may have many postalCodeInfo --
    @Id
    @Column(name = "postal_code_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String adminCode2;

    public String adminCode1;

    public String adminName2;

    public double lng;

    public String countryCode;

    public String adminName1;

    @Column(name = "iso3166_2")
    public String iSO31662;

    public String placeName;

    public String postalCodeValue;

    public double lat;

    public String adminCode3;

    public String adminName3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_id", nullable = false)
    public PostalCode postalCode;
}

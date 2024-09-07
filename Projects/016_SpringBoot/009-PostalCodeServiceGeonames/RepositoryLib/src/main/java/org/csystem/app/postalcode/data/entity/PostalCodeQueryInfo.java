package org.csystem.app.postalcode.data.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


@EqualsAndHashCode
@ToString
@Entity
public class PostalCodeQueryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public LocalDateTime queryDatetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_id", nullable = false)
    public PostalCode postalCode;
}

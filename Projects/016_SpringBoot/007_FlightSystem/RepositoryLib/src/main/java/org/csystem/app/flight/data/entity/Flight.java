package org.csystem.app.flight.data.entity;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Flight {
    @Accessors(prefix = "m_")
    private String m_id;

    @Accessors(prefix = "m_")
    private long m_departureAirportId;

    @Accessors(prefix = "m_")
    private long m_destinationAirportId;

    @Accessors(prefix = "m_")
    private LocalDateTime m_departureTime;

    @Accessors(prefix = "m_")
    private LocalDateTime m_returnTime;

    @Accessors(prefix = "m_")
    private double m_price;

}

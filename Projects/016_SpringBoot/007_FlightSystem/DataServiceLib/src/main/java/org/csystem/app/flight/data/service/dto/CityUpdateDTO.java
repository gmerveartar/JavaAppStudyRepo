package org.csystem.app.flight.data.service.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CityUpdateDTO {
    @Accessors(prefix = "m_")
    private String m_name;
}

package org.csystem.app.flight.data.service.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.csystem.app.flight.data.entity.City;
import org.springframework.stereotype.Component;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CitySaveDTO {
    @Accessors(prefix = "m_")
    private String m_name;
}

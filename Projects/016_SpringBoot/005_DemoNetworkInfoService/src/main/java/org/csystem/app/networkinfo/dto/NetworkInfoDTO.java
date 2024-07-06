package org.csystem.app.networkinfo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
public class NetworkInfoDTO {
    @Accessors(prefix = "m_")
    private String m_firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("middleName")
    @Accessors(prefix = "m_")
    private String m_middleName;

    @Accessors(prefix = "m_")
    private String m_lastName;

    @Accessors(prefix = "m_")
    private String m_remoteHost;

    @Accessors(prefix = "m_")
    private String m_localAddress;

    @JsonProperty("ephemeralPort")
    @Accessors(prefix = "m_")
    private int m_remotePort; //ephemeral port

    @Accessors(prefix = "m_")
    private int m_localPort;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("serviceRequestTime")
    @Accessors(prefix = "m_")
    private LocalDateTime m_serviceRequestTime;

}

package de.cw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlexaRequestDto {

    private SessionDto session;

    private RequestDto request;

}

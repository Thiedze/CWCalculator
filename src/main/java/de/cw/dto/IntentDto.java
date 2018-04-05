package de.cw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntentDto {

    private IntentNameDto name;

    private String confirmationStatus;

    private SlotsDto slots;


}

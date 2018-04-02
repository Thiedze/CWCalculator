package de.cw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntentDto {

    private String name;

    private String confirmationStatus;

    private SlotsDto slots;


}

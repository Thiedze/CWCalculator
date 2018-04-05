package de.cw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlotDto {

    private String name;

    private Object value;

    private String confirmationStatus;

}

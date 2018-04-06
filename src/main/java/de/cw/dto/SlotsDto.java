package de.cw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlotsDto {

    private SlotDto digitOne;

    private SlotDto digitTwo;

}

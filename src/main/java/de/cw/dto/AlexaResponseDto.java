package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class AlexaResponseDto {

    @Getter
    private String version = "1.0";

    @Getter
    private ResponseDto response = new ResponseDto();

    @Getter
    private Boolean shouldEndSession = true;

}

package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ResponseDto {

    @Getter
    private OutputSpeechDto outputSpeech = new OutputSpeechDto();

}

package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ResponseDto {

    @Getter
    private Boolean shouldEndSession = true;

    @Getter
    private OutputSpeechDto outputSpeech = new OutputSpeechDto();

    @Getter
    private CardDto card = new CardDto();

    //@Getter
    //private List<DirectiveDto> directives = new ArrayList<>();

}

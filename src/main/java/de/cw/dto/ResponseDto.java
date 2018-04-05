package de.cw.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class ResponseDto {

    @Getter
    private OutputSpeechDto outputSpeech = new OutputSpeechDto();

    @Getter
    private CardDto card = new CardDto();

    /*
    @Getter
    private List<DirectiveDto> directives = new ArrayList<>();
    */
}

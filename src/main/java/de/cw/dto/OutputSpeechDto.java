package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class OutputSpeechDto {

    @Getter
    private String type = "PlainText";

    private String text;

}

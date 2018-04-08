package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class OutputSpeech {

    @Getter
    private String type;

    private String text;

    public OutputSpeech() {
        this.type = "PlainText";
    }

}

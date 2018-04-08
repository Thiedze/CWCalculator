package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class Reprompt {

    @Getter
    private OutputSpeech outputSpeech;

    public Reprompt() {
        this.outputSpeech = new OutputSpeech();
    }

}
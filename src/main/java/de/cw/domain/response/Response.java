package de.cw.domain.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class Response {

    private Boolean shouldEndSession;

    @Getter
    private OutputSpeech outputSpeech;

    @Getter
    private Reprompt reprompt;

    @Getter
    private Card card;

    @Getter
    private List<Directive> directives;

    public Response() {
        this.shouldEndSession = false;
        this.outputSpeech = new OutputSpeech();
        this.reprompt = new Reprompt();
        this.card = new Card();
        this.directives = new ArrayList<>();
    }

}
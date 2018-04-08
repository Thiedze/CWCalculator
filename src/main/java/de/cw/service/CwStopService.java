package de.cw.service;

import de.cw.domain.response.AlexaResponse;

public class CwStopService {

    public AlexaResponse response() {
        AlexaResponse alexaResponse = new AlexaResponse();
        alexaResponse.getResponse().setShouldEndSession(true);
        alexaResponse.getResponse().getOutputSpeech().setText(getIntentText());
        return alexaResponse;
    }

    private String getIntentText() {
        return "Campuswoche wird beendet.";
    }

}

package de.cw.service;

import de.cw.domain.response.AlexaResponse;

public class CwInfoService {

    public AlexaResponse response() {
        AlexaResponse alexaResponse = new AlexaResponse();
        alexaResponse.getResponse().getOutputSpeech().setText("Ich kann addieren.");
        return alexaResponse;
    }

}

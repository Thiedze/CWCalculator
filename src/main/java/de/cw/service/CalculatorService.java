package de.cw.service;

import de.cw.domain.request.AlexaRequest;
import de.cw.domain.response.AlexaResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorService {

    private CwPlusService cwPlusService;

    private CwStopService cwStopService;

    public CalculatorService() {
        this.cwPlusService = new CwPlusService();
        this.cwStopService = new CwStopService();
    }

    public AlexaResponse interprete(AlexaRequest alexaRequest) {
        switch (alexaRequest.getRequest().getIntent().getName()) {
            case CWPlus:
                return cwPlusService.response(alexaRequest.getRequest().getIntent());
            case CWStop:
                return cwStopService.response();
            default:
                AlexaResponse alexaResponse = new AlexaResponse();
                alexaResponse.getResponse().setShouldEndSession(true);
                return alexaResponse;
        }
    }

}

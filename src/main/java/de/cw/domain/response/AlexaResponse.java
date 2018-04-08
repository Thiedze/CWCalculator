package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class AlexaResponse {

    @Getter
    private String version;

    @Getter
    private Response response;

    public AlexaResponse() {
        this.version = "1.0";
        this.response = new Response();
    }

}

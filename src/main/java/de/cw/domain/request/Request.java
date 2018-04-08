package de.cw.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private String type;

    private String requestId;

    private String timestamp;

    private String locale;

    private Intent intent;

}

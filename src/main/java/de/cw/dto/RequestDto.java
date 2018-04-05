package de.cw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto {

    private String type;

    private String requestId;

    private String timestamp;

    private String locale;

    private IntentDto intent;

}

package de.cw.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slot {

    private String name;

    private Object value;

    private String confirmationStatus;

}

package de.cw.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slots {

    private Slot digitOne;

    private Slot digitTwo;

}

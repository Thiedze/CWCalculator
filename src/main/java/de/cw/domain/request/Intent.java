package de.cw.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.cw.domain.IntentName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intent {

    private IntentName name;

    private String confirmationStatus;

    private Slots slots;

}

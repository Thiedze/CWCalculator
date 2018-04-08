package de.cw.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupportedInterfaces {

    @JsonProperty("AudioPlayer")
    private AudioPlayer audioPlayer;

    @JsonProperty("VideoApp")
    private VideoApp videoApp;

    @JsonProperty("Display")
    private Display display;

}

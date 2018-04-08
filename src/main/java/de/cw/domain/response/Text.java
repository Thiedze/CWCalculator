package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class Text {

    @Getter
    private String type;

    private String text;

    public Text() {
        this.type = "RichText";
    }

}
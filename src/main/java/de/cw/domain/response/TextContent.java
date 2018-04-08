package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class TextContent {

    @Getter
    private Text primaryText;

    @Getter
    private Text secondaryText;

    @Getter
    private Text tertiaryText;

    public TextContent() {
        this.primaryText = new Text();
        this.secondaryText = new Text();
        this.tertiaryText = new Text();
    }

}
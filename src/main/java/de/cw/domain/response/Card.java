package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class Card {

    @Getter
    private String type;

    private String title;

    private String content;

    private String text;

    @Getter
    private Image image;

    public Card() {
        this.type = "Standard";
        this.image = new Image();
    }

}

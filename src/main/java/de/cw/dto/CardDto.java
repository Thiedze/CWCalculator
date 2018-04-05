package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class CardDto {

    @Getter
    private String type = "Standard";

    private String title;

    private String content;

    private String text;

    private ImageDto image = new ImageDto();

}

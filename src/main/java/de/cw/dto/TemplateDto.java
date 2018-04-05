package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class TemplateDto {

    private String type;

    private String token;

    private String backButton = "VISIBLE";

    private String backgroundImage;

    private String title;

    private TextContentDto textContent = new TextContentDto();
}
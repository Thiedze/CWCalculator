package de.cw.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class DirectiveDto {

    @Getter
    private String type = "Display.RenderTemplate";

    private TemplateDto template = new TemplateDto();
}
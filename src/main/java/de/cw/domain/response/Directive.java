package de.cw.domain.response;

import lombok.Data;
import lombok.Getter;

@Data
public class Directive {

    @Getter
    private String type;

    @Getter
    private Template template;

    public Directive() {
        this.type = "Display.RenderTemplate";
        this.template = new Template();
    }
}
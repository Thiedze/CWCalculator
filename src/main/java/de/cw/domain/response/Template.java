package de.cw.domain.response;

import java.security.SecureRandom;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.Data;
import lombok.Getter;

@Data
public class Template {

    private String type;

    private String title;

    @Getter
    private String token;

    private String backButton;

    @Getter
    private BackgroundImage backgroundImage;

    @Getter
    private TextContent textContent;

    public Template() {
        this.backButton = "VISIBLE";
        this.backgroundImage = new BackgroundImage();
        this.textContent = new TextContent();
    }

    public String getToken() {
        Date date = new Date();
        return new Integer(Math.abs(date.hashCode())).toString();
    }
}
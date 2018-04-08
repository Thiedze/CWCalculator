package de.cw.service;

import de.cw.domain.request.Intent;
import de.cw.domain.response.AlexaResponse;
import de.cw.domain.response.Card;
import de.cw.domain.response.Directive;
import de.cw.domain.response.Reprompt;
import de.cw.domain.response.Source;
import org.apache.commons.lang.StringUtils;

public class CwPlusService {

    public AlexaResponse response(Intent intent) {
        AlexaResponse alexaResponse = new AlexaResponse();
        if (intent != null) {
            alexaResponse.getResponse().getOutputSpeech().setText(getIntentText(intent));
            alexaResponse.getResponse().setReprompt(getReprompt(intent));
            alexaResponse.getResponse().setCard(getIntentCard(intent));
            //alexaResponse.getResponse().getDirectives().add(getIntentDirective(intent));
        }
        return alexaResponse;
    }

    private Card getIntentCard(Intent intent) {
        Card card = new Card();
        card.setTitle("Addieren");
        card.setText(getIntentText(intent));
        card.getImage().setLargeImageUrl("https://tomcat.campuswoche.de/cwcalculator/images/background.jpg");
        card.getImage().setSmallImageUrl("https://tomcat.campuswoche.de/cwcalculator/images/background.jpg");
        return card;
    }

    private Directive getIntentDirective(Intent intent) {
        Directive directive = new Directive();
        directive.getTemplate().setType("BodyTemplate1");
        directive.getTemplate().setTitle("Addieren");

        directive.getTemplate().getTextContent().getPrimaryText().setText(getIntentText(intent));

        Source source = new Source();
        source.setUrl("https://tomcat.campuswoche.de/cwcalculator/images/background.jpg");
        directive.getTemplate().getBackgroundImage().getSources().add(source);

        return directive;
    }

    private String getIntentText(Intent intent) {
        String output = "";
        if (intent.getSlots().getDigitOne() != null && intent.getSlots().getDigitTwo() != null) {
            if (StringUtils.isNumeric(intent.getSlots().getDigitOne().getValue().toString()) && StringUtils
                .isNumeric(intent.getSlots().getDigitTwo().getValue().toString())) {

                Integer digitOneValue = new Integer(intent.getSlots().getDigitOne().getValue().toString());
                Integer digitTwoValue = new Integer(intent.getSlots().getDigitTwo().getValue().toString());

                output = "Die Campuswoche hat die korrekte Antwort berechnet. \nSie lautet\n\n " + (digitOneValue
                    + digitTwoValue) + ". \n\n\n";
                output += "Stelle mir eine weitere Aufgabe. Ich kann addieren.";
            }
        }
        return output;
    }

    private Reprompt getReprompt(Intent intent) {
        Reprompt reprompt = new Reprompt();
        reprompt.getOutputSpeech().setText(
            "Stelle mir eine weitere Aufgabe. Ich kann addieren.");
        return reprompt;
    }

}

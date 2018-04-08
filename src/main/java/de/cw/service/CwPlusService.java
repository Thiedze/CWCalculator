package de.cw.service;

import de.cw.domain.request.AlexaRequest;
import de.cw.domain.request.Intent;
import de.cw.domain.response.AlexaResponse;
import de.cw.domain.response.Card;
import de.cw.domain.response.Directive;
import de.cw.domain.response.Reprompt;
import de.cw.domain.response.Source;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class CwPlusService {

    public AlexaResponse response(AlexaRequest alexaRequest) {
        AlexaResponse alexaResponse = new AlexaResponse();
        try {
            Intent intent = alexaRequest.getRequest().getIntent();
            if (intent != null) {
                alexaResponse.getResponse().getOutputSpeech().setText(getIntentText(intent));
                alexaResponse.getResponse().setReprompt(getReprompt(intent));
                alexaResponse.getResponse().setCard(getIntentCard(intent));
                if (alexaRequest.getContext().getSystem().getDevice().getSupportedInterfaces().getDisplay() != null) {
                    alexaResponse.getResponse().getDirectives().add(getIntentDirective(intent));
                }
            } else {
                alexaResponse.getResponse().setShouldEndSession(true);
                alexaResponse.getResponse().getOutputSpeech().setText("Es ist ein Fehler aufgetreten.");
            }
        } catch (Exception exception) {
            log.error(exception.getMessage());
            alexaResponse.getResponse().setShouldEndSession(true);
            alexaResponse.getResponse().getOutputSpeech().setText("Es ist ein Fehler aufgetreten.");
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
                output += "Stelle mir eine weitere Aufgabe.";
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

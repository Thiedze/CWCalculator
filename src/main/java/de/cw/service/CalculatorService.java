package de.cw.service;

import de.cw.dto.AlexaRequestDto;
import de.cw.dto.AlexaResponseDto;
import de.cw.dto.CardDto;
import de.cw.dto.DirectiveDto;
import de.cw.dto.IntentDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class CalculatorService {

    public AlexaResponseDto interprete(AlexaRequestDto alexaRequestDto) {
        switch (alexaRequestDto.getRequest().getIntent().getName()) {
            case CWPlus:
                return interpreteCwPlusIntent(alexaRequestDto.getRequest().getIntent());
            default:
                return new AlexaResponseDto();
        }
    }

    private AlexaResponseDto interpreteCwPlusIntent(IntentDto intentDto) {
        AlexaResponseDto alexaResponseDto = new AlexaResponseDto();
        if (intentDto != null) {
            alexaResponseDto.getResponse().getOutputSpeech().setText(getCwPlusIntentText(intentDto));
            alexaResponseDto.getResponse().setCard(getCwPlusIntentCard(intentDto));
            //alexaResponseDto.getResponse().getDirectives().add(getCwPlusIntentDirective(intentDto));
        }
        return alexaResponseDto;
    }

    private CardDto getCwPlusIntentCard(IntentDto intentDto) {
        CardDto cardDto = new CardDto();
        cardDto.setTitle("Plus");
        cardDto.setText(getCwPlusIntentText(intentDto));
        return cardDto;
    }

    private DirectiveDto getCwPlusIntentDirective(IntentDto intentDto) {
        DirectiveDto directiveDto = new DirectiveDto();
        directiveDto.getTemplate().setType("BodyTemplate1");
        directiveDto.getTemplate().setToken("plus");
        directiveDto.getTemplate().setTitle("Addieren");

        directiveDto.getTemplate().getTextContent().getPrimaryText().setType("RichText");
        directiveDto.getTemplate().getTextContent().getPrimaryText().setText(getCwPlusIntentText(intentDto));

        directiveDto.getTemplate()
            .setBackgroundImage("https://tomcat.campuswoche.de/cwcalculator/images/background.jpg");

        return directiveDto;
    }

    private String getCwPlusIntentText(IntentDto intentDto) {
        String output = "";
        if (intentDto.getSlots().getDigitOne() != null && intentDto.getSlots().getDigitTwo() != null) {
            if (StringUtils.isNumeric(intentDto.getSlots().getDigitOne().getValue().toString()) && StringUtils
                .isNumeric(intentDto.getSlots().getDigitTwo().getValue().toString())) {

                Integer digitOneValue = new Integer(intentDto.getSlots().getDigitOne().getValue().toString());
                Integer digitTwoValue = new Integer(intentDto.getSlots().getDigitTwo().getValue().toString());

                output = digitOneValue + " plus " + digitTwoValue + " ist gleich " + (digitOneValue + digitTwoValue);
            }
        }
        return output;
    }

}

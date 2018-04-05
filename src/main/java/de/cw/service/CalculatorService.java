package de.cw.service;

import de.cw.dto.AlexaRequestDto;
import de.cw.dto.AlexaResponseDto;
import de.cw.dto.IntentDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorService {

    public AlexaResponseDto interprete(AlexaRequestDto alexaRequestDto) {
        AlexaResponseDto alexaResponseDto = new AlexaResponseDto();
        log.info(alexaRequestDto.getRequest().getIntent().getName().toString());
        switch (alexaRequestDto.getRequest().getIntent().getName()) {
            case CWPlus:
                alexaResponseDto.getResponse().getOutputSpeech()
                    .setText(interpreteCwPlusIntent(alexaRequestDto.getRequest().getIntent()));
                break;
        }
        return alexaResponseDto;
    }

    private String interpreteCwPlusIntent(IntentDto intentDto) {
        String output = "";
        if (intentDto.getSlots().getDigitOne() != null && intentDto.getSlots().getDigitTwo() != null) {
            Integer digitOneValue = new Integer(intentDto.getSlots().getDigitOne().getValue().toString());
            Integer digitTwoValue = new Integer(intentDto.getSlots().getDigitTwo().getValue().toString());

            output = digitOneValue + " plus " + digitTwoValue + " ist gleich " + (digitOneValue + digitTwoValue);
        }
        return output;
    }

}

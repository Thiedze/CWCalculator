package de.cw.controller;

import de.cw.dto.AlexaRequestDto;
import de.cw.dto.AlexaResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = "/v1", method = RequestMethod.POST)
public class CalculatorPostController {

    @RequestMapping(value = "/request")
    @ResponseBody
    public AlexaResponseDto createCustomerBankAccount(@RequestBody AlexaRequestDto alexaRequestDto) {
        log.info("Post");
        AlexaResponseDto alexaResponseDto = new AlexaResponseDto();
        alexaResponseDto.getResponse().getOutputSpeech().setText("42");
        return alexaResponseDto;
    }

}

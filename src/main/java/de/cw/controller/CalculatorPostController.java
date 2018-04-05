package de.cw.controller;

import de.cw.dto.AlexaRequestDto;
import de.cw.dto.AlexaResponseDto;
import de.cw.exception.PermissionDeniedException;
import de.cw.service.CalculatorService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = "/v1", method = RequestMethod.POST)
public class CalculatorPostController {

    @Autowired
    private List<String> applicationIds;

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/request")
    @ResponseBody
    public AlexaResponseDto createCustomerBankAccount(@RequestBody AlexaRequestDto alexaRequestDto) {
        log.info("Post applicationId: " + alexaRequestDto.getSession().getApplication().getApplicationId());
        if(applicationIds.contains(alexaRequestDto.getSession().getApplication().getApplicationId())) {
            return calculatorService.interprete(alexaRequestDto);
        } else {
            throw new PermissionDeniedException();
        }
    }

}
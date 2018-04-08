package de.cw.controller;

import de.cw.domain.request.AlexaRequest;
import de.cw.domain.response.AlexaResponse;
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
    public AlexaResponse createCustomerBankAccount(@RequestBody AlexaRequest alexaRequest) {
        log.info(alexaRequest.toString());
        if (applicationIds.contains(alexaRequest.getSession().getApplication().getApplicationId())) {
            AlexaResponse alexaResponse = calculatorService.interprete(alexaRequest);
            log.info(alexaResponse.toString());
            return alexaResponse;
        } else {
            throw new PermissionDeniedException();
        }
    }

}
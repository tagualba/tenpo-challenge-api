package com.tenpo.challenge.api.controllers;

import com.tenpo.challenge.api.exceptions.ControllerHandlerException;
import com.tenpo.challenge.api.exceptions.RandomPercentageClientException;
import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.services.CalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/tenpo/calculate")
@RestController
public class CalculateController {

    private static final Logger log = LoggerFactory.getLogger(ControllerHandlerException.class);

    @Autowired
    private CalculateService calulateServices;

    @GetMapping
    public String calculate(@RequestParam Double valueA, @RequestParam Double valueB)
            throws ValidationException, RandomPercentageClientException {
        log.info(String.format("Event: %s - Request: %s", "calculate {%s} + {%s}" , valueA, valueB));
        String response = calulateServices.calculate(valueA, valueB);
        log.info(String.format("Event: %s - Response: %s", "calculate result: %s", response));
        return response;
    }
}

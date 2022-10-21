package com.tenpo.challenge.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/tenpo/percentage")
@RestController
public class MockRandomPercentageClientController {

    @GetMapping
    public Integer getPercentage(){
        Double random = Math.random() *(100-1+1)+1;
        return random.intValue();
    }
}

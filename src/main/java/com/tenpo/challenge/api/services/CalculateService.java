package com.tenpo.challenge.api.services;

import com.tenpo.challenge.api.client.RandomPercentageClient;
import com.tenpo.challenge.api.exceptions.RandomPercentageClientException;
import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.statics.ErrorCode;
import com.tenpo.challenge.api.utils.JwtUtil;
import com.tenpo.challenge.api.validators.CalculateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    @Autowired
    private RandomPercentageClient randomPercentageClient;

    @Autowired
    private JwtUtil jwtUtill;

    public String calculate(Double valueA, Double valueB, String tokenApiKey) throws ValidationException, RandomPercentageClientException {
        CalculateValidator.validateValues(valueA, valueB);
        if(!jwtUtill.validate(tokenApiKey))
        {
            throw new ValidationException(ErrorCode.INVALID_TOKEN);
        }

        Integer percentage = randomPercentageClient.getPercentageNow();

        Double result = valueA + valueB;
        result = result + calculatePercentage(percentage, result);

        return String.format("{ (%s + %s) + %s%% = %s }", valueA, valueB, percentage, result);
    }

    private Double calculatePercentage(Integer percentage, Double value){
        return value * (percentage / Double.valueOf(100));
    }

}

package com.tenpo.challenge.api.services;

import com.tenpo.challenge.api.client.RandomPercentageClient;
import com.tenpo.challenge.api.exceptions.RandomPercentageClientException;
import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.validators.CalculateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    @Autowired
    private RandomPercentageClient randomPercentageClient;


    public String calculate(Double valueA, Double valueB) throws ValidationException, RandomPercentageClientException {
        CalculateValidator.validateValues(valueA, valueB);
        Integer percentage = randomPercentageClient.getPercentageNow();
        String response = "(%s + %s) + %s% = %s)";
        Double result = valueA + valueB;
        result = result + calculatePercentage(percentage, result);

        return String.format(response, valueA, valueB, percentage, result);
    }

    private Double calculatePercentage(Integer percentage, Double value){
        return value * (percentage / 100);
    }

}

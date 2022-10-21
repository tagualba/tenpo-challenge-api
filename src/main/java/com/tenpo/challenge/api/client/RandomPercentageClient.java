package com.tenpo.challenge.api.client;

import com.tenpo.challenge.api.exceptions.RandomPercentageClientException;

public interface RandomPercentageClient {

    Integer getPercentageNow() throws RandomPercentageClientException;

}

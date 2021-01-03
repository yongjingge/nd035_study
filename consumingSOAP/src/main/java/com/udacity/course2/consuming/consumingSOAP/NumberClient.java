package com.udacity.course2.consuming.consumingSOAP;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import com.dataaccess.webservicesserver.NumberToWords;

import java.math.BigInteger;

public class NumberClient extends WebServiceGatewaySupport {

    public NumberToWordsResponse getWords (String numbers) {

        // publicly accessible SOAP service
        String uri = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

        // set the request
        NumberToWords numberRequest = new NumberToWords();
        numberRequest.setUbiNum(new BigInteger(numbers));

        // obtain and return the response
        NumberToWordsResponse res = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(uri, numberRequest);

        return res;
    }
}

package com.gyan.msdesign.service;

import com.gyan.msdesign.entity.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class CurrencyConversionService {


    public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity){
        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        System.out.println("sending request");
        ResponseEntity<CurrencyConversion> conversionResponse =   new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,uriVariables);
        System.out.println("response from currency exchange service "+conversionResponse.getStatusCode());
        CurrencyConversion currencyConversion = conversionResponse.getBody();

        return   new CurrencyConversion(currencyConversion.getId(),
                from,
                to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment());

    }
}

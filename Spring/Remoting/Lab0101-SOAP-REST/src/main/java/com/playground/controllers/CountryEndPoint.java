package com.playground.controllers;


import com.playground.endpoints.GetCountryRequest;
import com.playground.endpoints.GetCountryResponse;
import com.playground.services.impls.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndPoint {
    private static final String NAMESPACE = "http://testwebservice/soap";

    private CountryService countryService;

    @Autowired
    public CountryEndPoint(CountryService countryService){
        this.countryService = countryService;
    }


    @PayloadRoot(namespace = NAMESPACE, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest request){
        System.out.println(request);
        System.out.println(request.getName());
        GetCountryResponse resp = new GetCountryResponse();
        resp.setCountry(countryService.findCountryByName(request.getName()));
        return  resp;
    }

}

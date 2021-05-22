package com.playground.services.impls;


import com.playground.endpoints.Country;
import com.playground.endpoints.Currency;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {


    public List<Country> countryList = new ArrayList<>();

    public  CountryService(){

        for(int i = 1 ; i <= 5; i++){
            Country country = new Country();
            country.setCapital("Capital");
            country.setName("country"+i);
            country.setPopulation(i*1000);
            country.setCurrency(Currency.valueOf("GBP"));
            countryList.add(country);
        }
    }

    public Country findCountryByName(String name){

        System.out.println(name);

//        Optional<Country> c = countryList.stream().filter(country -> country.getName().equals(name))
//                .findFirst();
//        return c.get();
        return  countryList.get(2);
    }


}

package com.example.backingbeans;


import com.example.EJBs.interfaces.CurrencyConverter;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named(value = "currency")
@SessionScoped
public class Currency implements Serializable {

    @EJB
    private  CurrencyConverter currencyConverter;

    private  double input = 0;
    private double yen = 0;
    private double euro = 0;

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }

    public double getYen() {
        return yen;
    }

    public void setYen(double yen) {
        this.yen = yen;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }


    public void calc(){
        yen = currencyConverter.dollarsToYen(input);
        euro = currencyConverter.dollarsToEuro(input);
    }


}

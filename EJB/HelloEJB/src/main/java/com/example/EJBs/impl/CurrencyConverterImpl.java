package com.example.EJBs.impl;


import com.example.EJBs.interfaces.CurrencyConverter;
import jakarta.ejb.Stateless;

@Stateless
public class CurrencyConverterImpl implements CurrencyConverter {

    private final double yenRate = 104.34;
    private final double euroRate = 0.007;


    @Override
    public double dollarsToYen(double amount) {
        return amount * yenRate;
    }

    @Override
    public double dollarsToEuro(double amount) {
        return amount * euroRate;
    }
}

package com.example.EJBs.interfaces;


import jakarta.ejb.Local;

@Local
public interface CurrencyConverter {

    public double dollarsToYen(double amount);
    public double dollarsToEuro(double amount);

}

package com.playground.services;

public class CalculatorServiceImpl implements Calculator{

    public CalculatorServiceImpl(){

    }

    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public double sub(double x, double y) {
        return x-y;
    }

    @Override
    public double mul(double x, double y) {
        System.out.println("**In The Multiply Method**");
        return x*y;
    }

    @Override
    public double div(double x, double y) {
        
        if(y == 0) throw new IllegalArgumentException("Divsion By Zero");
        return x/y;
    }

}
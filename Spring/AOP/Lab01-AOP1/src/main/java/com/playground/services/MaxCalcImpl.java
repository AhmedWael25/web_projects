package com.playground.services;

public class MaxCalcImpl implements MaxCalc{

    @Override
    public double findMax(double x, double y) {
        double result = (x >= y)? x:y;
        System.out.println("From findMax:max is ="+ result );
        return result;
    }
    
}

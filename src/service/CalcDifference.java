package service;

import model.NumberDecor;

public class CalcDifference extends NumberDecor {

    public CalcDifference(double number, Calculate calculate) {
        super(number, calculate);
    }


    @Override
    public double calculate() {
        return  calculate.calculate()-super.getNumber() ;
    }
}

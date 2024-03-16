package service;

import model.NumberDecor;

public class CalcSum extends NumberDecor {

    public CalcSum(double number, Calculate calculate) {
        super(number, calculate);
    }

    @Override
    public double calculate() {
        return calculate.calculate()+super.getNumber();
    }
}

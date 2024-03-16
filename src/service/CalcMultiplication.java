package service;

import model.NumberDecor;

public class CalcMultiplication extends NumberDecor {
    public CalcMultiplication(Double number, Calculate calculate) {
        super(number, calculate);
    }

    @Override
    public double calculate() {
        return calculate.calculate()*super.getNumber();
    }
}

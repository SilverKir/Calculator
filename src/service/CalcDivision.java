package service;

import model.NumberDecor;

public class CalcDivision extends NumberDecor {
    public CalcDivision(Double number, Calculate calculate) {
        super(number, calculate);
    }

    @Override
    public double calculate() {
        if (super.getNumber() == 0) {
            if (calculate.calculate() == 0) {
                return 1;
            } else {
                return Double.POSITIVE_INFINITY;
            }
        } else {
            return calculate.calculate() / super.getNumber();
        }
    }
}

package model;

import service.Calculate;

public abstract class NumberDecor implements Calculate {
    protected  Calculate calculate;
    Double number;
    public NumberDecor(Double number, Calculate calculate) {
        this.number = number;
        this.calculate = calculate;
    }


    public Double getNumber() {
        return number;
    }
}

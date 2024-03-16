package service;

import model.OperationPriority;

import java.util.Arrays;
import java.util.Stack;

public class ComputePostfixExpression {


    public double ComputePostfixExpr(String expression) {
        Calculate calc;
        DigitVerification dv= new DigitVerification();
        OperationPriority op=new OperationPriority();
        op.setMap();
        var exp = expression.split(" ");
        double res = 0;
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (dv.isDigit(exp[i])) {
                st.push((double) Double.parseDouble(exp[i]));
            } else {
                if (op.containKey(exp[i].charAt(0))&&(op.getPriority(exp[i].charAt(0))>0)) {
                    switch (exp[i]) {
                        case "+":
                            calc = new CalcSum(st.pop(), new CalcSum(st.pop(), new Equals()));
                            res = calc.calculate();
                            st.push(res);
                            break;
                        case "-":
                            calc = new CalcDifference(st.pop(), new CalcSum(st.pop(), new Equals()));
                            res = calc.calculate();
                            ;
                            st.push(res);
                            break;
                        case "*":
                            calc = new CalcMultiplication(st.pop(), new CalcSum(st.pop(), new Equals()));
                            res = calc.calculate();
                            st.push(res);
                            break;
                        case "/":
                            calc = new CalcDivision(st.pop(), new CalcSum(st.pop(), new Equals()));
                            res = calc.calculate();
                            st.push(res);
                            break;
                        default:
                            break;
                    }
                } else {
                    throw  new NullPointerException("Non-valid data");
                }
            }
        }
        return st.pop();
    }

}

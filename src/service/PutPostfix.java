package service;

import model.OperationPriority;

import java.util.Stack;

import static java.lang.Character.isDigit;

public class PutPostfix {
    OperationPriority op = new OperationPriority();
    Integer pos = 0;
    String expression;

    public PutPostfix(String expression) {
        this.expression = expression;
        op.setMap();
        this.pos = 0;
    }

    public String getPostfix() {
        String postfix = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isDigit(ch)) {
                pos = i;
                postfix += getStringNumber() + " ";
                i = pos;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop() + " ";
                }
                stack.pop();
            } else if (ch == ' ') {

            } else {
                if (op.containKey(ch)) {
                    char operator = ch;
                    if (operator == '-' && (i == 0 || (i > 1 && op.containKey(expression.charAt(i - 1))))) {
                        operator = '~';
                    }
                    while (!stack.isEmpty() && (op.getPriority(stack.peek()) >= op.getPriority(operator))) {
                        postfix += stack.pop() + " ";
                    }
                    stack.push(operator);
                } else {
                    throw new NullPointerException("Non-valid data");
                }
            }
        }
        if (stack.size() == 2) {
            char chOne = stack.pop();
            if (op.getPriority(stack.peek()) > op.getPriority(chOne)) {
                postfix += stack.pop() + " ";
                postfix += chOne + " ";
            } else {
                postfix += chOne + " ";
                postfix += stack.pop() + " ";
            }
        }
        for (Character c : stack) {
            postfix += c + " ";
        }
        return postfix;
    }

    private String getStringNumber() {
        String strNumber = "";
        for (int i = pos; i < expression.length(); i++) {
            char num = expression.charAt(i);
            if (num == '.') {
                strNumber += num;
                pos++;
            } else if (isDigit(num)) {
                strNumber += num;
                pos++;
            } else {
                pos = i - 1;
                break;
            }

        }
        return strNumber;
    }

}

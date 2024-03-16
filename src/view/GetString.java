package view;

import java.util.Scanner;

public class GetString {
    Scanner scanner=new Scanner(System.in);
    public String getString(String message){
        System.out.println(message);
        String expression = scanner.nextLine();
        if (expression.trim().length()==0) {
            return getString("Expression is Empty \n" + message);
        }
        return expression;
    }
}

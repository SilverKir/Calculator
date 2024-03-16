package controller;

import service.*;
import view.*;

public class Controller {
 public void StartCalculator(){
     GetString gs = new GetString();
     ComputePostfixExpression cp=new ComputePostfixExpression();
     PrintResult pr = new PrintResult();
     String str=gs.getString("Введите выражение:");
     PutPostfix pp=new PutPostfix(str);
     pr.printResult(str+" = "+cp.ComputePostfixExpr(pp.getPostfix()));

 }
}

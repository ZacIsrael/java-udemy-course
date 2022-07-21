package com.zacisrael;

import java.util.Stack;

public class Postfix {

    public static double evaluatePostfix(String expr){
        String[] tokens = expr.split(" ");
        Stack<Double> operands = new Stack<Double>();
        double result = 0.0;

        // Postfix evaluation algorithm:
        // (1) Operand — Push it onto the stack
        // (2) Operator — Pop the top two operands from the stack
        // and apply operator to it. Push the result back to the stack.

        for (int i =0; i<tokens.length; i++) {
            String token = tokens[i];

            if(token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-")){
                //.. TODO ..//
                double val1 = operands.pop();
                double val2 = operands.pop();
                System.out.println("Operator " + tokens[i]);
                switch (token){
                    case "+": result = val2 + val1;
                        break;
                    case "*": result = val2 * val1;
                        break;
                    case"/": result = val2 / val1;
                        break;
                    case"-": result = val2 - val1;
                        break;
                        default:
                            System.out.println("Invalid operator!");
                            break;
                }
                operands.push(result);
            }
            else // by this point, must be an operand
            {
                operands.push(Double.valueOf(token));
            }
        }
        return result;
    }

    public static void main(String[] args){
        String exprString = "3 4 5 + *";                // Expected: 27
     //   String exprString = "24 1 5 + / 6 1 2 + / -";  // Expected: 2.0
       // String exprString = "2 4 / 5 6 - *";          // Expected: -0.5

        System.out.println( "Evaluation of Postfix Expression: " + exprString + "\n");
        double result = evaluatePostfix(exprString);
        System.out.println( "\n" + exprString + " = " + result );
    }

}

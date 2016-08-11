package org.hirudy.practice;

import java.util.Stack;

/**
 * @author: rudy
 * @date: 2016/08/09
 * function description
 */
public class StackPractice {

    public static void calculate(String expression){
        Stack<Character> ops = new Stack<Character>();
        Stack<Double> values = new Stack<Double>();
        int stringLength = expression.length();
        for(int i=0; i<stringLength; i++){
            char temp = expression.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/'){
                ops.push(temp);
            }else if (temp == '(' || temp == ' '){

            }else if (temp == ')'){
                Double val1 = values.pop();
                Double val2 = values.pop();
                Character op = ops.pop();
                Double result;
                if (op.equals('+')){
                    result = val2 + val1;
                }else if (op.equals('-')){
                    result = val2 - val1;
                }else if (op.equals('*')){
                    result = val2 * val1;
                }else{
                    result = val2 / val1;
                }
                values.push(result);
            }else {
                values.push(Double.parseDouble(Character.toString(temp)));
            }
        }
        Double rel = values.pop();
        System.out.println(rel);
    }

    public static void matchParentheses(String expression){
        Stack<Character> parentheses = new Stack<Character>();
        int stringLength = expression.length();
        for(int i=0; i<stringLength; i++){
            char temp = expression.charAt(i);
            if (temp == '(' || temp == '{' || temp == '['){
                parentheses.push(temp);
            }else if (temp == ')'){
                char lastChar = parentheses.pop();
                if (lastChar != '('){
                    parentheses.push(lastChar);
                    parentheses.push(temp);
                }
            }else if (temp == '}'){
                char lastChar = parentheses.pop();
                if (lastChar != '{'){
                    parentheses.push(lastChar);
                    parentheses.push(temp);
                }
            }else if (temp == ']'){
                char lastChar = parentheses.pop();
                if (lastChar != '['){
                    parentheses.push(lastChar);
                    parentheses.push(temp);
                }
            }
        }
        if (parentheses.empty()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public static void polishParentheses(String expression){
        Stack<String> ops = new Stack<String>();
        Stack<String> values = new Stack<String>();
        int stringLength = expression.length();
        for(int i=0; i<stringLength; i++){
            char temp = expression.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/'){
                ops.push(Character.toString(temp));
            }else if (temp == ' '){

            }else if (temp == ')'){
                String val2 = values.pop();
                String val1 = values.pop();
                String op = ops.pop();
                String value = "(" + val1 + op + val2 + ")";
                values.push(value);
            }else{
                values.push(Character.toString(temp));
            }
        }
        System.out.println(values.pop());
    }

    public static void main(String args[]){
        String expression1 = "( 5 + ( ( 2 + 3 ) - ( 4 * 5) ) )";
        calculate(expression1);

        String expression2 = "[(){}{(})({}([]))]";
        matchParentheses(expression2);

        String expression3 = "5 + 2 + 3 ) - 4 * 5) ) )";
        polishParentheses(expression3);
    }
}

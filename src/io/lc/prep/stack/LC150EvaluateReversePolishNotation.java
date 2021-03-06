package io.lc.prep.stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 * 	• Division between two integers should truncate toward zero.
 * 	• The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Approach: (1) Use the stack,
 * (2) Use the Integer stack to parse and push the values
 * (3) Code will be clean if using the switch statement
 *
 */
public class LC150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Integer first = 0;
        Integer second= 0;
        Integer result = 0;
        for(String token : tokens) {
            //System.out.println(token);
            switch (token) {
                case "+" :
                    second = stack.pop();
                    first  = stack.pop();
                    stack.push(first + second);
                    break;
                case "-" :
                    second = stack.pop();
                    first  = stack.pop();
                    stack.push(first - second);
                    break;
                case "*" :
                    second = stack.pop();
                    first  = stack.pop();
                    stack.push(first * second);
                    break;
                case "/" :
                    second = stack.pop();
                    first  = stack.pop();
                    stack.push((int)first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }

        }

        return stack.isEmpty() ? 0 : stack.pop();
    }


}

package com.lbh.算法第四版.part1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @Description: 双栈算术表达式求值算法
 * @Author lbh
 * @Date 2021/7/26 15:48
 * @Version V1.0
 **/
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            //读取字符，如果是运算符则压入栈
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                Double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                if (op.equals("-")) v = vals.pop() - v;
                if (op.equals("*")) v = vals.pop() * v;
                if (op.equals("/")) v = vals.pop() / v;
                if (op.equals("sqrt")) v = Math.sqrt(v);
            }//如果字符既非运算符也不是括号，则将它作为double值入栈
            else vals.push(Double.parseDouble(s));
        }
        StdOut.print(vals.pop());

    }
}

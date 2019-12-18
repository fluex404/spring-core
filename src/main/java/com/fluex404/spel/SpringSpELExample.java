package com.fluex404.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringSpELExample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = null;

        // concat
        exp = parser.parseExpression("'Welcome SPEL'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);

        //String to bytes
        exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        for(int i=0;i<bytes.length;i++) {
            System.out.print(bytes[i]+" ");
        }

        //String into Uppercase
        exp = parser.parseExpression("'Hello World'.toUpperCase()");
        String msg = (String) exp.getValue();
        System.out.println(msg);

    }
}

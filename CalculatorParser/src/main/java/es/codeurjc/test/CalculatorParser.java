package es.codeurjc.test;

public class CalculatorParser {

    public int parse(String expression) {
        if ((expression.length() == 1) && (Character.isLetter(expression.charAt(0)))) {
            throw new NumberFormatException("The expression received is not a number.");
        }
        else {
            return Integer.parseInt(expression);
        }
    }	
}
package es.codeurjc.test;

public class CalculatorParser {

    public int parse(String expression) {
        if (containsInvalidCharacters(expression)) {
            throw new NumberFormatException("The expression received is not a number.");
        }
        return this.evaluateExpression(expression);
    }

    /**
     * Method that verifies if a given expression contains a letter.
     * @param expression said expression.
     * @return true if it does contains a letter, false otherwise.
     */
    private boolean containsALetter(String expression) {
        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the expression contains invalid characters (letters).
     * @param expression The input expression.
     * @return true if invalid characters are found, false otherwise.
     */
    private boolean containsInvalidCharacters(String expression) {
        return (expression.length() == 1 && Character.isLetter(expression.charAt(0))) 
            || (expression.length() > 1 && this.containsALetter(expression));
    }

    /**
     * Evaluates an arithmetic expression with addition and subtraction.
     * Supports numbers separated by '+' or '-'.
     * @param expression A string containing integers with '+' or '-' symbols.
     * @return The computed result.
     * @throws NumberFormatException If any part cannot be parsed as an integer.
     */
    private int evaluateExpression(String expression) {
        String[] tokens = expression.split("(?=[+-])"); // Split keeping '+'/'-' with numbers
        int result = 0;
        for (String token : tokens) {
            result += Integer.parseInt(token.trim()); // Convert and sum/subtract
        }
        return result;
    }
}
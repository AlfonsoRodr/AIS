package es.codeurjc.test;

public class CalculatorParser {

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

    public int parse(String expression) {
        if ((expression.length() == 1) && (Character.isLetter(expression.charAt(0)))) {
            throw new NumberFormatException("The expression received is not a number.");
        }
        else if ((expression.length() > 1) && (this.containsALetter(expression))) {
            throw new NumberFormatException("The expression received is not a number.");
        }
        else {
            String[] numbers = expression.split("\\+");
            int sum = 0;
            for (String num : numbers) {
                sum = sum + Integer.parseInt(num.trim()); // Delete blank spaces.
            }
            return sum;
        }
    }
}
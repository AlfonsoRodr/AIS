package es.codeurjc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorParserTest {
    private  CalculatorParser calculator ;

    private static final String ERROR_MESSAGE = "The expression received is not a number.";

    @BeforeEach
    public void setup(){
        calculator = new CalculatorParser();
    }
    @Test
    public void oneNumberTest(){
        String operation = "1";

        int res = calculator.parse(operation);
        
        assertEquals(1, res);
    }

    @Test
    @DisplayName("When receiving an expression with a letter, a NumberFormatException should be thrown")
    public void singleLetterTest() {
        String operation = "A";
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            this.calculator.parse(operation);
        });
        assertEquals(ERROR_MESSAGE, thrown.getMessage());
    }

    @Test
    @DisplayName("When receiving an expression with multiple letters, a NumberFormatException should be thrown")
    public void multipleLettersTest() {
        String operation = "Hello";
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            this.calculator.parse(operation);
        });
        assertEquals(ERROR_MESSAGE, thrown.getMessage());
    }

    @Test
    @DisplayName("When receiving an expression that mixes numbers and letters, a NumberFormatException should be thrown.")
    public void mixNumbersAndLettersTest() {
        String operation = "19283939AB726X6";
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            this.calculator.parse(operation);
        });
        assertEquals(ERROR_MESSAGE, thrown.getMessage());
    }

    @Test
    @DisplayName("When receiving an arithmethic sum, the result of said sum should be returned")
    public void arithmeticSumTest() {
        String operation = "5+3+6+8";
        assertEquals(22, this.calculator.parse(operation));
    }

    @Test
    @DisplayName("When receiving an invalid format for an arithmethic sum, the result of said sum should be returned")
    public void invalidAritmethicSumTest() {
        String operation = "4+3+A+7+C+88+BB";
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            this.calculator.parse(operation);
        });
        assertEquals(ERROR_MESSAGE, thrown.getMessage());
    }
}
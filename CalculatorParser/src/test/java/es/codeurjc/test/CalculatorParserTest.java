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
    public void expressionWithLetterTest() {
        String operation = "A";
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            this.calculator.parse(operation);
        });
        assertEquals(ERROR_MESSAGE, thrown.getMessage());
    }
}
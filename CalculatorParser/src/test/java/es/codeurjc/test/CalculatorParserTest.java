package es.codeurjc.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorParserTest {
    
    private  CalculatorParser calculator;

    private static final String ERROR_MESSAGE = "The expression received is not a number.";

    @BeforeEach
    public void setup() {
        calculator = new CalculatorParser();
    }

    @Test
    public void oneNumberTest(){
        String operation = "1";

        int res = calculator.parse(operation);
        
        assertEquals(1, res);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "Hello", "19283939AB726X6", "4+3+A+7+C+88+BB", "987-145-A", "5-4+34-9+B-ABA"})
    @DisplayName("Invalid expressions should throw NumberFormatException with correct message")
    public void testInvalidExpressions(String operation) {
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            this.calculator.parse(operation);
        }); 
        assertEquals(ERROR_MESSAGE, thrown.getMessage(),"Exception message did not match expected.");
    }

    @Test
    @DisplayName("Arithmetic sum should return correct result")
    public void testArithmeticSum() {
        String operation = "5+3+6+8";
        assertDoesNotThrow(() -> {
            this.calculator.parse(operation);
        });
        assertEquals(22, calculator.parse(operation));
    }

    @Test
    @DisplayName("Arithmetic subtraction should return correct result")
    public void testArithmeticSubtraction() {
        String operation = "10-3-2";
        assertDoesNotThrow(() -> {
            calculator.parse(operation);
        });
        assertEquals(5, calculator.parse(operation));
    }

    @Test
    @DisplayName("Mixed operations (addition and subtraction) should return correct result")
    public void testMixedOperations() {
        String operation = "10+5-2";
        assertDoesNotThrow(() -> {
            this.calculator.parse(operation);
        });
        assertEquals(13, calculator.parse(operation));
    }
}
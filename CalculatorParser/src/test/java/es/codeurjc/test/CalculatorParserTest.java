package es.codeurjc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorParserTest {
    public CalculatorParser calculator ;
    @BeforeEach
    public void setup(){
        calculator = new CalculatorParser();
    }
    @Test
    public void TestOneNumber(){
        String operation = "1";

        int res = calculator.parse(operation);
        
        assertEquals(1, res);
    }

}

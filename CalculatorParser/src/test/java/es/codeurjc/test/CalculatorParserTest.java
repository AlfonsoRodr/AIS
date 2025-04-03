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
    @Test
    public void TestOneNumber2(){
        String operation = "2";

        int res = calculator.parse(operation);
        
        assertEquals(2, res);
    }
    @Test
    public void TestOneNumber3(){
        String operation = "3";

        int res = calculator.parse(operation);
        
        assertEquals(3, res);
    }
    @Test
    public void TestSubstractNumber1(){
        String operation = "5 - 3";

        int res = calculator.parse(operation);
        
        assertEquals(2, res);
    }
    @Test
    public void TestSubstractNumber2(){
        String operation =  "1 - 2" ;

        int res = calculator.parse(operation);
        
        assertEquals(-1, res);
    }
    @Test
    public void TestSubstractNumber3(){
        String operation =  "7 - 2 - 1" ;

        int res = calculator.parse(operation);
        
        assertEquals(4, res);
    }

   
}

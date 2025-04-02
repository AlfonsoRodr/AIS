package es.codeurjc.test;

public class CalculatorParser {

    public int parse(String expression) {
        int num = Integer.parseInt(expression);
     if(expression.length()==1){
        return num;
     }else{
        throw new IllegalArgumentException();
     }
	
}
}
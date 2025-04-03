package es.codeurjc.test;

public class CalculatorParser {

    public int parse(String expression) {
     if(expression.length()==1){
        int num = Integer.parseInt(expression);
        return num;
     }else if(expression.contains("-")){
        String[] tokens = expression.split(" - ");
        int res = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            res -= Integer.parseInt(tokens[i]);
        }
        return res;
    }else{
        throw new IllegalArgumentException();
    }
    }
}
     
    



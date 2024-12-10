package calculator;

public class MyCalculator {
    public double root(String command){
        double x = Double.parseDouble(command);

        return (double) Math.round(Math.sqrt(x) * 100) / 100;
    }

}
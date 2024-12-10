package calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;


public enum OperatorEnum {
    ADD("+", (x , y) -> x + y),
    MINUS("-", (x , y) -> x - y),
    MULTIPLY("*", (x , y) -> x * y),
    DIVIDE("/", (x , y) -> {
        if(y == 0.0 || x == 0.0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return Math.round(x/y * 100) /(double)100;
    }),
    SQUARE("^", (x , y) -> (double)Math.pow(x,y));

    private final String sign;
    private final DoubleBinaryOperator expression;

    private static final Map<String, OperatorEnum> operatorMap;
    static{
        Map<String, OperatorEnum> temp = new HashMap<>();
        temp.put("+", ADD);
        temp.put("-", MINUS);
        temp.put("*", MULTIPLY);
        temp.put("/", DIVIDE);
        temp.put("^", SQUARE);
        operatorMap = Collections.unmodifiableMap(temp);
    }

    OperatorEnum(String sign, DoubleBinaryOperator expression){
        this.sign = sign;
        this.expression = expression;
    }

    public String getSign(){
        return sign;
    }

    public static OperatorEnum getSymbol(final String sign){
        return operatorMap.get(sign);
    }
    public double apply(double x, double y){
        return expression.applyAsDouble(x, y);
    }

}
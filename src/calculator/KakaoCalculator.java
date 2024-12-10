package calculator;

import java.util.ArrayList;
import java.util.List;

public class KakaoCalculator {
    private final Checker checker = new Checker();
    private final List<String> list = new ArrayList<>();
    private final MyCalculator myCal = new MyCalculator();

    public double calculate(String command) {
        double result = 0;
        try{
            List<Object> checkedCommand = checker.checkInputStructure(command);
            if(checkedCommand.size() == 1) {
                result = myCal.root(command);
                printRoot(command, result);
            } else {
                double x = (double)checkedCommand.getFirst();
                String operator = (String)checkedCommand.get(1);
                double y = (double)checkedCommand.getLast();
                OperatorEnum operatorEnum = OperatorEnum.getSymbol(operator);
                result = operatorEnum.apply(x,y);
                printResult(x, operatorEnum.getSign(), y, result);
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return result;
    }
    public List<String> getList(){
        return list;
    }
    public String printRoot(String command, double result){
        System.out.println("카카오 계산 결과 : " + result);
        list.add("root " + command + " = : " + result);
        return "카카오 계산 결과 : " + result;
    }

    public String printResult(double x, String name, double y, double result){
        System.out.println("카카오 계산 결과 : " + x + " " + name + " " + y + " = " + result);
        list.add(x + " " + name + " " + y + " = " + result);
        return "카카오 계산 결과 : " + x + " " + name + " " + y + " = " + result;
    }
}
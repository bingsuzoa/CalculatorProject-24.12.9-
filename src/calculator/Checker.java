package calculator;

import java.util.*;

public class Checker {

    public List<Object> checkInputStructure(String command){
        command = command.replace(" ", "");
        List<String> checkCommand = new ArrayList<>();
        List<Object> checkedCommand = new ArrayList<>();

        for(int i = 0; i < command.length(); i++){
            String c = Character.toString(command.charAt(i));
            checkCommand.add(c);
        }

        if(command.matches("^[0-9 .]*$")){
            checkedCommand.add(Double.parseDouble(command));
        }
        else {
            boolean complete = false;
            for (int i = 1; i < checkCommand.size(); i++) {
                if (complete) break;
                for (OperatorEnum ope : OperatorEnum.values()) {
                    String c = checkCommand.get(i);
                    if (c.equals(ope.getSign())) {

                        double x = Double.parseDouble(command.substring(0, i));
                        checkedCommand.add(x);
                        checkedCommand.add(ope.getSign());
                        double y = Double.parseDouble(command.substring(i+1));
                        if(ope.getSign().equals("/") && (x == 0 || y == 0))
                            throw new ArithmeticException("0으로 나눌 수 없습니다.");
                        checkedCommand.add(y);
                        complete = true;
                        break;
                    }
                }
                if (i == checkCommand.size() - 1) {
                    try {
                        double x = Double.parseDouble(command);

                        if(x < 0) throw new IllegalArgumentException(x + " : 음수만 입력하셨습니다. 연산이 불가합니다.");
                        if(x > 0) checkedCommand.add(x);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException(command + " : 유효하지 않은 연산자 입니다.");
                    }
                }
            }
        }
        return checkedCommand;
    }
}

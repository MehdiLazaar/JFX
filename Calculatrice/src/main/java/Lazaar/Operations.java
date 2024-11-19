package Lazaar;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Operations {
    protected StringProperty result;
    protected StringProperty expression;
    protected IntegerProperty nb1;
    protected IntegerProperty nb2;

    public Operations() {
        this.result = new SimpleStringProperty("");
        this.expression = new SimpleStringProperty("");
        this.nb1 = new SimpleIntegerProperty(0);
        this.nb2 = new SimpleIntegerProperty(0);
    }

    public void init() {
        // Perform the operation
        String op = expression.get();
        int number1 = nb1.get();
        int number2 = nb2.get();

        try {
            switch (op) {
                case "+":
                    result.set(String.valueOf(number1 + number2));
                    break;
                case "-":
                    result.set(String.valueOf(number1 - number2));
                    break;
                case "*":
                    result.set(String.valueOf(number1 * number2));
                    break;
                case "/":
                    result.set(number2 != 0 ? String.valueOf(number1 / number2) : "Error");
                    break;
                case "%":
                    result.set(number2 != 0 ? String.valueOf(number1 % number2) : "Error");
                    break;
                case "^":
                    result.set(String.valueOf(Math.pow(number1, number2)));
                    break;
                default:
                    result.set("Invalid operation");
            }
        } catch (Exception e) {
            result.set("Error");
        }
    }

    public StringProperty resultProperty() {
        return result;
    }

    public StringProperty expressionProperty() {
        return expression;
    }

    public IntegerProperty nb1Property() {
        return nb1;
    }

    public IntegerProperty nb2Property() {
        return nb2;
    }
}

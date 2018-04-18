package main;

import app.Calculation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private String operand1;
    private String operand2;
    private String operator;
    private Calculation activeCalc;

    @FXML
    private TextField outputTxtField;

    public void initialize() {
        outputTxtField.setText("0.00");
    }

    /**
     * Dispatches the actions based on the source.
     */
    @FXML
    void buttonPressed(ActionEvent event) {
        Button pressedBtn = (Button) event.getSource();
        String buttonText = pressedBtn.getText();

        if (buttonText.matches("\\d")) {
            numberPressed(buttonText);
        } else if (buttonText.matches("[/+\\-*]")) {
            operatorPressed(buttonText);
        } else {
            utilityPressed(buttonText);
        }



    }


    /**
     * Called when the {@code buttonPressed} method determines
     * that a number was pressed.
     * Simply adds the number that was pressed, to the first or
     * second operand.
     *
     * @param number the number that was pressed
     */
    private void numberPressed(String number) {
        if (operator == null) {
            if (operand1 == null) {
                operand1 = number;
            } else {
                operand1 += number;
            }
        } else {
            if (operand2 == null) {
                operand2 = number;
            } else {
                operand2 += number;
            }

        }

        //TODO DEBUG
        System.out.printf(
                "%s: %s\n%s: %s\n%s: %s\n\n",
                "Operand 1",
                operand1,
                "Operator",
                operator,
                "Operand 2",
                operand2
        );

    }

    /**
     * Sets the operator if the first number is known already
     * and if the operator was not set before. The latter is to
     * ensure that there is no switch between operations
     * mid-calculation.
     */
    private void operatorPressed(String operator) {
        if (operand1 != null && this.operator == null) {
            this.operator = operator;
        }

        System.out.println(operator);

    }

    /**
     * Handling the equals and delete buttons.
     * @param utility the action to perform
     * */
    private void utilityPressed(String utility) {
        if (operand1 != null && operand2 != null & operator !=null) {

            switch (utility) {
                case "=":
                    double operand1Num = Double.parseDouble(operand1);
                    double operand2Num = Double.parseDouble(operand2);
                    double result;

                    activeCalc = new Calculation(operand1Num, operand2Num, operator);
                    result = activeCalc.execute();

                    operand1 = String.valueOf(result);

                    //resetting variables to continue calculation
                    operand2 = null;
                    operator = null;

                    System.out.printf("%.2f", result);

                    break;

                case "C":
                    nullify();
                    break;
            }
        }
    }


    //TODO implement
    /**
     * Called after changes in the instance variables.
     * */
    private void updateOutput() {


    }

    /**
     * Resets all the instance variables to null, so that a
     * new calculation can begin.
     * */
    private void nullify() {
            operand1 = null;
            operand2 = null;
            operator = null;
            activeCalc = null;
    }

}

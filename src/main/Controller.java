package main;

import app.Calculation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    private String operand1;
    private String operand2;
    private String operator;
    private Calculation activeCalc;

    @FXML
    private Button btn2;

    @FXML
    private Button btn1;

    /**
     * Dispatches the actions based on the source.
     */
    @FXML
    void buttonPressed(ActionEvent event) {
        Button pressedBtn = (Button) event.getSource();
        String buttonText = pressedBtn.getText();

        if (buttonText.matches("\\d")) {
            numberPressed(buttonText);
        } else if (buttonText.matches("[\\/\\+\\-\\*]")) {
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


    private void utilityPressed(String utility) {

        switch (utility) {
            case "=":
                double operand1Num = Double.parseDouble(operand1);
                double operand2Num = Double.parseDouble(operand2);
                double result = -1;

                activeCalc = new Calculation(operand1Num, operand2Num, operator);
                result = activeCalc.execute();

                operand1 = String.valueOf(result);

                //operand2 = null;
                //operator = null;

                //resetting variables to continue calculation
                nullify(operand2, operator);

                System.out.printf("%.2f", result);

                break;

            case "C":
                nullify();
                break;
        }

    }

    private void nullify(String... what) {

        if (what.length == 0) {
            operand1 = null;
            operand2 = null;
            operator = null;
            activeCalc = null;
        } else {
            for (int i = 0; i < what.length; i++) {
                what[i] = null;
            }
        }
    }

}

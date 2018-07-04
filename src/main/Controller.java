package main;

import app.Calculation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller class for the layout. Connects representation (gui)
 * with app logic (calculation).
 *
 * @author Janos Benyovszki
 */
public class Controller {

    private String operand1;
    private String operand2;
    private String operator;
    private Calculation activeCalc;

    @FXML
    private TextField outputTxtField;

    public void initialize() {
        defaultOutput();
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

        updateOutput();

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

    }

    /**
     * Sets the operator if the first number is known already
     * and if the operator was not set before. The latter is to
     * ensure that there is no switch between operations
     * mid-calculation.
     */
    private void operatorPressed(String operator) {
        if (operand1 == null) {
            if (operator.equals("-")) {
                operand1 = "-";
            }
        } else if (this.operator == null) {
            this.operator = operator;
        } else if (operand2 == null) {
            operand2 = "-";
        }
    }

    /**
     * Handling the equals and delete buttons.
     *
     * @param utility the action to perform
     */
    private void utilityPressed(String utility) {

        switch (utility) {

            case "=":
                if (operand1 != null && operand2 != null && operator != null) {

                    double operand1Num = Double.parseDouble(operand1);
                    double operand2Num = Double.parseDouble(operand2);
                    double result;

                    activeCalc = new Calculation(operand1Num, operand2Num, operator);
                    result = activeCalc.execute();

                    /*
                     * Handles the case of 0 result. If operand1
                     * is not reset, the newly typed number will be
                     * added after 0.0.
                     * */
                    if (result != 0.0) {
                        operand1 = String.valueOf(result);
                    } else {
                        operand1 = null;
                    }

                    //resetting variables to continue calculation
                    operand2 = null;
                    operator = null;
                    activeCalc = null;
                }

                break;

            case "C":
                nullify();
                break;
        }
    }


    //TODO implement

    /**
     * Called after changes in the instance variables.
     */
    private void updateOutput() {

        StringBuilder toDisplay = new StringBuilder();

        if (operand1 != null) {
            toDisplay.append(operand1);

            if (operator != null) {
                toDisplay.append(" ").append(operator);

                if (operand2 != null) {
                    toDisplay.append(" ").append(operand2);
                }
            }

        } else {
            defaultOutput();
            return;
        }

        outputTxtField.setText(toDisplay.toString());

    }

    private void defaultOutput() {
        outputTxtField.setText("0.0");
    }

    /**
     * Resets all the instance variables to null, so that a
     * new calculation can begin.
     */
    private void nullify() {
        operand1 = null;
        operand2 = null;
        operator = null;
        activeCalc = null;
    }

}

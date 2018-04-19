package app;

/**
 * Contains the logic for calculations. Could be implemented
 * with inheritance where Calculation is the superclass and
 * the individual calc types are subclasses, but this would
 * over-complicate this simple application.
 *
 * @author Janos Benyovszki
 *
 * */
public class Calculation implements CalculationTypes{

    private String type;
    private double operand1;
    private double operand2;

    /**
     * @param operand1 first part of the calculation
     * @param operand2 second part of the calculation
     * @param type type of the calculation
     * */
    public Calculation(double operand1, double operand2, String type) {
        this.type = type;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    /**
     * Executes the calculation based on its {@type}.
     * @return the result of the calculation
     * */
    public double execute() {
        double returnValue = -1;

        switch (type) {
            case ADDITION:
                returnValue = addition();
                break;

            case SUBTRACTION:
                returnValue = subtraction();
                break;

            case DIVISION:
                returnValue = division();
                break;

            case MULTIPLICATION:
                returnValue = multiplication();
                break;
        }

        return returnValue;

    }

    private double addition() {
        return operand1 + operand2;
    }

    private double subtraction() {
        return operand1 - operand2;
    }

    private double division() {
        return operand1 / operand2;
    }

    private double multiplication() {
        return operand1 * operand2;
    }

}

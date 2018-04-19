# SimpleCalculator

## Features

JavaFX, CSS

## Description

A very simple calculator, that can perform 4 basic operations:
- addition
- subtraction
- division
- multiplication

The tool just shows a quick example on JavaFX MVC implementation. The content window is styled with a cascading stylesheet.

## Structure

### Packages
- app: contains calculation related classes

- main: contains the FXML for the layout, the Controller class and the Main class to start the application

- res: contains the resource file for internalisation. As the application is not translated into other languages, this only serves to separate descriptions from layout, so that they are not hardcoded.

- style: contains the CSS file to style the layout

## Hands On

Calculator Screen:

![Simple Calculator screen](https://github.com/bjanos/Screenshots/blob/master/SimpleCalculator/2018-04-19_10-48-33.png)

Negative numbers are understood by the calculator:

![Negative Numbers](https://github.com/bjanos/Screenshots/blob/master/SimpleCalculator/2018-04-19_11-01-21.png)

Once a calculation is done, the result becomes the first operand of the calculaltion and a new one can be initiated by clicking on one of the operands.


package MVC.Controller;

import MVC.Model.Model;
import MVC.View.StandardView;

import Exception.DivideBy0Exception;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardController implements ActionListener{
    private final Model model = new Model();
    private final StandardView standardView = new StandardView();

    public StandardView getStandardView() {
        return standardView;
    }

    public StandardController(){
        createListener();
    }

    public void createListener(){
        for (JButton numberButton : standardView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }
        for (JButton operatorButton : standardView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }
    }

    //ActionListener================================================================================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button Action
        for(int i = 0; i < 10; i++){
            if(e.getSource() == standardView.getNumberButtons()[i]){
                if(standardView.getResultLabel().getText().equals("0")) standardView.getResultLabel().setText("");
                standardView.getResultLabel().setText(standardView.getResultLabel().getText().concat(String.valueOf(i)));
            }
        }
        //Decimal Point Button Action
        if(e.getSource() == standardView.getOperatorButtons()[9]){
            if(standardView.getResultLabel().getText().contains(".")) standardView.getResultLabel().setText(standardView.getResultLabel().getText());
            else standardView.getResultLabel().setText(standardView.getResultLabel().getText().concat("."));
        }
        //PosOrNegative Button Action
        if(e.getSource() == standardView.getOperatorButtons()[8]){
            double temp = Double.parseDouble(standardView.getResultLabel().getText());
            temp *= -1;
            standardView.getResultLabel().setText(String.valueOf(temp));
        }
        //Clear Button Action
        if(e.getSource() == standardView.getOperatorButtons()[6]){
            standardView.getResultLabel().setText("0");
            standardView.getShowProblemLabel().setText("");
        }
        //Backspace Button Action
        if(e.getSource() == standardView.getOperatorButtons()[7]){
            if(standardView.getResultLabel().getText().equals("0"))
                standardView.getResultLabel().setText("0");
            else{
                String temp = standardView.getResultLabel().getText();
                standardView.getResultLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    standardView.getResultLabel().setText(standardView.getResultLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(standardView.getResultLabel().getText().equals("")) standardView.getResultLabel().setText("0");
            }
        }
        //Plus Button Action
        if(e.getSource() == standardView.getOperatorButtons()[1]){

            if(standardView.getShowProblemLabel().getText().contains("+") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("-") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("*") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("/") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    standardView.getResultLabel().setText("Infinity Value...");
                }

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("%") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(standardView.getResultLabel().getText());
            model.operator = "Addition";

            standardView.getShowProblemLabel().setText(standardView.getShowProblemLabel().getText().concat(standardView.getResultLabel().getText() + " + "));

            if(standardView.getShowProblemLabel().getText().contains("=")){
                standardView.getShowProblemLabel().setText(standardView.getResultLabel().getText() + " + ");
            }

            standardView.getResultLabel().setText("0");
        }
        //Minus Button Action
        if(e.getSource() == standardView.getOperatorButtons()[2]){
            if(standardView.getShowProblemLabel().getText().contains("+") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("-") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("*") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("/") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    standardView.getResultLabel().setText("Infinity Value...");
                }

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("%") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(standardView.getResultLabel().getText());
            model.operator = "Subtraction";
            standardView.getShowProblemLabel().setText(standardView.getShowProblemLabel().getText().concat(standardView.getResultLabel().getText() + " - "));

            if(standardView.getShowProblemLabel().getText().contains("=")){
                standardView.getShowProblemLabel().setText(standardView.getResultLabel().getText() + " - ");
            }

            standardView.getResultLabel().setText("0");
        }
        //Multiply Button Action
        if(e.getSource() == standardView.getOperatorButtons()[3]){
            if(standardView.getShowProblemLabel().getText().contains("+") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("-") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("*") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("/") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    standardView.getResultLabel().setText("Infinity Value...");
                }

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("%") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(standardView.getResultLabel().getText());
            model.operator = "Multiplication";
            standardView.getShowProblemLabel().setText(standardView.getShowProblemLabel().getText().concat(standardView.getResultLabel().getText() + " * "));

            if(standardView.getShowProblemLabel().getText().contains("=")){
                standardView.getShowProblemLabel().setText(standardView.getResultLabel().getText() + " * ");
            }

            standardView.getResultLabel().setText("0");
        }
        //Divide Button Action
        if(e.getSource() == standardView.getOperatorButtons()[4]){
            if(standardView.getShowProblemLabel().getText().contains("+") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("-") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("*") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("/") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    standardView.getResultLabel().setText("Infinity Value...");
                }

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("%") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(standardView.getResultLabel().getText());
            model.operator = "Division";
            standardView.getShowProblemLabel().setText(standardView.getShowProblemLabel().getText().concat(standardView.getResultLabel().getText() + " / "));

            if(standardView.getShowProblemLabel().getText().contains("=")){
                standardView.getShowProblemLabel().setText(standardView.getResultLabel().getText() + " / ");
            }

            standardView.getResultLabel().setText("0");
        }
        //Mod Button Action
        if(e.getSource() == standardView.getOperatorButtons()[5]){
            if(standardView.getShowProblemLabel().getText().contains("+") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("-") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("*") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("/") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    standardView.getResultLabel().setText("Infinity Value...");
                }

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            if(standardView.getShowProblemLabel().getText().contains("%") && !standardView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

                standardView.getShowProblemLabel().setText("");

                standardView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = standardView.getResultLabel().getText();
                model.operand = standardView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(standardView.getResultLabel().getText());
            model.operator = "Modulo";
            standardView.getShowProblemLabel().setText(standardView.getShowProblemLabel().getText().concat(standardView.getResultLabel().getText() + " % "));

            if(standardView.getShowProblemLabel().getText().contains("=")){
                standardView.getShowProblemLabel().setText(standardView.getResultLabel().getText() + " % ");
            }

            standardView.getResultLabel().setText("0");
        }
        //Show Result Button Action
        if(e.getSource() == standardView.getOperatorButtons()[0]){
            model.input2 = Double.parseDouble(standardView.getResultLabel().getText());

            if(standardView.getShowProblemLabel().getText().contains("=")){
                standardView.getShowProblemLabel().setText("");
            }

            standardView.getShowProblemLabel().setText(standardView.getShowProblemLabel().getText().concat(standardView.getResultLabel().getText()) + " = ");

            switch (model.operator){
                case "Addition" ->{
                    standardView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));
                    model.result = standardView.getResultLabel().getText();
                    model.operand = standardView.getShowProblemLabel().getText();
                }

                case "Subtraction" ->{
                    standardView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));
                    model.result = standardView.getResultLabel().getText();
                    model.operand = standardView.getShowProblemLabel().getText();
                }

                case "Multiplication" ->{
                    standardView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));
                    model.result = standardView.getResultLabel().getText();
                    model.operand = standardView.getShowProblemLabel().getText();
                }

                case "Division" ->{
                    standardView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));
                    try {
                        if (model.input2 == 0) throw new DivideBy0Exception();
                    } catch (DivideBy0Exception ex) {
                        standardView.getResultLabel().setText("Infinity Value...");
                    }
                    model.result = standardView.getResultLabel().getText();
                    model.operand = standardView.getShowProblemLabel().getText();
                }

                case "Modulo" ->{
                    standardView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));
                    model.result = standardView.getResultLabel().getText();
                    model.operand = standardView.getShowProblemLabel().getText();
                }
            }
        }
    }
}

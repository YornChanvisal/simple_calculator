package MVC.Controller;

import Exception.DivideBy0Exception;
import MVC.Model.Model;
import MVC.View.ScientificView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificController implements ActionListener {
    private final Model model = new Model();
    private final ScientificView scientificView = new ScientificView();
    
    public ScientificView getScientificView(){
        return scientificView;
    }

    public ScientificController(){
        createListener();
    }
    
    public void createListener(){
        for (JButton numberButton : scientificView.getNumberButtons()){
            numberButton.addActionListener(this);
        }
        for (JButton operatorButton : scientificView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == scientificView.getNumberButtons()[i]){
                if(scientificView.getResultLabel().getText().equals("0")) scientificView.getResultLabel().setText("");
                scientificView.getResultLabel().setText(scientificView.getResultLabel().getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == scientificView.getOperatorButtons()[9]){
            if(scientificView.getResultLabel().getText().contains(".")) scientificView.getResultLabel().setText(scientificView.getResultLabel().getText());
            else scientificView.getResultLabel().setText(scientificView.getResultLabel().getText().concat("."));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[8]){
            double temp = Double.parseDouble(scientificView.getResultLabel().getText());
            temp *= -1;
            scientificView.getResultLabel().setText(String.valueOf(temp));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[6]){
            scientificView.getResultLabel().setText("0");
            scientificView.getShowProblemLabel().setText("");
        }

        if(e.getSource() == scientificView.getOperatorButtons()[7]){
            if(scientificView.getResultLabel().getText().equals("0"))
                scientificView.getResultLabel().setText("0");
            else{
                String temp = scientificView.getResultLabel().getText();
                scientificView.getResultLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    scientificView.getResultLabel().setText(scientificView.getResultLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(scientificView.getResultLabel().getText().equals("")) scientificView.getResultLabel().setText("0");
            }
        }

        if(e.getSource() == scientificView.getOperatorButtons()[1]){
            if(scientificView.getShowProblemLabel().getText().contains("+") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("-") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("*") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("/") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    scientificView.getResultLabel().setText("Infinity Value...");
                }
                
                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("%") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }
            
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            model.operator = "Addition";
            
            scientificView.getShowProblemLabel().setText(scientificView.getShowProblemLabel().getText().concat(scientificView.getResultLabel().getText() + " + "));

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText() + " + ");
            }

            scientificView.getResultLabel().setText("0");
        }

        if(e.getSource() == scientificView.getOperatorButtons()[2]){
            if(scientificView.getShowProblemLabel().getText().contains("+") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("-") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("*") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("/") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    scientificView.getResultLabel().setText("Infinity Value...");
                }

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("%") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }
            
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            model.operator = "Subtraction";
            
            scientificView.getShowProblemLabel().setText(scientificView.getShowProblemLabel().getText().concat(scientificView.getResultLabel().getText() + " - "));

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText() + " - ");
            }

            scientificView.getResultLabel().setText("0");
        }

        if(e.getSource() == scientificView.getOperatorButtons()[3]){
            if(scientificView.getShowProblemLabel().getText().contains("+") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("-") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("*") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("/") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    scientificView.getResultLabel().setText("Infinity Value...");
                }

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("%") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }
            
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            model.operator = "Multiplication";
            
            scientificView.getShowProblemLabel().setText(scientificView.getShowProblemLabel().getText().concat(scientificView.getResultLabel().getText() + " * "));

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText() + " * ");
            }

            scientificView.getResultLabel().setText("0");
        }

        if(e.getSource() == scientificView.getOperatorButtons()[4]){
            if(scientificView.getShowProblemLabel().getText().contains("+") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("-") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("*") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("/") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    scientificView.getResultLabel().setText("Infinity Value...");
                }

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("%") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }
            
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            model.operator = "Division";
            
            scientificView.getShowProblemLabel().setText(scientificView.getShowProblemLabel().getText().concat(scientificView.getResultLabel().getText() + " / "));

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText() + " / ");
            }

            scientificView.getResultLabel().setText("0");
        }

        if(e.getSource() == scientificView.getOperatorButtons()[5]){
            if(scientificView.getShowProblemLabel().getText().contains("+") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("-") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("*") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("/") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                try {
                    if (model.input2 == 0) throw new DivideBy0Exception();
                } catch (DivideBy0Exception ex) {
                    scientificView.getResultLabel().setText("Infinity Value...");
                }

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }

            if(scientificView.getShowProblemLabel().getText().contains("%") && !scientificView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

                scientificView.getShowProblemLabel().setText("");

                scientificView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));

                model.result = scientificView.getResultLabel().getText();
                model.operand = scientificView.getShowProblemLabel().getText();
            }
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            model.operator = "Modulo";
            
            scientificView.getShowProblemLabel().setText(scientificView.getShowProblemLabel().getText().concat(scientificView.getResultLabel().getText() + " % "));

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText() + " % ");
            }

            scientificView.getResultLabel().setText("0");
        }

        //More Functions
        if(e.getSource() == scientificView.getOperatorButtons()[16]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            model.operator = "XPowN";
            scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText());

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText());
            }

            scientificView.getResultLabel().setText("0");
        }

        if(e.getSource() == scientificView.getOperatorButtons()[15]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText(scientificView.getResultLabel().getText() + "^2 = ");
            scientificView.getResultLabel().setText(String.valueOf(Math.pow(model.input1, 2)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[18]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("10^" + scientificView.getResultLabel().getText() + " = ");
            scientificView.getResultLabel().setText(String.valueOf(Math.pow(10, model.input1)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[17]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("1/" + scientificView.getResultLabel().getText() + " = ");
            scientificView.getResultLabel().setText(String.valueOf(1.0 / model.input1));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[11]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("sin(" + scientificView.getResultLabel().getText() + ") = ");

            if (scientificView.getOperatorButtons()[10].getText().equals("DEG"))
                scientificView.getResultLabel().setText(String.valueOf(Math.sin(Math.toRadians(model.input1))));
            else scientificView.getResultLabel().setText(String.valueOf(Math.sin(model.input1)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[12]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("cos(" + scientificView.getResultLabel().getText() + ") = ");

            if (scientificView.getOperatorButtons()[10].getText().equals("DEG"))
                scientificView.getResultLabel().setText(String.valueOf(Math.cos(Math.toRadians(model.input1))));
            else scientificView.getResultLabel().setText(String.valueOf(Math.cos(model.input1)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[13]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("tan(" + scientificView.getResultLabel().getText() + ") = ");

            if (scientificView.getOperatorButtons()[10].getText().equals("DEG"))
                scientificView.getResultLabel().setText(String.valueOf(Math.tan(Math.toRadians(model.input1))));
            else scientificView.getResultLabel().setText(String.valueOf(Math.tan(model.input1)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[14]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("cot(" + scientificView.getResultLabel().getText() + ") = ");

            if (scientificView.getOperatorButtons()[10].getText().equals("DEG"))
                scientificView.getResultLabel().setText(String.valueOf(1.0 / Math.tan(Math.toRadians(model.input1))));
            else scientificView.getResultLabel().setText(String.valueOf(1.0 / Math.tan(model.input1)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[19]){
            model.input1 = Double.parseDouble(scientificView.getResultLabel().getText());
            scientificView.getShowProblemLabel().setText("sqrt(" + scientificView.getResultLabel().getText() + ") = ");

            scientificView.getResultLabel().setText(String.valueOf(Math.sqrt(model.input1)));
        }

        if(e.getSource() == scientificView.getOperatorButtons()[10]){
            if(scientificView.getOperatorButtons()[10].getText().equals("DEG")) scientificView.getOperatorButtons()[10].setText("RAD");
            else scientificView.getOperatorButtons()[10].setText("DEG");
        }

        //Show Result
        if(e.getSource() == scientificView.getOperatorButtons()[0]){
            model.input2 = Double.parseDouble(scientificView.getResultLabel().getText());

            if(scientificView.getShowProblemLabel().getText().contains("=")){
                scientificView.getShowProblemLabel().setText("");
            }

            scientificView.getShowProblemLabel().setText(scientificView.getShowProblemLabel().getText().concat(scientificView.getResultLabel().getText()) + " = ");

            switch (model.operator){
                case "Addition" ->{
                    scientificView.getResultLabel().setText(String.valueOf(model.input1 + model.input2));
                    model.result = scientificView.getResultLabel().getText();
                    model.operand = scientificView.getShowProblemLabel().getText();
                }

                case "Subtraction" ->{
                    scientificView.getResultLabel().setText(String.valueOf(model.input1 - model.input2));
                    model.result = scientificView.getResultLabel().getText();
                    model.operand = scientificView.getShowProblemLabel().getText();
                }

                case "Multiplication" ->{
                    scientificView.getResultLabel().setText(String.valueOf(model.input1 * model.input2));
                    model.result = scientificView.getResultLabel().getText();
                    model.operand = scientificView.getShowProblemLabel().getText();
                }

                case "Division" ->{
                    scientificView.getResultLabel().setText(String.valueOf(model.input1 / model.input2));

                    try {
                        if (model.input2 == 0) throw new DivideBy0Exception();
                    } catch (DivideBy0Exception ex) {
                        scientificView.getResultLabel().setText("Infinity Value...");
                    }
                    model.result = scientificView.getResultLabel().getText();
                    model.operand = scientificView.getShowProblemLabel().getText();
                }

                case "Modulo" ->{
                    scientificView.getResultLabel().setText(String.valueOf(model.input1 % model.input2));
                    model.result = scientificView.getResultLabel().getText();
                    model.operand = scientificView.getShowProblemLabel().getText();
                }
                case "XPowN" ->
                        scientificView.getResultLabel().setText(String.valueOf(Math.pow(model.input1, model.input2)));
            }
        }
    }
}

package MVC.Controller;

import MVC.Model.Model;
import MVC.View.BinaryArithmeticView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryArithmeticController implements ActionListener {
    private final Model model = new Model();
    private final BinaryArithmeticView binaryArithmeticView = new BinaryArithmeticView();
    
    public BinaryArithmeticView getBinaryArithmeticView(){
        return binaryArithmeticView;
    }
    
    //Constructor
    public BinaryArithmeticController(){
        createListener();
    }
    //Add Action Listener
    public void createListener(){
        for (JButton numberButton : binaryArithmeticView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }
        for (JButton operatorButton : binaryArithmeticView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }
    }

    //Action Performed
    @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button Action
        for(int i = 0; i < 2; i++){
            if(e.getSource() == binaryArithmeticView.getNumberButtons()[i]){
                if(binaryArithmeticView.getResultLabel().getText().equals("0")) binaryArithmeticView.getResultLabel().setText("");
                binaryArithmeticView.getResultLabel().setText(binaryArithmeticView.getResultLabel().getText().concat(String.valueOf(i)));
            }
        }
        //Clear Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[5]){
            binaryArithmeticView.getResultLabel().setText("0");
            binaryArithmeticView.getShowProblemLabel().setText("");
        }
        //Backspace Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[6]){
            if(binaryArithmeticView.getResultLabel().getText().equals("0"))
                binaryArithmeticView.getResultLabel().setText("0");
            else{
                String temp = binaryArithmeticView.getResultLabel().getText();
                binaryArithmeticView.getResultLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    binaryArithmeticView.getResultLabel().setText(binaryArithmeticView.getResultLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(binaryArithmeticView.getResultLabel().getText().equals("")) binaryArithmeticView.getResultLabel().setText("0");
            }
        }

        //Plus Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[1]){
            if(binaryArithmeticView.getShowProblemLabel().getText().contains("+") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);
                
                model.decimal = model.dec1 + model.dec2;
                
                model.result = Long.toBinaryString(model.decimal);
                
                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("-") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 - model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("*") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 * model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("/") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 / model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            model.bin1 = binaryArithmeticView.getResultLabel().getText();
            model.operator = "Addition";

            binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getShowProblemLabel().getText().concat(binaryArithmeticView.getResultLabel().getText() + " + "));

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getResultLabel().getText() + " + ");
            }

            binaryArithmeticView.getResultLabel().setText("0");
        }

        //Minus Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[2]){
            if(binaryArithmeticView.getShowProblemLabel().getText().contains("+") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 + model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("-") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 - model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("*") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 * model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("/") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 / model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            model.bin1 = binaryArithmeticView.getResultLabel().getText();
            model.operator = "Subtraction";

            binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getShowProblemLabel().getText().concat(binaryArithmeticView.getResultLabel().getText() + " - "));

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getResultLabel().getText() + " - ");
            }

            binaryArithmeticView.getResultLabel().setText("0");
        }

        //Multiply Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[3]){
            if(binaryArithmeticView.getShowProblemLabel().getText().contains("+") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 + model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("-") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 - model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("*") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 * model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("/") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 / model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            model.bin1 = binaryArithmeticView.getResultLabel().getText();
            model.operator = "Multiplication";

            binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getShowProblemLabel().getText().concat(binaryArithmeticView.getResultLabel().getText() + " * "));

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getResultLabel().getText() + " * ");
            }

            binaryArithmeticView.getResultLabel().setText("0");
        }

        //Multiply Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[4]){
            if(binaryArithmeticView.getShowProblemLabel().getText().contains("+") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 + model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("-") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 - model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("*") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 * model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("/") && !binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                model.bin2 = binaryArithmeticView.getResultLabel().getText();

                binaryArithmeticView.getShowProblemLabel().setText("");
                //Convert to decimal, Do operation and Convert back to binary
                model.dec1 = Long.parseLong(model.bin1, 2);
                model.dec2 = Long.parseLong(model.bin2, 2);

                model.decimal = model.dec1 / model.dec2;

                model.result = Long.toBinaryString(model.decimal);

                //Result
                binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                model.result = binaryArithmeticView.getResultLabel().getText();
                model.operand = binaryArithmeticView.getShowProblemLabel().getText();
            }

            model.bin1 = binaryArithmeticView.getResultLabel().getText();
            model.operator = "Division";

            binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getShowProblemLabel().getText().concat(binaryArithmeticView.getResultLabel().getText() + " / "));

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getResultLabel().getText() + " / ");
            }

            binaryArithmeticView.getResultLabel().setText("0");
        }
        
        //Show Result Button Action
        if(e.getSource() == binaryArithmeticView.getOperatorButtons()[0]){
            model.bin2 = binaryArithmeticView.getResultLabel().getText();

            if(binaryArithmeticView.getShowProblemLabel().getText().contains("=")){
                binaryArithmeticView.getShowProblemLabel().setText("");
            }

            binaryArithmeticView.getShowProblemLabel().setText(binaryArithmeticView.getShowProblemLabel().getText().concat(binaryArithmeticView.getResultLabel().getText()) + " = ");

            switch (model.operator){
                case "Addition" ->{
                    //Convert to decimal, Do operation and Convert back to binary
                    model.dec1 = Long.parseLong(model.bin1, 2);
                    model.dec2 = Long.parseLong(model.bin2, 2);

                    model.decimal = model.dec1 + model.dec2;

                    model.result = Long.toBinaryString(model.decimal);

                    //Result
                    binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                    model.result = binaryArithmeticView.getResultLabel().getText();
                    model.operand = binaryArithmeticView.getShowProblemLabel().getText();
                }

                case "Subtraction" ->{
                    //Convert to decimal, Do operation and Convert back to binary
                    model.dec1 = Long.parseLong(model.bin1, 2);
                    model.dec2 = Long.parseLong(model.bin2, 2);

                    model.decimal = model.dec1 - model.dec2;

                    model.result = Long.toBinaryString(model.decimal);

                    //Result
                    binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                    model.result = binaryArithmeticView.getResultLabel().getText();
                    model.operand = binaryArithmeticView.getShowProblemLabel().getText();
                }

                case "Multiplication" ->{
                    //Convert to decimal, Do operation and Convert back to binary
                    model.dec1 = Long.parseLong(model.bin1, 2);
                    model.dec2 = Long.parseLong(model.bin2, 2);

                    model.decimal = model.dec1 * model.dec2;

                    model.result = Long.toBinaryString(model.decimal);

                    //Result
                    binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                    model.result = binaryArithmeticView.getResultLabel().getText();
                    model.operand = binaryArithmeticView.getShowProblemLabel().getText();
                }

                case "Division" ->{
                    //Convert to decimal, Do operation and Convert back to binary
                    model.dec1 = Long.parseLong(model.bin1, 2);
                    model.dec2 = Long.parseLong(model.bin2, 2);

                    model.decimal = model.dec1 / model.dec2;

                    model.result = Long.toBinaryString(model.decimal);

                    //Result
                    binaryArithmeticView.getResultLabel().setText(String.valueOf(model.result));

                    model.result = binaryArithmeticView.getResultLabel().getText();
                    model.operand = binaryArithmeticView.getShowProblemLabel().getText();
                }
            }
        }
    }
}

package MVC.Controller;

import MVC.Model.Model;
import MVC.View.BitwiseView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BitwiseController implements ActionListener {
    private final Model model = new Model();
    private final BitwiseView bitwiseView = new BitwiseView();

    public BitwiseView getBitwiseView(){
        return bitwiseView;
    }

    public BitwiseController(){
        createListener();
    }

    public void createListener(){
        for (JButton numberButton : bitwiseView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }
        for (JButton operatorButton : bitwiseView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button Action
        for(int i = 0; i < 10; i++){
            if(e.getSource() == bitwiseView.getNumberButtons()[i]){
                if(bitwiseView.getResultLabel().getText().equals("0")) bitwiseView.getResultLabel().setText("");
                bitwiseView.getResultLabel().setText(bitwiseView.getResultLabel().getText().concat(String.valueOf(i)));
            }
        }
        //PosOrNegative Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[9]){
            double temp = Double.parseDouble(bitwiseView.getResultLabel().getText());
            temp *= -1;
            bitwiseView.getResultLabel().setText(String.valueOf(temp));
        }
        //Clear Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[7]){
            bitwiseView.getResultLabel().setText("0");
            bitwiseView.getShowProblemLabel().setText("");
        }
        //Backspace Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[8]){
            if(bitwiseView.getResultLabel().getText().equals("0"))
                bitwiseView.getResultLabel().setText("0");
            else{
                String temp = bitwiseView.getResultLabel().getText();
                bitwiseView.getResultLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    bitwiseView.getResultLabel().setText(bitwiseView.getResultLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(bitwiseView.getResultLabel().getText().equals("")) bitwiseView.getResultLabel().setText("0");
            }
        }
        //Inverse Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[6]){
            model.input1 = Double.parseDouble(bitwiseView.getResultLabel().getText());
            bitwiseView.getShowProblemLabel().setText("~(" + bitwiseView.getResultLabel().getText() + ") = ");

            bitwiseView.getResultLabel().setText(String.valueOf(~(int)model.input1));
        }
        //LeftShift Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[1]){
            if(bitwiseView.getShowProblemLabel().getText().contains("<<") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 << (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains(">>") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 >> (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("|") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 | (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("^") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 ^ (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(bitwiseView.getResultLabel().getText());
            model.operator = "LeftShift";
            bitwiseView.getShowProblemLabel().setText(bitwiseView.getShowProblemLabel().getText().concat(bitwiseView.getResultLabel().getText() + " << "));

            if(bitwiseView.getShowProblemLabel().getText().contains("=")){
                bitwiseView.getShowProblemLabel().setText(bitwiseView.getResultLabel().getText() + " << ");
            }

            bitwiseView.getResultLabel().setText("0");
        }
        //RightShift Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[2]){
            if(bitwiseView.getShowProblemLabel().getText().contains("<<") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 << (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains(">>") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 >> (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("|") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 | (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("^") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 ^ (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(bitwiseView.getResultLabel().getText());
            model.operator = "RightShift";
            bitwiseView.getShowProblemLabel().setText(bitwiseView.getShowProblemLabel().getText().concat(bitwiseView.getResultLabel().getText() + " >> "));

            if(bitwiseView.getShowProblemLabel().getText().contains("=")){
                bitwiseView.getShowProblemLabel().setText(bitwiseView.getResultLabel().getText() + " >> ");
            }

            bitwiseView.getResultLabel().setText("0");
        }
        //OR Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[3]){
            if(bitwiseView.getShowProblemLabel().getText().contains("<<") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 << (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains(">>") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 >> (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("|") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 | (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("^") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 ^ (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(bitwiseView.getResultLabel().getText());
            model.operator = "Or";
            bitwiseView.getShowProblemLabel().setText(bitwiseView.getShowProblemLabel().getText().concat(bitwiseView.getResultLabel().getText() + " | "));

            if(bitwiseView.getShowProblemLabel().getText().contains("=")){
                bitwiseView.getShowProblemLabel().setText(bitwiseView.getResultLabel().getText() + " | ");
            }

            bitwiseView.getResultLabel().setText("0");
        }
        //AND Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[4]){
            if(bitwiseView.getShowProblemLabel().getText().contains("<<") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 << (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains(">>") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 >> (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("|") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 | (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("^") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 ^ (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(bitwiseView.getResultLabel().getText());
            model.operator = "And";
            bitwiseView.getShowProblemLabel().setText(bitwiseView.getShowProblemLabel().getText().concat(bitwiseView.getResultLabel().getText() + " & "));

            if(bitwiseView.getShowProblemLabel().getText().contains("=")){
                bitwiseView.getShowProblemLabel().setText(bitwiseView.getResultLabel().getText() + " & ");
            }

            bitwiseView.getResultLabel().setText("0");
        }
        //XOR Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[5]){
            if(bitwiseView.getShowProblemLabel().getText().contains("<<") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 << (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains(">>") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 >> (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("|") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 | (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            if(bitwiseView.getShowProblemLabel().getText().contains("^") && !bitwiseView.getShowProblemLabel().getText().contains("=")){
                model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

                bitwiseView.getShowProblemLabel().setText("");

                bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 ^ (int)model.input2));

                model.result = bitwiseView.getResultLabel().getText();
                model.operand = bitwiseView.getShowProblemLabel().getText();
            }

            model.input1 = Double.parseDouble(bitwiseView.getResultLabel().getText());
            model.operator = "Xor";
            bitwiseView.getShowProblemLabel().setText(bitwiseView.getShowProblemLabel().getText().concat(bitwiseView.getResultLabel().getText() + " ^ "));

            if(bitwiseView.getShowProblemLabel().getText().contains("=")){
                bitwiseView.getShowProblemLabel().setText(bitwiseView.getResultLabel().getText() + " ^ ");
            }

            bitwiseView.getResultLabel().setText("0");
        }
        //Show Result Button Action
        if(e.getSource() == bitwiseView.getOperatorButtons()[0]){
            model.input2 = Double.parseDouble(bitwiseView.getResultLabel().getText());

            if(bitwiseView.getShowProblemLabel().getText().contains("=")){
                bitwiseView.getShowProblemLabel().setText("");
            }

            bitwiseView.getShowProblemLabel().setText(bitwiseView.getShowProblemLabel().getText().concat(bitwiseView.getResultLabel().getText()) + " = ");

            switch (model.operator){
                case "LeftShift" ->{
                    bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 << (int)model.input2));
                    model.result = bitwiseView.getResultLabel().getText();
                    model.operand = bitwiseView.getShowProblemLabel().getText();
                }

                case "RightShift" ->{
                    bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 >> (int)model.input2));
                    model.result = bitwiseView.getResultLabel().getText();
                    model.operand = bitwiseView.getShowProblemLabel().getText();
                }

                case "And" ->{
                    bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 & (int)model.input2));
                    model.result = bitwiseView.getResultLabel().getText();
                    model.operand = bitwiseView.getShowProblemLabel().getText();
                }

                case "Or" ->{
                    bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 | (int)model.input2));
                    model.result = bitwiseView.getResultLabel().getText();
                    model.operand = bitwiseView.getShowProblemLabel().getText();
                }

                case "Xor" ->{
                    bitwiseView.getResultLabel().setText(String.valueOf((int)model.input1 ^ (int)model.input2));
                    model.result = bitwiseView.getResultLabel().getText();
                    model.operand = bitwiseView.getShowProblemLabel().getText();
                }
            }
        }
        
    }
}

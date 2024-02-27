package MVC.Controller;

import MVC.Model.Model;
import MVC.View.NumberSystemConvertorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConvertorController implements ActionListener {
    private final Model model = new Model();
    private final NumberSystemConvertorView numberSystemConvertorView = new NumberSystemConvertorView();

    public NumberSystemConvertorView getNumberSystemConvertorView() {
        return numberSystemConvertorView;
    }

    public NumberSystemConvertorController(){
        createListener();
    }

    public void createListener(){
        for (JButton numberButton : numberSystemConvertorView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }
        for (JButton operatorButton : numberSystemConvertorView.getLetterButton()) {
            operatorButton.addActionListener(this);
        }
        for (JButton operatorButton : numberSystemConvertorView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }

        numberSystemConvertorView.getComboBox1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ComboBox Action
        if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Binary"){
            //Number Button Action
            for(int i = 0; i < 2; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,255,255));
                if(e.getSource() == numberSystemConvertorView.getNumberButtons()[i]){
                    if(numberSystemConvertorView.getProblemLabel().getText().equals("0")) numberSystemConvertorView.getProblemLabel().setText("");
                    numberSystemConvertorView.getProblemLabel().setText(numberSystemConvertorView.getProblemLabel().getText().concat(String.valueOf(i)));
                }
            }
            //Number Button Action Disable
            for(int i = 2; i < 10; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,85,102));
            }
            //Letter Button Action Disable
            for(int i = 0; i < 6; i++){
                numberSystemConvertorView.getLetterButton()[i].setBackground(new Color(255,85,102));
            }
        } else if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Octal"){
            //Number Button Action
            for(int i = 0; i < 8; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,255,255));
                if(e.getSource() == numberSystemConvertorView.getNumberButtons()[i]){
                    if(numberSystemConvertorView.getProblemLabel().getText().equals("0")) numberSystemConvertorView.getProblemLabel().setText("");
                    numberSystemConvertorView.getProblemLabel().setText(numberSystemConvertorView.getProblemLabel().getText().concat(String.valueOf(i)));
                }
            }
            //Number Button Action Disable
            for(int i = 8; i < 10; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,85,102));
            }
            //Letter Button Action Disable
            for(int i = 0; i < 6; i++){
                numberSystemConvertorView.getLetterButton()[i].setBackground(new Color(255,85,102));
            }
        } else if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Decimal"){
            //Number Button Action
            for(int i = 0; i < 10; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,255,255));
                if(e.getSource() == numberSystemConvertorView.getNumberButtons()[i]){
                    if(numberSystemConvertorView.getProblemLabel().getText().equals("0")) numberSystemConvertorView.getProblemLabel().setText("");
                    numberSystemConvertorView.getProblemLabel().setText(numberSystemConvertorView.getProblemLabel().getText().concat(String.valueOf(i)));
                }
            }
            //Letter Button Action Disable
            for(int i = 0; i < 6; i++){
                numberSystemConvertorView.getLetterButton()[i].setBackground(new Color(255,85,102));
            }
        } else if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Hexadecimal"){
            //Number Button Action
            for(int i = 0; i < 10; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,255,255));
                if(e.getSource() == numberSystemConvertorView.getNumberButtons()[i]){
                    if(numberSystemConvertorView.getProblemLabel().getText().equals("0")) numberSystemConvertorView.getProblemLabel().setText("");
                    numberSystemConvertorView.getProblemLabel().setText(numberSystemConvertorView.getProblemLabel().getText().concat(String.valueOf(i)));
                }
            }
            //Letter Button Action
            for(int i = 0; i < 6; i++){
                numberSystemConvertorView.getLetterButton()[i].setBackground(new Color(255,255,255));
                if(e.getSource() == numberSystemConvertorView.getLetterButton()[i]){
                    if(numberSystemConvertorView.getProblemLabel().getText().equals("0")) numberSystemConvertorView.getProblemLabel().setText("");
                    numberSystemConvertorView.getProblemLabel().setText(numberSystemConvertorView.getProblemLabel().getText().concat(numberSystemConvertorView.letter[i]));
                }
            }
        }else{
            //Number Button Action
            for(int i = 0; i < 10; i++){
                numberSystemConvertorView.getNumberButtons()[i].setBackground(new Color(255,255,255));
            }
            //Letter Button Action
            for(int i = 0; i < 6; i++){
                numberSystemConvertorView.getLetterButton()[i].setBackground(new Color(255,255,255));
            }
        }

        //Clear Button Action
        if(e.getSource() == numberSystemConvertorView.getOperatorButtons()[1]){
            numberSystemConvertorView.getProblemLabel().setText("0");
            numberSystemConvertorView.getResultLabel().setText("0");
        }
        //Backspace Button Action
        if(e.getSource() == numberSystemConvertorView.getOperatorButtons()[2]){
            if(numberSystemConvertorView.getProblemLabel().getText().equals("0"))
                numberSystemConvertorView.getProblemLabel().setText("0");
            else{
                String temp = numberSystemConvertorView.getProblemLabel().getText();
                numberSystemConvertorView.getProblemLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    numberSystemConvertorView.getProblemLabel().setText(numberSystemConvertorView.getProblemLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(numberSystemConvertorView.getProblemLabel().getText().equals("")) numberSystemConvertorView.getProblemLabel().setText("0");
            }
        }
        
        //Result Button Action
        if(e.getSource() == numberSystemConvertorView.getOperatorButtons()[0]){
            model.input = numberSystemConvertorView.getProblemLabel().getText();

            //Default
            if (numberSystemConvertorView.getComboBox1().getSelectedItem() == "Select Here")
                numberSystemConvertorView.getResultLabel().setText("0");
            
            //From Decimal
            if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Decimal"){
                if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Decimal"){
                    model.result = model.input;
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Binary"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input);
                    //Result
                    model.result = Long.toBinaryString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Octal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input);
                    //Result
                    model.result = Long.toOctalString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Hexadecimal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input);
                    //Result
                    model.result = Long.toHexString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else{
                    numberSystemConvertorView.getResultLabel().setText("0");
                    numberSystemConvertorView.getProblemLabel().setText("0");
                }
            }

            //From Binary
            if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Binary"){
                if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Decimal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 2);
                    //Result
                    model.result = String.valueOf(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Binary"){
                    model.result = model.input;
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Octal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 2);
                    //Result
                    model.result = Long.toOctalString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Hexadecimal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 2);
                    //Result
                    model.result = Long.toHexString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else{
                    numberSystemConvertorView.getResultLabel().setText("0");
                    numberSystemConvertorView.getProblemLabel().setText("0");
                }
            }

            //From Octal
            if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Octal"){
                if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Decimal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 8);
                    //Result
                    model.result = String.valueOf(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Binary"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 8);
                    //Result
                    model.result = Long.toBinaryString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Octal"){
                    model.result = model.input;
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Hexadecimal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 8);
                    //Result
                    model.result = Long.toHexString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else{
                    numberSystemConvertorView.getResultLabel().setText("0");
                    numberSystemConvertorView.getProblemLabel().setText("0");
                }
            }

            //From Hexadecimal
            if(numberSystemConvertorView.getComboBox1().getSelectedItem() == "Hexadecimal"){
                if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Decimal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 16);
                    //Result
                    model.result = String.valueOf(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Binary"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 16);
                    //Result
                    model.result = Long.toBinaryString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Octal"){
                    //To Decimal
                    model.decimal = Long.parseLong(model.input, 16);
                    //Result
                    model.result = Long.toOctalString(model.decimal);
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else if(numberSystemConvertorView.getComboBox2().getSelectedItem() == "Hexadecimal"){
                    model.result = model.input;
                    numberSystemConvertorView.getResultLabel().setText(model.result);
                }else{
                    numberSystemConvertorView.getResultLabel().setText("0");
                    numberSystemConvertorView.getProblemLabel().setText("0");
                }
            }
        }
    }
}

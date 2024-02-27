package MVC.Controller;

import MVC.Model.Model;
import MVC.View.CurrencyView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyController implements ActionListener {
    private final Model model = new Model();
    private final CurrencyView currencyView = new CurrencyView();

    public CurrencyView getCurrencyView() {
        return currencyView;
    }
    
    //Constructor
    public CurrencyController(){
        createListener();
    }

    //Listener
    public void createListener(){
        for (JButton numberButton : currencyView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }

        for (JButton operatorButton : currencyView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }

        currencyView.getComboBox1().addActionListener(e -> {
            //Default
            if(currencyView.getComboBox1().getSelectedItem() == "Select Here") currencyView.getExchangeRateLabel().setText("Money Exchange Rate");

            //From USD
            if(currencyView.getComboBox1().getSelectedItem() == "USD"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1USD = 1USD");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1USD = 4,112KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1USD = 35.32THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1USD = 0.94FRANC");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1USD = 0.97EUR");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From KHR
            if(currencyView.getComboBox1().getSelectedItem() == "KHR"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1USD = 4,112KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1KHR = 1KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1THB = 116.45KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 4367.08KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1EURO = 4219.96KHR");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From THB
            if(currencyView.getComboBox1().getSelectedItem() == "THB"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1USD = 35.32THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1THB = 116.45KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1THB = 1THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 37.50THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1EURO = 36.25THB");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From FRANC
            if(currencyView.getComboBox1().getSelectedItem() == "FRANC"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 1.06USD");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 4367.08KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 37.50THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 1FRANC");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 1.03EURO");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From EURO
            if(currencyView.getComboBox1().getSelectedItem() == "EURO"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1EURO = 1.03USD");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1EURO = 4219.96KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1EURO = 36.25THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1EURO = 0.97FRANC");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1EURO = 1EURO");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
        });
        
        currencyView.getComboBox2().addActionListener(e -> {
            //Default
            if(currencyView.getComboBox1().getSelectedItem() == "Select Here") currencyView.getExchangeRateLabel().setText("Money Exchange Rate");

            //From USD
            if(currencyView.getComboBox1().getSelectedItem() == "USD"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1USD = 1USD");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1USD = 4,112KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1USD = 35.32THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1USD = 0.94FRANC");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1USD = 0.97EUR");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From KHR
            if(currencyView.getComboBox1().getSelectedItem() == "KHR"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1USD = 4,112KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1KHR = 1KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1THB = 116.45KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 4367.08KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1EURO = 4219.96KHR");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From THB
            if(currencyView.getComboBox1().getSelectedItem() == "THB"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1USD = 35.32THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1THB = 116.45KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1THB = 1THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 37.50THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1EURO = 36.25THB");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From FRANC
            if(currencyView.getComboBox1().getSelectedItem() == "FRANC"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 1.06USD");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 4367.08KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 37.50THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 1FRANC");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1FRANC = 1.03EURO");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
            //From EURO
            if(currencyView.getComboBox1().getSelectedItem() == "EURO"){
                if(currencyView.getComboBox2().getSelectedItem() == "USD")
                    currencyView.getExchangeRateLabel().setText("1EURO = 1.03USD");
                else if(currencyView.getComboBox2().getSelectedItem() == "KHR")
                    currencyView.getExchangeRateLabel().setText("1EURO = 4219.96KHR");
                else if(currencyView.getComboBox2().getSelectedItem() == "THB")
                    currencyView.getExchangeRateLabel().setText("1EURO = 36.25THB");
                else if(currencyView.getComboBox2().getSelectedItem() == "FRANC")
                    currencyView.getExchangeRateLabel().setText("1EURO = 0.97FRANC");
                else if(currencyView.getComboBox2().getSelectedItem() == "EURO")
                    currencyView.getExchangeRateLabel().setText("1EURO = 1EURO");
                else currencyView.getExchangeRateLabel().setText("Money Exchange Rate");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button Action
        for(int i = 0; i < 10; i++){
            if(e.getSource() == currencyView.getNumberButtons()[i]){
                if(currencyView.getProblemLabel().getText().equals("0")) currencyView.getProblemLabel().setText("");
                currencyView.getProblemLabel().setText(currencyView.getProblemLabel().getText().concat(String.valueOf(i)));
            }
        }
        //Decimal Point Button Action
        if(e.getSource() == currencyView.getOperatorButtons()[3]){
            if(currencyView.getProblemLabel().getText().contains(".")) currencyView.getProblemLabel().setText(currencyView.getProblemLabel().getText());
            else currencyView.getProblemLabel().setText(currencyView.getProblemLabel().getText().concat("."));
        }
        //Clear Button Action
        if(e.getSource() == currencyView.getOperatorButtons()[1]){
            currencyView.getProblemLabel().setText("0");
            currencyView.getResultLabel().setText("0");
        }
        //Backspace Button Action
        if(e.getSource() == currencyView.getOperatorButtons()[2]){
            if(currencyView.getProblemLabel().getText().equals("0"))
                currencyView.getProblemLabel().setText("0");
            else{
                String temp = currencyView.getProblemLabel().getText();
                currencyView.getProblemLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    currencyView.getProblemLabel().setText(currencyView.getProblemLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(currencyView.getProblemLabel().getText().equals("")) currencyView.getProblemLabel().setText("0");
            }
        }

        //Show Result Button Action
        if(e.getSource() == currencyView.getOperatorButtons()[0]) {
            model.input1 = Double.parseDouble(currencyView.getProblemLabel().getText());

            //Default
            if (currencyView.getComboBox1().getSelectedItem() == "Select Here")
                currencyView.getResultLabel().setText("0");

            //From USD
            if (currencyView.getComboBox1().getSelectedItem() == "USD") {
                if (currencyView.getComboBox2().getSelectedItem() == "USD") {
                    model.result = String.valueOf(model.input1);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "KHR") {
                    model.result = String.valueOf(model.input1 * 4112.0);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "THB") {
                    model.result = String.valueOf(model.input1 * 35.32);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "FRANC") {
                    model.result = String.valueOf(model.input1 * 0.94);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "EURO") {
                    model.result = String.valueOf(model.input1 * 0.97);
                    currencyView.getResultLabel().setText(model.result);
                } else currencyView.getResultLabel().setText("0");
            }
            //From KHR
            if (currencyView.getComboBox1().getSelectedItem() == "KHR") {
                if (currencyView.getComboBox2().getSelectedItem() == "USD") {
                    model.result = String.valueOf(model.input1 / 4112.0);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "KHR") {
                    model.result = String.valueOf(model.input1);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "THB") {
                    model.result = String.valueOf(model.input1 / 116.45);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "FRANC") {
                    model.result = String.valueOf(model.input1 / 4367.08);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "EURO") {
                    model.result = String.valueOf(model.input1 / 4219.96);
                    currencyView.getResultLabel().setText(model.result);
                } else currencyView.getResultLabel().setText("0");
            }
            //From THB
            if (currencyView.getComboBox1().getSelectedItem() == "THB") {
                if (currencyView.getComboBox2().getSelectedItem() == "USD") {
                    model.result = String.valueOf(model.input1 / 35.32);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "KHR") {
                    model.result = String.valueOf(model.input1 * 116.45);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "THB") {
                    model.result = String.valueOf(model.input1);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "FRANC") {
                    model.result = String.valueOf(model.input1 / 37.50);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "EURO") {
                    model.result = String.valueOf(model.input1 / 36.25);
                    currencyView.getResultLabel().setText(model.result);
                } else currencyView.getResultLabel().setText("0");
            }
            //From FRANC
            if (currencyView.getComboBox1().getSelectedItem() == "FRANC") {
                if (currencyView.getComboBox2().getSelectedItem() == "USD") {
                    model.result = String.valueOf(model.input1 * 1.06);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "KHR") {
                    model.result = String.valueOf(model.input1 * 4367.08);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "THB") {
                    model.result = String.valueOf(model.input1 * 37.50);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "FRANC") {
                    model.result = String.valueOf(model.input1);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "EURO") {
                    model.result = String.valueOf(model.input1 * 1.03);
                    currencyView.getResultLabel().setText(model.result);
                } else currencyView.getResultLabel().setText("0");
            }
            //From EURO
            if (currencyView.getComboBox1().getSelectedItem() == "EURO") {
                if (currencyView.getComboBox2().getSelectedItem() == "USD") {
                    model.result = String.valueOf(model.input1 * 1.03);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "KHR") {
                    model.result = String.valueOf(model.input1 * 4219.96);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "THB") {
                    model.result = String.valueOf(model.input1 * 36.25);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "FRANC") {
                    model.result = String.valueOf(model.input1 * 0.97);
                    currencyView.getResultLabel().setText(model.result);
                } else if (currencyView.getComboBox2().getSelectedItem() == "EURO") {
                    model.result = String.valueOf(model.input1);
                    currencyView.getResultLabel().setText(model.result);
                } else currencyView.getResultLabel().setText("0");
            }
        }
    }
}

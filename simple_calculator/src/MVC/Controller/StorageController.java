package MVC.Controller;

import MVC.Model.Model;
import MVC.View.StorageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StorageController implements ActionListener {
    private final Model model = new Model();
    private final StorageView storageView = new StorageView();

    public StorageView getStorageView() {
        return storageView;
    }

    //Constructor
    public StorageController(){
        createListener();
    }

    public void createListener(){
        for (JButton numberButton : storageView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }

        for (JButton operatorButton : storageView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }

        storageView.getComboBox1().addActionListener(e -> {
            //Default
            if(storageView.getComboBox1().getSelectedItem() == "Select Here") storageView.getExchangeRateLabel().setText("Storage Exchange Rate");

            //From PB
            if(storageView.getComboBox1().getSelectedItem() == "PB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1PB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024TB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000GB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000,000B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From TB
            if(storageView.getComboBox1().getSelectedItem() == "TB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024TB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1TB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1tB = 1,024GB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000,000B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From GB
            if(storageView.getComboBox1().getSelectedItem() == "GB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000GB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024GB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1GB = 1GB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024,000B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From MB
            if(storageView.getComboBox1().getSelectedItem() == "MB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024MB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1MB = 1MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1MB = 1,024B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From B
            if(storageView.getComboBox1().getSelectedItem() == "B"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000,000B");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000,000B");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024,000B");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1MB = 1,024MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1B = 1B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
        });
        storageView.getComboBox2().addActionListener(e -> {
            //Default
            if(storageView.getComboBox1().getSelectedItem() == "Select Here") storageView.getExchangeRateLabel().setText("Storage Exchange Rate");

            //From PB
            if(storageView.getComboBox1().getSelectedItem() == "PB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1PB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024TB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000GB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000,000B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From TB
            if(storageView.getComboBox1().getSelectedItem() == "TB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024TB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1TB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024GB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000,000B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From GB
            if(storageView.getComboBox1().getSelectedItem() == "GB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000GB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024GB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1GB = 1GB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024,000B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From MB
            if(storageView.getComboBox1().getSelectedItem() == "MB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000MB");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024MB");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1MB = 1MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1MB = 1,024B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
            //From B
            if(storageView.getComboBox1().getSelectedItem() == "B"){
                if(storageView.getComboBox2().getSelectedItem() == "PB")
                    storageView.getExchangeRateLabel().setText("1PB = 1,024,000,000,000B");
                else if(storageView.getComboBox2().getSelectedItem() == "TB")
                    storageView.getExchangeRateLabel().setText("1TB = 1,024,000,000B");
                else if(storageView.getComboBox2().getSelectedItem() == "GB")
                    storageView.getExchangeRateLabel().setText("1GB = 1,024,000B");
                else if(storageView.getComboBox2().getSelectedItem() == "MB")
                    storageView.getExchangeRateLabel().setText("1MB = 1,024MB");
                else if(storageView.getComboBox2().getSelectedItem() == "B")
                    storageView.getExchangeRateLabel().setText("1B = 1B");
                else storageView.getExchangeRateLabel().setText("Storage Exchange Rate");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button Action
        for(int i = 0; i < 10; i++){
            if(e.getSource() == storageView.getNumberButtons()[i]){
                if(storageView.getProblemLabel().getText().equals("0")) storageView.getProblemLabel().setText("");
                storageView.getProblemLabel().setText(storageView.getProblemLabel().getText().concat(String.valueOf(i)));
            }
        }
        //Decimal Point Button Action
        if(e.getSource() == storageView.getOperatorButtons()[3]){
            if(storageView.getProblemLabel().getText().contains(".")) storageView.getProblemLabel().setText(storageView.getProblemLabel().getText());
            else storageView.getProblemLabel().setText(storageView.getProblemLabel().getText().concat("."));
        }
        //Clear Button Action
        if(e.getSource() == storageView.getOperatorButtons()[1]){
            storageView.getProblemLabel().setText("0");
            storageView.getResultLabel().setText("0");
        }
        //Backspace Button Action
        if(e.getSource() == storageView.getOperatorButtons()[2]){
            if(storageView.getProblemLabel().getText().equals("0"))
                storageView.getProblemLabel().setText("0");
            else{
                String temp = storageView.getProblemLabel().getText();
                storageView.getProblemLabel().setText("");
                for(int i = 0; i < temp.length() - 1; i++){
                    storageView.getProblemLabel().setText(storageView.getProblemLabel().getText().concat(String.valueOf(temp.charAt(i))));
                }
                if(storageView.getProblemLabel().getText().equals("")) storageView.getProblemLabel().setText("0");
            }
        }

        //Show Result Button Action
        if(e.getSource() == storageView.getOperatorButtons()[0]){
            model.input1 = Double.parseDouble(storageView.getProblemLabel().getText());

            //Default
            if(storageView.getComboBox1().getSelectedItem() == "Select Here") storageView.getResultLabel().setText("0");

            //From PB
            if(storageView.getComboBox1().getSelectedItem() == "PB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB"){
                    model.result = String.valueOf(model.input1);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "TB"){
                    model.result = String.valueOf(model.input1 * 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "GB"){
                    model.result = String.valueOf(model.input1 * 1024000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "MB"){
                    model.result = String.valueOf(model.input1 * 1024000000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "B"){
                    model.result = String.valueOf(model.input1 * 1024000000000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else storageView.getResultLabel().setText("0");
            }
            //From TB
            if(storageView.getComboBox1().getSelectedItem() == "TB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB"){
                    model.result = String.valueOf(model.input1 / 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "TB"){
                    model.result = String.valueOf(model.input1);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "GB"){
                    model.result = String.valueOf(model.input1 * 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "MB"){
                    model.result = String.valueOf(model.input1 * 1024000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "B"){
                    model.result = String.valueOf(model.input1 * 1024000000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else storageView.getResultLabel().setText("0");
            }
            //From GB
            if(storageView.getComboBox1().getSelectedItem() == "GB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB"){
                    model.result = String.valueOf(model.input1 / 1024000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "TB"){
                    model.result = String.valueOf(model.input1 / 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "GB"){
                    model.result = String.valueOf(model.input1);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "MB"){
                    model.result = String.valueOf(model.input1 * 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "B"){
                    model.result = String.valueOf(model.input1 * 1024000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else storageView.getResultLabel().setText("0");
            }
            //From MB
            if(storageView.getComboBox1().getSelectedItem() == "MB"){
                if(storageView.getComboBox2().getSelectedItem() == "PB"){
                    model.result = String.valueOf(model.input1 / 1024000000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "TB"){
                    model.result = String.valueOf(model.input1 / 1024000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "GB"){
                    model.result = String.valueOf(model.input1 / 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "MB"){
                    model.result = String.valueOf(model.input1);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "B"){
                    model.result = String.valueOf(model.input1 * 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else storageView.getResultLabel().setText("0");
            }
            //From B
            if(storageView.getComboBox1().getSelectedItem() == "B"){
                if(storageView.getComboBox2().getSelectedItem() == "PB"){
                    model.result = String.valueOf(model.input1 / 1024000000000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "TB"){
                    model.result = String.valueOf(model.input1 / 1024000000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "GB"){
                    model.result = String.valueOf(model.input1 / 1024000.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "MB"){
                    model.result = String.valueOf(model.input1 / 1024.0);
                    storageView.getResultLabel().setText(model.result);
                }
                else if(storageView.getComboBox2().getSelectedItem() == "B"){
                    model.result = String.valueOf(model.input1);
                    storageView.getResultLabel().setText(model.result);
                }
                else storageView.getResultLabel().setText("0");
            }
        }
    }
}

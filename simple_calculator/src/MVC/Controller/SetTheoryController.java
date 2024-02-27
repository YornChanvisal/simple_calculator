package MVC.Controller;

//import MVC.Model.Model;
import MVC.View.SetTheoryView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetTheoryController implements ActionListener {

    //private final Model model = new Model();
    private final SetTheoryView setTheoryView = new SetTheoryView();

    public SetTheoryView getSetTheoryView() {
        return setTheoryView;
    }

    public SetTheoryController(){
        createListener();
    }

    public void createListener(){
        for (JButton numberButton : setTheoryView.getNumberButtons()) {
            numberButton.addActionListener(this);
        }

        for (JButton operatorButton : setTheoryView.getOperatorButtons()) {
            operatorButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button Action
        for(int i = 0; i < 10; i++){
            if(e.getSource() == setTheoryView.getNumberButtons()[i]){
                if(setTheoryView.getInputATextField().isEnabled()){
                    if(setTheoryView.getInputATextField().getText().equals("0")) setTheoryView.getInputATextField().setText("");
                    setTheoryView.getInputATextField().setText(setTheoryView.getInputATextField().getText().concat(String.valueOf(i)));
                }else if(setTheoryView.getInputBTextField().isEnabled()){
                    if(setTheoryView.getInputBTextField().getText().equals("0")) setTheoryView.getInputBTextField().setText("");
                    setTheoryView.getInputBTextField().setText(setTheoryView.getInputBTextField().getText().concat(String.valueOf(i)));
                }

            }
        }
    }
}

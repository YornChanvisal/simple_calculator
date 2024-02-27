package MVC.View;

import javax.swing.*;
import java.awt.*;

public class SetTheoryView extends JPanel{
    //Private Field
    private final JPanel aPanel = new JPanel();
    private final JPanel bPanel = new JPanel();
    private final JPanel resultPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();

    //TextField, Labels That Show Problem and Result With Getter Methods Of Them
    private JTextField inputATextField;
    private JTextField inputBTextField;
    private JLabel resultLabel;
    private JLabel showProblemLabel;

    public JLabel getResultLabel() {
        return resultLabel;
    }
    public JLabel getShowProblemLabel() {
        return showProblemLabel;
    }
    public JTextField getInputATextField() {
        return inputATextField;
    }
    public JTextField getInputBTextField() {
        return inputBTextField;
    }

    //Arrays Of All Buttons And Getter Methods Of Them
    private JButton[] numberButtons;        //Number Button
    private JButton[] operatorButtons;      //Operator Button

    public JButton[] getNumberButtons() {
        return numberButtons;
    }
    public JButton[] getOperatorButtons() {
        return operatorButtons;
    }

    //Create Default Font
    Font defaultFont = new Font("Courier", Font.BOLD, 36);

    //Constructor
    public SetTheoryView(){
        //Create Panel
        createInputAPanel();
        createInputBPanel();
        createResultPanel();
        createInputPanel();

        //Add Sub Panels to Main Panel
        add(aPanel);
        add(bPanel);
        add(resultPanel);
        add(inputPanel);
    }

    //Create Panels
    private void createInputAPanel(){
        aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.PAGE_AXIS));
        aPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        aPanel.setBackground(new Color(255,255,255));
        aPanel.setPreferredSize(new Dimension(830, 135));

        JLabel inputALabel = new JLabel("Set A");
        inputALabel.setForeground(new Color(75, 75, 75));
        inputALabel.setFont(new Font("Lato", Font.BOLD, 36));

        inputATextField = new JTextField();
        inputATextField.setFont(new Font("Lato", Font.BOLD, 64));

        aPanel.add(inputALabel);
        aPanel.add(inputATextField);
    }

    private void createInputBPanel(){
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.PAGE_AXIS));
        bPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        bPanel.setBackground(new Color(255,255,255));
        bPanel.setPreferredSize(new Dimension(830, 135));

        JLabel inputBLabel = new JLabel("Set B");
        inputBLabel.setForeground(new Color(75, 75, 75));
        inputBLabel.setFont(new Font("Lato", Font.BOLD, 36));

        inputBTextField = new JTextField();
        inputBTextField.setFont(new Font("Lato", Font.BOLD, 64));

        bPanel.add(inputBLabel);
        bPanel.add(inputBTextField);
    }

    private void createResultPanel(){
        //Set Layout
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        resultPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        //Set Panel Size and Background
        resultPanel.setBackground(new Color(255,255,255));
        resultPanel.setPreferredSize(new Dimension(1664, 135));

        //Set Labels
        resultLabel = new JLabel("0");
        resultLabel.setForeground(new Color(0, 0, 0));
        resultLabel.setFont(new Font("Lato", Font.BOLD, 64));

        showProblemLabel = new JLabel("intersect(A, B)=");
        showProblemLabel.setForeground(new Color(75,75,75));
        showProblemLabel.setFont(new Font("Lato", Font.BOLD, 24));

        //Add Labels
        resultPanel.add(resultLabel);
        resultPanel.add(showProblemLabel);
    }

    private void createInputPanel(){
        //Set Layout And Size
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(1680, 470));

        //Create Constraint
        GridBagConstraints inputGrid = new GridBagConstraints();

        //Array of Number Buttons And Modify Number Buttons
        numberButtons = new JButton[10];

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBackground(new Color(255, 255, 255));
            numberButtons[i].setFont(defaultFont);
            numberButtons[i].setPreferredSize(new Dimension(405,90));
            numberButtons[i].setBorderPainted(false);
            numberButtons[i].setFocusable(false);
        }

        //Array of Operator Buttons
        operatorButtons = new JButton[6];
        JButton commaButton;
        operatorButtons[0] = (commaButton = new JButton(","));
        JButton clearButton;
        operatorButtons[1] = (clearButton = new JButton("C"));
        JButton backspaceButton;
        operatorButtons[2] = (backspaceButton = new JButton(new ImageIcon("src/Image/backspace.png")));
        JButton unionButton;
        operatorButtons[3] = (unionButton = new JButton(new ImageIcon("src/Image/union-sign.png")));
        JButton intersectButton;
        operatorButtons[4] = (intersectButton = new JButton(new ImageIcon("src/Image/intersection-sign.png")));
        JButton diffButton;
        operatorButtons[5] = (diffButton = new JButton("A - B"));

        //Modify Operator Buttons
        for(int i = 0; i < 6; i++){
            operatorButtons[i].setBackground(new Color(255, 255, 255));
            if(i == 3 || i == 4 || i == 5) operatorButtons[i].setBackground(new Color(85, 255, 102));
            operatorButtons[i].setFont(defaultFont);
            operatorButtons[i].setPreferredSize(new Dimension(405,90));
            operatorButtons[i].setBorderPainted(false);
            operatorButtons[i].setFocusable(false);
        }

        //Modify Button on Interface
        inputGrid.gridx = 0;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[7], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[8], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[9], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(intersectButton, inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[4], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[5], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[6], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(unionButton, inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[1], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[2], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[3], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(diffButton, inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(clearButton, inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[0], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(commaButton, inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(backspaceButton, inputGrid);
    }
}

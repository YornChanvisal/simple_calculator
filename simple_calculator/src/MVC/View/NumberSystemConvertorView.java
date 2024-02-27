package MVC.View;

import javax.swing.*;
import java.awt.*;

public class NumberSystemConvertorView extends JPanel {
    //Private Field
    private final JPanel problemPanel = new JPanel();
    private final JPanel resultPanel = new JPanel();
    private final JPanel optionPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();

    //Labels That Show Problem and Result With Getter Methods Of Them
    private JLabel resultLabel;
    private JLabel problemLabel;

    public JLabel getResultLabel() {
        return resultLabel;
    }
    public JLabel getProblemLabel() {
        return problemLabel;
    }

    //Arrays Of All Buttons And Getter Methods Of Them
    private JButton[] numberButtons;        //Number Button
    private JButton[] letterButton;         //Letter button
    private JButton[] operatorButtons;      //Operator Button

    public JButton[] getNumberButtons() {
        return numberButtons;
    }
    public JButton[] getLetterButton() {
        return letterButton;
    }
    public JButton[] getOperatorButtons() {
        return operatorButtons;
    }

    //The Combo Boxes To Choose Option
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    public JComboBox<String> getComboBox1() {
        return comboBox1;
    }
    public JComboBox<String> getComboBox2() {
        return comboBox2;
    }

    //Create Default Font
    Font defaultFont = new Font("Courier", Font.BOLD, 36);

    public String[] letter = {"a", "b", "c", "d", "e", "f"};

    //Constructor
    public NumberSystemConvertorView(){
        //Create Panel
        createProblemPanel();
        createResultPanel();
        createOptionPanel();
        createInputPanel();

        //Add Sub Panels to Main Panel
        add(problemPanel);
        add(resultPanel);
        add(optionPanel);
        add(inputPanel);
    }

    //Create Panels
    private void createProblemPanel(){
        //Set Layout
        problemPanel.setLayout(new BorderLayout());
        problemPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        //Set Background And Size
        problemPanel.setBackground(new Color(255,255,255));
        problemPanel.setPreferredSize(new Dimension(830, 135));

        //Modify TextField
        problemLabel = new JLabel("0");
        problemLabel.setForeground(new Color(0, 0, 0));
        problemLabel.setFont(new Font("Lato", Font.BOLD, 64));

        //Add TextField
        problemPanel.add(problemLabel, BorderLayout.LINE_START);
    }

    private void createResultPanel(){
        //Set Layout
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        //Set background And Size
        resultPanel.setBackground(new Color(255,255,255));
        resultPanel.setPreferredSize(new Dimension(830, 135));

        //Modify Label
        resultLabel = new JLabel("0");
        resultLabel.setForeground(new Color(0, 0, 0));
        resultLabel.setFont(new Font("Lato", Font.BOLD, 64));

        //Add Label
        resultPanel.add(resultLabel, BorderLayout.LINE_START);
    }

    private void createOptionPanel(){
        //Set Layout And Size
        optionPanel.setLayout(new FlowLayout());
        optionPanel.setPreferredSize(new Dimension(1680,60));

        String[] optionsToChoose = {"Select Here", "Decimal", "Binary", "Octal", "Hexadecimal"};

        //Modify ComboBoxes
        comboBox1 = new JComboBox<>(optionsToChoose);
        comboBox1.setBounds(0, 50, 200, 36);

        comboBox2 = new JComboBox<>(optionsToChoose);
        comboBox2.setBounds(840, 50, 200, 36);

        //Add ComboBoxes
        optionPanel.add(comboBox1);
        optionPanel.add(comboBox2);
    }

    private void createInputPanel(){
        //Set Layout And Size
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(1680, 570));

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

        //Array of Letter Buttons And Modify Letter Buttons
        letterButton = new JButton[6];

        for(int i = 0; i < 6; i++){
            letterButton[i] = new JButton(letter[i]);
            letterButton[i].setBackground(new Color(255, 255, 255));
            letterButton[i].setFont(defaultFont);
            letterButton[i].setPreferredSize(new Dimension(405,90));
            letterButton[i].setBorderPainted(false);
            letterButton[i].setFocusable(false);
        }

        //Array of Operator Buttons
        operatorButtons = new JButton[3];
        JButton showResultButton;
        operatorButtons[0] = (showResultButton = new JButton("="));
        JButton clearButton;
        operatorButtons[1] = (clearButton = new JButton("C"));
        JButton backspaceButton;
        operatorButtons[2] = (backspaceButton = new JButton(new ImageIcon("src/Image/backspace.png")));

        //Modify Operator Buttons
        for(int i = 0; i < 3; i++){
            operatorButtons[i].setBackground(new Color(255, 255, 255));
            if(i == 0) operatorButtons[i].setBackground(new Color(85, 255, 102));
            operatorButtons[i].setFont(defaultFont);
            operatorButtons[i].setPreferredSize(new Dimension(405,90));
            operatorButtons[i].setBorderPainted(false);
            operatorButtons[i].setFocusable(false);
        }

        //Set Grid
        inputGrid.gridx = 0;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(letterButton[0], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(letterButton[1], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(letterButton[2], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(letterButton[3], inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[7], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[8], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[9], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 1;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(letterButton[4], inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[4], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[5], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[6], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 2;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(letterButton[5], inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[1], inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[2], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[3], inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 3;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(showResultButton, inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[0], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(clearButton, inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(backspaceButton, inputGrid);
    }
}

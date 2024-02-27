package MVC.View;

import javax.swing.*;
import java.awt.*;

public class BitwiseView extends JPanel{
    //Private Field
    private final JPanel resultPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();

    //Labels That Show Result And Operand With Getter Methods Of Them
    private JLabel resultLabel;
    private JLabel showProblemLabel;

    public JLabel getResultLabel(){
        return resultLabel;
    }
    public JLabel getShowProblemLabel(){
        return showProblemLabel;
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
    public BitwiseView(){
        //Create Panel
        createResultPanel();
        createInputPanel();

        //Add Sub Panels to Main Panel
        add(resultPanel);
        add(inputPanel);
    }

    public void createResultPanel(){
        //Set Layout
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        resultPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        //Set Panel Size and Background
        resultPanel.setBackground(new Color(255,255,255));
        resultPanel.setPreferredSize(new Dimension(1680, 200));

        //Set labels
        resultLabel = new JLabel("0");
        resultLabel.setForeground(new Color(0, 0, 0));
        resultLabel.setFont(new Font("Lato", Font.BOLD, 64));
        resultLabel.setFocusable(true);

        showProblemLabel = new JLabel("");
        showProblemLabel.setForeground(new Color(160,160,160));
        showProblemLabel.setFont(new Font("Lato", Font.BOLD, 28));

        //Add Labels
        resultPanel.add(resultLabel);
        resultPanel.add(showProblemLabel);
    }

    private void createInputPanel(){
        //Set Layout and Size
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

        //Array of Operator Buttons
        operatorButtons = new JButton[10];
        JButton showResultButton;
        operatorButtons[0] = (showResultButton = new JButton("="));
        JButton leftShiftButton;
        operatorButtons[1] = (leftShiftButton = new JButton("<<"));
        JButton rightShiftButton;
        operatorButtons[2] = (rightShiftButton = new JButton(">>"));
        JButton orButton;
        operatorButtons[3] = (orButton = new JButton("|"));
        JButton andButton;
        operatorButtons[4] = (andButton = new JButton("&"));
        JButton xorButton;
        operatorButtons[5] = (xorButton = new JButton("^"));
        JButton inverseButton;
        operatorButtons[6] = (inverseButton = new JButton("~"));
        JButton clearButton;
        operatorButtons[7] = (clearButton = new JButton("C"));
        JButton backspaceButton;
        operatorButtons[8] = (backspaceButton = new JButton(new ImageIcon("src/Image/backspace.png")));
        JButton posOrNegButton;
        operatorButtons[9] = (posOrNegButton = new JButton(new ImageIcon("src/Image/pos-neg-symbol.png")));

        //Modify Operator Buttons
        for(int i = 0; i < 10; i++){
            operatorButtons[i].setBackground(new Color(255, 255, 255));
            if(i == 0) operatorButtons[i].setBackground(new Color(85, 255, 102));
            operatorButtons[i].setFont(defaultFont);
            operatorButtons[i].setPreferredSize(new Dimension(405,90));
            operatorButtons[i].setBorderPainted(false);
            operatorButtons[i].setFocusable(false);
        }

        //Arrange Buttons With Grid Bag Layout
        inputGrid.gridx = 0;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(clearButton, inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(leftShiftButton, inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(rightShiftButton, inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 0;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(inverseButton, inputGrid);

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
        inputPanel.add(orButton, inputGrid);

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
        inputPanel.add(andButton, inputGrid);

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
        inputPanel.add(xorButton, inputGrid);

        inputGrid.gridx = 0;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(posOrNegButton, inputGrid);

        inputGrid.gridx = 1;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(numberButtons[0], inputGrid);

        inputGrid.gridx = 2;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(backspaceButton, inputGrid);

        inputGrid.gridx = 3;
        inputGrid.gridy = 4;
        inputGrid.weightx = 1;
        inputGrid.weighty = 1;
        inputPanel.add(showResultButton, inputGrid);
    }
}

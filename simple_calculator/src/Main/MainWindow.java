package Main;

import MVC.Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    //Private Field
    private JToolBar toolBar;

    private JButton standardButton;
    private JButton bitwiseButton;
    private JButton storageButton;
    private JButton currencyButton;
    private JButton scientificButton;
    private JButton numberSystemConvertorButton;
    private JButton binaryArithmeticButton;
    private JButton setTheoryButton;

    //Create Main Panel
    public MainWindow() {
        //Create Tool Bar
        createControl();

        //Set Tool Bar Layout And Add to Main Window
        setLayout(new BorderLayout());
        this.getContentPane().add(toolBar, BorderLayout.PAGE_START);

        // Set icon for MainWindow
        ImageIcon logo = new ImageIcon("src/Image/MainLogo/math.png");
        setIconImage(logo.getImage());

        ScientificController scientificController = new ScientificController();
        getContentPane().add(scientificController.getScientificView());
    }

    //Create Tool Bar
    private void createControl(){
        //Create Toolbar
        toolBar = new JToolBar("Menu");

            //Create button
        standardButton = new JButton(new ImageIcon("src/Image/calculator.png"));
        standardButton.addActionListener(this);
        bitwiseButton = new JButton(new ImageIcon("src/Image/bitwise.png"));
        bitwiseButton.addActionListener(this);
        storageButton = new JButton(new ImageIcon("src/Image/storage.png"));
        storageButton.addActionListener(this);
        currencyButton = new JButton(new ImageIcon("src/Image/currency.png"));
        currencyButton.addActionListener(this);
        scientificButton = new JButton(new ImageIcon("src/Image/scientific.png"));
        scientificButton.addActionListener(this);
        numberSystemConvertorButton = new JButton(new ImageIcon("src/Image/num-system-convert.png"));
        numberSystemConvertorButton.addActionListener(this);
        binaryArithmeticButton = new JButton(new ImageIcon("src/Image/binary-arithmetic.png"));
        binaryArithmeticButton.addActionListener(this);
        setTheoryButton = new JButton(new ImageIcon("src/Image/set.png"));
        setTheoryButton.addActionListener(this);

            //Set Tool Tips Text
        standardButton.setToolTipText("STANDARD");
        bitwiseButton.setToolTipText("BITWISE");
        storageButton.setToolTipText("STORAGE");
        currencyButton.setToolTipText("CURRENCY");
        scientificButton.setToolTipText("SCIENTIFIC");
        numberSystemConvertorButton.setToolTipText("NUMBER SYSTEM CONVERTOR");
        binaryArithmeticButton.setToolTipText("BINARY ARITHMETIC");
        setTheoryButton.setToolTipText("SET THEORY");

            //Add Button To Toolbar
        toolBar.add(standardButton);
        toolBar.add(bitwiseButton);
        toolBar.add(storageButton);
        toolBar.add(currencyButton);
        toolBar.add(scientificButton);
        toolBar.add(numberSystemConvertorButton);
        toolBar.add(binaryArithmeticButton);
        toolBar.add(setTheoryButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        getContentPane().remove(getContentPane().getComponent(1));
        getContentPane().repaint();

        if(source == standardButton){
            StandardController standardController = new StandardController();
            getContentPane().add(standardController.getStandardView());
            this.repaint();
            revalidate();
        }else if(source == scientificButton){
            ScientificController scientificController = new ScientificController();
            getContentPane().add(scientificController.getScientificView());
            this.repaint();
            revalidate();
        }else if(source == bitwiseButton){
            BitwiseController bitwiseController = new BitwiseController();
            getContentPane().add(bitwiseController.getBitwiseView());
            this.repaint();
            revalidate();
        }else if(source == binaryArithmeticButton){
            BinaryArithmeticController binaryArithmeticController = new BinaryArithmeticController();
            getContentPane().add(binaryArithmeticController.getBinaryArithmeticView());
            this.repaint();
            revalidate();
        }else if(source == currencyButton){
            CurrencyController currencyController = new CurrencyController();
            getContentPane().add(currencyController.getCurrencyView());
            this.repaint();
            revalidate();
        }else if(source == numberSystemConvertorButton){
            NumberSystemConvertorController numberSystemConvertorController = new NumberSystemConvertorController();
            getContentPane().add(numberSystemConvertorController.getNumberSystemConvertorView());
            this.repaint();
            revalidate();
        }else if(source == setTheoryButton){
            SetTheoryController setTheoryController = new SetTheoryController();
            getContentPane().add(setTheoryController.getSetTheoryView());
            this.repaint();
            revalidate();
        }else if(source == storageButton){
            StorageController storageController = new StorageController();
            getContentPane().add(storageController.getStorageView());
            this.repaint();
            revalidate();
        }
    }
}

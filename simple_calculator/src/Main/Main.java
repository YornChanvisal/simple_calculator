/*
Lab 22 - ITE Calculator
By: Yorn Chanvisal, Date: August 04, 2022
 */

package Main;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args){
        //Create Object MainWindow
        MainWindow mainWindow = new MainWindow();
        //Set App Title
        mainWindow.setTitle("WeCalculate");
        // Set App Started location
        mainWindow.setLocation(0, 0);
        //Set MainWindow Size
        mainWindow.setSize(new Dimension(1720,880));
        //Set Visible
        mainWindow.setVisible(true);
        //Set Exit on close
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

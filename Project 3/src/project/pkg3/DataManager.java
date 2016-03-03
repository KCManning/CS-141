/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class DataManager
{

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: OrcaGUI
     * @File: OrcaGUI.java
     *
     * @author: Kevin Manning
     *
     * @Function: helpMenu
     * @Title: Help Menu Builder
     *
     * @Description: Opens the needed file, pulls the data into the string, and
     * places it into a popup.
     *
     * @Input: n/a
     * @Output: JOptionPane - Puts the information up to the screen
     *
     * @Parameters:
     * <br>String type - Sets file name and window message
     * @Return: n/a
     *
     * @CalledBy: menuInstructions, menuAbout
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 2/18/2016
     * @version 1.0
     * @HistoryLog: 2/18/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public void infoPop(String type)
    {

        try
        {
            FileReader freader = new FileReader("src//Data//" + type + ".txt");
            BufferedReader inputFile = new BufferedReader(freader);

            // Read the first name from the file.
            String inputLines = inputFile.readLine();
            StringBuffer data = new StringBuffer();

            while (inputLines
                    != null)
            {
                data.append(inputLines + "\n");
                inputLines = inputFile.readLine();
            }

            JOptionPane.showMessageDialog(
                    null, data, type,
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException exp) // catch file not found
        {
            exp.printStackTrace();
        } catch (IOException exp) // catch reading error
        {
            exp.printStackTrace();
        }
    }

    static public void save(String numDraws)
    {
        try
        {
            //Prepares a file for writing
            File file = new File("src//Data//Stats.txt");
            FileWriter writer = new FileWriter(file, true);

            //Verifies inputs are valid
            if (Integer.parseInt(numDraws) > 0)
            {
                //appends a delimiter
                numDraws += "\n";
                //Places the data in the file, closes file and window
                writer.write(numDraws);
            }
            writer.close();

        } catch (FileNotFoundException exp) // catch file not found
        {
            exp.printStackTrace();
        } catch (IOException exp) // catch writing error
        {
            exp.printStackTrace();
        }
    }//save

    static public void stats()
    {
        ArrayList<String> data = loadStats();
        int dataSet[] = new int[data.size()];

        for (int i = 0; i < data.size(); i++)
        {
            dataSet[i] = Integer.parseInt(data.get(i));
        }
        
        bubbleSort(dataSet);
        
        int total = 0;
        for (int val : dataSet)
        {
            total += val;
        }
        
        float mean = total / dataSet.length;
        int max = dataSet[dataSet.length - 1];
        int min = dataSet[0];
        int median = dataSet[dataSet.length / 2];
        int range = max - min;

        StringBuffer output = new StringBuffer();
        output.append("Total Number of Cards Drawn: " + total);
        output.append("\nFewest Cards Needed: " + min);
        output.append("\nMost cards needed: " + max);
        output.append("\nRange of Cards Drawn: " + range);
        output.append("\nMedian Number of Cards Drawn: " + median);
        output.append("\nMean Number of Cards Drawn: " + mean);
        JOptionPane.showMessageDialog(
                null, output, "Stats",
                JOptionPane.INFORMATION_MESSAGE);

    }//save

    static private void bubbleSort(int arr[])
    {
        int temp = arr[0];
        for (int pass = 1; pass < arr.length; pass++) // passes
        {
            for (int i = 0; i < arr.length - 1; i++) // one pass
            {
                if (arr[i] > arr[i + 1]) // one comparison
                {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    static private ArrayList<String> loadStats()
    {
        try
        {

            FileReader freader = new FileReader("src//Data//Stats.txt");
            BufferedReader inputFile = new BufferedReader(freader);

            // Read the first name from the file.
            String inputLines = inputFile.readLine();
            ArrayList<String> data = new ArrayList<String>();

            while (inputLines != null)
            {
                data.add(inputLines);
                inputLines = inputFile.readLine();
            }
            return data;
        } catch (FileNotFoundException exp) // catch file not found
        {
            exp.printStackTrace();
            return null;
        } catch (IOException exp) // catch reading error
        {
            exp.printStackTrace();
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class ExtractDigits
{

    public static void main(String[] args)
    {
        //check for valid number of arguments at command prompt: 2
        if (args.length < 2)
        {
            System.out.println("usage: java ExtractDigits <month> <year>");
            System.exit(1);
        }

        int month = Integer.valueOf(args[0]).intValue();
        int year = Integer.valueOf(args[1]).intValue();
        if (month < 1 || month > 12) //illegal month
        {
            System.out.println("Month must be between 1 and 12");
            System.exit(1); //not an elegant way to exit--use while instead
        }
        if (year < 1970) //illegal year
        {
            System.out.println("Year must be greater than 1969");
            System.exit(1); //not an elegant way to exit--use while instead
        }
        //display inputs for month and year
        System.out.print("The month you entered is ");
        System.out.println(month);
        System.out.print("The year you entered is ");
        System.out.println(year);

        //read a 4-digit number via a JOptionPane
        String input = JOptionPane.showInputDialog("Please enter a 4-digit number");
        String output = ""; //contains output string--poor implementation
        int number = Integer.parseInt(input);
        System.out.print("The digits of " + number + " are ");
        output += "The digits of " + number + " are ";
        System.out.print(number / 1000 + ", "); //display thousand's digit
        output += number / 1000 + ", ";
        number %= 1000;
        System.out.print(number / 100 + ", "); //display hundred's digit
        output += number / 100 + ", ";
        number %= 100;
        System.out.print(number / 10 + ", "); //display ten's digit
        output += number / 10 + ", ";
        number %= 10;
        System.out.println(number + "."); //display the unit's digit
        output += number + ".";
        //display output in a MessageDialog
        JOptionPane.showMessageDialog(null, output);
        System.exit(0);

    }
}

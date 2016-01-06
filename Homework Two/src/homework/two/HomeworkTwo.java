/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.two;

/**
 *
 * @author Kevin
 */
public class HomeworkTwo
{

    public static void main(String[] args)
    {
        float counter = 0f;
        float startingAmount = 10000f;
        float interest = 6;
        float rate = (interest / 12) / 100 + 1;
        float payment = 500;
        
        for(float i = startingAmount; i > 0; i *= rate)
        {
            i -= payment;
            counter++;
        }
        
        System.out.println(counter / 12);
        
    }//end main

}//end HomeWorkTwo class

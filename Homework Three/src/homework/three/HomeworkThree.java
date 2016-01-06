/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.three;

/**
 *
 * @author Kevin
 */
public class HomeworkThree
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /*
        You want to decide whether you should drive your car to work or take the train.
You know the one-way distance from your home to your place of work, and the
fuel efficiency of your car (in miles per gallon). You also know the one-way price
of a train ticket. You assume the cost of gas at $4 per gallon, and car maintenance at
5 cents per mile. Write an algorithm to decide which commute is cheaper. 
         */
        int mpg = 30;
        int distance = 30;
        float ticket = 4.00f;
        float maintenance = .05f * (distance + distance);
        float gasCost = 2.59f;
        float totesGas = (((distance + distance)/ mpg) * gasCost) + maintenance;
        float totesTrain = ticket + ticket;

        if (totesGas != totesTrain)
        {
            if (totesGas < totesTrain)
            {
                System.out.println("Drive!");
            } else if (totesGas > totesTrain)
            {
                System.out.println("Train!");
            }
        }
        else
             System.out.println("They're the same!");

    }

}

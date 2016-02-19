/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.two;

/**
 *
 * @author Kevin
 */
public class CostDataManager
{

    enum rooms
    {
        paradise, atlantis, orcas
    };

    final double MGR_DISCOUNT = 0.1;
    final double TAX = .08;
    final double ROOM_PARADISE = 135.0;
    final double ROOM_ATLANTIS = 185.0;
    final double ROOM_ORCAS = 235.0;

    double meals;
    double wifi;
    double misc;

    int nights;

    boolean discount;

    rooms room;

    public CostDataManager(double meals, double wifi, double misc, int nights, boolean discount, rooms room)
    {
        this.meals = meals;
        this.wifi = wifi;
        this.misc = misc;
        this.nights = nights;
        this.discount = discount;
        this.room = room;
    }

    public double calcTotal()
    {
        return (meals + wifi + misc + getRoomCost() - getDiscount());
    }

    public double getRoomCost()
    {
        double roomCost;

        switch (room)
        {
            default:
            case paradise:
                roomCost = ROOM_PARADISE;
                break;

            case atlantis:
                roomCost = ROOM_ATLANTIS;
                break;

            case orcas:
                roomCost = ROOM_ORCAS;
                break;
        }

        roomCost *= nights;

        return roomCost;
    }

    public double getDiscount()
    {
        if (discount)
        {
            return getRoomCost() * MGR_DISCOUNT;
        } else
        {
            return 0;
        }
    }

    public double getTAX(){return TAX;}
}

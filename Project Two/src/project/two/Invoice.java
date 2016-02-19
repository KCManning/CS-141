package project.two;

/**
 *
 * @author Kevin
 */
public class Invoice
{

    //Enumerates the room values for easier tracking and logic
    enum rooms
    {
        paradise, atlantis, orcas
    };

    //Declares constants
    final double MGR_DISCOUNT = 0.1;
    final double TAX = .08;
    final double ROOM_PARADISE = 135.0;
    final double ROOM_ATLANTIS = 185.0;
    final double ROOM_ORCAS = 235.0;

    //Declares variables
    double meals;
    double wifi;
    double misc;

    byte nights;

    boolean discount;

    rooms room;

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Invoice
     * @File: Invoice.java
     *
     * @author: Kevin Manning
     *
     * @Function: Invoice
     * @Title: Default Constructor
     *
     * @Description: Sets the values of the Invoice Class
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: Necessary values
     * @Return: n/a
     *
     * @CalledBy: btnCalc
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 2/18/2016
     * @version 1.0
     * @HistoryLog: 2/18/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Invoice(double meals, double wifi, double misc, byte nights, boolean discount, rooms room)
    {
        this.meals = meals;
        this.wifi = wifi;
        this.misc = misc;
        this.nights = nights;
        this.discount = discount;
        this.room = room;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Invoice
     * @File: Invoice.java
     *
     * @author: Kevin Manning
     *
     * @Function: calTotal
     * @Title: Total Calculation
     *
     * @Description: Calculates the values of the invoice
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return: the total
     *
     * @CalledBy: btnCalc
     * @Calls: getRoomCost(), getDiscount()
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 2/18/2016
     * @version 1.0
     * @HistoryLog: 2/18/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double calcTotal()
    {
        return (meals + wifi + misc + getRoomCost() - getDiscount());
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Invoice
     * @File: Invoice.java
     *
     * @author: Kevin Manning
     *
     * @Function: getRoomCost
     * @Title: Room Cost Calculation
     *
     * @Description: Determines the cost of the room
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: Necessary values
     * @Return: room cost
     *
     * @CalledBy: btnCalc,
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 2/18/2016
     * @version 1.0
     * @HistoryLog: 2/18/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
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

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Invoice
     * @File: Invoice.java
     *
     * @author: Kevin Manning
     *
     * @Function: getDiscount
     * @Title: Get Discount
     *
     * @Description: Determines the amount of discount (if any)
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return: discount value (or zero)
     *
     * @CalledBy: btnCalc, calcTotal
     * @Calls: getRoomCost
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 2/18/2016
     * @version 1.0
     * @HistoryLog: 2/18/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
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

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Invoice
     * @File: Invoice.java
     *
     * @author: Kevin Manning
     *
     * @Function: getTax
     * @Title: Get Tax
     *
     * @Description: Fetches the Tax Amount
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return:Tax amount
     *
     * @CalledBy: btnCalc
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 2/18/2016
     * @version 1.0
     * @HistoryLog: 2/18/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getTAX()
    {
        return TAX;
    }
}

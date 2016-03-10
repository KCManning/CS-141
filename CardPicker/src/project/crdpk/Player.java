/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.crdpk;

/**
 *
 * @author Kevin
 */
public class Player
{

    //creates singleton of Player object
    static Player player;

    //
    static String players[];
    static String stats[];
    static String statsRemoved[];
    static String logs[];
    static String logsRemoved[];

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Player
     * @File: Player.java
     *
     * @author: Kevin Manning
     *
     * @Function: Player
     * @Title: Default Constructor
     *
     * @Description: Sets the values of the Player Class from the DataManager
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return: n/a
     *
     * @CalledBy: PrintStats, DataManager, getPlayer
     * @Calls: DataManager.stats/log; grabs requested data for storage in an
     * array matching players
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Player()
    {
        players = DataManager.loadPlayers();
        int size = players.length;
        stats = new String[size];
        statsRemoved = new String[size];
        logs = new String[size];
        logsRemoved = new String[size];

        for (int i = 0; i < players.length; i++)
        {
            String name = players[i];
            stats[i] = DataManager.stats(false, name).toString();
            statsRemoved[i] = DataManager.stats(true, name).toString();
            logs[i] = DataManager.log(false, name).toString();
            logsRemoved[i] = DataManager.log(true, name).toString();
        }

    }//end constructor

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Player
     * @File: Player.java
     *
     * @author: Kevin Manning
     *
     * @Function: getPlayer
     * @Title: singleton implementer
     * @Description: Constructs a new Player if and only if one does not exist
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return: player; the already existing object
     *
     * @CalledBy: PrintStats, DataManager, getPlayer
     * @Calls: Player(); constructor for new player.
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public Player getPlayer()
    {
        if (player == null)
        {
            player = new Player();
        }

        return player;

    }//end singleton implementation

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Player
     * @File: Player.java
     *
     * @author: Kevin Manning
     *
     * @Function: getStats
     * @Title: getStats
     * @Description: retrieves stats for a given player and game mode
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters:
     * <br> int index; index of player's stats to be called
     * <br> boolean remove; game mode;
     * @Return: stats[index]/statsRemoved[index]; stats at a given index
     *
     * @CalledBy: PrintStats, DataManager
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public String getStats(int index, boolean remove)
    {
        if (remove)
        {
            return statsRemoved[index];
        } else
        {
            return stats[index];
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Player
     * @File: Player.java
     *
     * @author: Kevin Manning
     *
     * @Function: getLogs
     * @Title: getLogs
     * @Description: retrieves logs for a given player and game mode
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters:
     * <br> int index; index of player's logs to be called
     * <br> boolean remove; game mode;
     * @Return: logs[index]/logsRemoved[index]; logs at a given index
     *
     * @CalledBy: PrintStats, DataManager
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public String getLogs(int index, boolean remove)
    {
        if (remove)
        {
            return logsRemoved[index];
        } else
        {
            return logs[index];
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: Player
     * @File: Player.java
     *
     * @author: Kevin Manning
     *
     * @Function: getName
     * @Title: getName
     * @Description: retrieves the name of a given player
     * 
     * @Output: n/a
     *
     * @Parameters:
     * <br> int index; index of player's name to be called
     * @Return: players[index]; players at a given index
     *
     * @CalledBy: PrintStats, DataManager
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public String getName(int index)
    {
        return players[index];
    }

}

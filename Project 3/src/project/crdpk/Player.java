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

    static Player player;
    static String players[];

    public enum stat
    {
        total, min, max, range, median, mean, deviation
    }
    static String stats[];
    static String statsRemoved[];
    static String logs[];
        static String logsRemoved[];

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

    static public Player getPlayer()
    {
        if (player == null)
        {
            player = new Player();
        }

        return player;

    }//end singleton implementation
    
    static public String getStats (int index, boolean remove)
    {
        if(remove)
            return statsRemoved[index];
        else
            return stats[index];      
    }
    
      static public String getLogs (int index, boolean remove)
    {
        if(remove)
            return logsRemoved[index];
        else
            return logs[index];      
    }

}

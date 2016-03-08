/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3;

/**
 *
 * @author Kevin
 */
public class Player
{
    static Player player;
    static String players[];

    
    public Player()
    {
        players = DataManager.loadPlayers();
        
    }//end constructor
    
    static public Player getPlayer()
    {
        if(player == null)
            player = new Player();
        
        return player;
        
    }//end singleton implementation
    
}

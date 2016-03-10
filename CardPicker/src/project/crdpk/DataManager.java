/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.crdpk;

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
 *
 * @Note: This class is a PURELY method class, and as such has no class level
 * values or constructor. As a result of this, it does not need to be
 * instantiated, or even declared, simply called on an as-needed basis. It's
 * purpose is to serve as a middling layer between the interface, logic, and
 * file structure.
 */
public class DataManager
{

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: infoPop
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
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
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

            while (inputLines != null)
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

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: save
     * @Title: Stats Saver
     *
     * @Description: inputs the given stats into the appropriate player's file
     *
     * @Input: n/a
     * @Output: text file
     *
     * @Parameters:
     * <br>String numDraws; data to be stored
     * <br>boolean remove; game mode
     * <br>String name; player's name
     * @Return: n/a
     *
     * @CalledBy: menuInstructions, menuAbout
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public void save(String numDraws, boolean remove, String name)
    {
        //concatonates the player's name into the file path
        String fileName = "src//Data//" + name + "//Stats";

        //determines gametype file to use
        if (remove)
        {
            fileName += "wRemove";
        }
        try
        {
            //Prepares a file for writing
            File file = new File(fileName + ".txt");
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

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: stats
     * @Title: Stats reader
     *
     * @Description: takes the loaded stats and formats them for display or
     * printing
     *
     * @Input: text file
     * @Output: n/a
     *
     * @Parameters:
     * <br>boolean remove; game mode
     * <br>String name; player's name
     * @Return: output; a stringbuffer for easy display
     *
     * @CalledBy: Player(), menuStats
     * @Calls: loadStats
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public StringBuffer stats(boolean remove, String name)
    {
        //constant for math.pow
        final byte SQUARE = 2;

        //Data storare for the passing in and out of the data
        StringBuffer output = new StringBuffer();
        ArrayList<String> data = loadStats(remove, name);

        //checks if file was empty
        if (!data.isEmpty())
        {
            //array for easy sorting of data
            int dataSet[] = new int[data.size()];

            //Casts Arraylist of type string to an array of ints
            for (int i = 0; i < data.size(); i++)
            {
                dataSet[i] = Integer.parseInt(data.get(i));
            }

            //sorts the data for ease of use
            bubbleSort(dataSet);

            //tallies the values of the array
            int total = 0;
            for (int val : dataSet)
            {
                total += val;
            }

            //Average
            float mean = total / dataSet.length;
            //highest number according to sorted array
            int max = dataSet[dataSet.length - 1];
            //lowest number according to sorted array
            int min = dataSet[0];
            //middle number according to sorted array
            int median = dataSet[dataSet.length / 2];
            //range of possible numbers
            int range = max - min;

            //Calculates standard deviation by calcualting variance, then taking the root
            double standardDev = 0;
            for (int i = 0; i < dataSet.length; i++)
            {
                dataSet[i] -= mean;
                standardDev += Math.pow(dataSet[i], SQUARE);
            }
            standardDev /= dataSet.length;
            standardDev = Math.sqrt(standardDev);

            //Formats the output to return to the called function for easy display
            output.append("Total Number of Cards Drawn: " + total);
            output.append("\nFewest Cards Needed: " + min);
            output.append("\nMost cards needed: " + max);
            output.append("\nRange of Cards Drawn: " + range);
            output.append("\nMedian Number of Cards Drawn: " + median);
            output.append("\nMean Number of Cards Drawn: " + mean);
            output.append("\nStandard Deviation of Cards Drawn:\n" + standardDev);

        } else
        {
            //If data was empty, provides a default string
            output.append("No stats saved. Please run then save.");
        }

        return output;

    }//stats

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: bubbleSort
     * @Title: SORTING!
     *
     * @Description: sorts an array of integers. Bubbles are fun!
     *
     * @Input: n/a
     * @Output: n/a
     *
     * @Parameters:
     * <br>int arr[]; array of integers to be sorted
     * @Return: n/a (array is sorted directly because java)
     *
     * @CalledBy: getStats();
     * @Calls: m/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
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
    }//sort

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: loadStats
     * @Title: loadStats!
     *
     * @Description: Loads a text file of stats into an Arraylist to be used
     *
     * @Input: text file
     * @Output: n/a
     *
     * @Parameters:
     * <br>boolean remove; game mode
     * <br>String name; player's name
     * @Return: data; ready for formatting or null if no data to be found
     *
     * @CalledBy: getStats(); getLogs;
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static private ArrayList<String> loadStats(boolean remove, String name)
    {
        //determines directory of file based on player name
        String fileName = "src//Data//" + name + "//Stats";

        //determines which file to open based on game mode
        if (remove)
        {
            fileName += "wRemove";
        }
        try
        {
            //Prepares the file for reading
            FileReader freader = new FileReader(fileName + ".txt");
            BufferedReader inputFile = new BufferedReader(freader);

            // Read the first name from the file.
            String inputLines = inputFile.readLine();
            ArrayList<String> data = new ArrayList<String>();

            while (inputLines != null)
            {
                //reads each line and saves it in the data ArrayList
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
    }//load

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: clear
     * @Title: file clear
     *
     * @Description: empties a text file of all data
     *
     * @Input: text file
     * @Output: empty text file
     *
     * @Parameters:
     * <br>boolean remove; game mode
     * <br>String name; player's name
     * @Return: n/a
     *
     * @CalledBy: clearStats menu item
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public void clear(boolean remove, String name)
    {
        //determines directory of file based on player name
        String fileName = "src//Data//" + name + "//Stats";

        //determines file based on game mode
        if (remove)
        {
            fileName += "wRemove";
        }
        try
        {
            //Prepares a file for writing
            File file = new File(fileName + ".txt");
            //lack of boolean creates an overwrite
            FileWriter writer = new FileWriter(file);
            //closes without new data, overwriting original file
            writer.close();

        } catch (FileNotFoundException exp) // catch file not found
        {
            exp.printStackTrace();
        } catch (IOException exp) // catch writing error
        {
            exp.printStackTrace();
        }
    }//Clear

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: log
     * @Title: log reader
     *
     * @Description: takes the loaded log and formats them for display or
     * printing
     *
     * @Input: text file
     * @Output: n/a
     *
     * @Parameters:
     * <br>boolean remove; game mode
     * <br>String name; player's name
     * @Return: output; a stringbuffer for easy display
     *
     * @CalledBy: Player(), menuLog
     * @Calls: loadStats
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public StringBuffer log(boolean remove, String name)
    {
        //data storage
        StringBuffer output = new StringBuffer();
        ArrayList<String> data = loadStats(remove, name);

        //verifies data was present
        if (!data.isEmpty())
        {
            //determines number of games played
            int counter = 0;
            //passes the data into a formatted string
            for (String val : data)
            {
                counter++;
                output.append("Run number " + counter + " was: " + val + "\n");
            }
            output.append("Total Games Played: " + counter);
        } else
        {
            //default message if data was not present
            output.append("No log saved. Please run then save.");
        }

        return output;
    }//log

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: savePlayer
     * @Title: savePlayer
     *
     * @Description: Saves a new player into the file structure
     *
     * @Input: n/a
     * @Output: directory and text files
     *
     * @Parameters:
     * <br>String playerName; player's name
     * @Return: true if new diretory created, otherwise false
     *
     * @CalledBy: InsertPlayerGUI
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public boolean savePlayer(String playerName)
    {
        try
        {
            //Verifies the file is valid
            //Prepares a file for writing
            File file;
            FileWriter writer;

            //checks if a new directory was required, of if directory already existed
            file = new File("src//Data//" + playerName + "//");
            boolean successful = file.mkdir();
            
            //If new directory was required, then player did not already exist
            if (successful)
            {
                // creating the directory succeeded
                //adds new player to Players.txt
                file = new File("src//Data//Players.txt");
                writer = new FileWriter(file, true);
                writer.write(playerName + "\n");
                writer.close();
                
                //creates new game stst files in directory
                clear(false, playerName);
                clear(true, playerName);
                return true;
            } else
            {
                // creating the directory failed
                JOptionPane.showMessageDialog(null, "Player Already Exists", "Directory Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException exp) // catch file not found
        {
            exp.printStackTrace();
        } catch (IOException exp) // catch writing error
        {
            exp.printStackTrace();
        } catch (IllegalStateException exp)// catch empy text field
        {
            JOptionPane.showMessageDialog(null, "Please enter a first AND last name.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }//end savePlayer

            /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * @Class: DataManager
     * @File: DataManager.java
     *
     * @author: Kevin Manning
     *
     * @Function: loadPlayers
     * @Title: loadPlayers
     *
     * @Description: Loads all player names
     * 
     * @Input: text file
     * @Output: n/a
     *
     * @Parameters: n/a
     * @Return: players; string array of all player names
     *
     * @CalledBy: Players()
     * @Calls: n/a
     *
     * @Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
     * @Date: 3/7/2016
     * @version 1.0
     * @HistoryLog: 3/7/16 - Built function and called methods
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public String[] loadPlayers()
    {
        //source file
        String fileName = "src//Data//Players.txt";
        try
        {

            FileReader freader = new FileReader(fileName);
            BufferedReader inputFile = new BufferedReader(freader);

            // Read the first name from the file.
            String inputLines = inputFile.readLine();
            ArrayList<String> data = new ArrayList<String>();

            while (inputLines != null)
            {
                data.add(inputLines);
                inputLines = inputFile.readLine();
            }
            if (data.size() > 0)
            {
                String players[] = new String[data.size()];
                int i = 0;
                for (String val : data)
                {
                    players[i] = val;
                    i++;
                }
                freader.close();
                return players;
            } else
            {
                JOptionPane.showMessageDialog(null, "Players' List Empty.\nPlease add player.", "Data Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (FileNotFoundException exp) // catch file not found
        {
            exp.printStackTrace();
        } catch (IOException exp) // catch reading error
        {
            exp.printStackTrace();
        }
        return null;
    }//end player load

}

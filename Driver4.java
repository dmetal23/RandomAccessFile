/*
Programmer: Daniel Rojas
Project #4: RandomAccessFile - Driver 
Class: COMP 282, MoWe 9:30
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver4 {

    public static void parseCommand(String command) {
        String commands[] = command.split(" ");
        if (commands[0].equals("insert") && commands.length == 3) {

            Item i = new Item(new BigInteger(commands[1]), new BigInteger(commands[2]));
            i.insert();
            //System.out.println("insert command execute");
        } else if (commands[0].equals("find") && commands.length == 2) {
            //System.out.println("find command executr");
             Item.find(new BigInteger(commands[1]));
        }
          else if (commands[0].equals("quit") && commands.length == 1) {
            System.out.println("Bye");
           
            try {
                Item.file.close();
            } catch (IOException ex) {
                Logger.getLogger(Driver4.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        else {
            System.out.println("Invalid command");
        }

    }

    public static void main(String[] arg) {
        System.out.print("Welcome to Hasher - ");
        Item.loadFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        do {
            System.out.println("\nCommand");
            System.out.print(">");
            try {
                command = br.readLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            parseCommand(command);

        } while (!command.equals("quit"));

       
    }
}

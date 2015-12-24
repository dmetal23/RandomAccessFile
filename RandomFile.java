/*
Programmer: Daniel Rojas
Project #4: RandomAccessFile - Hasher
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

class Item {

    private BigInteger key;
    private BigInteger value;
    static RandomAccessFile file;

    public Item(BigInteger key, BigInteger value) {
        this.key = key;
        this.value = value;

    }

    public Item() {
    }

    public void insert() {
        try {
            int hash = key.mod(new BigInteger(((int) Math.pow(2.0, 30.0)) + "")).intValue();
            long pos = hash * 4096;
            file.seek(pos);

            System.out.print("Placing in page " + hash + ". ");
            String rv = file.readLine();
          
            if (rv == null) {
                System.out.print("No other items in this page.");
                file.seek(pos);
                file.writeChars("0");
            } else {
                // System.out.print("else execute...");
                int cnt = 0;
                while (file.readLine() != null) {
                    cnt++;
                }
                switch (cnt) {
                    case 1:
                        System.out.print("One other item in this page");
                        break;
                    case 2:
                        System.out.print("Two other items in this page");
                        break;
                    case 3:
                        System.out.print("Three other items in this page");
                        break;
                    case 4:
                        System.out.print("Page is full...");
                        return;

                }

            }
            String val = "\n" + key.toString(10) + "," + value.toString(10);
          
            file.writeChars(val);
           
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public static void find(BigInteger key) {
        try {
            int hash = key.mod(new BigInteger(((int) Math.pow(2.0, 30.0)) + "")).intValue();
            long pos = hash * 4096;
            file.seek(pos);

            String rv = file.readLine();
           System.out.print(key.toString(10)+":");
            if (rv == null) {
                System.out.print("No such items");
               
            } else {
              
                int cnt = 0;
                String val=null;
                String output="";
                while ((val=file.readLine()) != null) {
                    cnt++;
                    output+=val.split(",")[1]+"  ";
                    
                }
               System.out.print(output);

            }
        
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void loadFile() {
        try {
            file = new RandomAccessFile("info.dat", "rw");
            file.setLength(((int) Math.pow(2.0, 30.0)) * 4096);
            System.out.println("found file info.dat");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

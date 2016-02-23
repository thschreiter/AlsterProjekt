/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwarsbobafettbountyhunter505;

import frameapi.FrameAPI;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marvin.mohr
 */
public class StarWarsBobaFettBountyHunter505 
{

    /**
     * @param args the command line arguments
     */
    public static void Ausgabe  ( String[][] Spielfeld)
    {
        
        for(int i=0; i<Spielfeld.length; i++)
        {
            for(int j=0; j<Spielfeld.length; j++)
            {
                System.out.print(Spielfeld[i][j] + " ");
            }
            System.out.println();
        } 
    }
    
    
    public static void BewegeHasen (String [][] Spielfeld)
    {
        String[][] Speicher = new String[14][14];
        for(int i=0; i<Spielfeld.length; i++)    
        {
            for(int j=0; j<Spielfeld.length; j++)
            {
                Speicher[i][j] = Spielfeld[i][j];
            }          
        }
 
        for(int i=0; i<Spielfeld.length; i++)    
        {
            for(int j=0; j<Spielfeld.length; j++)
            {
                if(Speicher[i][j].equals("H"))
                {
                    Spielfeld[i][j] = ",";
                    Spielfeld[i][j+1] = "H";
                }
            }
        }    
    
    }
    
    public static void main(String[] args) 
    {
        //int[][] meinArray = new int[10][10]
        //for(int i=0; i<meinArray.length; i++)
        //{
            //for(int j=0; j<meinArray[i].length; j++)
            //{
                //meinArray[i][j]= (i+j);
                //System.out.print(meinArray[i][j] + " ");
            //}
            //System.out.println();
        //}
      
                
      /*  System.out.println("Spielfeld anzeigen?");
        
        Scanner sc = new Scanner(System.in);
        String Eingabe = sc.next();*/
        boolean finished = false;
      
                
        String[][] Spielfeld= new String[14][14];
        for(int i=0; i<Spielfeld.length; i++)
        {
            for(int j=0; j<Spielfeld.length; j++)
            {  
                Spielfeld[i][j] = ",";
                //System.out.print(Spielfeld[i][j] + " ");
            }
           
            //System.out.println();
        }
        
        //Hasen
        for(int i=0; i<40; i++)
        {
            //Würfel x //Würfel y
            int x = (int) (Math.random()*10 + 0);
            int y = (int) (Math.random()*10 + 0);
            Spielfeld[x][y] = "H";
        }
       
        //Füchse
        for(int i=0; i<10; i++)
        {
            //Würfel x //Würfel y
            int x = (int) (Math.random()*14 + 0);
            int y = (int) (Math.random()*14 + 0);
            Spielfeld[x][y] = "F";
        }
           
        FrameAPI.initFrame();
        FrameAPI.initString(Spielfeld.length, Spielfeld);
        FrameAPI.setPlayground();
        
        do 
        {
            if(FrameAPI.newRound)
            {
                BewegeHasen(Spielfeld);
                FrameAPI.initString(Spielfeld.length, Spielfeld);
                FrameAPI.setPlayground();
            }
        } 
        while(!FrameAPI.allDead);
        
        Ausgabe(Spielfeld);
           
        Scanner sc = new Scanner(System.in);
        String Eingabe = sc.next();    
        Eingabe = sc.next();
        if(Eingabe.equals("Ja"))
        finished = true;

           
    }
}    

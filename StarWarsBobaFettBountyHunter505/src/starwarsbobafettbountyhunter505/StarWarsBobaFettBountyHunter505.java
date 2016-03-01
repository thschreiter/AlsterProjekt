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
                if(Speicher[i][j].equals("F"))
                {
                    Spielfeld[i][j] = ",";
                    Spielfeld[i][(j+1)%14] = "F";
                }
                /*if(Spielfeld[i][13].equals("F"))
                {
                       Spielfeld[i][j] = ",";
                       Spielfeld[i][0] = "F";
                } */   
                
               
                if(Speicher[i][j].equals("H"))
                {
                    Spielfeld[i][j] = ",";
                    int zufall = (int)(Math.random()*8);
                    System.out.println(zufall);
                    switch (zufall){
                    
                        case 0: Spielfeld[i][j]= "H"; break;
                        
                        case 1: Spielfeld[i][j]= ",";
                                Spielfeld[(i+1)%14][j]= "H"; break;
                        
                        case 2:  if(i>0)
                        {
                            Spielfeld[i][j]= ",";
                            Spielfeld[i-1][j]= "H"; 
                        }
                        else
                        {
                            Spielfeld[i][j]= ",";
                            Spielfeld[13][j]= "H";
                        }
                        break;
                                 
                        case 3:  Spielfeld[i][j]= ",";
                                 Spielfeld[i][(j+1)%14]= "H"; break;
                                          
                        case 4:  Spielfeld[i][j]= ",";
                                 Spielfeld[i][j-1]= "H"; break;
                            
                        case 5:  Spielfeld[i][j]= ",";
                                 Spielfeld[(i+1)%14][(j+1)%14]= "H"; break;
                        
                        case 6:  Spielfeld[i][j]= ",";
                                 Spielfeld[(i+1)%14][j-1]= "H"; break;
                        
                        case 7:  Spielfeld[i][j]= ",";
                                 Spielfeld[i-1][(j+1)%14]= "H"; break;
                                 
                        case 8:  Spielfeld[i][j]= ",";
                                 Spielfeld[i-1][j-1]= "H"; break;
                                          
                          
                        default: break;
                    }
                    
                }
                if(Spielfeld[i][13].equals("H"))
                {
                    Spielfeld[i][j] = ",";
                    Spielfeld[i][0] = "H"; 
                }    
                
            }
        }
    }
    
    
    public static void main(String[] args) 
    {
       
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
        for(int i=0; i<30; i++)
        {
            //Würfel x //Würfel y
            int x = (int) (Math.random()*14 + 0);
            int y = (int) (Math.random()*14 + 0);
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

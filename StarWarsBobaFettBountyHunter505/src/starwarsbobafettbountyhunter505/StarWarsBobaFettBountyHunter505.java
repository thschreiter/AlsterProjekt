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
public class StarWarsBobaFettBountyHunter505 {

    /**
     * @param args the command line arguments
     */
    public static void Ausgabe(String[][] Spielfeld) {

        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                System.out.print(Spielfeld[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void BewegeHasen(String[][] Spielfeld) {
        String[][] Speicher = new String[14][14];
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }

        //Hasenbewegung!
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                if (Speicher[i][j].equals("H")) {
                    //Spielfeld[i][j] = ",";
                    int zufall = (int) (Math.random() * 8);
                    System.out.println(zufall);
                    switch (zufall) {

                        case 0:
                            Spielfeld[i][j] = "H";
                            break;

                        case 1:
                            if (Spielfeld[(i + 1) % 14][j].equals(",")) {
                                Spielfeld[i][j] = ",";
                                Spielfeld[(i + 1) % 14][j] = "H";
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 2:
                            int Index1 = i - 1;
                            if (Index1 < 0) {
                                Index1 = 13;
                            }
                            if (Spielfeld[Index1][j].equals(",")) {
                                if (i > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[Index1][j] = "H";
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[13][j] = "H";
                                }
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 3:
                            if (Spielfeld[i][(j + 1) % 14].equals(",")) {
                                Spielfeld[i][j] = ",";
                                Spielfeld[i][(j + 1) % 14] = "H";
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 4:
                            int Index2 = j - 1;
                            if (Index2 < 0) {
                                Index2 = 13;
                            }
                            if (Spielfeld[i][Index2].equals(",")) {
                                if (j > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][Index2] = "H";
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][13] = "H";
                                }
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 5:
                            if (Spielfeld[(i + 1) % 14][(j + 1) % 14].equals(",")) {
                                Spielfeld[i][j] = ",";
                                Spielfeld[(i + 1) % 14][(j + 1) % 14] = "H";
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 6:
                            Index2 = j - 1;
                            if (Index2 < 0) {
                                Index2 = 13;
                            }
                            if (Spielfeld[(i + 1) % 14][Index2].equals(",")) {
                                if (j > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[(i + 1) % 14][Index2] = "H";
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][13] = "H";
                                }
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 7:

                            Index1 = i - 1;
                            if (Index1 < 0) {
                                Index1 = 13;
                            }
                            if (Spielfeld[Index1][(j + 1) % 14].equals(",")) {
                                if (i > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[Index1][(j + 1) % 14] = "H";
                                    break;
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[13][j] = "H";
                                }
                            } else {
                                Spielfeld[i][j] = "H";
                            }
                            break;

                        case 8:
                            Index1 = i - 1;
                            if (Index1 < 0) {
                                Index1 = 13;
                            }
                            Index2 = j - 1;
                            if (Index2 < 0) {
                                Index2 = 13;
                            }
                            if (Spielfeld[Index1][Index2].equals(",")) {
                                if (i > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[Index1][Index2] = "H";
                                    break;
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[13][j] = "H";
                                }
                                if (j > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i - 1][j - 1] = "H";
                                    break;
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][13] = "H";
                                }
                            } else {
                                Spielfeld[i][j] = "H";
                            }

                        default:
                            break;
                    }

                }

            }
        }

        //Fuchsbewegung! 
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                if (Speicher[i][j].equals("F")) {
                    //Spielfeld[i][j] = ",";
                    int zufall = (int) (Math.random() * 8);
                    System.out.println(zufall);
                    switch (zufall) {

                        case 0:
                            Spielfeld[i][j] = "F";
                            break;

                        case 1:
                            if (Spielfeld[(i + 1) % 14][j].equals(",")) {
                                Spielfeld[i][j] = ",";
                                Spielfeld[(i + 1) % 14][j] = "F";
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 2:
                            int Index1 = i - 1;
                            if (Index1 < 0) {
                                Index1 = 13;
                            }
                            if (Spielfeld[Index1][j].equals(",")) {
                                if (i > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[Index1][j] = "F";
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[13][j] = "F";
                                }
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 3:
                            if (Spielfeld[i][(j + 1) % 14].equals(",")) {
                                Spielfeld[i][j] = ",";
                                Spielfeld[i][(j + 1) % 14] = "F";
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 4:
                            int Index2 = j - 1;
                            if (Index2 < 0) {
                                Index2 = 13;
                            }
                            if (Spielfeld[i][Index2].equals(",")) {
                                if (j > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][Index2] = "F";
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][13] = "F";
                                }
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 5:
                            if (Spielfeld[(i + 1) % 14][(j + 1) % 14].equals(",")) {
                                Spielfeld[i][j] = ",";
                                Spielfeld[(i + 1) % 14][(j + 1) % 14] = "F";
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 6:
                            Index2 = j - 1;
                            if (Index2 < 0) {
                                Index2 = 13;
                            }
                            if (Spielfeld[(i + 1) % 14][Index2].equals(",")) {
                                if (j > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[(i + 1) % 14][Index2] = "F";
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][13] = "F";
                                }
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 7:

                            Index1 = i - 1;
                            if (Index1 < 0) {
                                Index1 = 13;
                            }
                            if (Spielfeld[Index1][(j + 1) % 14].equals(",")) {
                                if (i > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[Index1][(j + 1) % 14] = "F";
                                    break;
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[13][j] = "F";
                                }
                            } else {
                                Spielfeld[i][j] = "F";
                            }
                            break;

                        case 8:
                            Index1 = i - 1;
                            if (Index1 < 0) {
                                Index1 = 13;
                            }
                            Index2 = j - 1;
                            if (Index2 < 0) {
                                Index2 = 13;
                            }
                            if (Spielfeld[Index1][Index2].equals(",")) {
                                if (i > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[Index1][Index2] = "F";
                                    break;
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[13][j] = "F";
                                }
                                if (j > 0) {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i - 1][j - 1] = "F";
                                    break;
                                } else {
                                    Spielfeld[i][j] = ",";
                                    Spielfeld[i][13] = "F";
                                }
                            } else {
                                Spielfeld[i][j] = "F";
                            }

                        default:
                            break;
                    }

                }

            }
        
    
        }
    }

    public static void main(String[] args) {

        boolean finished = false;

        String[][] Spielfeld = new String[14][14];
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                Spielfeld[i][j] = ",";
                //System.out.print(Spielfeld[i][j] + " ");
            }
 
            //System.out.println();
        }

        //Hasen
        for (int i = 0; i < 16; i++) {
            //Würfel x //Würfel y
            int x = (int) (Math.random() * 14 + 0);
            int y = (int) (Math.random() * 14 + 0);
            Spielfeld[x][y] = "H";
        }

        //Füchse
        for (int i = 0; i < 8; i++) {
            //Würfel x //Würfel y
            int x = (int) (Math.random() * 14 + 0);
            int y = (int) (Math.random() * 14 + 0);
            Spielfeld[x][y] = "F";
        }

        FrameAPI.initFrame();
        FrameAPI.initString(Spielfeld.length, Spielfeld);
        FrameAPI.setPlayground();

        do {
            if (FrameAPI.newRound) {
                BewegeHasen(Spielfeld);
                FrameAPI.initString(Spielfeld.length, Spielfeld);
                FrameAPI.setPlayground();
            }
        } while (!FrameAPI.allDead);

        Ausgabe(Spielfeld);

        Scanner sc = new Scanner(System.in);
        String Eingabe = sc.next();
        Eingabe = sc.next();
        if (Eingabe.equals("Ja")) {
            finished = true;
        }

    }
}

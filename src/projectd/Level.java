/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectd;

import Enum.Direction;
import Karakters.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author win 7
 */
public class Level extends JPanel{
    private int x;
    private Scanner map;
    Vak[][] vakken = new Vak[25][25];
    private Speler speler;
    Direction dir;
    private static int niveau=1;
    private GameObject vriend,bazooka,cheater,helper;

    public Level() {
        addKeyListener(new input()); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        laadFile(Level.niveau);
        creerLevel();
    }

    private void laadFile(int level) {
        if(niveau==1){
        try {
            map = new Scanner(new File("src/Mapjes/level.txt"));
             } catch (FileNotFoundException e) {
            System.out.println("Geen map gevonden " + e);
            }
        }
        else if(niveau==2){
        try {
            map = new Scanner(new File("src/Mapjes/level2.txt"));
             } catch (FileNotFoundException e) {
            System.out.println("Geen map gevonden " + e);
            }
        }
        else if(niveau==3){
        try {
            map = new Scanner(new File("src/Mapjes/level3.txt"));
             } catch (FileNotFoundException e) {
            System.out.println("Geen map gevonden " + e);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 25; y++) {
                vakken[x][y].drawObject(g);
            }
        }
    }

    private void creerLevel() {
        x = 0;
        while (map.hasNext()) {
            for (int y = 0; y < 25; y++) {
                vakken[x][y] = new Vak((x * 20) , (y * 20));
                switch (map.next()) {
                    case "M":
                        GameObject m = new Muur(vakken[x][y]);
                        vakken[x][y].setObject(m);
                        break;
                    case "S":
                        speler = new Speler(vakken[x][y]);
                        vakken[x][y].setObject(speler);
                        break;
                    case "V" : 
                        vriend = new Vriend(vakken[x][y]);
                        vakken[x][y].setObject(vriend);
                        break;
                    case "B" : 
                        bazooka = new Bazooka(vakken[x][y]);
                        vakken[x][y].setObject(bazooka);
                        break;
                    case "H":    
                        helper  = new Helper(vakken[x][y]);
                        vakken[x][y].setObject(helper);
                        break;
                    case "C":
                        cheater = new Cheater(vakken[x][y]);
                        vakken[x][y].setObject(cheater);
                        break;
                    
                         
                }
            }
            x++;
        }
        
        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 25; y++) {
                if (x > 0) {
                    vakken[x][y].setBuur(Direction.WEST, vakken[x - 1][y]);
                }
                if (y > 0) {
                    vakken[x][y].setBuur(Direction.NORTH, vakken[x][y - 1]);
                }
                if (x < 25 - 1) {
                    vakken[x][y].setBuur(Direction.EAST, vakken[x + 1][y]);
                }
                if (y < 25 - 1) {
                    vakken[x][y].setBuur(Direction.SOUTH, vakken[x][y + 1]);
                }
            }
        }
    }
    
    
    public void voerActieUit(){
        if(speler.checkCollision(speler).equals(vriend)){
            if(Level.niveau !=3){
                laadFile(Level.niveau++);
                creerLevel();
            }
            else{
                System.out.println("GEFELICITEERD");
            }
        }
       // else if(speler.checkCollision(speler, bazooka)){
       //     System.out.println("Bazooka opgepakt");  
       // }
       // else if(speler.checkCollision(speler, helper)){
       //     System.out.println(" aantal stappen - waardecheater");
       // }
       // else if (speler.checkCollision(speler, cheater)){
         //   System.out.println("kortste route");
       // }
    }
    
   
    public void restart(){
        laadFile(Level.niveau);
        creerLevel();
        
    }
    
    
    
    public class input implements KeyListener{
        

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_UP:        speler.loop(Direction.NORTH);
                                            dir=Direction.NORTH;
                                            voerActieUit();
                                            
                                            break;
                case KeyEvent.VK_DOWN:      speler.loop(Direction.SOUTH);
                                            dir=Direction.SOUTH;
                                            voerActieUit();
                                            break;
                case KeyEvent.VK_LEFT:      speler.loop(Direction.WEST);
                                            dir=Direction.WEST;
                                            voerActieUit();
                                            break;
                case KeyEvent.VK_RIGHT:     speler.loop(Direction.EAST);
                                            dir=Direction.EAST;
                                            voerActieUit();
                                            break;
                case KeyEvent.VK_R:         restart();
                    
            
            }
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    
    }

}

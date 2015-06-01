/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectd;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Mustafa
 */
public class Game extends JFrame{
    private final int width=600;
    private final int height=600;

    public static int niveau=1;
    
    public Game(){
        
        this.setLayout(new BorderLayout());
        this.setSize(width, height);
        this.setTitle("Project D Blok");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        start();
        
        
    }
    public void start()
    {
        Level level= new Level();
        level.setSize(600, 600);
        add(level, BorderLayout.CENTER);
        this.repaint();
    }
    
}

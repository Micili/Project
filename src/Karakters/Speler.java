/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Karakters;

import Enum.Direction;
import javax.swing.ImageIcon;
import projectd.Level;
import projectd.Vak;

/**
 *
 * @author Mustafa
 */
public class Speler extends GameObject{
    Level level;
    public Speler(Vak vak) {
        super(vak);
        imgIc = new ImageIcon("src/GameImage/speler.png");
        img = imgIc.getImage();
    }
    public void loop(Direction dir) {
        Vak buur = vak.getBuur(dir);
        if (!checkCollisionWall(dir)) { 
            buur.setObject(this);
            this.vak = buur;
        }
        
    }
    public GameObject checkCollision(Speler speler){
        return speler.getVak().getObject(); //equals(go.getVak());
    }
    public boolean checkCollisionWall(Direction dir){
        Vak buur = vak.getBuur(dir);
        GameObject go = buur.getObject();
        if(go instanceof Muur)
        {
            return true;
        }
        return false;
    }
    
    
} 
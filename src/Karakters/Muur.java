/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Karakters;

import Karakters.GameObject;
import javax.swing.ImageIcon;
import projectd.Vak;

/**
 *
 * @author win 7
 */
public class Muur extends GameObject{
    
    public Muur(Vak vak) {
        super(vak);
        imgIc = new ImageIcon("src/GameImage/wall.png");
        img = imgIc.getImage();
    }
}

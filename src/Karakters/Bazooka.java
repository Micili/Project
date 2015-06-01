/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Karakters;

import javax.swing.ImageIcon;
import projectd.Vak;

/**
 *
 * @author Mustafa
 */
public class Bazooka extends GameObject{

    public Bazooka(Vak vak) {
        super(vak);
        imgIc = new ImageIcon("src/GameImage/bazooka.png");
        img = imgIc.getImage();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Karakters;

import javax.swing.ImageIcon;
import projectd.Vak;

/**
 *
 * @author Mustafa
 */
public class Helper extends GameObject{
    
    public Helper(Vak vak){
       super(vak);
       imgIc = new ImageIcon("src/GameImage/helper.png");
       img = imgIc.getImage();
    }
    
}

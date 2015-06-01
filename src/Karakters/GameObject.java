/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Karakters;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import projectd.Vak;

/**
 *
 * @author Mustafa
 */
public abstract class GameObject extends JComponent{
    
    protected ImageIcon imgIc;
    protected Image img;
    protected Vak vak;
    
    public GameObject(Vak vak){
        this.vak = vak;
    }
    
    public void drawObject(Graphics g) {
        g.drawImage(this.img, vak.getXpos(),vak.getYpos(), null);
    }

    public Vak getVak() {
        return vak;
    }

    public void setVak(Vak vak) {
        this.vak = vak;
    }
    
}

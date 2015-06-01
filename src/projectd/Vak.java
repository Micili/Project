/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectd;

import Karakters.GameObject;
import Enum.Direction;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Mustafa
 */
public class Vak extends JComponent{
    
    protected ImageIcon imgIc = new ImageIcon("src/GameImage/background.png");
    protected Image img = imgIc.getImage();
    private int ypos;
    private int xpos;
    private HashMap<Direction, Vak> buurvakjes;
    private GameObject go;

    public Vak(int xpos, int ypos) {
        buurvakjes = new HashMap<>();
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public Vak getBuur(Direction dir) {
        return buurvakjes.get(dir);
    }

    public void setBuur(Direction dir, Vak buur) {
        buurvakjes.put(dir, buur);
    }

    public void setObject(GameObject g) {
        this.go = g;
    }
    
    public GameObject getObject(){
        return go;
    }

    public void drawObject(Graphics g) {
        g.drawImage(img, xpos, ypos, null);
        if (go != null) {
            go.drawObject(g);
        }
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
    
}
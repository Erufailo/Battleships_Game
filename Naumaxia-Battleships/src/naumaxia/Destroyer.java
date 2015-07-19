/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naumaxia;

import javax.swing.*;

public class Destroyer extends JButton {

    private int posx, posy, length;
    private boolean orientation, visible;

    public Destroyer(int posx, int posy, boolean orientation, boolean visible) {
        this.posx = posx;
        this.posy = posy;
        this.orientation = orientation;
        this.visible = visible;
        this.length = 3;





    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isOrientation() {
        return orientation;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }
    
}

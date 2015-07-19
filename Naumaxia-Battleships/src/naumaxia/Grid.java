/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naumaxia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Grid extends JPanel {

    //private boolean listener;
    private int rows;
    private int cols;
    private Color backgroundColor;
    private Color lineColor;
    private JPanel[][] innerCells;
    //private boolean occupied;
    private int hitCounter;//new

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.backgroundColor = Color.CYAN;
        this.lineColor = Color.BLACK;
        innerCells = new JPanel[rows][cols];

        this.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                innerCells[i][j] = new JPanel();
                innerCells[i][j].setLayout(new BorderLayout());
                innerCells[i][j].setBorder(BorderFactory.createLineBorder(lineColor));
                innerCells[i][j].setBackground(backgroundColor);
                innerCells[i][j].setEnabled(false); //an exei ploio
                innerCells[i][j].setRequestFocusEnabled(false); //an exei ksanaxtipithei
                this.add(innerCells[i][j]);
            }
        }
    }

    public int getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(int hitCounter) {
        this.hitCounter = hitCounter;
    }
    
    
    

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public JPanel[][] getInnerCells() {
        return innerCells;
    }

    public void setInnerCells(JPanel[][] innerCells) {
        this.innerCells = innerCells;
    }

    public void cellColor(int x, int y, Color clr) {
        this.innerCells[x][y].setBackground(clr);
    }

    public void hit(int x, int y) {
        Random rand = new Random();

        if (this.innerCells[x][y].getBackground() == Color.RED || this.innerCells[x][y].getBackground() == Color.WHITE) {
            hit(rand.nextInt(10), rand.nextInt(10));
        }
        if (this.innerCells[x][y].getBackground() == Color.GRAY) {
            this.innerCells[x][y].setBackground(Color.RED);
            hitCounter++;
            if (hitCounter >= 17) { //new
                JOptionPane.showMessageDialog(null, "nikitis einai o CPU");

            }
            this.innerCells[x][y].setRequestFocusEnabled(true);
        }
        if (this.innerCells[x][y].getBackground() == Color.CYAN) {
            this.innerCells[x][y].setBackground(Color.WHITE);
            this.innerCells[x][y].setRequestFocusEnabled(true);
        }
    }
}

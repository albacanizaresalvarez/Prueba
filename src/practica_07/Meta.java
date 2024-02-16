/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_07;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author albit
 */
public class Meta {
    
    private static final int X = 650;
    private static final int Y = 100;
    private static final int WITH = 10;
    private static final int HEIGHT = 300;
    int xa = 0;
    Panel panel;

    
    public Meta( Panel panel) {
        this.panel = panel;
    }
    

    
    public void paint(Graphics2D g) {
	g.fillRect(X, Y, WITH, HEIGHT);
    }
    
    public Rectangle getBounds() {
		return new Rectangle(X, Y, WITH, HEIGHT);
	}
    
}

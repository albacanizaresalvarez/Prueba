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
public class Corredor extends Thread{
    
    private static boolean finalCarrera = false;
    private static String ganador = "";
    private String nombre = "";

    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int vx = 5;
    private Panel panel;
    int i = 0;
    
    public Corredor(Panel panel, int x, int y) {
        this.panel= panel;
        this.x = x;
        this.y = y;
        nombre = "CARACOL NÚMERO " + (i+1);
    }
    
    void move() {
	if (x + vx < 0)
            vx = 1;
	if (collision()){
            finalCarrera = true;
            panel.gameOver();
	}
	x = x + vx;
	
    }

    public static void iniciarCarrrera() {
        finalCarrera = false;
    }

    public static boolean haTerminado() {
        return finalCarrera;
    }

    public static String getGanagor() {
        return ganador;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    private boolean collision() {
        return panel.meta.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }
    
    @Override
   public void run() {
      while (!finalCarrera) {
          move();
          panel.repaint();
         try {
            Thread.sleep((int)(Math.random() * 200));
         } catch (InterruptedException e) {
            System.err.println(e);
         }
      }
      
   }

   
   
    
}

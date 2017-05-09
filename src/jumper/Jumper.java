/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.*;
import javax.swing.Timer;


public class Jumper extends JFrame{

    public Jumper(){
        add(new Newpanel());
    }
    
    public static void main(String[] args) {
        Jumper game= new Jumper();
        game.setTitle("JUMPER");
        game.setSize(1000, 700);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}    
    class Newpanel extends JPanel implements ActionListener{
        
        private Timer time;
        private int x;
        private int y;
        private int i;
        private int j;
        private int secuencia;
        
        public Newpanel(){
            this.x=0;
            this.y=0;
            this.i=0;
            this.j=0;
            this.time=new Timer(50,this);  
            this.time.start();
            addKeyListener(new TAdapter());
            setFocusable(true);
        
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Image background=loadImage("blue_background.png");
            Image monster=loadImage("enemy_standing.png");
            Image cloudes=loadImage("clouds.png");
            Image ground1=loadImage("ground_loop.png");
            Image ground2=loadImage("ground_single.png");
            Image stone=loadImage("stone.png");
            Image jumper= loadImage("walking.png");
            
            //g.drawImage(monster, 100, 200, null);
            for (int k = 0; k < 46; k++) {
                g.drawImage(background, 0, 0,k*22,800, null);
                
            }
            for (int k = 0; k < 3; k++) {
                g.drawImage(cloudes, k*335, 200, null);
                g.drawImage(cloudes,-100+ k*400,150,400,92, null);
                
            }
            for (int k = 0; k < 5; k++) {
                g.drawImage(ground1,k*200,600,200,90,null);
                
            }
            g.drawImage(ground2,800,300,200,90,null);
            g.drawImage(stone,200,460,60,60,null);
            g.drawImage(stone,260,460,60,60,null);
            
            //g.drawImage(jumper,100,450,115,134,456,545,null);
            //g.drawImage(jumper, x, 80, x+80, 20, (115*this.secuencia), 134, 115+(115*this.secuencia), 0, this);
            
            g.drawImage(jumper,50+x,540,120+x,600, (115*this.secuencia) , 0, 115+(115*this.secuencia), 134, this);
            
            
            
           
               
        
        
        }
        
        
        
        private class TAdapter extends KeyAdapter{
            @Override
            public void keyReleased(KeyEvent e){
                System.out.println("RELASED");
                
                
                
            }
            @Override
            public void keyPressed(KeyEvent e){
                System.out.println("PRESSED");
                int key= e.getKeyCode();
                
                if(key == KeyEvent.VK_SPACE){
                    System.out.println("ESPACIO");
                }
                if(key == KeyEvent.VK_LEFT){
                    x-=10;
                }
            
                if(key == KeyEvent.VK_RIGHT){
                    x+=10;
                }
                if(key == KeyEvent.VK_UP){
                    j+=1;
                }
                if(key == KeyEvent.VK_DOWN){
                    j+=1;
                }
                

            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(this.secuencia==3){
                this.secuencia=0;
            }
            else{
                this.secuencia++;
            }
            x+=10;
            repaint();
        }
        
        public void checkcollision(){
            Rectangle character= this.getBounds();
            Rectangle muro= new Rectangle(600, 240, 201, 161);
            
            if(character.intersects(muro)){
                System.out.println("Collision");
                time.stop();
            }
        }
        
        public Image loadImage(String imageName){
            ImageIcon ii= new ImageIcon(imageName);
            Image image =ii.getImage();
            return image;
        }
}
    

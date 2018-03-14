package day5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Hero {
	 private int x;
	 private int y;
     private int r;
     private int allBlood;
     private int blood;
     private int score;
     private Image heroImg = new ImageIcon("img/hero.png").getImage();
	
     public void paint(Graphics g){
    	  
    	 //paint hero
    	 g.drawImage(heroImg,x-r,y-r,100,100,null);
    	 
    	 //paint all blood
    	 g.setColor(Color.YELLOW);
    	 g.fillRect(20, 20, allBlood, 30);
    	 
    	 //paint blood
    	 g.setColor(Color.red);
    	 g.fillRect(20, 20, blood, 30);
    	 
    	 //show score
    	 g.setFont(new Font("",Font.BOLD,25));
    	 g.drawString("sore: "+score, 1800, 50);
     }
    public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getAllBlood() {
		return allBlood;
	}
	public void setAllBlood(int allBlood) {
		this.allBlood = allBlood;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
     
}

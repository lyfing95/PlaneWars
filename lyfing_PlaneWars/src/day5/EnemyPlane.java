package day5;

import java.awt.Graphics;
import java.awt.Image;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

public class EnemyPlane {
	  private int x;
	     private int y;
	     private int r;
	     private int speed;
	     private int epNum;
	     private Image epImg = null;  //只能声明，不能实例化
	     
	     public void EnemyPlane(){
	    	 epNum = (int)(Math.random()*12)+1;
	    	 String ep = null;  //实例化
	    	 DecimalFormat df = new DecimalFormat("00");  //位数
	    	 ep = df.format(epNum);
	    	 epImg = new ImageIcon("img/ep"+ep+".png").getImage();
	     }
	     
	     public void changeImg(){
	    	 epNum = (int)(Math.random()*15)+1;
	    	 String ep = null;  //实例化
	    	 DecimalFormat df = new DecimalFormat("00");  //位数
	    	 ep = df.format(epNum);
	    	 epImg = new ImageIcon("img/ep"+ep+".png").getImage();
	     }
	     
	     public void paint(Graphics g){
	    	 g.drawImage(epImg, x-r, y-r, null);
	    	 
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
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		public int getEpNum() {
			return epNum;
		}
		public void setEpNum(int epNum) {
			this.epNum = epNum;
		}
}

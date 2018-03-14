package day5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable,MouseMotionListener{
     private int bgx;
     private int bgy;
     
     private Hero hero = new Hero();
     
     private Image bgImg = null;
     
     private Image goImg = new ImageIcon("img/GameOver.jpg").getImage();
     
     private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
     
     private ArrayList<EnemyPlane> eps = new ArrayList<EnemyPlane>();
     private int epNum = 10;
     
     public MyPanel (Dimension dim){
         
    	 bgx = dim.width;
    	 bgy = dim.height;
    	 
    	 //set hero
    	 hero.setR(80);
    	 hero.setX((bgx-hero.getR()*2)/2);
    	 hero.setY(bgy-3*hero.getR());
    	 hero.setAllBlood(250);
    	 hero.setBlood(250);
    	 hero.setScore(0);
    	 
    	 //set enemy planes
    	 for(int i = 0;i<epNum;i++){
    		 EnemyPlane ep = new EnemyPlane();
    		 ep.setX((int)(Math.random()*bgx));
    		 ep.setY((int)(Math.random()*bgy));
    		 ep.setR(25);
    		 ep.setSpeed((int)(Math.random()*4)+1);
    		 eps.add(ep);
    	 }
    	 
    	 //set background
    	 int bgNum = (int)(Math.random()*4)+1;
    	 bgImg = new ImageIcon("img/bg"+bgNum+".jpg").getImage();
 		
    	 this.addMouseMotionListener(this);
     }
     
     public void initBullet(){
    	 Bullet bullet = new Bullet();
    	 bullet.setX(hero.getX());
    	 bullet.setY(hero.getY());
    	 bullet.setR(45);
    	 bullets.add(bullet);
     }
   
     public boolean isHit(EnemyPlane ep,Bullet bullet){         //勾股定理判断子弹射中敌机
    	 if((ep.getX()-bullet.getX())*(ep.getX()-bullet.getX())+
    			 (ep.getY()-bullet.getY())*(ep.getY()-bullet.getY())<=
    			 (ep.getR()+bullet.getR())*(ep.getR()+bullet.getR())){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
     public boolean isHit(Bullet bullet,EnemyPlane ep){         //哪个在前
    	 if((ep.getX()-bullet.getX())*(ep.getX()-bullet.getX())+
    			 (ep.getY()-bullet.getY())*(ep.getY()-bullet.getY())<=
    			 (ep.getR()+bullet.getR())*(ep.getR()+bullet.getR())){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
     public boolean isHit(EnemyPlane ep,Hero hero){         //勾股定理判断我机撞中敌机
    	 if((ep.getX()-hero.getX())*(ep.getX()-hero.getX())+
    			 (ep.getY()-hero.getY())*(ep.getY()-hero.getY())<=
    			 (ep.getR()+hero.getR())*(ep.getR()+hero.getR())){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
     public boolean isHit(Hero hero,EnemyPlane ep){         //哪个在前
    	 if((ep.getX()-hero.getX())*(ep.getX()-hero.getX())+
    			 (ep.getY()-hero.getY())*(ep.getY()-hero.getY())<=
    			 (ep.getR()+hero.getR())*(ep.getR()+hero.getR())){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
     public void paint(Graphics g){
    	 super.paint(g);
    	 
    	 //paint background
    	 g.drawImage(bgImg, 0, 0, bgx,bgy,null);
 		
    	 //paint enemy planes
    	 for(int i = 0;i<eps.size();i++)
    	     eps.get(i).paint(g);
    	 //paint bullets
    	 for(int i = 0;i<bullets.size();i++)
    		 bullets.get(i).paint(g);
    	 
    	 //paint hero
    	 hero.paint(g);
    	 
    	 //paint over
    	 if(hero.getBlood() <=0){
    		 g.drawImage(goImg, 0, 0, bgx, bgy,null);
    	 }
     }
	@Override
	 public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(hero.getBlood()>0){
			hero.setX(e.getX());
			hero.setY(e.getY());
			repaint();
		}
	}
	@Override
	 public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	 public void run() {
		// TODO Auto-generated method stub
		int cnt = 0;
		 
		while(true){
			if(hero.getBlood()>0){
			
				if(cnt % 10 == 0){
					initBullet();
				}
				cnt++;
				
				//for enemy planes:up to down
				for(int i = 0;i<eps.size();i++){
					EnemyPlane ep = eps.get(i);
					if(ep.getY()>=bgy){
						eps.remove(i);
						
						ep.setX((int)(Math.random()*bgx));//随机数
						ep.setY(0-ep.getR());
						ep.setSpeed((int)(Math.random()*3)+1);
						ep.changeImg();
						eps.add(ep);
						
					}else{
						ep.setY(ep.getY()+ep.getSpeed());
					}
					
					
					//敌机与战机相撞
					boolean b = isHit(ep,hero);
					if(b == true){
						eps.remove(i);
						
						ep.setX((int)(Math.random()*bgx));
						ep.setY(0-ep.getR());
						ep.setSpeed((int)(Math.random()*5)+1);
						ep.changeImg();
						eps.add(ep);
						
						hero.setBlood(hero.getBlood()-30);
					}
				}//end eps
				
				//for bullets:down to up
				for(int i =0;i<bullets.size();i++){
					Bullet bullet = bullets.get(i);
					if(bullet.getY() <= 0- bullet.getR()){
						bullets.remove(i);
					}else{
						bullet.setY(bullet.getY() -20);
					}
				//end for bullets
				
				
				for(int j = 0;j<eps.size();j++){
					EnemyPlane ep = eps.get(j);
					boolean b = isHit(bullet,ep);
					
					if(b == true){
						bullets.remove(i);
						eps.remove(j);
						
						ep.setX((int)(Math.random()*bgx));
						ep.setY(0-ep.getR());
						ep.setSpeed((int)(Math.random()*5)+1);
						ep.changeImg();
						eps.add(ep);
						
						hero.setScore(hero.getScore()+50);
					}
				  }
				}
			}//end if
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//end while
	}
}

package day5;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Started extends JFrame {
     public Started(){
    	 JFrame frame = new JFrame("·É»ú´óÕ½");
    	 
    	 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	 
    	 MyPanel panel = new MyPanel(dim);
    	 
    	 Thread thread = new Thread(panel);
    	 thread.start();
    	 
    	 frame.add(panel);
    	 
    	 frame.setSize(dim);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 frame.setVisible(true);
    	 frame.setResizable(false);
     }
}

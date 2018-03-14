package day5;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * 游戏开始界面
 */
public class MyFrame extends JFrame implements ActionListener{
	 private JButton button_start = new JButton("开始游戏");
	 private JButton button_end = new JButton("结束游戏");
public MyFrame(){
	
	JFrame frame = new JFrame("开始界面");
	
	button_start.addActionListener(this);
	button_end.addActionListener(this);
	
	JPanel panel = new JPanel();
	panel.add(button_start);
	panel.add(button_end);
	frame.add(panel);
	
	URL img = MyFrame.class.getResource("001.png");
	ImageIcon i = new ImageIcon(img);
	JLabel d = new JLabel();
	d.setIcon(i);
	panel.add(d);
	
	
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setBounds((dim.width-300)/2,(dim.height-400)/2,300,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == button_start){
		new Started();
	}
	if(e.getSource() == button_end){
		System.exit(0);
	}
	}
}


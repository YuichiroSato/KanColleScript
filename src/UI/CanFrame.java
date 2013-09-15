package UI;

import java.awt.*;
import java.awt.image.*;


import javax.swing.*;

import MainThread.MainThread;


public class CanFrame extends JFrame{

	private final static long serialVersionUID = 1L;
	
	Image buffer;
	BufferedImage img;
	MainThread main_thread;

	Color white = new Color(255,255,255);
	Color black = new Color(0,0,0);

	public CanFrame(MainThread t){
	    this.setSize(150,150);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(null);
	    
	    Button stopb = new Button("stop");
	    stopb.addActionListener(new StopAction(t));
	    stopb.setBounds(1, 1, 30, 20);
	    this.add(stopb);
	    
	    Button startb = new Button("start");
	    startb.addActionListener(new StartAction(t));
	    startb.setBounds(35, 1, 30, 20);
	    this.add(startb);
	    
	    this.setVisible(true);
	    
		img = null;
		buffer = createImage(200, 200);
		main_thread = t;
	}

	public void setImage(BufferedImage g){
		img = g;
	}
		
	public void paint(Graphics g) {
		Graphics bufferg = buffer.getGraphics();
		
		bufferg.setColor(white);
		bufferg.fillRect(0, 0, 200, 200);		
		bufferg.setColor(black);
		bufferg.drawString(""+main_thread.getStateName(),77, 47);
		bufferg.drawString(""+main_thread.getTime(),115, 47);
		if (img == null) {
			bufferg.drawRect(27, 52, 100, 80);
			bufferg.drawString("no KanColle", 40, 90);
		}
		else
			bufferg.drawImage(img,27,52,this);
		g.drawImage(buffer, 0, 0, this);
	}
}

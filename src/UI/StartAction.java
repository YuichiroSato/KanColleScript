package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainThread.MainThread;


public class StartAction implements ActionListener {

	MainThread cap;
	
	public StartAction(MainThread c) {
		cap = c;
	}
	
	public void actionPerformed(ActionEvent ae) {
		cap.setStart();
	}
}

package UI;



import java.awt.event.*;

import MainThread.MainThread;

public class StopAction implements ActionListener {

	MainThread main_thread;
	
	public StopAction(MainThread t) {
		main_thread = t;
	}
	
	public void actionPerformed(ActionEvent ae) {
		main_thread.setStop();
	}
}

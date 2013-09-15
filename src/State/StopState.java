package State;

import java.awt.image.BufferedImage;

public class StopState extends State {

	State buffer;
	
	public StopState(State s) {
		buffer = s;
	}
	
	public void action(BufferedImage img) {
		;
	}
	
	public boolean actionFinished(BufferedImage img) {
		return false;
	}
	
	public State nextState() {
		return buffer;
	}
	
	public boolean isErrer(BufferedImage img) {
		return false;
	}
}

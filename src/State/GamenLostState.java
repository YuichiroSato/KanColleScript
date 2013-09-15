package State;
import java.awt.image.BufferedImage;



public class GamenLostState extends State {

	State buffer;
	
	public GamenLostState(State s) {
		buffer = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		;
	}

	@Override
	public boolean actionFinished(BufferedImage img) {
		return false;
	}

	@Override
	public State nextState() {
		return buffer;
	}

	@Override
	public boolean isErrer(BufferedImage img) {
		return false;
	}

}

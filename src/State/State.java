package State;
import Script.Code;
import java.awt.image.BufferedImage;

public abstract class State implements Code{
	
	public void excute(BufferedImage img) {
		action(img);
	}
	
	public boolean isFinished(BufferedImage img) {
		return actionFinished(img);
	}
	
	abstract public void action(BufferedImage img);
	abstract public boolean actionFinished(BufferedImage img);
	abstract public State nextState();
	abstract public boolean isErrer(BufferedImage img);
}

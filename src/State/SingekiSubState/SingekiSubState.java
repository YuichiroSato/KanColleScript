package State.SingekiSubState;

import java.awt.image.BufferedImage;


public abstract class SingekiSubState {

	abstract public void action(BufferedImage img);
	abstract public boolean finished(BufferedImage img);
	abstract public SingekiSubState nextSubState(BufferedImage img);
	abstract public boolean errer(BufferedImage img);
	abstract public String getStateName();
}

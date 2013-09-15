package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

public abstract class SyutugekiSubState {

	abstract public void action(BufferedImage img);
	abstract public boolean finished(BufferedImage img);
	abstract public SyutugekiSubState nextSubState(BufferedImage img);
	abstract public boolean errer(BufferedImage img);
}

package State.HokyuSubState;

import java.awt.image.BufferedImage;

public abstract class HokyuSubState {

	abstract public void action(BufferedImage img);
	abstract public boolean finished(BufferedImage img);
	abstract public HokyuSubState nextSubState(BufferedImage img);
	abstract public boolean errer(BufferedImage img);

}

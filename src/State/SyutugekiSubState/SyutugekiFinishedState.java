package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

public class SyutugekiFinishedState extends SyutugekiSubState {

	@Override
	public void action(BufferedImage img) {
		;
	}

	@Override
	public boolean finished(BufferedImage img) {
		return false;
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return this;
	}

	@Override
	public boolean errer(BufferedImage img) {
		return false;
	}
}

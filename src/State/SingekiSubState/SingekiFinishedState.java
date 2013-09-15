package State.SingekiSubState;

import java.awt.image.BufferedImage;

public class SingekiFinishedState extends SingekiSubState {

	@Override
	public void action(BufferedImage img) {
		;
	}

	@Override
	public boolean finished(BufferedImage img) {
		return true;
	}

	@Override
	public SingekiSubState nextSubState(BufferedImage img) {
		return this;
	}

	@Override
	public boolean errer(BufferedImage img) {
		return false;
	}

	@Override
	public String getStateName() {
		return "Finished";
	}
}

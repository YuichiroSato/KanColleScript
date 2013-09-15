package State.HokyuSubState;

import java.awt.image.BufferedImage;

public class HokyuFinishedState extends HokyuSubState {

	@Override
	public void action(BufferedImage img) {
		;
	}

	@Override
	public boolean finished(BufferedImage img) {
		return false;
	}

	@Override
	public HokyuSubState nextSubState(BufferedImage img) {
		return null;
	}

	@Override
	public boolean errer(BufferedImage img) {
		return false;
	}

}

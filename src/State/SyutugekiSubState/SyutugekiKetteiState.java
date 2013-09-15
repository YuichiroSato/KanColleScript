package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;

public class SyutugekiKetteiState extends SyutugekiSubState {
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickSyutugekiKettei();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().readySyutugekiKettei(img);
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new SyutugekiFinishedState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return false;
	}

}

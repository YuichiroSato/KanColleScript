package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SyutugekiState;

public class AreaKetteiState extends SyutugekiSubState {

	SyutugekiState super_state;
	
	public AreaKetteiState (SyutugekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickAreaKettei();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().readySyutugekiKettei(img);
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new SyutugekiKetteiState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !(KanColle.getKanColle().readyAreaKettei(img) || KanColle.getKanColle().readySyutugekiKettei(img));
	}

}

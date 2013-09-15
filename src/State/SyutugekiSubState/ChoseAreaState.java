package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SyutugekiState;

public class ChoseAreaState extends SyutugekiSubState {

	SyutugekiState super_state;
	
	public ChoseAreaState (SyutugekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().chooseArea(super_state.getArea());
		KanColleRobot.getRobot().sleep(1000);
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().readyAreaKettei(img);
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new AreaKetteiState(super_state);
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !(KanColle.getKanColle().isAreaSentakuGamen(img) || KanColle.getKanColle().readyAreaKettei(img));
	}

}

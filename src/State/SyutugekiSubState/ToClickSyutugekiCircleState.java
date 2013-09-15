package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SyutugekiState;

public class ToClickSyutugekiCircleState extends SyutugekiSubState {

	SyutugekiState super_state;
	
	public ToClickSyutugekiCircleState (SyutugekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickSyutugekiCircle();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().isAreaSentakuGamen(img);
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new ChoseAreaState(super_state);
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !(KanColle.getKanColle().isCircleBottonGamen(img) || KanColle.getKanColle().isAreaSentakuGamen(img));
	}

}

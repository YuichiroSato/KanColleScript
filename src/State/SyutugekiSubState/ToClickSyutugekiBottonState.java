package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SyutugekiState;

public class ToClickSyutugekiBottonState extends SyutugekiSubState {

	SyutugekiState super_state;
	
	public ToClickSyutugekiBottonState (SyutugekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickSyutugeki();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().isCircleBottonGamen(img);
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new ToClickCircleBottonState(super_state);
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !(KanColle.getKanColle().isBokouTop(img) || KanColle.getKanColle().isCircleBottonGamen(img));
	}

}

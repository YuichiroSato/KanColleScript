package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SyutugekiState;

public class StartSyutugekiState extends SyutugekiSubState {

	SyutugekiState super_state;
	
	public StartSyutugekiState (SyutugekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickBokou();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().isBokouTop(img);
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new ToClickSyutugekiBottonState(super_state);
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isBokou(img);
	}

}

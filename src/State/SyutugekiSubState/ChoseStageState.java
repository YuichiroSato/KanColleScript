package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SyutugekiState;

public class ChoseStageState extends SyutugekiSubState {

	SyutugekiState super_state;
	boolean done;
	
	public ChoseStageState (SyutugekiState s) {
		super_state = s;
		done = false;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().chooseStage(super_state.getStage());
		KanColleRobot.getRobot().sleep(1000);
		done = true;
	}

	@Override
	public boolean finished(BufferedImage img) {
		return done;
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		return new ChoseAreaState(super_state);
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isAreaSentakuGamen(img);
	}

}

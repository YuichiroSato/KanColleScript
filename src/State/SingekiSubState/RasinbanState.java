package State.SingekiSubState;

import java.awt.image.BufferedImage;
import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SingekiState;

public class RasinbanState extends SingekiSubState {

	SingekiState super_state;
	
	public RasinbanState (SingekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().sleep(1000);
		KanColleRobot.getRobot().clickRasinban();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().hasRasinban(img);
	}

	@Override
	public SingekiSubState nextSubState(BufferedImage img) {
		return new SingekiTopState(super_state);
	}

	@Override
	public boolean errer(BufferedImage img) {
		return KanColle.getKanColle().isBokou(img);
	}

	@Override
	public String getStateName() {
		return "click rasinban";
	}

}

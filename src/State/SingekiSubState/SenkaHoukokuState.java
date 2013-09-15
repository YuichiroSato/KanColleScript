package State.SingekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SingekiState;

public class SenkaHoukokuState extends SingekiSubState {

	SingekiState super_state;
	
	public SenkaHoukokuState (SingekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().sleep(1000);
		KanColleRobot.getRobot().clickTugi();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().isSenkaHoukoku(img);
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
		return "Senka houkoku";
	}

}

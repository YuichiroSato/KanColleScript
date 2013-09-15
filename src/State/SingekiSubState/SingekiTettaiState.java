package State.SingekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SingekiState;

public class SingekiTettaiState extends SingekiSubState {

	SingekiState super_state;
	
	public SingekiTettaiState (SingekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().sleep(1000);
		if (super_state.isTettaiState())
			KanColleRobot.getRobot().clickTettai();
		else
			KanColleRobot.getRobot().clickSingeki();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().isSingeki_Tettai(img);
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
		return "Singeki Tettai";
	}

}

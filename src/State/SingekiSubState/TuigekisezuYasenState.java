package State.SingekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SingekiState;

public class TuigekisezuYasenState extends SingekiSubState {
	
	SingekiState super_state;
	
	public TuigekisezuYasenState (SingekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().sleep(1000);
		if (super_state.yasenDekiru())
			KanColleRobot.getRobot().clickYasen();
		else
			KanColleRobot.getRobot().clickTuigekisezu();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().isTuigekisezu_Yasen(img);
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
		return "Tuigekisezu Yasen";
	}

}

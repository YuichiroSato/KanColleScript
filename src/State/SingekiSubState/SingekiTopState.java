package State.SingekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import State.SingekiState;

public class SingekiTopState extends SingekiSubState {
	
	SingekiState super_state;
	
	public SingekiTopState (SingekiState s) {
		super_state = s;
	}

	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().mouseReady();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return true;
	}

	@Override
	public SingekiSubState nextSubState(BufferedImage img) {
		if (KanColle.getKanColle().isChooseZinkei(img))
			return new ChooseZinkeiState(super_state);
		else if (KanColle.getKanColle().isTuigekisezu_Yasen(img))
			return new TuigekisezuYasenState(super_state);
		else if (KanColle.getKanColle().isSingeki_Tettai(img))
			return new SingekiTettaiState(super_state);
		else if (KanColle.getKanColle().isSenkaHoukoku(img))
			return new SenkaHoukokuState(super_state);
		else if (KanColle.getKanColle().isExpHoukoku(img))
			return new ExpHoukokuState(super_state);
		else if (KanColle.getKanColle().hasRasinban(img))
			return new RasinbanState(super_state);
		else if (KanColle.getKanColle().isGet(img))
			return new GetState(super_state);
		else if (KanColle.getKanColle().isBokou(img))
			return new SingekiFinishedState();
		return this;
	}

	@Override
	public boolean errer(BufferedImage img) {
		return KanColle.getKanColle().isBokou(img) && !KanColle.getKanColle().isBokouTop(img);
	}
	
	@Override
	public String getStateName() {
		return "top";
	}
	
}

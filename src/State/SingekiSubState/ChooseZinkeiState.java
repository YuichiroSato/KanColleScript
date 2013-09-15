package State.SingekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import State.SingekiState;

public class ChooseZinkeiState extends SingekiSubState {

	SingekiState super_state;
	
	public ChooseZinkeiState (SingekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		;//click zinkei
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().isChooseZinkei(img);
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
		return "choose zinkei";
	}

}

package State.SyutugekiSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import State.SyutugekiState;

public class ToClickCircleBottonState extends SyutugekiSubState {

	SyutugekiState super_state;
	
	public ToClickCircleBottonState (SyutugekiState s) {
		super_state = s;
	}
	
	@Override
	public void action(BufferedImage img) {
		;
	}

	@Override
	public boolean finished(BufferedImage img) {
		return true;
	}

	@Override
	public SyutugekiSubState nextSubState(BufferedImage img) {
		switch (super_state.getMokuteki()) {
			case "syutugeki":
				return new ToClickSyutugekiCircleState(super_state);
			case "ensyu":
				return new SyutugekiFinishedState();
			case "ensei":
				return new SyutugekiFinishedState();
		}
		return new SyutugekiFinishedState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isCircleBottonGamen(img);
	}

}

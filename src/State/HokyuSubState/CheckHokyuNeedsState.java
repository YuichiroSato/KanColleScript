package State.HokyuSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;

public class CheckHokyuNeedsState extends HokyuSubState {

	@Override
	public void action(BufferedImage img) {
		;
	}

	@Override
	public boolean finished(BufferedImage img) {
		return true;
	}

	@Override
	public HokyuSubState nextSubState(BufferedImage img) {
		if (KanColle.getKanColle().needHokyu(img))
			return new ToClickHokyuBottonState();
		else
			return new HokyuFinishedState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isHokyu(img);
	}

}

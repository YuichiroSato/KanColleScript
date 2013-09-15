package State.HokyuSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;

public class ToClickHokyuBottonState extends HokyuSubState {

	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickKantaiHokyu();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().readyHokyu(img);
	}

	@Override
	public HokyuSubState nextSubState(BufferedImage img) {
		return new ToClickHokyuKetteiBottonState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isHokyu(img);
	}

}

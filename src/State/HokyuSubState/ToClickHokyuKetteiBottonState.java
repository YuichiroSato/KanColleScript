package State.HokyuSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;

public class ToClickHokyuKetteiBottonState extends HokyuSubState {

	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickHokyuKettei();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return !KanColle.getKanColle().readyHokyu(img);
	}

	@Override
	public HokyuSubState nextSubState(BufferedImage img) {
		return new HokyuFinishedState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		// TODO Auto-generated method stub
		return false;
	}

}

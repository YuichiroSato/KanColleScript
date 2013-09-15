package State.HokyuSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;

public class ToHokyuGamenState extends HokyuSubState {

	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickHokyu();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().isHokyu(img);
	}

	@Override
	public HokyuSubState nextSubState(BufferedImage img) {
		return new CheckHokyuNeedsState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isBokou(img);
	}

}

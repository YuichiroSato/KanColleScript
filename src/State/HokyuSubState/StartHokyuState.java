package State.HokyuSubState;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;

public class StartHokyuState extends HokyuSubState {

	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().clickBokou();
	}

	@Override
	public boolean finished(BufferedImage img) {
		return KanColle.getKanColle().isBokouTop(img);
	}

	@Override
	public HokyuSubState nextSubState(BufferedImage img) {
		return new ToHokyuGamenState();
	}

	@Override
	public boolean errer(BufferedImage img) {
		return !KanColle.getKanColle().isBokou(img);
	}

}

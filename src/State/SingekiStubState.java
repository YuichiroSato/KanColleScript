package State;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import Script.Program;

public class SingekiStubState extends SingekiState {

	public SingekiStubState(Program p) {
		super(null,false,p);
	}
	
	@Override
	public void action(BufferedImage img) {
		KanColleRobot.getRobot().sleep(5000);
		if (KanColle.getKanColle().isGet(img))
			KanColleRobot.getRobot().clickKaeru();
		else if (!KanColle.getKanColle().gamenLost(img))
			KanColleRobot.getRobot().clickTettai();
	}

	@Override
	public boolean actionFinished(BufferedImage img) {
		return KanColle.getKanColle().isBokou(img);
	}

	@Override
	public State nextState() {
		return (State)program.getNext();
	}

	@Override
	public boolean isErrer(BufferedImage img) {
		return false;
	}

}

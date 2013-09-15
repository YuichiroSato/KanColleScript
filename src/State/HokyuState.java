package State;

import Script.Program;
import java.awt.image.BufferedImage;

import KanColleRobot.KanColleRobot;
import State.HokyuSubState.*;

public class HokyuState extends State {

	Program program;
	boolean finished;
	int state_counter;
	int errer_counter;
	HokyuSubState sub;
	
	public HokyuState(Program p) {
		program = p;
		finished = false;
		state_counter = 0;
		errer_counter = 0;
		sub = new StartHokyuState();
	}
	
	@Override
	public void action(BufferedImage img) {
		if (sub instanceof HokyuFinishedState)
			finished = true;
		else if (sub.errer(img))
			errer_counter++;
		else if (!sub.finished(img))
			sub.action(img);
		else {
			sub = sub.nextSubState(img);
			state_counter++;
			errer_counter = 0;
		}
		System.out.println("now state"+state_counter);
		KanColleRobot.getRobot().sleep(1000);
	}

	@Override
	public boolean actionFinished(BufferedImage img) {
		return finished;
	}

	@Override
	public State nextState() {
		return (State)program.getNext();
	}

	@Override
	public boolean isErrer(BufferedImage img) {
		return 10 < errer_counter;
	}

}

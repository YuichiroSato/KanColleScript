package State;
import java.awt.image.BufferedImage;

import KanColleRobot.KanColleRobot;
import Script.Program;
import State.SyutugekiSubState.*;

public class SyutugekiState extends State {

	String area;
	String mokuteki;
	Program program;
	boolean finished;
	int state_counter;
	int errer_counter;
	SyutugekiSubState sub;
	
	public SyutugekiState(String s, Program p) {
		area = s;
		mokuteki = "syutugeki";
		program = p;
		finished = false;
		state_counter = 0;
		errer_counter = 0;
		sub = new StartSyutugekiState(this);
	}
	
	@Override
	public void action(BufferedImage img) {
		if (sub instanceof SyutugekiFinishedState)
			finished = true;
		else if (sub.errer(img))
			errer_counter++;
		else if (sub.finished(img)) {
			sub = sub.nextSubState(img);
			state_counter++;
			errer_counter = 0;
		}
		else 
			sub.action(img);
			
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

	public String getMokuteki() {
		return mokuteki;
	}
	
	public int getArea() {
		return Integer.parseInt(area.substring(2,3));
	}
	
	public int getStage() {
		return Integer.parseInt(area.substring(0,1));
	}
}

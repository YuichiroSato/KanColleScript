package State;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import Script.Program;

public class ErrerState extends State {
	
	Program program;
	
	public ErrerState(Program p) {
		program = p;
	}
	
	public void action(BufferedImage img) {
		if (KanColle.getKanColle().isBokouTop(img))
			KanColleRobot.getRobot().sleep(1000);
//		else if (Math.random() < 0.1) {
//			int n = (int)(Math.random() * 5);
//			int i = 0;
//			while(i < n) {
//				int rad = (int)(Math.random() * 100);
//				KanColleRobot.getRobot().sleep(500 + rad);
//				KanColleRobot.getRobot().clickBokou();
//				i++;
//			}
//		}
		else {
			KanColleRobot.getRobot().clickBokou();
			KanColleRobot.getRobot().sleep(1000);
		}
	}
	
	public boolean actionFinished(BufferedImage img) {
		return KanColle.getKanColle().isBokouTop(img);
	}
	
	public State nextState() {
		return (State)program.getNext();
	}
	
	public boolean isErrer(BufferedImage img) {
		return false;
	}
}

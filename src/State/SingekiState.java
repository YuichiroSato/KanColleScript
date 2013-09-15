package State;

import java.awt.image.BufferedImage;

import KanColle.KanColle;
import Script.Program;
import Script.Damage;
import State.SingekiSubState.*;


public class SingekiState extends State {

	Program program;
	boolean finished;
	int errer_counter;
	SingekiSubState sub;

	Damage tettai_limit;
	boolean tettai;
	boolean yasen_dekiru;
	
	public SingekiState(Damage t, boolean y, Program p) {
		program = p;
		finished = false;
		errer_counter = 0;
		sub = new SingekiTopState(this);
		
		tettai_limit = t;
		tettai = true;
		yasen_dekiru = y;
	}
	
	@Override
	public void action(BufferedImage img) {
		if (sub instanceof SingekiFinishedState)
			finished = true;
		else if (sub.errer(img))
			errer_counter++;
		else if (!sub.finished(img))
			sub.action(img);
		else {
			sub = sub.nextSubState(img);
			errer_counter = 0;
		}
		System.out.println("now state "+sub.getStateName());	}

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
	
	public int chooseZinkei(BufferedImage img) {
		return 0;
	}

	public boolean yasenDekiru() {
		return yasen_dekiru;
	}
	
	public boolean isTettaiState() {
		return tettai;
	}
	
	public void damageCheck(BufferedImage img) {
		tettai = maketa(KanColle.getKanColle().damageCheck(img));
	}

	private boolean maketa(Damage damage) {
		int sum0 = damage.getTaiha();
		int sum1 = sum0 + damage.getTyuha();
		int sum2 = sum1 + damage.getSyoha();
		
		return tettai_limit.getTaiha() <= sum0
				|| tettai_limit.getTyuha() <= sum1
				|| tettai_limit.getSyoha() <= sum2;
	}
}

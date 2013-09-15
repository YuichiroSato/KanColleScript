package MainThread;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import KanColle.KanColle;
import KanColleRobot.KanColleRobot;
import Script.Program;
import State.ErrerState;
import State.GamenLostState;
import State.SingekiState;
import State.State;
import State.StopState;
import UI.CanFrame;

public class MainThread implements Runnable {

	CanFrame frame;
	Program program;
	State code;
	int time;
	
	public MainThread(Program p){
		frame = new CanFrame(this);
		code = new StopState((State)p.getCurrent());
		time = 0;
		program = p;
	}
	
	public void run() {
		try {
			while(true) {
				Thread.sleep(25);
				if (program.justFinished())
					incTime();
				
				BufferedImage img = KanColleRobot.getRobot().captureScreen();
				gamenLostCheck(img);
				evolve(img);
			
				if (code instanceof GamenLostState)
					frame.setImage(null);
				else
					frame.setImage(resize(rectangle(img)));
				frame.repaint();
			}
		}
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	private void gamenLostCheck(BufferedImage img) {
		if (code instanceof GamenLostState) {
			if (!KanColle.getKanColle().gamenLost(img) || KanColle.getKanColle().hasKanColleGamen(img))
				code = code.nextState();
			else if (code.nextState() instanceof SingekiState && KanColle.getKanColle().isGet(img))
				KanColleRobot.getRobot().clickKaeru();
		}
		else {
			if (KanColle.getKanColle().gamenLost(img)) {
				KanColle.getKanColle().bufferKanColleGamenXY();
				KanColle.getKanColle().findKanColleGamen(img);
				code = new GamenLostState(code);
			}
		}
	}
	
	private void evolve(BufferedImage img) {
		if (code.isErrer(img))
			code = new ErrerState(program);
		else if (code.isFinished(img))
			code = code.nextState();
		else
			code.excute(img);
	}
	
	private BufferedImage rectangle(BufferedImage img) {
		int red = 0xff0000;
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		int width = KanColle.getKanColle().getWidth();
		int height = KanColle.getKanColle().getHeigth();
		
		if (!isReasonableSize(img))
			return img;
		
		for (int j = 0; j < 20; j++) {
			for (int i = x; i < x + width; i++) {
				img.setRGB(i, y + j, red);
			}
			for (int i = x; i < x + width; i++) {
				img.setRGB(i, y + height + j, red);
			}
			for (int i = y; i < y+ height; i++) {
				img.setRGB(x + j, i, red);
			}
			for (int i = y; i < y + height; i++) {
				img.setRGB(x + width + j, i, red);
			}
		}
		return img;
	}
	
	private boolean isReasonableSize(BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		int width = KanColle.getKanColle().getWidth();
		int height = KanColle.getKanColle().getHeigth();
		return x + width < img.getWidth() && y + height < img.getHeight() && 0 < x && 0 < y; 
	}
	
	private BufferedImage resize(BufferedImage img) {
		int width = 100;
	    int height = 80;
	    BufferedImage resizeImage = new BufferedImage(width, height, img.getType());
	    
	    AffineTransformOp ato = null;
		ato = new AffineTransformOp(
                   AffineTransform.getScaleInstance((double)width / img.getWidth(), 
				                                    (double) height / img.getHeight()), 
				                                    null);
		ato.filter(img, resizeImage);
		return resizeImage;
	}
    
	public int getTime() {
		return time;
	}
	
	public void incTime() {
		time++;
	}
	
    public void setStop() {
    	if (!(code instanceof StopState))
    		code = new StopState(code);
    }
    
    public void setStart() {
    	if (code instanceof StopState)
    		code = code.nextState();
    }
    
    public String getStateName() {
    	if (code instanceof StopState)
    		return "stop";
    	else if (code instanceof GamenLostState)
    		return "lost";
    	else if (code instanceof ErrerState)
    		return "errer";
    	return "run";
    }
}

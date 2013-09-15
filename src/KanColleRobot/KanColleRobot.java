package KanColleRobot;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

import KanColle.KanColle;

public class KanColleRobot {

	static public KanColleRobot kancollerobot;
	
	static public KanColleRobot getRobot() {
		if (kancollerobot == null)
			kancollerobot = new KanColleRobot();
		return kancollerobot;
	}
	
	Robot r;
	Rectangle rec;
	
	int KanColleGamenX;
	int KanColleGamenY;
	
	private KanColleRobot() {
		try {
		      r = new Robot();
		    }
		catch(AWTException e) {
		     ;
		}
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		rec = new Rectangle(d);
	}
	
	public void mouseReady() {
		r.mouseMove(KanColle.getKanColle().getX(), KanColle.getKanColle().getY());
	}
	
	private void click(int x, int y) {
		r.mouseMove(x, y);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public void sleep(int ms) {
		r.delay(ms);
//		r.delay((int)((Math.random()*5000+Math.random()*5000+Math.random()*5000)/3));
	}
	
	public BufferedImage captureScreen() {
		return r.createScreenCapture(rec);
	}
	
	public void doSingeki() {
		clickSingeki();
	}
	
	// click Menue Ring
	public void clickBokou() {
		click(KanColle.getKanColle().getBokouBottonX(), KanColle.getKanColle().getBokouBottonY());
	}
	
	public void clickSyutugeki() {
		click(KanColle.getKanColle().getSyutugekiBottonX(), KanColle.getKanColle().getSyutugekiBottonY());
	}
	
	public void clickHensei() {
		click(KanColle.getKanColle().getHenseiBottonX(), KanColle.getKanColle().getHenseiBottonY());
	}
	
	public void clickKaisou() {
		click(KanColle.getKanColle().getKaisouBottonX(), KanColle.getKanColle().getKaisouBottonY());
	}
	
	public void clickKousyou() {
		click(KanColle.getKanColle().getKousyouBottonX(), KanColle.getKanColle().getKousyouBottonY());
	}
	
	public void clickNyukyo() {
		click(KanColle.getKanColle().getNyukyoBottonX(), KanColle.getKanColle().getNyukyoBottonY());
	}
	
	public void clickHokyu() {
		click(KanColle.getKanColle().getHokyuBottonX(), KanColle.getKanColle().getHokyuBottonY());
	}
	//end
	
	// click Hokyu
	public void clickKantaiHokyu() {
		click(KanColle.getKanColle().getKantaiHokyuBottonX(), KanColle.getKanColle().getKantaiHokyuBottonY());
	}
	
	public void clickHokyuKettei() {
		click(KanColle.getKanColle().getHokyuKetteiBottonX(), KanColle.getKanColle().getHokyuKetteiBottonY());
	}
	//end
	
	
	// click Syutugeki
	public void clickSyutugekiCircle() {
		click(KanColle.getKanColle().getSyutugekiCircleBottonX(), KanColle.getKanColle().getSyutugekiCircleBottonY());
	}
	
	public void clickEnsyuCircle() {
		click(KanColle.getKanColle().getEnsyuCircleBottonX(), KanColle.getKanColle().getEnsyuCircleBottonY());
	}
	
	public void clickEnseiCircle() {
		click(KanColle.getKanColle().getEnseiCircleBottonX(), KanColle.getKanColle().getEnseiCircleBottonY());
	}
	
	public void chooseStage (int i) {
		int click_x = -1;
		int click_y = -1;
		
		switch (i) {
			case 1:
				click_x = KanColle.getKanColle().getArea1_xX();
				click_y = KanColle.getKanColle().getArea1_xY();
				break;
			case 2:
				click_x = KanColle.getKanColle().getArea2_xX();
				click_y = KanColle.getKanColle().getArea2_xY();
				break;
			case 3:
				click_x = KanColle.getKanColle().getArea3_xX();
				click_y = KanColle.getKanColle().getArea3_xY();
				break;
			case 4:
				click_x = KanColle.getKanColle().getArea4_xX();
				click_y = KanColle.getKanColle().getArea4_xY();
				break;
		}
		if (0 < click_x && 0 < click_y)
			click(click_x, click_y);
	}
	
	public void chooseArea (int i) {
		int click_x = -1;
		int click_y = -1;
		
		switch (i) {
			case 1:
				click_x = KanColle.getKanColle().getAreax_1X();
				click_y = KanColle.getKanColle().getAreax_1Y();
				break;
			case 2:
				click_x = KanColle.getKanColle().getAreax_2X();
				click_y = KanColle.getKanColle().getAreax_2Y();
				break;
			case 3:
				click_x = KanColle.getKanColle().getAreax_3X();
				click_y = KanColle.getKanColle().getAreax_3Y();
				break;
			case 4:
				click_x = KanColle.getKanColle().getAreax_4X();
				click_y = KanColle.getKanColle().getAreax_4Y();
				break;
		}
		if (0 < click_x && 0 < click_y)
			click(click_x, click_y);
	}

	
	public void clickAreaKettei () {
		click(KanColle.getKanColle().getAreaKetteiBottonX(), KanColle.getKanColle().getAreaKetteiBottonY());
	}
	
	public void clickSyutugekiKettei () {
		click(KanColle.getKanColle().getSyutugekiKetteiBottonX(), KanColle.getKanColle().getSyutugekiKetteiBottonY());
	}
	//end
	
	// Singeki
	public void clickTuigekisezu() {
		click(KanColle.getKanColle().getTuigekisezuBottonX(), KanColle.getKanColle().getTuigekisezuBottonY());
	}
	
	public void clickYasen() {
		click(KanColle.getKanColle().getYasenBottonX(), KanColle.getKanColle().getYasenBottonY());
	}
	
	public void clickSingeki() {
		click(KanColle.getKanColle().getSingekiBottonX(), KanColle.getKanColle().getSingekiBottonY());
	}
	
	public void clickTettai() {
		click(KanColle.getKanColle().getTettaiBottonX(), KanColle.getKanColle().getTettaiBottonY());
	}
	
	public void clickTugi() {
		click(KanColle.getKanColle().getTugiBottonX(), KanColle.getKanColle().getTugiBottonY());
	}
	
	public void clickKaeru() {
		click(KanColle.getKanColle().getKaeruBottonX(), KanColle.getKanColle().getKaeruBottonY());
	}
	
	public void clickRasinban() {
		click(KanColle.getKanColle().getRasinbanX(), KanColle.getKanColle().getRasinbanY());
		int rad = (int)(((Math.random() + Math.random() + Math.random()) * 1000) / 3);
		KanColleRobot.getRobot().sleep(rad);
		click(KanColle.getKanColle().getRasinbanX(), KanColle.getKanColle().getRasinbanY());
	}
	
}

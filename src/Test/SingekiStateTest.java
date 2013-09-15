package Test;

import java.io.File;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

import State.SingekiState;
import Script.Damage;

public class SingekiStateTest extends TestCase {
	
	BufferedImage damaged;
	SingekiState state;

	public SingekiStateTest () {
		try { 
			  damaged = ImageIO.read(new File("syutugeki_image/damaged.bmp"));
			} catch (Exception e) {
			  e.printStackTrace();
			}
		state = new SingekiState(new Damage(0,0,0), false, null);
	}
	
	public void testdamageCheck() {
		state.damageCheck(damaged);
	}
}

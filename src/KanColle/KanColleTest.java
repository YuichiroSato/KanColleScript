package KanColle;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

public class KanColleTest extends TestCase {

	BufferedImage rasinban;
	BufferedImage getgamen;
	
	
	
	public KanColleTest() {
		try {
			  rasinban = ImageIO.read(new File("syutugeki_image/rasinban.bmp"));
			  getgamen = ImageIO.read(new File("syutugeki_image/get_gamen.bmp"));
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}
	
	public void testisGet() {
		boolean res = KanColle.getKanColle().isGet(getgamen);
		assertEquals(true,res);
		res = KanColle.getKanColle().isGet(rasinban);
		assertEquals(false,res);
	}

}

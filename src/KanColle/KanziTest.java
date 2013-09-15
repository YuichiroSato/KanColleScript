package KanColle;

import junit.framework.TestCase;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class KanziTest extends TestCase {

	BufferedImage syouri;
	BufferedImage getgamen;
	BufferedImage rasinban;
	
	BufferedImage singeki_tettai;
	BufferedImage tuigekisezu_yasen;
	BufferedImage senka_houkoku;
	
	BufferedImage taiha;
	BufferedImage tyuha;
	BufferedImage syoha;
	
	public KanziTest() {
		try {
			  syouri = ImageIO.read(new File("syutugeki_image/syouri.bmp"));
			  getgamen = ImageIO.read(new File("syutugeki_image/get_gamen.bmp"));
			  rasinban = ImageIO.read(new File("syutugeki_image/rasinban.bmp"));
			  
			  singeki_tettai = ImageIO.read(new File("syutugeki_image/singeki_tettai.bmp"));
			  tuigekisezu_yasen = ImageIO.read(new File("syutugeki_image/tuigeki_yasen.bmp"));
			  senka_houkoku = ImageIO.read(new File("syutugeki_image/senka_houkoku.bmp"));
			  
			  taiha = ImageIO.read(new File("syutugeki_image/taiha.bmp"));
			  tyuha = ImageIO.read(new File("syutugeki_image/tyuha.bmp"));
			  syoha = ImageIO.read(new File("syutugeki_image/syoha.bmp"));
			  
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}
	
	public void testhasTugi() {
		boolean res = Kanzi.hasTugi(syouri);
		assertEquals(true,res);
		res = Kanzi.hasTugi(getgamen);
		assertEquals(false,res);
	}
	
	public void testhasKaeru() {
		boolean res = Kanzi.hasKaeru(getgamen);
		assertEquals(true,res);
		res = Kanzi.hasKaeru(syouri);
		assertEquals(false,res);
	}
	
	public void testhasTuigekisezu() {
		boolean res = Kanzi.hasTuigekisezu(tuigekisezu_yasen);
		assertEquals(true,res);
		res = Kanzi.hasTuigekisezu(singeki_tettai);
		assertEquals(false,res);
	}
	
	public void testhasYasen() {
		boolean res = Kanzi.hasYasen(tuigekisezu_yasen);
		assertEquals(true,res);
		res = Kanzi.hasYasen(singeki_tettai);
		assertEquals(false,res);
	}
	
	public void testhasShingeki() {
		boolean res = Kanzi.hasShingeki(singeki_tettai);
		assertEquals(true,res);
		res = Kanzi.hasShingeki(tuigekisezu_yasen);
		assertEquals(false,res);
	}
	
	public void testhasTettai() {
		boolean res = Kanzi.hasTettai(singeki_tettai);
		assertEquals(true,res);
		res = Kanzi.hasTettai(tuigekisezu_yasen);
		assertEquals(false,res);
	}
	
	public void testisTaiha() {
		boolean res = Kanzi.isTaiha(taiha);
		assertEquals(true,res);
		res = Kanzi.isTaiha(tyuha);
		assertEquals(false,res);
		res = Kanzi.isTaiha(syoha);
		assertEquals(false,res);
	}
	
	public void testisTyuha() {
		boolean res = Kanzi.isTyuha(tyuha);
		assertEquals(true,res);
		res = Kanzi.isTyuha(taiha);
		assertEquals(false,res);
		res = Kanzi.isTyuha(syoha);
		assertEquals(false,res);		
	}
	
	public void testisSyoha() {
		boolean res = Kanzi.isSyoha(syoha);
		assertEquals(true,res);
		res = Kanzi.isSyoha(taiha);
		assertEquals(false,res);
		res = Kanzi.isSyoha(tyuha);
		assertEquals(false,res);
	}
}

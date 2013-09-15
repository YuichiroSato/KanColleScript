package KanColle;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

public class GeometryTest extends TestCase {

	BufferedImage bokou;
	BufferedImage areakettei;
	BufferedImage syutugekikettei;
	BufferedImage syutugekikettei2;
	BufferedImage syutugekikettei3;
	
	BufferedImage rasinban;
	BufferedImage getgamen;
	BufferedImage damage_check;
	BufferedImage senka_houkoku;
	BufferedImage syouri;
	
	public GeometryTest() {
		try {
			  bokou = ImageIO.read(new File("bokou_image/bokou.bmp"));
			  areakettei = ImageIO.read(new File("bokou_image/syutugeki3.bmp"));

			  syutugekikettei = ImageIO.read(new File("bokou_image/syutugeki4.bmp"));
			  syutugekikettei2 = ImageIO.read(new File("bokou_image/syutugeki4_2.bmp"));
			  syutugekikettei3 = ImageIO.read(new File("bokou_image/syutugeki4_3.bmp"));
			  
			  rasinban = ImageIO.read(new File("syutugeki_image/rasinban.bmp"));
			  getgamen = ImageIO.read(new File("syutugeki_image/get_gamen.bmp"));
			  damage_check = ImageIO.read(new File("syutugeki_image/damaged.bmp"));
			  senka_houkoku = ImageIO.read(new File("syutugeki_image/senka_houkoku.bmp"));
			  syouri = ImageIO.read(new File("syutugeki_image/syouri.bmp"));
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}
	
	public void testhasBokouRing() {
		boolean res = Geometry.hasBokouRing(bokou);
		assertEquals(true,res);
		res = Geometry.hasBokouRing(rasinban);
		assertEquals(false,res);
	}
	
	public void testhasSyutugekiRing() {
		boolean res = Geometry.hasSyutugekiRing(bokou);
		assertEquals(true,res);
		res = Geometry.hasSyutugekiRing(rasinban);
		assertEquals(false,res);
	}

	public void testhasAreaKetteiBotton() {
		boolean res = Geometry.hasAreaKetteiBotton(areakettei);
		assertEquals(true,res);
		res = Geometry.hasAreaKetteiBotton(rasinban);
		assertEquals(false,res);
	}
	
	public void testhasRedSyutugekiKetteiBotton() {
		boolean res = Geometry.hasRedSyutugekiKetteiBotton(syutugekikettei);
		assertEquals(true,res);
		res = Geometry.hasAreaKetteiBotton(rasinban);
		assertEquals(false,res);
	}
	
	public void testhasOrangeSyutugekiKetteiBotton() {
		boolean res = Geometry.hasOrangeSyutugekiKetteiBotton(syutugekikettei3);
		assertEquals(true,res);
		res = Geometry.hasAreaKetteiBotton(rasinban);
		assertEquals(false,res);
	}

	public void testhasGraySyutugekiKetteiBotton() {
		boolean res = Geometry.hasGraySyutugekiKetteiBotton(syutugekikettei2);
		assertEquals(true,res);
		res = Geometry.hasGraySyutugekiKetteiBotton(rasinban);
		assertEquals(false,res);
	}

	public void testhasTugiRing() {
		boolean res = Geometry.hasTugiRing(syouri);
		assertEquals(true,res);
		res = Geometry.hasTugiRing(getgamen);
		assertEquals(false,res);
	}
	
	public void testhasKaeruRing() {
		boolean res = Geometry.hasKaeruRing(getgamen);
		assertEquals(true,res);
		res = Geometry.hasKaeruRing(rasinban);
		assertEquals(false,res);
	}
	
	public void testhasExpVerticalLine() {
		boolean res = Geometry.hasExpVerticalLine(damage_check);
		assertEquals(true,res);
		res = Geometry.hasExpVerticalLine(syouri);
		assertEquals(false,res);
	}
	
	public void testhasHari() {
		boolean res = Geometry.hasHari(rasinban);
		assertEquals(true,res);
		res = Geometry.hasHari(getgamen);
		assertEquals(false,res);
		
	}
}

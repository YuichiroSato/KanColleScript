package KanColle;

import java.awt.image.BufferedImage;

public class Kanzi {
	
	protected static boolean hasTugi (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 744;
		int y1 = y + 422;
		
		int x2 = x + 742;
		int y2 = y + 436;
		
		int x3 = x + 755;
		int y3 = y + 427;
		
		int x4 = x + 752;
		int y4 = y + 434;
		
		int x5 = x + 759;
		int y5 = y + 438;
		
		return isPartOfTugi(img, x1, y1)
				&& isPartOfTugi(img, x2, y2)
				&& isPartOfTugi(img, x3, y3)
				&& isPartOfTugi(img, x4, y4)
				&& isPartOfTugi(img, x5, y5);
	}
	
	private static boolean isPartOfTugi (BufferedImage img, int x, int y) {
		return RGButil.isWhiteZiColor(RGButil.averageRGB(img, x, y, 2, 2));
	}

	protected static boolean hasKaeru (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 752;
		int y1 = y + 430;
		
		int x2 = x + 757;
		int y2 = y + 443;
		
		int x3 = x + 762;
		int y3 = y + 443;
		
		int x4 = x + 768;
		int y4 = y + 443;
		
		return isPartOfKaeru(img, x1, y1)
				&& isPartOfKaeru(img, x2, y2)
				&& isPartOfKaeru(img, x3, y3)
				&& isPartOfKaeru(img, x4, y4);
	}

	private static boolean isPartOfKaeru (BufferedImage img, int x, int y) {
		return RGButil.isWhiteZiColor(RGButil.averageRGB(img, x, y, 3, 6));
	}
	
	protected static boolean hasKaeruBuffer (BufferedImage img, int x, int y) {
		int x1 = x + 752;
		int y1 = y + 430;
		
		int x2 = x + 757;
		int y2 = y + 443;
		
		int x3 = x + 762;
		int y3 = y + 443;
		
		int x4 = x + 768;
		int y4 = y + 443;
		
		return isPartOfKaeru(img, x1, y1)
				&& isPartOfKaeru(img, x2, y2)
				&& isPartOfKaeru(img, x3, y3)
				&& isPartOfKaeru(img, x4, y4);
	}
	
	protected static boolean hasTuigekisezu (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 275;
		int y1 = y + 246;
		int w1 = 2;
		int h1 = 18;
		
		int x2 = x + 288;
		int y2 = y + 237;
		int w2 = 2;
		int h2 = 19;

		int x3 = x + 281;
		int y3 = y + 268;
		int w3 = 13;
		int h3 = 3;
		
		int x4 = x + 314;
		int y4 = y + 244;
		int w4 = 3;
		int h4 = 29;
		
		int x5 = x + 265;
		int y5 = y + 200;
		int w5 = 3;
		int h5 = 24;

		return RGButil.isWhiteZiColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
	
	protected static boolean hasYasen(BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 472;
		int y1 = y + 206;
		int w1 = 3;
		int h1 = 23;
		
		int x2 = x + 507;
		int y2 = y + 213;
		int w2 = 2;
		int h2 = 24;

		int x3 = x + 519;
		int y3 = y + 203;
		int w3 = 3;
		int h3 = 17;
		
		int x4 = x + 507;
		int y4 = y + 268;
		int w4 = 4;
		int h4 = 3;
		
		int x5 = x + 528;
		int y5 = y + 259;
		int w5 = 3;
		int h5 = 5;

		return RGButil.isWhiteZiColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
	
	protected static boolean hasShingeki(BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 253;
		int y1 = y + 227;
		int w1 = 3;
		int h1 = 16;
		
		int x2 = x + 262;
		int y2 = y + 212;
		int w2 = 4;
		int h2 = 33;

		int x3 = x + 272;
		int y3 = y + 216;
		int w3 = 5;
		int h3 = 25;
		
		int x4 = x + 303;
		int y4 = y + 220;
		int w4 = 3;
		int h4 = 27;
		
		int x5 = x + 314;
		int y5 = y + 248;
		int w5 = 4;
		int h5 = 23;

		return RGButil.isWhiteZiColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
	
	protected static boolean hasTettai(BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 466;
		int y1 = y + 209;
		int w1 = 4;
		int h1 = 41;
		
		int x2 = x + 476;
		int y2 = y + 230;
		int w2 = 4;
		int h2 = 24;

		int x3 = x + 486;
		int y3 = y + 229;
		int w3 = 3;
		int h3 = 22;
		
		int x4 = x + 527;
		int y4 = y + 222;
		int w4 = 4;
		int h4 = 34;
		
		int x5 = x + 544;
		int y5 = y + 222;
		int w5 = 4;
		int h5 = 18;

		return RGButil.isWhiteZiColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isWhiteZiColor(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
	
	protected static boolean isTaiha(BufferedImage img) {
		int x2 = 127;
		int y2 = 11;
		int w2 = 3;
		int h2 = 3;

		int x3 = 133;
		int y3 = 23;
		int w3 = 3;
		int h3 = 2;
		
		int x4 = 122;
		int y4 = 16;
		int w4 = 2;
		int h4 = 3;
		
		int x5 = 140;
		int y5 = 23;
		int w5 = 7;
		int h5 = 3;

//		RGButil.printRGB(RGButil.averageRGB(img, x2, y2, w2, h2));
//		RGButil.printRGB(RGButil.averageRGB(img, x3, y3, w3, h3));
//		RGButil.printRGB(RGButil.averageRGB(img, x4, y4, w4, h4));
//		RGButil.printRGB(RGButil.averageRGB(img, x5, y5, w5, h5));
//		
		return RGButil.isTaihaRed(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isTaihaRed(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isTaihaRed(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isTaihaRed(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
	
	protected static boolean isTyuha(BufferedImage img) {
		int x1 = 117;
		int y1 = 9;
		int w1 = 2;
		int h1 = 4;
		
		int x2 = 129;
		int y2 = 1;
		int w2 = 2;
		int h2 = 5;

		int x3 = 124;
		int y3 = 18;
		int w3 = 2;
		int h3 = 4;
		
		int x4 = 154;
		int y4 = 24;
		int w4 = 2;
		int h4 = 2;
		
		int x5 = 150;
		int y5 = 35;
		int w5 = 2;
		int h5 = 2;
		
//		RGButil.printRGB(RGButil.averageRGB(img, x1, y1, w1, h1));
//		RGButil.printRGB(RGButil.averageRGB(img, x2, y2, w2, h2));
//		RGButil.printRGB(RGButil.averageRGB(img, x3, y3, w3, h3));
//		RGButil.printRGB(RGButil.averageRGB(img, x4, y4, w4, h4));
//		RGButil.printRGB(RGButil.averageRGB(img, x5, y5, w5, h5));

		return RGButil.isTyuhaOrange(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isTyuhaOrange(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isTyuhaOrange(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isTyuhaOrange(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isTyuhaOrange(RGButil.averageRGB(img, x5, y5, w5, h5));

	}
	
	protected static boolean isSyoha(BufferedImage img) {
		int x1 = 123;
		int y1 = 5;
		int w1 = 2;
		int h1 = 4;
		
		int x2 = 132;
		int y2 = 2;
		int w2 = 2;
		int h2 = 4;

		int x3 = 124;
		int y3 = 21;
		int w3 = 4;
		int h3 = 3;
		
		int x4 = 149;
		int y4 = 31;
		int w4 = 3;
		int h4 = 2;
		
		int x5 = 151;
		int y5 = 35;
		int w5 = 2;
		int h5 = 2;
		
//		RGButil.printRGB(RGButil.averageRGB(img, x1, y1, w1, h1));
//		RGButil.printRGB(RGButil.averageRGB(img, x2, y2, w2, h2));
//		RGButil.printRGB(RGButil.averageRGB(img, x3, y3, w3, h3));
//		RGButil.printRGB(RGButil.averageRGB(img, x4, y4, w4, h4));
//		RGButil.printRGB(RGButil.averageRGB(img, x5, y5, w5, h5));

		return RGButil.isSyohaYellow(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isSyohaYellow(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isSyohaYellow(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isSyohaYellow(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isSyohaYellow(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
}

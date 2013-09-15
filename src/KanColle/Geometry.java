package KanColle;

import java.awt.image.BufferedImage;

public class Geometry {
	
	// Gamen Geometry
	protected static int[] findKanColleGamenOrigin(BufferedImage img) {
		int[] xy = new int[2];
		
		for (int i = 1; i < img.getWidth() - (KanColle.getKanColle().width + 2); i++){
			for (int j = 1; j < img.getHeight() - (KanColle.getKanColle().height + 2); j++){
				if(isOriginOfKanColleGamen(img, i, j)) {
					xy[0] = i;
					xy[1] = j;
					return xy;
				}
			}
		}
		xy[0] = -1;
		xy[1] = -1;
		
		return xy;
	}
	
	public static boolean isOriginOfKanColleGamen(BufferedImage img, int x, int y) {
		return easyOriginCheck(img, x, y) && finalOriginCheck(img, x, y);
	}
	
	private static boolean easyOriginCheck (BufferedImage img, int x, int y) {
		int w = KanColle.getKanColle().width;
		int h = KanColle.getKanColle().height;
		
		return isKanColleRightEdge(img, x + w, y + 290)
				&& isKanColleRightEdge(img, x + w, y + 240)
				&& isKanColleRightEdge(img, x + w, y + 340)
				&& isKanColleLeftEdge(img, x, y + 290)
				&& isKanColleLeftEdge(img, x, y + 240)
				&& isKanColleLeftEdge(img, x, y + 340)
				&& isKanColleLowerEdge(img, x + 100, y + h)
				&& isKanColleLowerEdge(img, x + 400, y + h)
				&& isKanColleLowerEdge(img, x + 700, y + h);
	}
	
	private static boolean finalOriginCheck (BufferedImage img, int x, int y) {
		return 3.6 < isUpperBound(img,x,y) + isLeftBound(img,x,y) + isLowerBound(img,x,y) + isRightBound(img,x,y);
	}
	
	private static double isUpperBound(BufferedImage img, int x, int y) {
		int point = 0;
		for (int i = x; i < x + KanColle.getKanColle().width; i++) {
			if (isKanColleUpperEdge(img,i,y))
				point++;
		}
		return (double) point / KanColle.getKanColle().width;
	}
	
	private static double isLeftBound(BufferedImage img, int x, int y) {
		int point = 0;
		for (int i = y; i < y + KanColle.getKanColle().height; i++){
			if (isKanColleLeftEdge(img,x,i))
				point++;
		}
		return (double) point / KanColle.getKanColle().height;
	}
	
	private static double isLowerBound(BufferedImage img, int x, int y) {
		int point = 0;
		y += KanColle.getKanColle().height;
		for (int i = x; i < x + KanColle.getKanColle().width; i++) {
			if (isKanColleLowerEdge(img,i,y))
				point++;
		}
		return (double) point / KanColle.getKanColle().width;
	}
	
	private static double isRightBound(BufferedImage img, int x, int y) {
		int point = 0;
		x += KanColle.getKanColle().width;
		for (int i = y; i < y + KanColle.getKanColle().height; i++){
			if (isKanColleRightEdge(img,x,i))
				point++;
		}
		return (double) point / KanColle.getKanColle().height;
	}
	
	private static boolean isKanColleUpperEdge(BufferedImage img, int x, int y) {
		return !RGButil.isWhite(img.getRGB(x, y)) && RGButil.isWhite(img.getRGB(x, y - 1));
	}
	
	private static boolean isKanColleLeftEdge(BufferedImage img, int x, int y) {
		return !RGButil.isWhite(img.getRGB(x, y)) && RGButil.isWhite(img.getRGB(x - 1, y));
	}
	
	private static boolean isKanColleLowerEdge(BufferedImage img, int x, int y) {
		return !RGButil.isWhite(img.getRGB(x, y)) && RGButil.isWhite(img.getRGB(x, y + 1));
	}
	
	private static boolean isKanColleRightEdge(BufferedImage img, int x, int y) {
		return !RGButil.isWhite(img.getRGB(x, y)) && RGButil.isWhite(img.getRGB(x + 1, y));
	}
	//end
	
	// Bokou Top Geometry
	protected static boolean hasBokouRing (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 97;
		int y1 = y + 2;
		
		int x2 = x + 108;
		int y2 = y + 43;
		
		int x3 = x + 90;
		int y3 = y + 86;
		
		int x4 = x + 39;
		int y4 = y + 104;
		
		return isPartOfBokouRing(img,x1,y1)
				&& isPartOfBokouRing(img,x2,y2)
				&& isPartOfBokouRing(img,x3,y3)
				&& isPartOfBokouRing(img,x4,y4);
	}
	
	private static boolean isPartOfBokouRing (BufferedImage img, int x, int y) {
		return RGButil.isBokouRingColor(RGButil.averageRGB(img, x, y, 4, 4));
	}
	
	protected static boolean hasSyutugekiRing (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 196;
		int y1 = y + 198;
		
		int x2 = x + 139;
		int y2 = y + 240;
		
		int x3 = x + 195;
		int y3 = y + 316;
		
		int x4 = x + 250;
		int y4 = y + 240;
		
		int x5 = x + 200;
		int y5 = y + 215;
		
		return isPartOfSyutugekiRing(img, x1, y1)
				&& isPartOfSyutugekiRing(img, x2, y2)
				&& isPartOfSyutugekiRing(img, x3, y3)
				&& isPartOfSyutugekiRing(img, x4, y4)
				&& RGButil.isMenueRingGray(RGButil.averageRGB(img, x5, y5, 10, 10));
	}
	
	private static boolean isPartOfSyutugekiRing (BufferedImage img, int x, int y) {
		return RGButil.isMenueRingColor(RGButil.averageRGB(img, x, y, 2, 2));
	}
	
	protected static boolean hasMenueLine(BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 50;
		int y1 = y + 140;
		int w1 = 2;
		int h1 = 230;
		
		int x2 = x + 79;
		int y2 = y + 170;
		int w2 = 2;
		int h2 = 50;

		int x3 = x + 79;
		int y3 = y + 294;
		int w3 = 2;
		int h3 = 53;

		return RGButil.isMenueLineColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isMenueLineColor(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isMenueLineColor(RGButil.averageRGB(img, x3, y3, w3, h3));
	}
	//end
	
	// Sub Menue Geometry
	protected static boolean isChoosenMenue (BufferedImage img, int x1, int y1, int x2, int y2, int x3, int y3) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1r = x + x1;
		int y1r = y + y1;
		
		int x2r = x + x2;
		int y2r = y + y2;
		
		int x3r = x + x3;
		int y3r = y + y3;
		
		return isPartOfChoosenSubmenue(img, x1r, y1r)
				&& isPartOfChoosenSubmenue(img, x2r, y2r)
				&& isPartOfChoosenSubmenue(img, x3r, y3r);
	}
	
	
	protected static boolean isFreeMenue (BufferedImage img, int x1, int y1, int x2, int y2, int x3, int y3) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1r = x + x1;
		int y1r = y + y1;
		
		int x2r = x + x2;
		int y2r = y + y2;
		
		int x3r = x + x3;
		int y3r = y + y3;
		
		return isPartOfFreeSubmenue(img, x1r, y1r)
				&& isPartOfFreeSubmenue(img, x2r, y2r)
				&& isPartOfFreeSubmenue(img, x3r, y3r);
	}
	
	private static boolean isPartOfChoosenSubmenue (BufferedImage img, int x, int y) {
		return RGButil.isChoosenSubmenueColor(RGButil.averageRGB(img, x, y, 3, 3));
	}
	
	private static boolean isPartOfFreeSubmenue (BufferedImage img, int x, int y) {
		return RGButil.isFreeSubmenueColor(RGButil.averageRGB(img, x, y, 3, 3));
	}
	
	protected static boolean hasChoosenHokyu (BufferedImage img) {
		int x1 = 29;
		int y1 = 190;
		
		int x2 = 37;
		int y2 = 190;
		
		int x3 = 15;
		int y3 = 220;
		
		return isChoosenMenue(img, x1, y1, x2, y2, x3, y3);
	}
	
	protected static boolean hasFreeHokyu (BufferedImage img) {
		int x1 = 19;
		int y1 = 190;
		
		int x2 = 31;
		int y2 = 190;
		
		int x3 = 9;
		int y3 = 220;
		
		return isFreeMenue(img, x1, y1, x2, y2, x3, y3);
	}

	protected static boolean hasChoosenNyukyo (BufferedImage img) {
		int x1 = 14;
		int y1 = 330;
		
		int x2 = 14;
		int y2 = 297;
		
		int x3 = 26;
		int y3 = 299;
		
		return isChoosenMenue(img, x1, y1, x2, y2, x3, y3);
	}
	
	protected static boolean hasFreeNyukyo (BufferedImage img) {
		int x1 = 8;
		int y1 = 330;
		
		int x2 = 8;
		int y2 = 297;
		
		int x3 = 20;
		int y3 = 299;
		
		return isFreeMenue(img, x1, y1, x2, y2, x3, y3);
	}
	//end
	
	// Hokyu Geometry
	protected static boolean hasHokyuDekiru (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 115;
		int y1 = y + 162;
		
		int x2 = x + 115;
		int y2 = y + 213;
		
		int x3 = x + 115;
		int y3 = y + 265;
		
		int x4 = x + 115;
		int y4 = y + 318;
		
		int x5 = x + 115;
		int y5 = y + 370;

		int x6 = x + 115;
		int y6 = y + 421;
		
		return isHokyuDekiruBotton(img, x1, y1)
				|| isHokyuDekiruBotton(img, x2, y2)
				|| isHokyuDekiruBotton(img, x3, y3)
				|| isHokyuDekiruBotton(img, x4, y4)
				|| isHokyuDekiruBotton(img, x5, y5)
				|| isHokyuDekiruBotton(img, x6, y6);
		}
	
	private static boolean isHokyuDekiruBotton (BufferedImage img, int x, int y) {
		return RGButil.isHokyuDekiruBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	
	protected static boolean hasGreenHokyuKetteiBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX() + 660;
		int y = KanColle.getKanColle().getY() + 428;
		return RGButil.isGreenHokyuKetteiBottonColor(RGButil.averageRGB(img, x, y, 80, 3));
	}
	
	protected static boolean hasGrayHokyuKetteiBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX() + 660;
		int y = KanColle.getKanColle().getY() + 428;
		return RGButil.isGrayHokyuKetteiBottonColor(RGButil.averageRGB(img, x, y, 80, 3));
	}
	//end
	
	// Syutugeki Geometry
	protected static boolean hasSyutugekiCircleBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 165;
		int y1 = y + 165;
		
		int x2 = x + 215;
		int y2 = y + 130;
		
		int x3 = x + 280;
		int y3 = y + 160;
		
		return isPartOfSyutugekiCircleBotton(img, x1, y1)
				&& isPartOfSyutugekiCircleBotton(img, x2, y2)
				&& isPartOfSyutugekiCircleBotton(img, x3, y3);
	}
	
	private static boolean isPartOfSyutugekiCircleBotton (BufferedImage img, int x, int y) {
		return RGButil.isSyutugekiCircleBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	    
	protected static boolean hasEnsyuCircleBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 430;
		int y1 = y + 135;
		
		int x2 = x + 455;
		int y2 = y + 240;
		
		int x3 = x + 515;
		int y3 = y + 220;
		
		return isPartOfEnsyuCircleBotton(img, x1, y1)
				&& isPartOfEnsyuCircleBotton(img, x2, y2)
				&& isPartOfEnsyuCircleBotton(img, x3, y3);
	}
	
	private static boolean isPartOfEnsyuCircleBotton (BufferedImage img, int x, int y) {
		return RGButil.isEnsyuCircleBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	    
	protected static boolean hasEnseiCircleBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 610;
		int y1 = y + 160;
		
		int x2 = x + 645;
		int y2 = y + 135;
		
		int x3 = x + 690;
		int y3 = y + 140;
		
		return isPartOfEnseiCircleBotton(img, x1, y1)
				&& isPartOfEnseiCircleBotton(img, x2, y2)
				&& isPartOfEnseiCircleBotton(img, x3, y3);
	}
	
	private static boolean isPartOfEnseiCircleBotton (BufferedImage img, int x, int y) {
		return RGButil.isEnseiCircleBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	
	protected static boolean hasAreaRectangles (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();

		int width = 660;
		int heigth = 200;
		
		int upper_left_x = 120;
		int upper_left_y = 135;
		
		int upper_midle_x = 450;
		int upper_midle_y = upper_left_y;
		
		int upper_right_x = upper_left_x + width;
		int upper_right_y = upper_left_y;
		
		int midle_left_x = upper_left_x;
		int midle_left_y = 277;
		
		int x1 = x + upper_left_x;
		int y1 = y + upper_left_y;
		int w1 = width;
		int h1 = 2;
		
		int x2 = x1;
		int y2 = y1;
		int w2 = 2;
		int h2 = heigth;

		int x3 = x + upper_midle_x;
		int y3 = y + upper_midle_y;
		int w3 = 2;
		int h3 = heigth;
		
		int x4 = x + upper_right_x;
		int y4 = y + upper_right_y;
		int w4 = 2;
		int h4 = heigth;
		
		int x5 = x + midle_left_x;
		int y5 = y + midle_left_y;
		int w5 = width;
		int h5 = 2;

		return RGButil.isAreaRectangleColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isAreaRectangleColor(RGButil.averageRGB(img, x2, y2, w2, h2))
				&& RGButil.isAreaRectangleColor(RGButil.averageRGB(img, x3, y3, w3, h3))
				&& RGButil.isAreaRectangleColor(RGButil.averageRGB(img, x4, y4, w4, h4))
				&& RGButil.isAreaRectangleColor(RGButil.averageRGB(img, x5, y5, w5, h5));
	}
	
	protected static boolean hasAreaKetteiBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 635;
		int y1 = y + 435;
		
		int x2 = x + 700;
		int y2 = y + 435;
		
		return isPartOfAreaKetteiBotton(img, x1, y1)
				&& isPartOfAreaKetteiBotton(img, x2, y2);
	}
	
	private static boolean isPartOfAreaKetteiBotton (BufferedImage img, int x, int y) {
		return RGButil.isAreaKetteiBottonColor(RGButil.averageRGB(img, x, y, 5, 5));
	}
	    
	protected static boolean hasRedSyutugekiKetteiBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 560;
		int y1 = y + 435;
		
		int x2 = x + 700;
		int y2 = y + 435;
		
		return isPartOfRedSyutugekiKetteiBotton(img, x1, y1)
				&& isPartOfRedSyutugekiKetteiBotton(img, x2, y2);
	}
	
	private static boolean isPartOfRedSyutugekiKetteiBotton (BufferedImage img, int x, int y) {
		return RGButil.isRedSyutugekiKetteiBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	
	protected static boolean hasOrangeSyutugekiKetteiBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 560;
		int y1 = y + 435;
		
		int x2 = x + 700;
		int y2 = y + 435;
		
		return isPartOfOrangeSyutugekiKetteiBotton(img, x1, y1)
				&& isPartOfOrangeSyutugekiKetteiBotton(img, x2, y2);
	}
	
	private static boolean isPartOfOrangeSyutugekiKetteiBotton (BufferedImage img, int x, int y) {
		return RGButil.isOrangeSyutugekiKetteiBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	 
	protected static boolean hasGraySyutugekiKetteiBotton (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 560;
		int y1 = y + 435;
		
		int x2 = x + 700;
		int y2 = y + 435;
		
		return isPartOfGraySyutugekiKetteiBotton(img, x1, y1)
				&& isPartOfGraySyutugekiKetteiBotton(img, x2, y2);
	}
	
	private static boolean isPartOfGraySyutugekiKetteiBotton (BufferedImage img, int x, int y) {
		return RGButil.isGraySyutugekiKetteiBottonColor(RGButil.averageRGB(img, x, y, 10, 10));
	}
	//end
	
	// Singeki
	protected static boolean hasExpVerticalLine (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 49;
		int y1 = y + 77;
		int w1 = 3;
		int h1 = 98;
		
		int x2 = x + 394;
		int y2 = y + 77;
		int w2 = 2;
		int h2 = 366;
		
		return RGButil.isWhite(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isWhite(RGButil.averageRGB(img, x2, y2, w2, h2));
	}

	protected static BufferedImage[] getKanmusuArray(BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int kanmusu_w = 160;
		int kanmusu_h = 40;
		
		int x1 = x + 195;
		int y1 = y + 189;
		int y2 = y1 + 45;
		int y3 = y2 + 45;
		int y4 = y3 + 45;
		int y5 = y4 + 45;
		int y6 = y5 + 45;
		
		BufferedImage[] imga = new BufferedImage[6];
		imga[0] = img.getSubimage(x1, y1, kanmusu_w, kanmusu_h);
		imga[1] = img.getSubimage(x1, y2, kanmusu_w, kanmusu_h);
		imga[2] = img.getSubimage(x1, y3, kanmusu_w, kanmusu_h);
		imga[3] = img.getSubimage(x1, y4, kanmusu_w, kanmusu_h);
		imga[4] = img.getSubimage(x1, y5, kanmusu_w, kanmusu_h);
		imga[5] = img.getSubimage(x1, y6, kanmusu_w, kanmusu_h);
		return imga;
	}
	
	protected static boolean hasHari (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 399;
		int y1 = y + 205;
		int w1 = 3;
		int h1 = 20;
		
		int x2 = x + 399;
		int y2 = y + 253;
		int w2 = 3;
		int h2 = 20;
		
		return RGButil.isRashinbanRedColor(RGButil.averageRGB(img, x1, y1, w1, h1))
				&& RGButil.isRashinbanBlackColor(RGButil.averageRGB(img, x2, y2, w2, h2));
	}
	
	protected static boolean hasTugiRing (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 733;
		int y1 = y + 413;
		
		int x2 = x + 773;
		int y2 = y + 413;
		
		int x3 = x + 733;
		int y3 = y + 449;
		
		int x4 = x + 773;
		int y4 = y + 449;
		
		return isPartOfClickRing(img, x1, y1)
				&& isPartOfClickRing(img, x2, y2)
				&& isPartOfClickRing(img, x3, y3)
				&& isPartOfClickRing(img, x4, y4);
	}
	
	private static boolean isPartOfClickRing (BufferedImage img, int x, int y) {
		return RGButil.isClicRingColor(RGButil.averageRGB(img, x, y, 3, 3));
	}
	
	protected static boolean hasKaeruRing (BufferedImage img) {
		int x = KanColle.getKanColle().getX();
		int y = KanColle.getKanColle().getY();
		
		int x1 = x + 740;
		int y1 = y + 421;
		
		int x2 = x + 778;
		int y2 = y + 421;
		
		int x3 = x + 741;
		int y3 = y + 459;
		
		int x4 = x + 776;
		int y4 = y + 458;
		
		return isPartOfClickRing(img, x1, y1)
				&& isPartOfClickRing(img, x2, y2)
				&& isPartOfClickRing(img, x3, y3)
				&& isPartOfClickRing(img, x4, y4);
	}
	
	protected static boolean hasKaeruRingBuffer (BufferedImage img, int x, int y) {
		int x1 = x + 740;
		int y1 = y + 421;
		
		int x2 = x + 778;
		int y2 = y + 421;
		
		int x3 = x + 741;
		int y3 = y + 459;
		
		int x4 = x + 776;
		int y4 = y + 458;
		
		return isPartOfClickRing(img, x1, y1)
				&& isPartOfClickRing(img, x2, y2)
				&& isPartOfClickRing(img, x3, y3)
				&& isPartOfClickRing(img, x4, y4);
	}

}

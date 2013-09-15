package KanColle;

import java.awt.image.BufferedImage;

public class RGButil {

	protected static int red(int c){
        return c>>16 & 0xff;
    }
	
    protected static int green(int c){
        return c>>8 & 0xff;
    }
    
    protected static int blue(int c){
        return c & 0xff;
    }

    protected static int convert(int r, int g, int b) {
    	return r<<16 | g<<8 | b;
    }
    
    protected static boolean greater (int rgb, int r1, int g1, int b1) {
    	return r1 < red(rgb) && g1 < green(rgb) && b1 < blue(rgb);
    }

    protected static boolean less (int rgb, int r1, int g1, int b1) {
    	return r1 > red(rgb) && g1 > green(rgb) && b1 > blue(rgb);
    }
    
    protected static int averageRGB(BufferedImage img, int x, int y, int width, int heigth) {
    	int r = 0;
    	int g = 0;
    	int b = 0;
    	int aria = width * heigth;
    	
    	for (int i = 0; i < width; i++) {
			for (int j = 0; j < heigth; j++) {
				int rgb = img.getRGB(x + i, y + j);
				r += red(rgb);
				g += green(rgb);
				b += blue(rgb);
			}
		}
		r /= aria;
		g /= aria;
		b /= aria;
		
    	return convert(r, g, b);
    }
    
    protected static void printRGB(int rgb) {
    	System.out.println("red"+red(rgb)+" green"+green(rgb)+" blue"+blue(rgb));
    }
    
    protected static boolean isWhite(int rgb) {
    	return greater(rgb, 240, 240, 240);
	}
    
    // Bokou Top Colors
    protected static boolean isBokouRingColor(int rgb) { return blue(rgb) < 100 && 100 < red(rgb) && 100 < green(rgb); }
    protected static boolean isMenueRingColor(int rgb) { return greater(rgb, 100, 100, 0) && less(rgb, 250, 250, 100); }
    protected static boolean isMenueRingGray (int rgb) { return greater(rgb, 40, 40, 40) && less(rgb, 60, 60, 60); }
    
    // Bokou Sub Menue Colors 
    protected static boolean isMenueLineColor (int rgb) { return greater(rgb, 0, 0, 0) && less(rgb, 120, 120, 120); }
    protected static boolean isChoosenSubmenueColor (int rgb) { return greater(rgb, 150, 100, 0) && less(rgb, 250, 200, 50); }
    protected static boolean isFreeSubmenueColor(int rgb) { return greater(rgb, 0, 100, 100) && less(rgb, 100, 200, 100); }
    
    // Hokyu Colors
    protected static boolean isHokyuDekiruBottonColor(int rgb) { return greater(rgb, 67, 67, 67) && less(rgb, 69, 69, 69); }
    protected static boolean isHokyuDekinaiBottonColor(int rgb) { return greater(rgb, 130, 130, 130) && less(rgb, 170, 170, 170); }
    protected static boolean isGreenHokyuKetteiBottonColor(int rgb) { return greater(rgb, 50, 150, 150) && less(rgb, 100, 210, 210); }
    protected static boolean isGrayHokyuKetteiBottonColor(int rgb) { return greater(rgb, 90, 90, 90) && less(rgb, 110, 110, 110); }
    
    // Syutugeki Colors
    protected static boolean isSyutugekiCircleBottonColor(int rgb) { return greater(rgb, 200, 60, 60) && less(rgb, 250, 120, 120); }
    protected static boolean isEnsyuCircleBottonColor(int rgb) { return greater(rgb, 80, 150, 60) && less(rgb, 170, 230, 140); }
    protected static boolean isEnseiCircleBottonColor(int rgb) { return greater(rgb, 30, 150, 150) && less(rgb, 90, 240, 220); }
//    protected static boolean isChoosenCircleiBottonColor(int rgb) { return greater(rgb, , , ) && less(rgb, , , ); }
    protected static boolean isAreaRectangleColor(int rgb) { return greater(rgb, 230, 220, 210) && less(rgb, 245, 240, 230); }
    protected static boolean isAreaKetteiBottonColor(int rgb) { return greater(rgb, 20, 50, 50) && less(rgb, 70, 170, 170); }
    protected static boolean isRedSyutugekiKetteiBottonColor(int rgb) { return greater(rgb, 150, 30, 30) && less(rgb, 250, 100, 100); }
    protected static boolean isOrangeSyutugekiKetteiBottonColor(int rgb) { return greater(rgb, 180, 50, 0) && less(rgb, 250, 150, 50); }
    protected static boolean isGraySyutugekiKetteiBottonColor(int rgb) { return greater(rgb, 20, 20, 20) && less(rgb, 100, 100, 100); }
    
    // Singeki Colors
    protected static boolean isClicRingColor(int rgb) { return greater(rgb, 0, 100, 100) && less(rgb, 50, 200, 200); }
    protected static boolean isWhiteZiColor(int rgb) { return greater(rgb, 190, 190, 170) && less(rgb, 257, 257, 257); }
    protected static boolean isRashinbanRedColor(int rgb) { return greater(rgb, 100, 0, 0) && less(rgb, 200, 50, 50); }
    protected static boolean isRashinbanBlackColor(int rgb) { return greater(rgb, 0, 0, 0) && less(rgb, 50, 50, 50); }
    protected static boolean isTaihaRed(int rgb) { return greater(rgb, 50, 0, 0) && less(rgb, 100, 50, 50); }
    protected static boolean isTyuhaOrange(int rgb) { return greater(rgb, 240, 170, 80) && less(rgb, 257, 200, 110); }
    protected static boolean isSyohaYellow(int rgb) { return greater(rgb, 230, 210, 80) && less(rgb, 250, 240, 100); }
    
    // Nyukyo Colors
    protected static boolean isEmptyDogColor(int rgb) { return false; }
}

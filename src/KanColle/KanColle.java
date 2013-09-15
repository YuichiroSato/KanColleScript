package KanColle;
import java.awt.image.BufferedImage;
import Script.Damage;

public class KanColle {
	
	static public KanColle kancolle;
	
	final int width = 799;
	final int height = 479;
	
	int KanColleGamenX;
	int KanColleGamenY;
	
	int buf_x;
	int buf_y;
	
	static public KanColle getKanColle() {
		if (kancolle == null)
			kancolle = new KanColle();
		return kancolle;
	}
	
	private KanColle() {
		KanColleGamenX = 0;
		KanColleGamenY = 0;
		buf_x = 0;
		buf_y = 0;
	}
	
	public void findKanColleGamen(BufferedImage img) {
		int[] xy = Geometry.findKanColleGamenOrigin(img);
		KanColleGamenX = xy[0];
		KanColleGamenY = xy[1];
	}
	
	public boolean bufferKanColleGamenXY() {
		if (isReasonableKanColleGamenXY()) {
			buf_x = KanColleGamenX;
			buf_y = KanColleGamenY;
			return true;
		}
		return false;
	}
	
	public boolean hasKanColleGamen (BufferedImage img) {
		findKanColleGamen(img);
		return isReasonableKanColleGamenXY();
	}
	
	private boolean isReasonableKanColleGamenXY () {
		return 0 < KanColleGamenX && 0 < KanColleGamenY;
	}
	
	public boolean gamenLost (BufferedImage img) {
		return !isReasonableKanColleGamenXY()
				|| !Geometry.isOriginOfKanColleGamen(img, KanColleGamenX, KanColleGamenY);
	}
	
	public boolean isBokou (BufferedImage img) {
		return Geometry.hasBokouRing(img);
	}
	
	public boolean isBokouTop (BufferedImage img) {
		return Geometry.hasBokouRing(img) && Geometry.hasSyutugekiRing(img);
	}
	
	public boolean isMenue (BufferedImage img) {
		return isBokou(img) && Geometry.hasMenueLine(img);
	}
	
	public boolean isHokyu (BufferedImage img) {
		return isMenue(img) && Geometry.hasChoosenHokyu(img);
	}
	
	public int choosenKantaiInHokyu (BufferedImage img) {
		return 0; //sutabu
	}
	
	public boolean isKantai1ChoosenInHokyu (BufferedImage img) {
		return 1 == choosenKantaiInHokyu(img);
	}
	
	public boolean isNyukyo (BufferedImage img) {
		return isMenue(img) && Geometry.hasChoosenNyukyo(img);
	}
	
	public boolean needHokyu (BufferedImage img) {
		return isHokyu(img) && Geometry.hasHokyuDekiru(img);
	}
	
	public boolean readyHokyu (BufferedImage img) {
		return Geometry.hasGreenHokyuKetteiBotton(img) && !Geometry.hasGrayHokyuKetteiBotton(img);
	}
	
	// Syutugeki
	public boolean isCircleBottonGamen (BufferedImage img) {
		int count = 0;
		if (Geometry.hasSyutugekiCircleBotton(img))
			count++;
		if (Geometry.hasEnsyuCircleBotton(img))
			count++;
		if (Geometry.hasEnseiCircleBotton(img))
			count++;
		return 2 <= count;
	}
	
	public boolean isAreaSentakuGamen (BufferedImage img) {
		return Geometry.hasAreaRectangles(img);
	}
	
	public boolean readyAreaKettei (BufferedImage img) {
		return Geometry.hasAreaKetteiBotton(img);
	}
	
	public boolean readySyutugekiKettei (BufferedImage img) {
		return Geometry.hasRedSyutugekiKetteiBotton(img) || Geometry.hasOrangeSyutugekiKetteiBotton(img);
	}
	//end
	
	// Singeki
	public boolean isChooseZinkei (BufferedImage img) {
		return false;
	}
	
	public boolean isTuigekisezu_Yasen (BufferedImage img) {
		return Kanzi.hasTuigekisezu(img) && Kanzi.hasYasen(img);
	}
	
	public boolean isSingeki_Tettai (BufferedImage img) {
		return Kanzi.hasShingeki(img) && Kanzi.hasTettai(img);
	}

	public boolean isSenkaHoukoku (BufferedImage img) {
		return Geometry.hasTugiRing(img) && Kanzi.hasTugi(img);
	}

	public boolean isExpHoukoku (BufferedImage img) {
		return Geometry.hasExpVerticalLine(img);
	}

	public boolean hasRasinban (BufferedImage img) {
		return Geometry.hasHari(img);
	}

	public boolean isGet(BufferedImage img) {
		if (isReasonableKanColleGamenXY())
			return Kanzi.hasKaeru(img) && Geometry.hasKaeruRing(img);
		return Kanzi.hasKaeruBuffer(img, buf_x, buf_y) && Geometry.hasKaeruRingBuffer(img, buf_x, buf_y);
	}
	
	
	// Damage recognition
	public Damage damageCheck(BufferedImage img) {
		BufferedImage[] kanmusu = Geometry.getKanmusuArray(img);
		int taiha = countupTaiha(kanmusu);
		int tyuha = countupTyuha(kanmusu);
		int syoha = countupSyoha(kanmusu);
		return new Damage(taiha, tyuha, syoha);
	}
	
	private int countupTaiha(BufferedImage[] imga) {
		int c = 0;
		for (int i = 0; i < imga.length; i++) {
			if (KanColle.getKanColle().isTaiha(imga[i]))
				c++;
		}
		return c;
	}
	
	private int countupTyuha(BufferedImage[] imga) {
		int c = 0;
		for (int i = 0; i < imga.length; i++) {
			if (KanColle.getKanColle().isTyuha(imga[i]))
				c++;
		}
		return c;
	}

	private int countupSyoha(BufferedImage[] imga) {
		int c = 0;
		for (int i = 0; i < imga.length; i++) {
			if (KanColle.getKanColle().isSyoha(imga[i]))
				c++;
		}
		return c;
	}
	
	private boolean isTaiha(BufferedImage img) {
		return Kanzi.isTaiha(img);
	}
	
	private boolean isTyuha(BufferedImage img) {
		return Kanzi.isTyuha(img);
	}

	private boolean isSyoha(BufferedImage img) {
		return Kanzi.isSyoha(img);
	}

	// getter
	public int getX() { return KanColleGamenX; }
	public int getY() { return KanColleGamenY; }
	public int getWidth() { return width; }
	public int getHeigth() { return height; }
    
	// XY of Menues in Bokou top
    public int getBokouBottonX() { return KanColleGamenX + 40; }
    public int getBokouBottonY() { return KanColleGamenY + 40; }
    public int getSyutugekiBottonX() { return KanColleGamenX + 200; }
    public int getSyutugekiBottonY() { return KanColleGamenY + 265; }
    public int getHenseiBottonX() { return KanColleGamenX + 200; }
    public int getHenseiBottonY() { return KanColleGamenY + 135; }
    public int getKaisouBottonX() { return KanColleGamenX + 320; }
    public int getKaisouBottonY() { return KanColleGamenY + 220; }
    public int getKousyouBottonX() { return KanColleGamenX + 270; }
    public int getKousyouBottonY() { return KanColleGamenY + 365; }
    public int getNyukyoBottonX() { return KanColleGamenX + 120; }
    public int getNyukyoBottonY() { return KanColleGamenY + 365; }
    public int getHokyuBottonX() { return KanColleGamenX + 75; }
    public int getHokyuBottonY() { return KanColleGamenY + 220; }
    
    // XY of submenue
    public int getSubHenseiBottonX() { return KanColleGamenX + 25; }
    public int getSubHenseiBottonY() { return KanColleGamenY + 150; }
    public int getSubKaisouBottonX() { return KanColleGamenX + 25; }
    public int getSubKaisouBottonY() { return KanColleGamenY + 260; }
    public int getSubKousyouBottonX() { return KanColleGamenX + 25; }
    public int getSubKousyouBottonY() { return KanColleGamenY + 370; }
    public int getSubNyukyoBottonX() { return KanColleGamenX + 125; }
    public int getSubNyukyoBottonY() { return KanColleGamenY + 315; }
    public int getSubHokyuBottonX() { return KanColleGamenX + 25; }
    public int getSubHokyuBottonY() { return KanColleGamenY + 205; }
    
    // Syutugeki Botton XY
    public int getSyutugekiCircleBottonX() { return KanColleGamenX + 230; }
    public int getSyutugekiCircleBottonY() { return KanColleGamenY + 210; }
    public int getEnsyuCircleBottonX() { return KanColleGamenX + 450; }
    public int getEnsyuCircleBottonY() { return KanColleGamenY + 210; }
    public int getEnseiCircleBottonX() { return KanColleGamenX + 680; }
    public int getEnseiCircleBottonY() { return KanColleGamenY + 210; }
    public int getAreax_1X() { return KanColleGamenX + 285; }
    public int getAreax_1Y() { return KanColleGamenY + 200; }
    public int getAreax_2X() { return KanColleGamenX + 630; }
    public int getAreax_2Y() { return KanColleGamenY + 200; }
    public int getAreax_3X() { return KanColleGamenX + 285; }
    public int getAreax_3Y() { return KanColleGamenY + 350; }
    public int getAreax_4X() { return KanColleGamenX + 630; }
    public int getAreax_4Y() { return KanColleGamenY + 350; }
    public int getArea1_xX() { return KanColleGamenX + 155; }
    public int getArea1_xY() { return KanColleGamenY + 440; }
    public int getArea2_xX() { return KanColleGamenX + 235; }
    public int getArea2_xY() { return KanColleGamenY + 440; }
    public int getArea3_xX() { return KanColleGamenX + 310; }
    public int getArea3_xY() { return KanColleGamenY + 440; }
    public int getArea4_xX() { return KanColleGamenX + 380; }
    public int getArea4_xY() { return KanColleGamenY + 440; }
    public int getAreaKetteiBottonX() { return KanColleGamenX + 675; }
    public int getAreaKetteiBottonY() { return KanColleGamenY + 445; }
    public int getSyutugekiKetteiBottonX() { return KanColleGamenX + 630; }
    public int getSyutugekiKetteiBottonY() { return KanColleGamenY + 445; }
    
    // Hokyu XY
    // Botton to choose all kanmusu for hokyu
    public int getKantaiHokyuBottonX() { return KanColleGamenX + 120; }
    public int getKantaiHokyuBottonY() { return KanColleGamenY + 120; }
    
    // Botton to do hokyu
    public int getHokyuKetteiBottonX() { return KanColleGamenX + 700; }
    public int getHokyuKetteiBottonY() { return KanColleGamenY + 444; }
    
    // XY of Singeki botton
    public int getTuigekisezuBottonX() { return KanColleGamenX + 295; }
    public int getTuigekisezuBottonY() { return KanColleGamenY + 240; }
    public int getYasenBottonX() { return KanColleGamenX + 510; }
    public int getYasenBottonY() { return KanColleGamenY + 240; }
    public int getSingekiBottonX() { return KanColleGamenX + 295; }
    public int getSingekiBottonY() { return KanColleGamenY + 240; }
    public int getTettaiBottonX() { return KanColleGamenX + 510; }
    public int getTettaiBottonY() { return KanColleGamenY + 240; }
    public int getTugiBottonX() { return KanColleGamenX + 750; }
    public int getTugiBottonY() { return KanColleGamenY + 435; }
    public int getKaeruBottonX() { if (!(-1 == KanColleGamenX)) return KanColleGamenX + 760; else return buf_x + 760; }
    public int getKaeruBottonY() { if (!(-1 == KanColleGamenY)) return KanColleGamenY + 440; else return buf_y + 440; }
    public int getRasinbanX() { return KanColleGamenX + 400; }
    public int getRasinbanY() { return KanColleGamenY + 240; }
}
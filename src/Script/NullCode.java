package Script;

import java.awt.image.BufferedImage;

public class NullCode implements Code{

	public void excute(BufferedImage img) {
		;
	}
	
	public boolean isFinished(BufferedImage img) {
		return true;
	}
	
	public boolean isErrer(BufferedImage img) {
		return false;
	}
}

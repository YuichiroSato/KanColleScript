package Script;
import java.awt.image.BufferedImage;


public interface Code {

	public void excute(BufferedImage img);
	public boolean isFinished(BufferedImage img);
	public boolean isErrer(BufferedImage img);
}

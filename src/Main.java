import MainThread.MainThread;
import Script.Program;
import java.io.File;


public class Main{

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Program program = new Program(new File("sirei.kcs"));
		MainThread main_thread = new MainThread(program);
		Thread t = new Thread(main_thread);
		t.start();
	    
	}
}

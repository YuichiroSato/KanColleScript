package Script;
import java.util.LinkedList;

public class Leaf extends Tag{

	public Leaf(String t) {
		super(t);
	}
	
	public LinkedList<Node> getArgs() {
		return null;
	}
	
	public String toString() {
		return "<Leaf "+tag+">";
	}

}

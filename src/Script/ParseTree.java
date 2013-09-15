package Script;

import java.util.Iterator;

public class ParseTree {

	Node top_node;
	
	public ParseTree() {
		top_node = new Node("top");
	}
	
	public void addCode(Tag n) {
		top_node.addArgs(n);
	}
	
	public Iterator<Tag> getCode() {
		return top_node.getArgs().iterator();
	}
	
	public String toString() {
		return top_node.toString();
	}
}

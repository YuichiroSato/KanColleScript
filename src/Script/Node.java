package Script;

import java.util.*;

public class Node extends Tag{

	LinkedList<Tag> args;
	
	public Node(String t) {
		super(t);
		args = new LinkedList<Tag>();
	}
	
	public Node(String t, LinkedList<Tag> l) {
		super(t);
		args = l;
	}
	
	public void addArgs(Tag node) {
		args.add(node);
	}
	
	public LinkedList<Tag> getArgs() {
		return args;
	}
	
	public String toString() {
		String str = "(<Tag "+tag+"> ";
		int c = 0;		
		for (Iterator<Tag> i = args.iterator(); i.hasNext();) {
			str += "[arg"+c+" "+i.next().toString()+"] ";
			c++;
		}
		return str+")";
	}
}

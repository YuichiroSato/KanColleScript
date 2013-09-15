package Script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;


public class Parser {

	File source;
	String string_code;
	int head;
	
	public Parser() {
		source = null;
		string_code = "";
		head = 0;
	}
	public Parser(File f) {
		source = f;
		string_code = readFile();
		head = 0;
	}
	
	public String readFile() {
		String code = "";
		try {
			FileReader r = new FileReader(source);
			BufferedReader br = new BufferedReader(r);
			String tem = "";
			while((tem = br.readLine()) != null)
				code += tem;
			br.close();
			//System.out.println(string_code);
		} catch (Exception e) {
			;
		}
		return code;
	}
	
	public ParseTree getParseTree() {
		if (!parenthesisCheck(string_code))
			return new ParseTree();
		return parse(string_code);
	}

	private boolean parenthesisCheck(String str) {
		int c = 0;
		int i = 0;
		
		while(i < str.length()) {
			String chr = str.substring(i, i + 1); 
			if (chr.equals("("))
				c++;
			else if (chr.equals(")"))
				c--;
			if (c < 0)
				return false;
			i++;
		}
		
		if (c != 0)
			return false;
		return true;
	}

	private ParseTree parse(String str) {
		ParseTree tree = new ParseTree();
		String top = getTopBlock(str);
		
		if (getOperator(top).equals("main")) {
			top = removeOperator(top);
			LinkedList<String> args = parseArgs(top);
			for (Iterator<String> i = args.iterator(); i.hasNext();)
				tree.addCode(recursiveParse(i.next()));
		}
		return tree;
	}
	
	private String getTopBlock(String str) {
		str = skipSpacer(str);
		return str.substring(0, tailOfTopBlock(str));
	}
	
	private String removeTopBlock(String str) {
		str = skipSpacer(str);
		return str.substring(tailOfTopBlock(str));
	}
	
	private int tailOfTopBlock(String str) {
		str = skipSpacer(str);
		int i = 1;
		int c = 1;
		
		while (i < str.length() && c != 0) {
			if (str.substring(i,i+1).equals(")"))
				c--;
			else if (str.substring(i,i+1).equals("("))
				c++;
			i++;
		}
		return i;
	}
	
	private String getOperator(String str) {
		str = skipSpacer(str);
		return str.substring(1,nextSpacer(str));
	}
	
	private String removeOperator(String str) {
		str = skipSpacer(str);
		return str.substring(nextSpacer(str));
	}
	
	private String skipSpacer(String str) {
		int i = 0;
		while (i < str.length()) {
			if (!isSpacer(str.substring(i,i+1)))
				break;
			i++;
		}
		return str.substring(i);
	}
	
	private int nextSpacer(String str) {
		int i = 0;
		while (i < str.length()) {
			if (isSpacer(str.substring(i,i+1)))
				break;
			i++;
		}
		return i;
	}
	
	private Tag recursiveParse(String str) {
		Tag new_tag = null;
		str = skipSpacer(str);
		
		if (isStartOfBlock(str)) {
		    String tag = getOperator(str);
			str = removeOperator(str);
			new_tag = new Node(tag);
			
			LinkedList<String> args = parseArgs(str);
			for (Iterator<String> i = args.iterator(); i.hasNext();)
				((Node)new_tag).addArgs(recursiveParse(i.next()));
		}
		else {
			new_tag = new Leaf(getOperant(str));
		}
		return new_tag;
	}
	
	private LinkedList<String> parseArgs(String str) {
		LinkedList<String> args = new LinkedList<String>();
		while(!isEndOfBlock(str)) {
			str = skipSpacer(str);
			if (isStartOfBlock(str)) {
				args.add(getTopBlock(str));
				str = removeTopBlock(str);
			}
			else {
		        args.add(getOperant(str));
		        str = removeOperant(str);
			}
		}
		return args;
	}
	
	private String getOperant(String str) {
		str = skipSpacer(str);
		return str.substring(0,endOfOperant(str));
	}

	private String removeOperant(String str) {
		str = skipSpacer(str);
		return str.substring(endOfOperant(str));
	}
	
	private int endOfOperant(String str) {
		str = skipSpacer(str);
		int i = 0;
		while (i < str.length()) {
			String chr = str.substring(i,i+1);
			if (isSpacer(chr) || isEndOfBlock(chr))
				break;
			i++;
		}
        return i;
	}
	
	private boolean isEndOfBlock(String str) {
		return str.substring(0,1).equals(")");
	}

	private boolean isStartOfBlock(String str) {
		return str.substring(0,1).equals("(");
	}

	private boolean isSpacer(String str) {
		return str.equals(" ") || str.equals("\n") || str.equals("\t");
	}
	
}

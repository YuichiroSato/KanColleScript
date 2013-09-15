package Script;

import java.util.Iterator;
import java.util.LinkedList;

import State.HokyuState;
import State.SyutugekiState;
import State.SingekiState;

public class CodeGenerator {

	ParseTree tree;
	Program super_program;
	
	public CodeGenerator(ParseTree pt, Program p) {
		tree = pt;
		super_program = p;
	}
	
	public Code[] getCode() {
		LinkedList<Code> code = new LinkedList<Code>();
		for (Iterator<Tag> i = tree.getCode(); i.hasNext();) {
			code.add(createCode(i.next()));
		}

		Code[] arr = new Code[code.size()];
		int j = 0;
		for (Iterator<Code> i = code.iterator(); i.hasNext();) {
			arr[j] = i.next();
			j++;
		}
		return arr;
	}
	
	private Code createCode(Tag n) {
		String tag = n.getTag();
		switch(tag) {
			case "hokyu":
				return createHokyuCode(n);
			case "syutugeki":
				return createSyutugekiCode(n);
			case "singeki":
				return createSingekiCode(n);
		}
		return new NullCode();
	}
	
	private Code createHokyuCode(Tag n) {
		return new HokyuState(super_program);
	}
	
	private Code createSyutugekiCode(Tag n) {
		String area = "1-1";
		Tag tag = ((Node)n).getArgs().get(0);
		if (tag.getTag().equals("area"))
			area = ((Node)tag).getArgs().get(0).getTag();
		return new SyutugekiState(area,super_program);
	}

	private Code createSingekiCode(Tag n) {
		boolean yasen = false;
		Damage d = new Damage(7,7,7);
		
		LinkedList<Tag> args = ((Node)n).getArgs();
		for (Iterator<Tag> i = args.iterator(); i.hasNext();) {
			Node t = (Node)i.next();
			String tag = t.getTag();
			switch (tag) {
			    case "yasen":
			    	yasen = Boolean.valueOf(t.getArgs().get(0).getTag());
			    	break;
			    case "damage":
			    	int tai = 7;
			    	int tyu = 7;
			    	int syo = 7;
			    	for (Iterator<Tag> j = t.getArgs().iterator(); i.hasNext();) {
			    		Node node = (Node)j.next();
			    		String type = node.getTag();
			    		switch (type) {
			    		    case "taiha":
			    			    tai = Integer.valueOf(node.getArgs().get(0).getTag());
			    			    break;
			    		    case "tyuha":
			    			    tyu = Integer.valueOf(node.getArgs().get(0).getTag());
			    			    break;
			    		    case "syoha":
			    			    syo = Integer.valueOf(node.getArgs().get(0).getTag());
			    			    break;
			    		}
			    	}
			    	d = new Damage(tai,tyu,syo);
			    	break;
			}
		}
		return new SingekiState(d, yasen, super_program);
	}

}

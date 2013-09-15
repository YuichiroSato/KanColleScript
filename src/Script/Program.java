package Script;

import java.io.*;


public class Program {

	Code[] code;
	int program_counter;
	boolean just_finished;
	ParseTree tree;
	
	public Program(File source) {
		Parser parser = new Parser(source);
		tree = parser.getParseTree();
		CodeGenerator cg = new CodeGenerator(tree, this);
		code = cg.getCode();
		program_counter = 0;
		just_finished = false;
	}
	
	private Code[] newCode () {
		program_counter = 0;
		CodeGenerator cg = new CodeGenerator(tree, this);
		return cg.getCode();
	}
	
	public Code getCurrent() {
		return code[program_counter];
	}
	
	public Code getNext() {
		program_counter++;
		if (code.length <= program_counter) {
			code = newCode();
			just_finished = true;
		}
		return code[program_counter];
	}
	
	public boolean justFinished() {
		if (just_finished) {
			just_finished = false;
			return true;
		}
		return false;
	}
}

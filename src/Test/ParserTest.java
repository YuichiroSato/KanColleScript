package Test;

import java.io.File;
import java.lang.reflect.*;
import Script.Parser;
import Script.ParseTree;
import Script.Node;
import Script.Tag;


import junit.framework.TestCase;

import java.util.Iterator;
import java.util.LinkedList;

public class ParserTest extends TestCase {

	Parser parser;
	public ParserTest() {
		parser = new Parser(new File("./src/Test/ParserTest.kcs"));
	}
	
	public void testgenerateCode() {
//		parser.generateCode();
	}
	
	public void testparse() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("parse", args);
	        m.setAccessible(true);

	        String str = " (main (hokyu 1)    (syu (area 3-2) true)  (sin (tai 2)))";
	        ParseTree res = (ParseTree) m.invoke(c.newInstance(), str);
//	        System.out.println(res.toString());
	        for (Iterator<Tag> i = res.getCode(); i.hasNext();)
	            assertEquals(true,i.next() instanceof Node);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public void testgetTopBlock() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("getTopBlock", args);
	        m.setAccessible(true);

	        String str = " (hoge (hoge 2)) (hoge 3)";
	        String res = (String) m.invoke(c.newInstance(), str);
	        assertEquals("(hoge (hoge 2))",res);
	        
	        String str2 = "hoge (hoge (hoge 300))) (main hoge)";
	        String res2 = (String) m.invoke(c.newInstance(), str2);
	        assertEquals("hoge (hoge (hoge 300)))",res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public void testremoveTopBlock() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("removeTopBlock", args);
	        m.setAccessible(true);

	        String str = " (hoge (hoge 2)) (hoge 3)";
	        String res = (String) m.invoke(c.newInstance(), str);
	        assertEquals(" (hoge 3)",res);
	        
	        String str2 = "hoge (hoge (hoge 300))) (main hoge)";
	        String res2 = (String) m.invoke(c.newInstance(), str2);
	        assertEquals(" (main hoge)",res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public void testtailOfTopBlock() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("tailOfTopBlock", args);
	        m.setAccessible(true);

	        String str = "(h (h 2)) (hoge 3)";
	        int res = (int) m.invoke(c.newInstance(), str);
	        assertEquals(9,res);
	        
	        String str2 = "e (ho (h 300))) (main hoge)";
	        int res2 = (int) m.invoke(c.newInstance(), str2);
	        assertEquals(15,res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public void testgetOperator() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("getOperator", args);
	        m.setAccessible(true);

	        String str = "(hoge 3)";
	        String res = (String) m.invoke(c.newInstance(), str);
	        assertEquals("hoge",res);
	        
	        String str2 = "   (main hoge)";
	        String res2 = (String) m.invoke(c.newInstance(), str2);
	        assertEquals("main",res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public void testremoveOperator() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("removeOperator", args);
	        m.setAccessible(true);

	        String str = "hoge 3)";
	        String res = (String) m.invoke(c.newInstance(), str);
	        assertEquals(" 3)",res);
	        
	        String str2 = "   (main hoge)";
	        String res2 = (String) m.invoke(c.newInstance(), str2);
	        assertEquals(" hoge)",res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	
	public void testskipSpacer() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("skipSpacer", args);
	        m.setAccessible(true);

	        String str = "	(hoge 3)";
	        String res = (String) m.invoke(c.newInstance(), str);
	        assertEquals("(hoge 3)",res);
	        
	        String str2 = "   (main hoge)";
	        String res2 = (String) m.invoke(c.newInstance(), str2);
	        assertEquals("(main hoge)",res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public void testnextSpacer() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("nextSpacer", args);
	        m.setAccessible(true);

	        String str = "hoge 3)";
	        int res = (int) m.invoke(c.newInstance(), str);
	        assertEquals(4,res);
	        
	        String str2 = "mainloop hoge)";
	        int res2 = (int) m.invoke(c.newInstance(), str2);
	        assertEquals(8,res2);
	        
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public void testrecursiveParse() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("recursiveParse", args);
	        m.setAccessible(true);

	        String str = "(main (hoge nisin 300))";
	        Tag res = (Tag) m.invoke(c.newInstance(), str);
	        assertEquals("main",res.getTag());
	        assertEquals("hoge",((Node)res).getArgs().get(0).getTag());
	        assertEquals("nisin",((Node)((Node)res).getArgs().get(0)).getArgs().get(0).getTag());
	        assertEquals("300",((Node)((Node)res).getArgs().get(0)).getArgs().get(1).getTag());
	        
	        String str2 = "(singeki (aria 1-1) (if (less (tai 2) (tyu 3) (syo 1))))";
	        Tag res2 = (Tag) m.invoke(c.newInstance(), str2);
	        assertEquals("singeki",res2.getTag());
	        
	        Node node1 = ((Node)((Node)res2).getArgs().get(0));
	        assertEquals("aria",node1.getTag());
	        assertEquals("1-1",node1.getArgs().get(0).getTag());
	        
	        Node node2 = ((Node)((Node)res2).getArgs().get(1));
	        assertEquals("if",node2.getTag());
	        
	        Node node3 = ((Node)node2.getArgs().get(0));
	        assertEquals("less",node3.getTag());
	        
	        Node node4 = ((Node)node3.getArgs().get(0));
	        assertEquals("tai",node4.getTag());
	        assertEquals("2",node4.getArgs().get(0).getTag());
	        
	        Node node5 = ((Node)node3.getArgs().get(1));
	        assertEquals("tyu",node5.getTag());
	        assertEquals("3",node5.getArgs().get(0).getTag());

	        Node node6 = ((Node)node3.getArgs().get(2));
	        assertEquals("syo",node6.getTag());
	        assertEquals("1",node6.getArgs().get(0).getTag());

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}


	public void testparseArgs() {
		try {
		    Class[] args = { String.class };
	        Class<Parser> c = Parser.class;
	        Method m = c.getDeclaredMethod("parseArgs", args);
	        m.setAccessible(true);

	        String str = " (hoge nisin) 300 (hoge (hoge 400) (min 200)))";
	        LinkedList<String> res = (LinkedList<String>) m.invoke(c.newInstance(), str);
	        assertEquals("(hoge nisin)",res.get(0));
	        assertEquals("300",res.get(1));
	        assertEquals("(hoge (hoge 400) (min 200))",res.get(2));
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}

package KanColle;

import org.junit.Test;

import junit.framework.TestCase;

public class RGButilTest extends TestCase {

	
	@Test
	public void testRed() {
		int inp = 0xff0000;
		int res = RGButil.red(inp);
		int exp = 0x0000ff;
		assertEquals(res,exp);
	}

	public void testBlue() {
		int inp = 0x0000ee;
		int res = RGButil.blue(inp);
		int exp = 0x0000ee;
		assertEquals(res,exp);
	}

	public void testGreen() {
		int inp = 0x001100;
		int res = RGButil.green(inp);
		int exp = 0x000011;
		assertEquals(res,exp);
	}

	public void testConvert() {
		int r = 0x0000ff;
		int g = 0x000043;
		int b = 0x0000ac;
		int res = RGButil.convert(r, g, b);
		int exp = 0xff43ac;
		assertEquals(res, exp);
	}
	
}

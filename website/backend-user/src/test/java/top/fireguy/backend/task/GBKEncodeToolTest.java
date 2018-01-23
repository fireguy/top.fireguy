package top.fireguy.backend.task;

import junit.framework.TestCase;
import top.fireguy.backend.task.GBKEncodeTool;

public class GBKEncodeToolTest extends TestCase {
	public void testGetChnName() {
		String result = GBKEncodeTool.getChnName("NGKELMPONBPJLBLO");
		assertEquals("证件样本", result);
	}
	
	public void testGetGBKCode() {
		String result = GBKEncodeTool.getGBKCode("证件样本");
		assertEquals("NGKELMPONBPJLBLO", result);
	}
}

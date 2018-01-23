import java.io.UnsupportedEncodingException;

public class GBKEncodeTool {
	/**
	 * GBK编码转中文
	 * @param str GBK编码
	 * @return 中文
	 */
	public static String getChnName(String str) {
		String temp = stringToGbk(str);
		byte[] chnName = stringTobyte(temp);
		String name = "";
		try {
			name = new String(chnName, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	/**
	 * 中文转GBK编码
	 * @param str 
	 * @return GBK编码
	 */
	public static String getGBKCode(String chnStr) {
		String str = chnStr.trim();
		byte[] byteStr= {};
		try {
			byteStr = str.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for(byte b : byteStr) {
			sb.append(Integer.toHexString((b & 0xff)).toUpperCase());
		}
		return stringToGbk2(sb.toString());
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String stringToGbk2(String str) {
//		String[][] list = new String[][] { { "0", "A" }, { "1", "B" },
//			{ "2", "C" }, { "3", "D" }, { "4", "E" }, { "5", "F" },
//			{ "6", "G" }, { "7", "H" }, { "8", "I" }, { "9", "J" },
//			{ "A", "K" }, { "B", "L" }, { "C", "M" }, { "D", "N" },
//			{ "E", "O" }, { "F", "P" }, { "G", "Q" }, { "H", "R" },
//			{ "I", "S" }, { "J", "T" }, { "K", "U" }, { "L", "V" },
//			{ "M", "W" }, { "N", "X" }, { "O", "Y" }, { "P", "Z" } };
		StringBuffer sb = new StringBuffer(str.length());
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c > 64 && c < 81) {// A-P (ascii 75-90)
				sb.append((char) (c + 10));
			} else if (c > 48 && c < 58) {// 0-9 (ascii 65-74)
				sb.append((char) (c + 17));
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String stringToGbk(String str) {
//		String[][] list = new String[][] { { "0", "A" }, { "1", "B" },
//		{ "2", "C" }, { "3", "D" }, { "4", "E" }, { "5", "F" },
//		{ "6", "G" }, { "7", "H" }, { "8", "I" }, { "9", "J" },
//		{ "A", "K" }, { "B", "L" }, { "C", "M" }, { "D", "N" },
//		{ "E", "O" }, { "F", "P" }, { "G", "Q" }, { "H", "R" },
//		{ "I", "S" }, { "J", "T" }, { "K", "U" }, { "L", "V" },
//		{ "M", "W" }, { "N", "X" }, { "O", "Y" }, { "P", "Z" } };
		StringBuffer sb = new StringBuffer(str.length());
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c > 74 && c < 91) {// K-Z (ascii 75-90)
				sb.append((char) (c - 10));
			} else if (c > 64 && c < 75) {// 0-9 (ascii 65-74)
				sb.append((char) (c - 17));
			}
		}
		return sb.toString();
	}

	/**
	 * 字符转换
	 * @param str
	 * @return
	 */
	private static byte[] stringTobyte(String str) {
		str = str.toLowerCase();
		byte[] b = new byte[str.length() / 2];
		try {
			for (int i = 0; i < str.length();) {
				String sub = str.substring(i, i + 2);
				int n = Integer.parseInt(sub, 16) - 256;
				b[i / 2] = (byte) n;
				i = i + 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return b;
	}
}

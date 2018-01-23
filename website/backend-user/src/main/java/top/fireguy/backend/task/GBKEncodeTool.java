package top.fireguy.backend.task;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	/**
	 * 获取 国标码
	 * 
	 * @param chineseName
	 * @return
	 */
	public static String getGBCode(String chineseName) {
		// 先判断chinese是否为汉字
		if (!isCharacter(chineseName)){
			return "输入的不是汉字！";
		}
		int jiNeiMa = Integer.parseInt(getJineiMa(chineseName), 16);
		String gbMa = Integer.toHexString(jiNeiMa - 0x8080);
		return gbMa;
	}
	
	/**
	 * 根据机内码获取汉字
	 * @param quWeiMa
	 * @return 汉字
	 */
	public static String getCharacter(String jiNeiMa) {
		byte b1 = (byte) Integer.parseInt(jiNeiMa.substring(0, 2), 16);
		byte b2 = (byte) Integer.parseInt(jiNeiMa.substring(2, 4), 16);

		String str = null;
		try {
			str = new String(new byte[] { b1, b2 }, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 判断str是否为汉字
	 * @param str 待检测值
	 * @return true 是 false 不是
	 */
	public static boolean isCharacter(String str) {
		Pattern p_str = Pattern.compile("[\\u4e00-\\u9fa5]+");
		Matcher m = p_str.matcher(str);
		if (m.find() && m.group(0).equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取机内码
	 * @param chineseName
	 * @return 汉字的机内码 String类型
	 */
	public static String getJineiMa(String chineseName) {
		StringBuffer sb = new StringBuffer();
		try {
			char[] ch = chineseName.toCharArray();
			for (char c : ch) {
				if (isCharacter(String.valueOf(c))) {
					byte[] by = String.valueOf(c).getBytes("GBK");
					for (byte b : by) {
						sb.append(Integer.toHexString(b & 0xff));
					}
				} else {
					byte b = (byte) c;
					sb.append(Integer.toHexString(b & 0xff));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString().toUpperCase().trim();
	}

	/**
	 * 获得汉字区位码
	 * @param chineseName 汉字
	 * @return 单个汉字区位码
	 */
	public static String getLocationCode(String chineseName) {
		// 先判断chinese是否为汉字
		if (!isCharacter(chineseName)) {
			return "输入的不是汉字！";
		}
		String jiNeiMa = getJineiMa(chineseName);
		String highOrder = jiNeiMa.substring(0, 2); // 高位
		String lowOrder = jiNeiMa.substring(2, 4); // 低位
		String quWeiMa = String
				.valueOf((Integer.parseInt(highOrder, 16) - 0xA0))
				+ String.valueOf(Integer.parseInt(lowOrder, 16) - 0xA0);
		return quWeiMa;
	}
}

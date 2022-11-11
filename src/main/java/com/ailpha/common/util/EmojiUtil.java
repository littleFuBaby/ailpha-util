package com.ailpha.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiUtil {
	
	
	/**
	 * 过滤表情符号
	 * @create by ldw on 2016-10-25
	 * @param str
	 * @return str(去掉表情符号的字符串)
	 * @version 1.0
	 * */
	public static String filterEmoji(String str , String newRepStr) {
		if (str.trim().isEmpty()) {
			return str;
		}
		String pattern = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
		String reStr = StringUtils.isEmpty(newRepStr)?newRepStr:"";
		Pattern emoji = Pattern.compile(pattern);
		Matcher emojiMatcher = emoji.matcher(str);
		str = emojiMatcher.replaceAll(reStr);
		return str;
	}

}

package com.haozz.dailylearn.dailylearndetail.dailylearn202008.dailylearn_20200813;

/**
 * @Auther: haozhezhe@yunquna.com
 * @Description:
 * @Date: Created in 19:25 2019/5/14
 * @Modified:
 */
public class StringUtil {

    /**
     * 字符串是否为Null、空字符串组成。
     *
     * @param value
     * @return
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    /**
     * 字符串是否为Null、空字符串或仅由空白字符组成。
     *
     * @param value
     * @return
     */
    public static boolean isNullOrWhiteSpace(String value) {
        return value == null || value.isEmpty() || value.trim().isEmpty();
    }

    /**
     * 从字符串的开头得到一个字符串的子串
     *
     * @param value
     * @param len
     * @return
     */
    public static String left(String value, int len) {
        if (isNullOrWhiteSpace(value) || value.length() < len) {
            return value;
        }
        return value.substring(0, len);
    }

    /**
     * 从字符串的末尾得到一个字符串的子串
     *
     * @param value
     * @param len
     * @return
     */
    public static String right(String value, int len) {
        if (isNullOrWhiteSpace(value) || value.length() < len) {
            return value;
        }
        return value.substring(value.length() - len);
    }

    public static String toString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static String priceToString(Object value, Integer type) {
        if (value == null) {
            return null;
        }
        if (type == null) {
            return value.toString();
        }
        if (type.equals(1)) {
            return "CBC";
        }
        if (type.equals(3)) {
            return "不接";
        }
        return value.toString();
    }

}


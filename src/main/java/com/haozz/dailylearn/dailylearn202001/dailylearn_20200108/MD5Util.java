package com.haozz.dailylearn.dailylearn202001.dailylearn_20200108;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author haozhezhe@yunquna.com
 * @date 10:28 2020/1/8
 */
public class MD5Util {

    private MD5Util() {
        super();
    }

    public static String md5(String input) throws NoSuchAlgorithmException {
        String result;

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((input).getBytes(StandardCharsets.UTF_8));
        byte[] b = md5.digest();

        int i;
        StringBuilder buf = new StringBuilder();

        for (byte b1 : b) {
            i = b1;
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        result = buf.toString();
        return result;
    }

    public String genetateBusinessKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("ab");
        sb.append("abc");
        try {
            return MD5Util.md5(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

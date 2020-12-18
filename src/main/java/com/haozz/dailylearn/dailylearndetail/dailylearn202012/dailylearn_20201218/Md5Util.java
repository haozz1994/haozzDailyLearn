package com.haozz.dailylearn.dailylearndetail.dailylearn202012.dailylearn_20201218;

import cn.hutool.crypto.SecureUtil;

/**
 * @author haozhezhe@yunquna.com
 * @date 6:08 PM 12/18/20
 */
public class Md5Util {

    public static void main(String[] args) {


        String demo1 = "abc_123_def";

        String demo2 = "abc_123_def";

        String demo3 = "abc_123";

        System.out.println(SecureUtil.md5(demo1));
        System.out.println(SecureUtil.md5(demo2));
        System.out.println(SecureUtil.md5(demo3));


    }
}

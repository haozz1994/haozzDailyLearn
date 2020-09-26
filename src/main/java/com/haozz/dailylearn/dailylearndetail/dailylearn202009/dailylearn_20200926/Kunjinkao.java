package com.haozz.dailylearn.dailylearndetail.dailylearn202009.dailylearn_20200926;

import java.io.UnsupportedEncodingException;

/**
 * 锟斤拷demo
 * https://mp.weixin.qq.com/s/kTADQtTeOWPuXsvR9HsUIg
 *
 * @author haozhezhe@yunquna.com
 * @date 09:49 2020-09-26
 */
public class Kunjinkao {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "��";
        String strCode = new String(str.getBytes("UTF-8"), "GBK");
        System.out.println(strCode);
    }
}

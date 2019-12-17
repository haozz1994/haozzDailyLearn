package com.haozz.dailylearn.dailylearn201911.dailylearn_20191130;

import java.io.IOException;

/**
 * 刷博客点击量
 *
 * @author haozz
 * @date 2018/6/4 15:34
 **/
public class BlogClick {

    public static void main(String args[]) {

        try {
            //此处输入需要刷的博客地址
            String urls[] = {
                    "https://blog.csdn.net/hz_940611/article/details/80544670",
                    "https://blog.csdn.net/hz_940611/article/details/80522474",
                    "https://blog.csdn.net/hz_940611/article/details/80472774",
                    "https://blog.csdn.net/hz_940611/article/details/80473696",
                    "https://blog.csdn.net/hz_940611/article/details/80388691",
                    "https://blog.csdn.net/hz_940611/article/details/80365983",
                    "https://blog.csdn.net/hz_940611/article/details/80363243"
            };

            while (true) {
                for (int i = 0; i < 7; i++) {
                    openByBroweser(urls[i]);
                }
                //因为csdn的点击量计算规则是，60s内的点击只能算一次，所以此处需要将浏览器关掉，60s后再打开
                Thread.sleep(20000);
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                Thread.sleep(40000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openByBroweser(String url) {
        try {
            //此处输入浏览器的存储位置
            ProcessBuilder proc = new ProcessBuilder("C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe", url);
            proc.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

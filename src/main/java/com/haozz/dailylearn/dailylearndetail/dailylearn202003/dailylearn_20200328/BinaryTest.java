package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200328;

/**
 * java中的各种进制
 *
 * @author: haozz
 * @date: 2020/3/28 21:58
 */
public class BinaryTest {

    public static void main(String[] args) {

        //二进制
        int bin = 0b1100010;

        //八进制
        int oct = 0142;

        //十六进制
        int hex = 0x62;

        //十进制
        int dec = 98;

        //底层都是以二进制存储
        //java默认使用十进制输出显示

        System.out.println("===========================================");
        System.out.println("二进制：0b1100010 = " + bin);
        System.out.println("八进制：0142 = " + oct);
        System.out.println("十六进制：0x62 = " + hex);
        System.out.println("十进制：98 = " + dec);
        System.out.println("===========================================");


        int num = 98;
        System.out.println("转换为二进制显示：98 = "+Integer.toBinaryString(num));
        System.out.println("转换为八进制显示：98 = "+Integer.toOctalString(num));
        System.out.println("转换为十六进制显示：98 = "+Integer.toHexString(num));
        //自由转换，2~36，最多36进制
        System.out.println("自由转换：98 = "+Integer.toString(num,2));


        /**
         * 比特bit，信息量的最小单位，符号b，二级制中的一位数
         *
         * 字节byte，表示信息的最小单位，符号B。计算机中的所有数据以字节为单位。  1byte = 8bit
         *
         */
    }
}

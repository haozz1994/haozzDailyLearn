package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200326;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: haozz
 * @date: 2020/3/26 22:32
 */
public class RepeatUtil {

    public static String[] names = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /**
     * 获取指定大小的实体集合
     */
    public static List<RepeatEntity> genRepeatList(int size) {
        List<RepeatEntity> list = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            //生成[0,26)的随机数，即0-25
            int index1 = rand.nextInt(26);
            int index2 = rand.nextInt(26);
            int index3 = rand.nextInt(26);

            RepeatEntity repeatEntity = RepeatEntity.builder()
                    .index(list.size())
                    .firstName(names[index1])
                    .secondName(names[index2])
                    .thirdName(names[index3])
                    .build();

            list.add(repeatEntity);

        }


        return list;
    }
}

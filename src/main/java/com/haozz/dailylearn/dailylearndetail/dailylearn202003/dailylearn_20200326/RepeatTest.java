package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200326;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 判断对象集合中的重复数据，算法耗时测试
 * <p>
 * RepeatEntity中firstName、secondName、thirdName均相同视为数据重复，并且要将所有重复数据的isRepeat字段设为1
 *
 * @author: haozz
 * @date: 2020/3/26 22:28
 */
public class RepeatTest {

    public static void main(String[] args) {

        List<RepeatEntity> repeatEntities = RepeatUtil.genRepeatList(100000);

        long t1 = System.currentTimeMillis();

        int count = 0;

        //方法一：两层for循环嵌套，最笨的办法，时间复杂度n²
//        for (int i = 0; i < repeatEntities.size() - 1; i++) {
//            for (int j = i + 1; j < repeatEntities.size(); j++) {
//                if (repeat(repeatEntities.get(i), repeatEntities.get(j))) {
//                    repeatEntities.get(i).setIsRepeat(1);
//                    repeatEntities.get(j).setIsRepeat(1);
//                    count++;
//                    System.out.println(String.format("找到重复数据：%s & %s", i, j));
//                }
//            }
//        }
        //十万条数据耗时42s

        //方法二：HashMap，两次for循环，时间复杂度n
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < repeatEntities.size(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(repeatEntities.get(i).getFirstName());
            sb.append(repeatEntities.get(i).getSecondName());
            sb.append(repeatEntities.get(i).getThirdName());

            if (map.containsKey(sb.toString())) {
                System.out.println(String.format("找到重复数据：%s", i));
                repeatEntities.get(i).setIsRepeat(1);
            } else {
                map.put(sb.toString(), 1);
            }
        }
        //十万条数据耗时1.2s

        count = repeatEntities.stream().filter(item -> Objects.equals(item.getIsRepeat(), 1)).collect(Collectors.toList()).size();

        System.out.println("共找到 " + count + " 组重复数据，耗时:" + (System.currentTimeMillis() - t1) + "ms");

    }

    public static boolean repeat(RepeatEntity o1, RepeatEntity o2) {
        if (Objects.equals(o1.getFirstName(), o2.getFirstName())
                && Objects.equals(o1.getSecondName(), o2.getSecondName())
                && Objects.equals(o1.getThirdName(), o2.getThirdName())) {
            return true;
        }
        return false;
    }


}

package com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200718;

import com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200704.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * OOM测试，导出堆dump信息
 * <p>
 * 设置两个参数，在系统发生OOM的时候，会将堆dump快照信息导出到指定路径
 * <p>
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/haozz/Desktop
 *
 * @author haozhezhe@yunquna.com
 * @date 14:28 2020-07-18
 */
public class OOMTest {

    public static List<Object> list = new ArrayList<>();


    /**
     * 指定堆的大小，方便快速OOM
     * -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/haozz/Desktop
     */
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }

    /**
     * 发生OOM之后，会导出堆的快照信息到指定路径下，文件格式为.hprof或.dump，
     * 然后在jvisualvm里面装入该文件，就可以看到生成了大量的User类导致内存不足
     */
}

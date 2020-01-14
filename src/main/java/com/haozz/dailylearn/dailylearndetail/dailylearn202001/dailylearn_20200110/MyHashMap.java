package com.haozz.dailylearn.dailylearndetail.dailylearn202001.dailylearn_20200110;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 * 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 *
 * @author: haozz
 * @date: 2020/1/10 21:52
 */
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMap {

    private int datas[];

    /** Initialize your data structure here. */
    public MyHashMap() {
        datas = new int[10000];
        for (int i = 0; i < 10000; i++) {
            datas[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        datas[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return datas[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        datas[key] = -1;
    }

}

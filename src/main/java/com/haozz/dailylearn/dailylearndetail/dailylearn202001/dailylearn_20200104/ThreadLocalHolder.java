package com.haozz.dailylearn.dailylearndetail.dailylearn202001.dailylearn_20200104;

/**
 * @author
 * @date 2020/1/4 16:55
 **/
public class ThreadLocalHolder {

    private static final ThreadLocal<Integer> holder = new ThreadLocal<Integer>();

    public static void setFlag(Integer flag){
        holder.set(flag);
    }

    public static Integer getCurrentFlag(){
        return holder.get();
    }

    public static void remove(){
        holder.remove();
    }

}

package com.haozz.dailylearn.dailylearn202001.dailylearn_20200111;

import java.util.HashSet;
import java.util.Set;

/**
 * effective 第36条：坚持使用Override注解
 * Bigram类表示双字母组或有序的字母对
 * @author
 * @date 2020/1/11 9:53
 **/
public class Bigram {

    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // 这里并没有进行重写，而是重载。想要覆盖Objects.equals，方法的参数必须定义为Object
    // 但是很明显是想重写Object中的equals的，所以如果加上了@Override注解，那么编译器会帮助我们检查重写的正确性
    // 所以如果是重写的话，需要养成加@Override的习惯
    // 小例外：覆盖抽象类的抽象方法时可以不加，因为此时如果没有覆盖抽象方法的话同样会产生编译错误。但是最好还是加上

//    @Override
    public boolean equals(Bigram b){
        return b.first == first && b.second == second;
    }

    public int hashCode(){
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                set.add(new Bigram(ch, ch));
            }
        }
        System.out.println(set.size());
        //实际上这里打印的结果是260，而不是26
    }
}

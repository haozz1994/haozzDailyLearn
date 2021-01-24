package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210124;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Java响应式编程 RxJava
 * https://ke.qq.com/course/429389?taid=3506376941145421
 *
 * @author haozhezhe@yunquna.com
 * @date 6:58 PM 1/24/21
 */
public class HelloRx {

    public static void main(String[] args) {

        // 被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello");
                emitter.onNext("www.mashibing.com");
                emitter.onNext("let`s study!");
            }
        });


        // 观察者
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + " == consumer == " + s);
            }
        };

        observable.subscribe(consumer);

        /**
         * 和Mq很像，但是MQ是消费端拉的，响应式编程是被观察者主动推的
         */

    }
}

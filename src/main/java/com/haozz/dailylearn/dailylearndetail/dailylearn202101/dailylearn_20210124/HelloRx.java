package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210124;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Java响应式编程 RxJava
 * https://ke.qq.com/course/429389?taid=3506376941145421
 *
 * https://juejin.cn/post/6844903617124630535
 * <p>
 * <p>
 * 和Mq很像，但是MQ是消费端拉的，响应式编程是被观察者主动推的
 *
 * @author haozhezhe@yunquna.com
 * @date 6:58 PM 1/24/21
 */
public class HelloRx {

    public static void main(String[] args) throws InterruptedException {

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

        // 被观察者和观察者绑定，观察者在同一个线程中处理，也就是同步
//        observable.subscribe(consumer);


        // 绑定，异步，观察者在新线程中处理
        observable.observeOn(Schedulers.newThread()).subscribe(consumer);
        // 这样直接执行，打印不出东西，因为子线程还没来得及执行，主线程就结束了，可以在下面阻塞一下


        // 阻塞一下
//        for(;;);
        Thread.sleep(1000);

        // Observable  ->  Consumer   处理简单一点的逻辑


        // Observable  ->  Observer  处理复杂一点的逻辑
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(Thread.currentThread().getName() + " == observer == " + s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
//        observable.subscribe(observer);
        observable.observeOn(Schedulers.newThread()).subscribe(observer);


    }
}

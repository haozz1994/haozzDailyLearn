package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210327;

/**
 * 装饰器模式
 * 动态的给一个对象添加一些额外的功能。就增加功能来说，装饰器模式比生成子类更为灵活。
 * https://www.bilibili.com/video/BV1hp4y1D7MP
 *
 * @author haozhezhe@yunquna.com
 * @date 9:58 AM 3/27/21
 */
public class DecoratorPattern {

    /**
     * 机器人：
     * 第一代：唱歌、跳舞
     * 第二代：新增扫地功能
     *
     * 给一个类或者对象增加新的功能
     *
     * 有两种实现方式：继承  or   关联
     * 继承： 继承现有的类，在子类中扩展功能
     * 关联： 把现有类的兑现嵌入到另一个类中，进行扩展
     *
     */
}


/**
 * 机器人接口
 */
interface Robot {
    void doSomething();
}

/**
 * 第一代机器人
 */
class FirstRobot implements Robot {

    @Override
    public void doSomething() {
        System.out.println("唱歌、跳舞");
    }
}

/**
 * 装饰器机器人，也就是第二代机器人
 * 他装饰的对象，就是第一代机器人
 * 他装饰的对象的功能他都要有，在此之上扩展新的功能
 */
class DecoratorRobot implements Robot{

    /**
     * 引入他装饰的对象
     */
    private Robot robot;

    /**
     * 通过构造方法指定需要装饰的对象
     * @param robot 当前装饰器所装饰的对象
     */
    public DecoratorRobot(Robot robot) {
        this.robot = robot;
    }


    /**
     * 实现机器人该有的功能
     * 这里直接指派自己装饰的对象去做，也就是不改变原有的功能
     */
    @Override
    public void doSomething() {
        robot.doSomething();
    }
}
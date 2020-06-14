package java.lang;

/**
 * 新建String类，并且包名为java.lang
 */
public class String {

    public static void main(String[] args) {
        System.out.println("******** My String class **********");
    }

    /**
     * 测试JVM类加载机制
     *
     *
     * 结果：
     *
     * 执行失败，输出如下
     * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
     *    public static void main(String[] args)
     * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
     */


    /**
     * 原因：
     *
     * 类加载的时候，由于此类全类名与jdk中String类完全一致
     * 在进行双亲委派加载的时候，AppClassLoader会查找自己已经加载到的类，这时一开始肯定是没有的
     * 然后会委托ExtClassLoader进行查找lib/ext目录下，也是没有的
     * 继续委托到BootstrapClassLoader，查找lib目录，发现找到了与此类全类名完全一致的String类，就会加载到JVM中
     *
     * 然后执行main方法时，实际上执行的jdk的lib目录下的String类的main方法，但是String类中并没有main方法，所以会报错
     *
     */
}

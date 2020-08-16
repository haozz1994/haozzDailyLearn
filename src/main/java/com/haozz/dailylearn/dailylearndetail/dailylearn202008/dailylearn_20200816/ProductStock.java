package com.haozz.dailylearn.dailylearndetail.dailylearn202008.dailylearn_20200816;

/**
 * https://www.jianshu.com/p/f5ff017db62a
 * <p>
 * <p>
 * MySQL 乐观锁与悲观锁
 *
 * @author haozhezhe@yunquna.com
 * @date 23:44 2020-08-16
 */


/**
 * 悲观锁
 * 悲观锁（Pessimistic Lock），顾名思义，就是很悲观，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会block直到它拿到锁。
 *
 * 悲观锁：假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作。
 *
 * Java synchronized 就属于悲观锁的一种实现，每次线程要修改数据时都先获得锁，保证同一时刻只有一个线程能操作数据，其他线程则会被block。
 *
 * 乐观锁
 * 乐观锁（Optimistic Lock），顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在提交更新的时候会判断一下在此期间别人有没有去更新这个数据。乐观锁适用于读多写少的应用场景，这样可以提高吞吐量。
 *
 * 乐观锁：假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。
 *
 * 乐观锁一般来说有以下2种方式：
 *
 * 使用数据版本（Version）记录机制实现，这是乐观锁最常用的一种实现方式。何谓数据版本？即为数据增加一个版本标识，一般是通过为数据库表增加一个数字类型的 “version” 字段来实现。当读取数据时，将version字段的值一同读出，数据每更新一次，对此version值加一。当我们提交更新的时候，判断数据库表对应记录的当前版本信息与第一次取出来的version值进行比对，如果数据库表当前版本号与第一次取出来的version值相等，则予以更新，否则认为是过期数据。
 * 使用时间戳（timestamp）。乐观锁定的第二种实现方式和第一种差不多，同样是在需要乐观锁控制的table中增加一个字段，名称无所谓，字段类型使用时间戳（timestamp）, 和上面的version类似，也是在更新提交的时候检查当前数据库中数据的时间戳和自己更新前取到的时间戳进行对比，如果一致则OK，否则就是版本冲突。
 * Java JUC中的atomic包就是乐观锁的一种实现，AtomicInteger 通过CAS（Compare And Set）操作实现线程安全的自增。
 *
 */
public class ProductStock {


    /**
     * 实战
     * 接下来，我们通过一个具体案例来进行分析：考虑电商系统中的下单流程，商品的库存量是固定的，如何保证商品数量不超卖？ 其实需要保证数据一致性：某个人点击秒杀后系统中查出来的库存量和实际扣减库存时库存量的一致性就可以。
     *
     * 假设，MySQL数据库中商品库存表tb_product_stock 结构定义如下：
     *
     * CREATE TABLE `tb_product_stock` (
     *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
     *   `product_id` bigint(32) NOT NULL COMMENT '商品ID',
     *   `number` INT(8) NOT NULL DEFAULT 0 COMMENT '库存数量',
     *   `create_time` DATETIME NOT NULL COMMENT '创建时间',
     *   `modify_time` DATETIME NOT NULL COMMENT '更新时间',
     *   PRIMARY KEY (`id`),
     *   UNIQUE KEY `index_pid` (`product_id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品库存表';
     *
     *
     *
     *
     * 对应的POJO类：
     *
     *
     */

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 库存量
     */
    private Integer number;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

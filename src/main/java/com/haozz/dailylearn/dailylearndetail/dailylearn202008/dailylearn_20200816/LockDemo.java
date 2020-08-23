package com.haozz.dailylearn.dailylearndetail.dailylearn202008.dailylearn_20200816;

/**
 * @author haozhezhe@yunquna.com
 * @date 23:47 2020-08-16
 */
public class LockDemo {


    private ProductStock query(Object obj, Object... obj1) {
        return null;
    }

    private Integer update(Object obj, Object... obj1) {
        return null;
    }

    /**
     * 不考虑并发的情况下，更新库存代码如下：
     * 多线程并发情况下，会存在超卖的可能。
     */
    /**
     * 更新库存(不考虑并发)
     *
     * @param productId
     * @return
     */
    public boolean updateStockRaw(Long productId) {
        ProductStock product = query("SELECT * FROM tb_product_stock WHERE product_id=#{productId}", productId);
        if (product.getNumber() > 0) {
            int updateCnt = update("UPDATE tb_product_stock SET number=number-1 WHERE product_id=#{productId}", productId);
            if (updateCnt > 0) {    //更新库存成功
                return true;
            }
        }
        return false;
    }


    /**
     * 更新库存(使用悲观锁)   for update
     *
     * @param productId
     * @return
     */
    public boolean updateStock(Long productId) {
        //先锁定商品库存记录
        ProductStock product = query("SELECT * FROM tb_product_stock WHERE product_id=#{productId} FOR UPDATE", productId);
        if (product.getNumber() > 0) {
            int updateCnt = update("UPDATE tb_product_stock SET number=number-1 WHERE product_id=#{productId}", productId);
            if (updateCnt > 0) {    //更新库存成功
                return true;
            }
        }
        return false;
    }

    /**
     * 下单减库存(乐观锁)  这个例子不是很恰当，用了库存number本身来当版本号用
     * 使用乐观锁更新库存的时候不加锁，当提交更新时需要判断数据是否已经被修改（AND number=#{number}），只有在 number等于上一次查询到的number时 才提交更新。
     *
     * @param productId
     * @return
     */
    public boolean updateStock1(Long productId) {
        int updateCnt = 0;
        while (updateCnt == 0) {
            ProductStock product = query("SELECT * FROM tb_product_stock WHERE product_id=#{productId}", productId);
            if (product.getNumber() > 0) {
                updateCnt = update("UPDATE tb_product_stock SET number=number-1 WHERE product_id=#{productId} AND number=#{number}", productId, product.getNumber());
                if (updateCnt > 0) {    //更新库存成功
                    return true;
                }
            } else {    //卖完啦
                return false;
            }
        }

        /**
         * SELECT number, version FROM tb_product_stock WHERE product_id=#{productId}
         *
         *
         * UPDATE tb_product_stock SET number=number-1 WHERE product_id=#{productId} AND version=#{version}
         *
         * 当这里有两个线程A和B同时进来的时候，然后同时执行了query方法，假如查到的version都为1，
         * 然后线程A执行了update方法，修改金额，并且修改version = 2
         * 线程B执行update的时候，versiony已经不是1了，所以where条件生效，会更新失败（也不算是失败，只是影响行数为0），然后在while之后重试；
         */

        /**
         * 这里会有一个问题，如果这个方法在事务中，并且有多个线程并发来执行，以上面的例子为例：
         * A执行完之后，修改version = 2，由于方法在事务中，所以并未提交
         * B第一次执行失败后，进行while重试，但是由于A的事务还没有提交，所以再次执行的时候，进行的查询查到的version依然是1（MySQL默认事务隔离级别为可重复读）
         * 然后B在进行update的时候，where id= ？ and version = 1， 虽然A的事务还没有提交，但这个时候这种操作其实已经以version的真实值为准了（类似amount= amount+100这种操作），所以会更新失败（影响行数为0）
         *
         * 这种其实把事务隔离级别改为读未提交就可以拿到A未提交的真实数据，但是这样就把数据库的隔离级别降到了最低，安全性得不到保障。如果此时有别的查询过来，拿到了未提交的数据并进行处理，然后这边后面又回滚了，就会出问题。
         *
         * 财务城代三期开发的时候就有这种问题，其实不需要处理，并发的更新请求只能有一个成功，也就是不需要重试，失败了就直接报错出去。
         */
        return false;
    }


    /**
     * 乐观锁与悲观锁的区别
     * 乐观锁的思路一般是表中增加版本字段，更新时where语句中增加版本的判断，算是一种CAS（Compare And Swep）操作，商品库存场景中number起到了版本控制（相当于version）的作用（ AND number=#{number}）。
     *
     * 悲观锁之所以是悲观，在于他认为本次操作会发生并发冲突，所以一开始就对商品加上锁（SELECT ... FOR UPDATE），然后就可以安心的做判断和更新，因为这时候不会有别人更新这条商品库存。
     *
     */

}


新new出来的对象是无锁态

单个线程给对象加锁后，是偏向锁

两个线程竞争，升级为轻量级锁

竞争加剧，会升级为重量级锁（条件是：超过CPU核数二分之一的，以及存在一个线程自旋次数超过10）
升级为重量级锁需要申请操作系统的资源
 
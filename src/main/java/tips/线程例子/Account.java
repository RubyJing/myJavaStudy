package tips.线程例子;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行账户
 * @author RubyJing
 */
public class Account {
    //3.为每个银行账户创建一个锁对象，在存款操作进行加锁和解锁的操作
    private Lock accountLock = new ReentrantLock();
    /** 账户余额 **/
    private double balance;

    /**
     * 存款
     * 1.对存款方法进行同步
     * @param money 存入金额
     */
    public synchronized void deposit(double money){
        //3.加锁
        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                //模拟此业务需要的一段处理时间
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
        }finally {
            //3.解锁
            accountLock.unlock();
        }

    }

    /**
     * 获得账户余额
     * @return balance 余额
     */
    public double getBalance(){
        return balance;
    }
}

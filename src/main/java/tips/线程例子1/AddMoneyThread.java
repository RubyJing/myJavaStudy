package tips.线程例子1;

/**
 * 存钱线程
 * @author RubyJing
 */
public class AddMoneyThread implements Runnable{
    /** 存入账户 */
    private Account account;
    /** 存入金额 */
    private double money;

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        //2.对银行账户进行同步
        synchronized (account){
            account.deposit(money);
        }
    }
}

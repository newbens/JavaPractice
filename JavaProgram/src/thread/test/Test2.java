package thread.test;

public class Test2 {
    public static void main(String[] args) {
        Account a = new Account();
        user uv = new user(a, 2000);
        user ua = new user(a, 2000);
        Thread wchat = new Thread(ua, "微信");
        Thread ali = new Thread(uv, "支付宝");
        wchat.start();
        ali.start();


    }
}

class Account {
    public static int money = 3000;
//在普通方法加同步锁，锁的是一个对象，而不单单是一个方法，如果是不同的对象，同步锁就没有作用
//如果想要给代码块加锁， synchronized(this){代码块}  使用this不同对象也是同一个锁，如果不同对象想要不同的锁，this换成对象名
//静态方法加同步锁，所有对象共用一个同步锁
    public synchronized void draw(int m) {
        String name = Thread.currentThread().getName();
        if (money < m) {
            System.out.println(name + "操作，余额不足！！！！！");
        } else {
            System.out.println(name + "操作，账户原有金额" + money);
            System.out.println(name + "操作，取款金额" + m);
            money -= m;
            System.out.println(name + "操作，余额" + money);
        }
    }
}

class user implements Runnable {
    Account account;
    int money;

    public user(Account account, int money) {
        this.account = account;
        this.money = money;
    }

    @Override

    public void run() {
        account.draw(money);
    }
}

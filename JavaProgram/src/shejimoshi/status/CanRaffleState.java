package shejimoshi.status;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CanRaffleState extends State {

    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductmoney() {
        System.out.println("已经扣过积分啦");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖");
        try {
            TimeUnit.SECONDS.sleep(1);
            Random random = new Random();
            int n = random.nextInt(10);
            if (n == 0) {
                //抽中了 发送奖品
                activity.setState(activity.getDispenseState());
                return true;
            }else {
                System.out.println("没有抽中");
                activity.setState(activity.getNoRaffleState());
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("没有中奖");
    }
}

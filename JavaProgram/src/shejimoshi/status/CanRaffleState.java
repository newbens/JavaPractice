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
        System.out.println("�Ѿ��۹�������");
    }

    @Override
    public boolean raffle() {
        System.out.println("���ڳ齱");
        try {
            TimeUnit.SECONDS.sleep(1);
            Random random = new Random();
            int n = random.nextInt(10);
            if (n == 0) {
                //������ ���ͽ�Ʒ
                activity.setState(activity.getDispenseState());
                return true;
            }else {
                System.out.println("û�г���");
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
        System.out.println("û���н�");
    }
}

package shejimoshi.status;

public class DispenseOutState extends State {

    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductmoney() {
        System.out.println("活动结束！");
    }

    @Override
    public boolean raffle() {
        System.out.println("活动结束！");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("活动结束！");
    }
}

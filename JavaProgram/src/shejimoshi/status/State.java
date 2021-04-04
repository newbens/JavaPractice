package shejimoshi.status;

//状态抽象类
public abstract class State {

    public abstract void deductmoney();//扣除积分 每次抽奖口50积分
    public abstract boolean raffle();//是否抽中奖品
    public abstract void dispensePrize();//发放奖品

}

package shejimoshi.status;

//���ܳ齱��״̬
public class NoRaffleState extends State {

    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductmoney() {
        System.out.println("��50���֣�����Գ齱��");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("�۳����ֲſ��Գ齱Ŷ");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("���ܷ��Ž�Ʒ");
    }
}

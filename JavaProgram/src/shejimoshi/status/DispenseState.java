package shejimoshi.status;

//���Ž�Ʒ��״̬
public class DispenseState extends State {

    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductmoney() {
        System.out.println("���ܿ۳�����");
    }

    @Override
    public boolean raffle() {
        System.out.println("���ܳ齱");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("��ϲ�н���");
            activity.setState(activity.getNoRaffleState());
        }else {
            System.out.println("û�н�Ʒ��");
            //���治���Գ齱��
            activity.setState(activity.getDispenseOutState());
        }
    }
}

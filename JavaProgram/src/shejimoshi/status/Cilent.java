package shejimoshi.status;

public class Cilent {
    public static void main(String[] args) {

        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 100; i++) {
            System.out.println("��"+(i+1)+"�Σ��齱");
            activity.debuctMoney();
            activity.raffle();
        }

    }
}

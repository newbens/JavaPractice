package shejimoshi.status;

public class Cilent {
    public static void main(String[] args) {

        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 100; i++) {
            System.out.println("µÚ"+(i+1)+"´Î£¬³é½±");
            activity.debuctMoney();
            activity.raffle();
        }

    }
}

package Singleton;

/**
 * ¿¡∫∫ Ω
 */
public class SingleTon4 {

   private static SingleTon4 instance;

    private SingleTon4() {
    }

    public SingleTon4 getInstance() {
        if (instance == null) {
            instance = new SingleTon4();
        }
        return instance;
    }


}

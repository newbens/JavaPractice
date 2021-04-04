package src.ChapterFour;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {

    static class OOMObject{
        public byte[] bytes = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TimeUnit.SECONDS.sleep(1);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }


}

import java.util.ArrayList;
import java.util.List;

/**
 * GC占用大量资源却效果不好
 */
public class GCOverHeadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Exception e){
            System.out.println("i = "+i);
            e.printStackTrace();
        }

    }

}

import com.sun.deploy.security.EnhancedJarVerifier;

public class MetaSpaceDemo {
    static class Test {}
    public static void main(String[] args) {
        int i =0;
        try {
            while (true){
                i++;
//                Enhancer enhancer = new Enhancer();
            }
        }catch (Exception e){
            System.out.println("多少此后发生了异常"+i);
            e.printStackTrace();
        }
    }
}

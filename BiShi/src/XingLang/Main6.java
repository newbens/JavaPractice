package XingLang;

public class Main6 {
    public static void main(String[] args){
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a.show(b));  //AA
        System.out.println(a.show(d));  //AD
        System.out.println(b.show(a));  //BA
        System.out.println(b.show(c));  //BB
        System.out.println(b.show(d));  //AD
        }

    public static class A{
        public String show(D d){
            return ("AD");
        }

        public String show(A a) {
            return ("AA");
        }
    }
    public static class B extends A{
        public String show(B b){
            return ("BB");
        }

        public String show(A a) {
            return ("BA");
        }
    }
    public static class C extends B{}
    public static class D extends B{}
}

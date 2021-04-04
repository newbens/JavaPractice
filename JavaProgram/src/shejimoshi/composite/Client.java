package shejimoshi.composite;

public class Client {

    public static void main(String[] args) {
        OrganizationComponment qinghua = new University("清华大学", "中国顶级大学！");
        OrganizationComponment com = new College("计算机学院", "计院");
        OrganizationComponment man = new College("信息学院", "管院");
        com.add(new Department("软件工程","软件"));
        com.add(new Department("网络工程","网络"));
        com.add(new Department("计科","计科"));
        man.add(new Department("通信工程","通信"));
        man.add(new Department("信息工程","信息"));

        qinghua.add(com);
        qinghua.add(man);

        qinghua.print();



    }
}

package shejimoshi.composite;

public class Department extends OrganizationComponment {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    void print() {
        System.out.println("---------"+getName()+"-----");
    }
}

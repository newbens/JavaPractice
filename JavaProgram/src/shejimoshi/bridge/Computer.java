package shejimoshi.bridge;

public abstract class Computer {
    //��� Ʒ��
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info() {
        brand.info();
    }

}

class Desktop extends Computer {

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        brand.info();
        System.out.println("̨ʽ��");
    }
}

class Laptop extends Computer {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        brand.info();
        System.out.println("�ʼǱ�");
    }
}
package shejimoshi.builder;

public class Worker extends Builder {

    private House house;

    public Worker() {
        house = new House();
    }


    @Override
    Builder buildA(String s) {
        house.setA(s);
        return this;
    }

    @Override
    Builder buildB(String s) {
        house.setA(s);
        return this;
    }

    @Override
    Builder buildC(String s) {
        house.setA(s);
        return this;
    }

    @Override
    Builder buildD(String s) {
        house.setA(s);
        return this;
    }

    @Override
    House getBuildHouse() {
        return house;
    }
}
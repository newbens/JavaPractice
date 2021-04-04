package shejimoshi.builder;

public abstract class Builder {
    abstract Builder buildA(String s);
    abstract Builder buildB(String s);
    abstract Builder buildC(String s);
    abstract Builder buildD(String s);

    abstract House getBuildHouse();
}

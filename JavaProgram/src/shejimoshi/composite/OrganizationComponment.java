package shejimoshi.composite;

public abstract class OrganizationComponment {

    private String name;
    private String desc;

    protected void add(OrganizationComponment org) {
        //Ĭ��ʵ��
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponment org) {
        throw new UnsupportedOperationException();
    }

    public OrganizationComponment(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    //���඼��Ҫʵ���������
    abstract void print();
}

package shejimoshi.composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponment {

    List<OrganizationComponment> orgs = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void add(OrganizationComponment org) {
        orgs.add(org);
    }

    @Override
    protected void remove(OrganizationComponment org) {
        orgs.remove(org);
    }

    @Override
    void print() {
        System.out.println("---------"+getName()+"-----");
        for (OrganizationComponment org : orgs) {
            org.print();
        }
    }
}

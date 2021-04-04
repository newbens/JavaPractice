package com.niuben;

abstract class Employee {
     Employee() {
    }
    String name;
    int id;
    double salary;

    abstract void work();
}

class CommonEmployee extends Employee{

    public void setInfo(String name, int id, double salary) {
        super.name =name;
        super.id = id;
        super.salary = salary;
    }

    public void getInfo() {
        System.out.println(super.name+" "+super.id+" "+super.salary);
    }
    @Override
    void work() {
        System.out.println("这是一个普通员工！！！");
    }
}

class Manager extends Employee {
    private double bonus;
    public void setInfo(String name,int id,double salary,double bonus) {
        super.name = name;
        super.id = id;
        super.salary = salary;
        this.bonus = bonus;
    }

    public void getInfo() {
        System.out.println(super.name+" "+super.id+" "+super.salary+" "+this.bonus);
    }

    @Override
    void work() {
        System.out.println("这是一个管理人员！！！");

    }
}
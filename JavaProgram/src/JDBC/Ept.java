package JDBC;
//f封装数据的javabean

import java.util.Date;

public class Ept {
    Integer id;
    String name;
    Integer age;
    Integer score;
    Date birthday;
    String sex;

    public Ept(int id, String name, int age, int score, Date birthday, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Ept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}

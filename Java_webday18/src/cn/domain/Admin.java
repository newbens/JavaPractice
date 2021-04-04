package cn.domain;
//管理员类  用来封装管理员数据
public class Admin {
    private String user;
    private String password;
    private String checkcode;

    public Admin() {

    }
    public Admin(String user, String password,String checkcode) {
        this.user = user;
        this.password = password;
        this.checkcode = checkcode;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

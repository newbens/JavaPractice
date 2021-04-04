package shejimoshi.xiangyuan;

public class ConcereteWebSite extends WebSite {

    private String type;

    public ConcereteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(String userName) {
        User user = new User();
        user.setUserName(userName);
        System.out.println("网站的发布形式为："+type+"\t使用者是："+user.getUserName());

    }
}

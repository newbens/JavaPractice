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
        System.out.println("��վ�ķ�����ʽΪ��"+type+"\tʹ�����ǣ�"+user.getUserName());

    }
}

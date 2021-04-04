package shejimoshi.xiangyuan;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory wf = new WebSiteFactory();

        WebSite webSite1 = wf.getWebSite("����");
        webSite1.use("ţ��");
        System.out.println(wf.getWebSiteCount());

        WebSite webSite2 = wf.getWebSite("΢��");
        webSite2.use("ţ��");
        System.out.println(wf.getWebSiteCount());

    }
}

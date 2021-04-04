package shejimoshi.xiangyuan;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory wf = new WebSiteFactory();

        WebSite webSite1 = wf.getWebSite("ÐÂÎÅ");
        webSite1.use("Å£ Ä");
        System.out.println(wf.getWebSiteCount());

        WebSite webSite2 = wf.getWebSite("Î¢²©");
        webSite2.use("Å£ÀÚ");
        System.out.println(wf.getWebSiteCount());

    }
}

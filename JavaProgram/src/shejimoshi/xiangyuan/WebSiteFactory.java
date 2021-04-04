package shejimoshi.xiangyuan;

import java.util.HashMap;

/**
 * 网站工厂类
 */
public class WebSiteFactory {

    //充当池子
    private HashMap<String, ConcereteWebSite> pool = new HashMap<>();

    //如果有就从池中取，没有将创建并存入池子
    public WebSite getWebSite(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcereteWebSite(type));
        }
        return pool.get(type);
    }

    //获取网站总数
    public int getWebSiteCount() {
        return pool.size();
    }
}

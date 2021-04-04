package shejimoshi.xiangyuan;

import java.util.HashMap;

/**
 * ��վ������
 */
public class WebSiteFactory {

    //�䵱����
    private HashMap<String, ConcereteWebSite> pool = new HashMap<>();

    //����оʹӳ���ȡ��û�н��������������
    public WebSite getWebSite(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcereteWebSite(type));
        }
        return pool.get(type);
    }

    //��ȡ��վ����
    public int getWebSiteCount() {
        return pool.size();
    }
}

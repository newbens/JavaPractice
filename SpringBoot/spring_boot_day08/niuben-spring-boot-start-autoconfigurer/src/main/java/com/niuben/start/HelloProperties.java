package com.niuben.start;

import org.springframework.boot.context.properties.ConfigurationProperties;

//封装配置文件
@ConfigurationProperties(prefix = "niuben.hello")
public class HelloProperties {
    private String pre;
    private String suf;

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getSuf() {
        return suf;
    }

    public void setSuf(String suf) {
        this.suf = suf;
    }
}


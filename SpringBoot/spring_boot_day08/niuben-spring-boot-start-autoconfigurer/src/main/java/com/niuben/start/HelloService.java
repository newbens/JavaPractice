package com.niuben.start;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return helloProperties.getPre()+ "-" + name + "-" + helloProperties.getSuf();
    }
}

package com.niuben;

public class SmsSender implements Send {
    @Override
    public void send() {
        System.out.println("this is smssender");
    }
}

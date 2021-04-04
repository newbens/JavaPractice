package com.niuben;

public class SendFactory {   //Send抽象方法的工厂类
    public Send produce(String type) {
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("输入类型错误！");
            return null;
        }
    }
}

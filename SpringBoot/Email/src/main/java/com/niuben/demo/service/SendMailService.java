package com.niuben.demo.service;

import com.niuben.demo.domain.User;

import javax.servlet.http.HttpSession;

public interface SendMailService {

    public int sendMail(String target, String title, String content, User user);
}

package com.niuben.demo.service.imp;

import com.niuben.demo.domain.Content;
import com.niuben.demo.service.ShowMailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowMailServiceImp implements ShowMailService {



    @Override
    public List<Content> getAll() {
        List<Content> list = new ArrayList<>();


        return list;
    }
}

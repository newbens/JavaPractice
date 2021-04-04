package com.niuben.service.Imp;

import com.niuben.dao.AcountDao;
import com.niuben.dao.Imp.AcountDaoImp;
import com.niuben.service.AcountService;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class AcountServiceImp2 implements AcountService {
    private String[] strs;
    private List<String> lists;
    private Set<String> sets;
    private Map<String,String> maps;
    private Properties properties;

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public void saveAccount() {
        System.out.println(Arrays.toString(strs));
        System.out.println(lists);
        System.out.println(sets);
        System.out.println(maps);
        System.out.println(properties);
    }
}

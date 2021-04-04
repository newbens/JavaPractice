package com.niuben.service.Imp;

import com.niuben.factory.BeanFactory;
import com.niuben.service.AcountService;
import com.niuben.dao.AcountDao;
import com.niuben.dao.Imp.AcountDaoImp;

public class AcountServiceImp implements AcountService {
   private AcountDao acountDao = new AcountDaoImp();
//    private AcountDao acountDao = (AcountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        acountDao.saveAcount();
    }
}

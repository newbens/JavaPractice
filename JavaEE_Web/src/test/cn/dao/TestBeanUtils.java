package test.cn.dao;

import cn.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class TestBeanUtils {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user,"username","niuben");
        System.out.println(user);
        String name = BeanUtils.getProperty(user,"username");
        System.out.println(name);
    }
}

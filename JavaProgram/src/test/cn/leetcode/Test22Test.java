package test.cn.leetcode;

import cn.leetcode.Test22;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Test22 Tester. 
* 
* @author <Authors name> 
* @since <pre>ËÄÔÂ 18, 2020</pre> 
* @version 1.0 
*/ 
public class Test22Test { 

@Before
public void before() throws Exception {
    System.out.println("begin");
} 

@After
public void after() throws Exception {
    System.out.println("after");
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception {
    Test22 t = new Test22();
    t.solve(4);

}


} 

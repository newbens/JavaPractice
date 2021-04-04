package test.cn.dao;

import cn.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsonTest {
    @Test
    public void test1() throws Exception {
        Person p = new Person("张三", 23, "男");
        //创建Json核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        /*调用方法转换
            转换方法：
                1.writeValue（参数1：obj）
                   参数一：
                       File:将obj对象转换成JSon字符串，并保存指定文件夹中
                       Write:将object对象转换成Json字符串，并将数据填充到字符输出流中
                       OutputStream:将转换后的Json数据填充到字节输出流中
                2.writeValueAsString(obj):将对象转换为Json字符串
         */
        String string = mapper.writeValueAsString(p);
        System.out.println(string);
        //将数据写到文件中
        mapper.writeValue(new File("E://Json/json.txt"), p);
    }
    //json转java对象
    @Test
    public void test2() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        //Person必须由无参构造方法
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);



    }
}

package com.niuben;

import java.io.Serializable;
//可序列化和反序列化的对象

public class Test2 implements Serializable {
    //表明类的不同版本的兼容性
    private static final long serialVersionUID = 1l;
    String name;
}

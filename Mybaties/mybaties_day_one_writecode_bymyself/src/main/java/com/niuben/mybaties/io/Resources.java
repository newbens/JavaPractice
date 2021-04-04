package com.niuben.mybaties.io;

import java.io.InputStream;

/**
 * 使用类加载器 读取配置文件
 */
public class Resources {

    /**
     * 根据传入参数获取字节输入流
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}

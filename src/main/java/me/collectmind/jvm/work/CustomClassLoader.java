package me.collectmind.jvm.work;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * 作业1.2 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内 容是一个 Hello.class 文件所有字节(x=255-x)处理后的文件。
 *
 * Created by monica on 2020/10/19.
 */
public class CustomClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new CustomClassLoader().findClass("Hello");
            Method method = helloClass.getDeclaredMethod("hello");
            method.invoke(helloClass.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        // 读取加密后的class文件到字节数组
        byte[] encodedArray = {};
        try {
            ClassPathResource classPathResource = new ClassPathResource("Hello.xlass");
            File file = classPathResource.getFile();
            encodedArray = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // class字节数组解密
        byte[] bytes = decode(encodedArray);

        // 类加载
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 解码class字节数组
     *
     * @param encodedArray
     * @return
     */
    private byte[] decode(byte[] encodedArray) {
        byte[] decodedArray = new byte[encodedArray.length];
        for (int i = 0; i < encodedArray.length; i++) {
            decodedArray[i] = (byte) (255 - encodedArray[i]);
        }
        return decodedArray;
    }
}

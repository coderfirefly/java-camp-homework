package me.collectmind.week06.java.practice.java8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by monica on 2020/12/18.
 */
public class GenericDemo {

    public static void main(String[] args) {
        Demo demo = new Demo();

        Class clazz = demo.getClass();
        System.out.println(clazz.getSuperclass());


        // 获得带有泛型的父类
        Type type = clazz.getGenericSuperclass();
        // Type 是所有类型的公共高级接口
        System.out.println(type);

        // 获取泛型
        ParameterizedType p = (ParameterizedType) type;
        Class c = (Class) p.getActualTypeArguments()[0];
        System.out.println(c);
    }


    public static class Person<T> {

    }

    public static class Demo extends Person<GenericDemo> {

    }
}

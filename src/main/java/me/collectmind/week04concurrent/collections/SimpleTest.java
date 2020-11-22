package me.collectmind.week04concurrent.collections;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * 传值和引用的测试
 * @author monica
 * @date 2020/11/22
 */
public class SimpleTest {

    public static void main(String... args) {
        String[] strings = new String[] { "foo", "bar" };
        changeReference(strings);
        // still [foo, bar]
        System.out.println(Arrays.toString(strings));

        changeValue(strings);
        // [foo, foo]
        System.out.println(Arrays.toString(strings));
    }

    public static void changeReference(String[] strings) {
        strings = new String[] { "foo", "foo" };
    }

    public static void changeValue(String[] strings) {
        strings[1] = "foo";
    }
}

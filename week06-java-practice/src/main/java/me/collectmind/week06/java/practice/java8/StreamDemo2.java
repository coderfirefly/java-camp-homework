package me.collectmind.week06.java.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  java8 stream 示例
 * @author monica
 * @date 2020/12/18
 */
public class StreamDemo2 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println(strings);
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("java7 empty string count:" + count);

        count = strings.stream().filter(String::isEmpty).count();
        System.out.println("java8 empty string count:" + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("string length is 3 count:" + count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("string not empty:" + filtered);
    }

    private static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}

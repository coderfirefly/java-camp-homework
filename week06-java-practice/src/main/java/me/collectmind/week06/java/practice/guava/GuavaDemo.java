package me.collectmind.week06.java.practice.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Guava 示例
 *
 * @author monica
 * @date 2020/12/19
 */
public class GuavaDemo {

    public static void main(String[] args) {
        List<String> stringList = testString();

        List<Integer> integerList = testList();


        testBiMap(stringList);

        testMultimap(integerList);

    }

    /**
     * guava 集合类示例
     * key可以关联多个value
     * @param integerList
     */
    private static void testMultimap(List<Integer> integerList) {
        Multimap<Integer, Integer> multiMap = ArrayListMultimap.create();
        integerList.forEach(a -> multiMap.put(a, a + 1));
        System.out.println(multiMap);
    }

    /**
     * Guava 集合类示例
     *
     * BiMap可以根据key 找到value，也可以根据 value 找到 key
     * @param stringList
     */
    private static void testBiMap(List<String> stringList) {
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);
        System.out.println(words.get("Second").intValue());

        System.out.println(words.inverse().get(3));
        System.out.println(words);

        Map<String, String> map1 = Maps.toMap(stringList.listIterator(), a -> a + "-value");
        System.out.println(map1);
    }

    /**
     * Guava  集合工具类
     * @return
     */
    private static List<Integer> testList() {
        List<Integer> list = Lists.newArrayList(4,2,3,5,1,2,2,7,6);
        List<List<Integer>> lists1 = Lists.partition(list, 4);
        System.out.println(lists1);
        return list;
    }

    /**
     * Guava 字符串工具类示例
     * @return
     */
    private static List<String> testString() {
        List<String> lists = Lists.newArrayList("a","b","g","8","9");
        String result = Joiner.on(",").join(lists);
        System.out.println(result);


        String test =  "34344,34,34,哈哈";
        lists = Splitter.on(",").splitToList(test);
        System.out.println(lists);

        return lists;
    }
}

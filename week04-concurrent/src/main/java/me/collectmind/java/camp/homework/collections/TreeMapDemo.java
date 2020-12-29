package me.collectmind.java.camp.homework.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 遍历是有序的，可以执行比较器
 * @author monica
 * @date 2020/11/21
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.put(3, "val");
        treeMap.put(2, "val");
        treeMap.put(1, "val");
        treeMap.put(4, "val");
        treeMap.put(5, "val");
        System.out.println("treeMap in reverse order:" + treeMap);

        Map<Integer, String> treeMap2 = new TreeMap<>(Comparator.naturalOrder());
        treeMap2.putAll(treeMap);
        System.out.println("treeMap in natural order:" + treeMap2);
    }
}

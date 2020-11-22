package me.collectmind.week04concurrent.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap 遍历有序, HashMap遍历无序
 * @author monica
 * @date 2020/11/21
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        testHashMap();
        testLinkedHashMap();
    }

    public static void testHashMap() {
        System.out.println("=======> test HashMap");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");

        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ", value:" + value);
        }
    }

    public static void testLinkedHashMap() {
        System.out.println("=======> test LinkedHashMap");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");

        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ", value" + value);
        }
    }
}

package me.collectmind.week06.java.practice.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *  java8 stream 示例
 * @author monica
 * @date 2020/12/18
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,3,5,1,2,2,7,6);
        System.out.println(list);

        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.map(i -> i * 100).orElse(100));


        int sum = list.stream().filter(i -> i < 4).distinct().reduce(0, (a, b) -> a + b);
        System.out.println("sum: " + sum);


        Map<Integer, Integer> map = list.parallelStream()
                .collect(Collectors.toMap(a->a, a->(a+1), (a, b)-> a, HashMap::new));
//        Key 重复时会抛异常
//        Map<Integer, Integer> map1 = list.parallelStream()
//                .collect(Collectors.toMap(a->a, a->(a+1)));
        System.out.println(map);

    }
}

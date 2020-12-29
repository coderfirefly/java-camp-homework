package me.collectmind.java.camp.homework.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * List同步
 * @author monica
 * @date 2020/11/21
 */
public class SyncListDemo {

    public static void main(String[] args) {
        // Arrays.asList元素个数不能变，但是可以修改元素的内容
        List list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8);
        list1.set(8, 9);
        System.out.println("list1:" +list1);

        // ArrayList不是线程安全的
        List list2 = new ArrayList();
        list2.addAll(list1);
        list2.add(3);
        System.out.println("list2:" + list2);

        // 将ArrayList修改为同步容器
        List list3 = Collections.synchronizedList(list2);
        System.out.println("list3:" + list3);



        Collections.shuffle(list3);
        System.out.println("list3 after shuffle:" + list3);


        // 设置为不能修的
        List list4 = Collections.unmodifiableList(list3);
        System.out.println("list4:" + list4.getClass());
        // 修改会报运行时异常 UnsupportedOperationException
//        list4.set(1, 10);
        System.out.println("list4:" + list4);



    }
}
